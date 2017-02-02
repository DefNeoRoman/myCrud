package roman.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import roman.dao.UserDAO;
import roman.entity.User;

import java.util.List;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;
    public List<User> getAllUsers() {

        return userDAO.getAllUsers();
    }

    public List<User> getLimitUsers(int start, int end) {

        return userDAO.getLimitlUsers(start,end);
    }
    public int createUser(User user) {
        return userDAO.createUser(user);
    }

    public User updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }

    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    public List<User> getAllUsers(String userName) {
        return userDAO.getAllUsers(userName);
    }
}
