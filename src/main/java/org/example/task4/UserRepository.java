package org.example.task4;

import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface UserRepository {

    public List<User> getAll();

    public User getByUsername(String username);

    public void addUser(String username);

    public void delete(long id);


}
