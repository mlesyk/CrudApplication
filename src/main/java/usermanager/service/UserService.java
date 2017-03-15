package usermanager.service;

import org.springframework.transaction.annotation.Transactional;
import usermanager.model.User;

import java.util.List;

@Transactional
public interface UserService {
    public void addUser(User users);
    public void updateUser(User users);
    public void removeUser(int id);
    public User getUserById(int id);
    public List<User> listUsers();
    public List<User> searchUsers(String userName);
    public int getNumberOfRecords();
}
