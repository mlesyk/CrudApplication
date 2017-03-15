package usermanager.dao;

import usermanager.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User users);
    public void updateUser(User users);
    public void removeUser(int id);
    public User getUserById(int id);
    public List<User> listUsers();
    public List<User> searchUsers(String userName);
    public int getNumberOfRecords();
}