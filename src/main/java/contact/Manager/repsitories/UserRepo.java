package contact.Manager.repsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import contact.Manager.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,String> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

}
