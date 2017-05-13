package uni.db.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.db.project.dao.UserDAO;
import uni.db.project.entity.User;

/**
 * Created by Dimitry on 13.05.17.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserDAO userDAO;

    @Override
    @Transactional
    public void createNewUser(String email, String password) {
        userDAO.createNewUser(email, password);
    }

    @Override
    @Transactional
    public User getUserInfo(String email, String password) {
        return userDAO.getUserInfo(email, password);
    }

    @Override
    @Transactional
    public Boolean testUser(String email, String password) {
        return userDAO.testUser(email, password);
    }

    @Override
    @Transactional
    public Boolean testEmailExist(String email) {
        return userDAO.testEmailExist(email);
    }

    @Override
    @Transactional
    public Boolean testEmailFormat(String email) {
        return userDAO.testEmailFormat(email);
    }

    @Override
    @Transactional
    public Boolean testPasswordLength(String password) {
        return userDAO.testPasswordLength(password);
    }
}
