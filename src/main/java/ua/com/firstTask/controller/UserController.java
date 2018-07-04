package ua.com.firstTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.firstTask.dao.UserDaoImpl;
import ua.com.firstTask.entety.User;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoImpl userDao;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("id") long id) {
        return userDao.getByID(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public int saveUser(@RequestBody User user) {
        return userDao.save(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        userDao.remove(id);
    }
}
