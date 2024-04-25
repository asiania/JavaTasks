package org.example.task4;

import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepository {

    List<User> getAll();

    User getByUsername(String username);

    void addUser(String username);

    void delete(long id);


}
