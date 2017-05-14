package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.User;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.persistence.NoResultException;

/**
 * Created by Dimitry on 13.05.17.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createNewUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public Boolean validateUser(String username, String email, String password) {
        Session session = sessionFactory.getCurrentSession();
        Boolean bool = false;
        User user = null;
        try {
            user = (User) session.createQuery("FROM User WHERE (username = '" + username + "' AND password = '" + password + "') OR (email = '" + email + "' AND password = '" + password + "')").getSingleResult();
        } catch (NoResultException e) {
            return false;
        }
        if (user != null) {
            bool = true;
        }
        return bool;
    }

    @Override
    public Boolean validateEmail(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

    @Override
    public Boolean validatePassword(String password) {
//        ^                     #start - of - string
//        ( ? =.*[0 - 9])       #a digit must occur at least once
//        ( ? =.*[a - z])       #a lower case letter must occur at least once
//        ( ? =.*[A - Z])       #an upper case letter must occur at least once
//        ( ? =.*[@#$ % ^&+=])  #a special character must occur at least once
//        ( ? =\S + $)          #no whitespace allowed in the entire string
//        .{8,}                 #anything, at least eight places though
//        $                     #end - of - string
//        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}";
        Boolean isValid = password.matches(pattern);
        return isValid;
    }

}
