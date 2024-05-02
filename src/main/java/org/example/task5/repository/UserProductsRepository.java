package org.example.task5.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.example.task5.dto.Product;
import org.example.task5.dto.UserProductsInfo;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository
public class UserProductsRepository {

    private final HikariDataSource dataSource;

    public UserProductsRepository(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addUserProducts(long userId, long productId) {
        PreparedStatement statement;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement("insert into userproducts(userid, productid) values(?,?)");
            statement.setLong(1, userId);
            statement.setLong(2, productId);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Product> getAllUserProducts(long userId) {
        PreparedStatement statement;
        ResultSet resultSet;
        List<Product> userProductsInfo = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement("select p.id, p.accnum, p.balance, p.type from products p, userproducts up where up.productid=p.id and up.userid = ?");
            statement.setLong(1, userId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                userProductsInfo.add(new Product(  resultSet.getLong(1),
                        resultSet.getInt(2),
                        resultSet.getDouble(3),
                        resultSet.getString(4)
                ));
            }
            return userProductsInfo;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<UserProductsInfo> getAll() {
        String sql = "select u.id, u.username, p.id, p.accnum, p.balance, p.type from users u, products p, userproducts up where up.userid=u.id and up.productid=p.id";
        Statement statement;
        ResultSet resultSet;
        List<UserProductsInfo> userProductsInfo = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                userProductsInfo.add(new UserProductsInfo(  resultSet.getLong(1),
                        resultSet.getString(2),
                        resultSet.getLong(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6)
                ));
            }
            return userProductsInfo;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
