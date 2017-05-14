package uni.db.project.dao;

import javafx.beans.binding.BooleanBinding;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.User;

import java.util.List;

/**
 * Created by Dimitry on 13.05.17.
 */
@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createNewUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User getUserInfo(String email, String password){
        Session session = sessionFactory.getCurrentSession();
        User user = (User) session.createQuery("FROM User WHERE userEmail = '" + email + "' AND userPassword = '" + password + "'").getSingleResult();
        return user;
    }

    @Override
    public Boolean testUser(String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Boolean bool = false;
        User user = (User) session.createQuery("FROM User WHERE userEmail = '" + email + "' AND userPassword = '" + password + "'").getSingleResult();
        if(user != null){
            bool = true;
        }
        return bool;
    }

    @Override
    public Boolean testEmailExist(String email) {
        Session session = sessionFactory.getCurrentSession();
        Boolean bool = false;
        String emailExist = (String) session.createQuery("FROM User WHERE userEmail = '" + email + "'").getSingleResult();
        if(emailExist!=null){
            bool = true;
        }
        return bool;
    }

    @Override
    public Boolean testEmailFormat(String email) {
        Boolean bool = false;
        char[] charList = email.toCharArray();
        for (int i = 0; i < charList.length; i++) {
            if (String.valueOf(charList[i]).equals("@")) {
                bool = true;
            }
        }
        return bool;
    }

    @Override
    public Boolean testPasswordLength(String password) {
        Boolean bool = false;
        char[] charList = password.toCharArray();
        if (charList.length >= 8) {
            bool = true;
        }
        return bool;
    }

}
