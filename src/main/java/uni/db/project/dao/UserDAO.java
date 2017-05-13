package uni.db.project.dao;

import uni.db.project.entity.User;

/**
 * Created by Dimitry on 13.05.17.
 */
public interface UserDAO {

    void createNewUser(String email, String password);

    User getUserInfo(String email, String password);

    Boolean testUser(String email, String password);

    Boolean testEmailExist(String email);

    Boolean testEmailFormat(String email);

    Boolean testPasswordLength(String password);

}
