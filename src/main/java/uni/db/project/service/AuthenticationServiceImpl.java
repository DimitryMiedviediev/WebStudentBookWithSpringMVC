package uni.db.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uni.db.project.dao.UserDAO;
import uni.db.project.entity.User;

/**
 * Created by Dimitry on 13.05.17.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public Boolean testUserForm(String username, String email, String password) {
        return userDAO.testUserForm(username, email, password);
    }

    @Override
    @Transactional
    public Boolean validateUser(String username, String email, String password) {
        return userDAO.validateUser(username, email, password);
    }
}
