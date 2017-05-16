package uni.db.project.service;

import uni.db.project.entity.User;

/**
 * Created by Dimitry on 13.05.17.
 */
public interface AuthenticationService {

    void createUser(User user);

    Boolean testUserForm(String username, String email, String password);

    Boolean validateUser(String username, String email, String password);
}
