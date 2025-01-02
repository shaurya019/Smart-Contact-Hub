package contact.Manager.services;

import contact.Manager.entities.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    User saveUser(User user);

    Optional<User> getUserById(String id);

    Optional<User> updateUser(User user);

    void delete(String id);

    boolean isUserExist(String userId);

    boolean isUserExistByEmail(String email);

    List<User> getAllUsers();


}
