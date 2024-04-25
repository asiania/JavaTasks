package org.example.task4;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public final  class  UserService implements UserRepository{

    private final HikariDataSource dataSource;

    @Autowired
    public UserService(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void addUser(String username) {
        PreparedStatement statement;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement("insert into users(username) values(?)");
            statement.setString(1, username);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(long id) {
        PreparedStatement statement;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement("delete from  users where id = ?");
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public User getByUsername(String username) {
        PreparedStatement statement;
        ResultSet resultSet;

        try (Connection connection = dataSource.getConnection()) {
            statement = connection.prepareStatement("select id, username from users where username = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) return new User(resultSet.getLong(1), resultSet.getString(2));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        String sql = "select id, username from users";
        Statement statement;
        ResultSet resultSet;
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                users.add(new User(resultSet.getLong(1), resultSet.getString(2)));
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    return null;
    }
}
