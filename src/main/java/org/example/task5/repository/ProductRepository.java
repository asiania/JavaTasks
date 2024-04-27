package org.example.task5.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.example.task5.dto.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final HikariDataSource dataSource;

    public ProductRepository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addProduct(int accnum, double balance, String type) {
        PreparedStatement statement;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement("insert into products(accnum, balance, type) values(?, ?, ?)");
            statement.setInt(1, accnum);
            statement.setDouble(2, balance);
            statement.setString(3, type);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(long id) {
        PreparedStatement statement;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement("delete from  products where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Product getById(long id) {
        PreparedStatement statement;
        ResultSet resultSet;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement("select id, accnum, balance, type from products where id = ?");
            statement.setLong(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) return new Product(resultSet.getLong(1), resultSet.getInt(2), resultSet.getDouble(4), resultSet.getString(4));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Product> getAll() {
        String sql = "select id, accnum, balance, type from products";
        Statement statement;
        ResultSet resultSet;
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                products.add(new Product(resultSet.getLong(1), resultSet.getInt(2), resultSet.getDouble(3), resultSet.getString(4)));
            }
            return products;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}