package contact.Manager.services.impl;

import contact.Manager.entities.User;
import contact.Manager.helpers.ResourceNotFoundException;
import contact.Manager.services.UserService;
import contact.Manager.repsitories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setId(id);
        logger.info(user.getProvider().toString());
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());
        // save the user in database
        User save = userRepo.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void delete(String id) {
        User user = userRepo.findById(id).orElseThrow(() -> new  ResourceNotFoundException("User not found"));
        userRepo.delete(user);
    }

    @Override
    public boolean isUserExist(String id) {
        return userRepo.findById(id).orElse(null) != null ? true : false;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        return userRepo.findByEmail(email).orElse(null) != null ? true : false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
