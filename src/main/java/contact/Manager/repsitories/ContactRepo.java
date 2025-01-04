package contact.Manager.repsitories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import contact.Manager.entities.Contact;
import contact.Manager.entities.User;

public interface ContactRepo extends JpaRepository<Contact,String> {
List<Contact> findByUser(User user);

    @Query("SELECT c FROM Contact c WHERE c.user.id = :userId")
    List<Contact> findByUserId(@Param("userId") String userId);
}
