package contact.Manager.services;

import java.util.List;

import contact.Manager.entities.Contact;
import org.springframework.data.domain.Page;
import contact.Manager.entities.User;

public interface ContactService {
    // save contacts
    Contact save(Contact contact);

    // update contact
    Contact update(Contact contact);

    // get contacts
    List<Contact> getAll();

    // get contact by id

    Contact getById(String id);

    // delete contact

    void delete(String id);

    // search contact
    List<Contact> search(String name, String email, String phoneNumber);

    // get contacts by userId
    List<Contact> getByUserId(String userId);

    Page<Contact> getByUser(User user, int page, int size, String sortField, String sortDirection);
}
