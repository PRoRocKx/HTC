import java.util.List;

public interface ContactBook {
    String getContacts();
    String findContact(String name);
    boolean addContact(String contact);
    boolean deleteContact(String contact);

}
