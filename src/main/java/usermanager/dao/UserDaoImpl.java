package usermanager.dao;

import usermanager.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    public void updateUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);

    }

    public void removeUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = getUserById(id);
        if (user != null) {
            session.delete(user);
        }
    }

    public User getUserById(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.get(User.class, id);

        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User ")
                .list();
        return userList;
    }

    @SuppressWarnings("unchecked")
    public List<User> searchUsers(String userName) {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User where name like :userName")
                .setParameter("userName", "%" + userName + "%")
                .list();
        return userList;
    }

    @SuppressWarnings("unchecked")
    public int getNumberOfRecords() {
        Session session = sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User ")
                .list();
        return userList.size();
    }

}