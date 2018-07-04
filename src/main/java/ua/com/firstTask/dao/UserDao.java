package ua.com.firstTask.dao;

import ua.com.firstTask.entety.User;
import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getByID(long id);
    int save(User user);
    void remove(long id);

}
