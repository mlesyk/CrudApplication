package usermanager.service;

import usermanager.dao.UserDao;
import usermanager.model.User;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Transactional
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    public List<User> searchUsers(String userName) {
        return userDao.searchUsers(userName);
    }

    @Transactional
    public int getNumberOfRecords() {
        return userDao.getNumberOfRecords();
    }

}