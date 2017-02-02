package roman.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import roman.entity.User;
import roman.util.HibernateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {
    @Autowired
    private HibernateUtil hibernateUtil;
    public List<User> getAllUsers() {
        return hibernateUtil.fetchAll(User.class);
    }
    public List<User> getLimitlUsers(int start, int end) {
        return hibernateUtil.limitFetch(User.class,  start, end );
    }

    public int createUser(User user) {

        return (int) hibernateUtil.create(user);
    }

    public User updateUser(User user) {
        return hibernateUtil.update(user);
    }

    public void deleteUser(int id) {
        User user = new User();
        user.setId(id);
        hibernateUtil.delete(user);
    }

    public User getUser(int id) {
        return hibernateUtil.fetchById(id, User.class);
    }

    public List<User> getAllUsers(String userName) {
        String query = "SELECT t.* FROM user t WHERE t.name like '%"+ userName +"%'";
        List<Object[]> userObjects = hibernateUtil.fetchAll(query);
        List<User> users = new ArrayList<User>();
        for(Object[] userObject: userObjects) {
            User user = new User();
            int id = (int) userObject[0];
            String name = (String) userObject[1];
            int age = (int) userObject[2];
            boolean isAdmin = (boolean) userObject[3];
            Timestamp timestamp = (Timestamp) userObject[4];
            user.setId(id);
            user.setName(name);
            user.setAge(age);
            user.setIsAdmin(isAdmin);
            user.setCreatedDate(timestamp);
            users.add(user);
        }
        System.out.println(users);
        return users;
    }
}
