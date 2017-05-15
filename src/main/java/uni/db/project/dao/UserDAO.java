package uni.db.project.dao;

import uni.db.project.entity.User;

/**
 * Created by Dimitry on 13.05.17.
 */
public interface UserDAO {

    void createNewUser(User user);

    Boolean testUserForm(String username, String email, String password);

    Boolean validateUser(String username, String email, String password);

    Boolean validateEmail(String email);

    Boolean validatePassword(String password);

}
