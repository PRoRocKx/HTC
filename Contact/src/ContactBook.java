import java.util.List;

public interface ContactBook {
    String getContacts();
    String findContact(String name);
    String addContact(String contact);
    String deleteContact(String contact);

}
