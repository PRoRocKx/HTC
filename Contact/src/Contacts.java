import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Contacts implements ContactBook {
    private List<Contact> contacts;

    private static final String FILENAME = "contact.txt";

    private void parse(String s){
        String[] strings = s.split(";");
        if (strings.length != 4)
            return;
        Contact contact = new Contact();
        contact.name = strings[0];
        contact.phone = strings[1];
        contact.address = strings[2];
        contact.info = strings[3];
        contacts.add(contact);
    }

    private void read(){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(FILENAME), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                parse(line);
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public Contacts() {
        contacts = new ArrayList<>();
        read();
    }

    private boolean write(){
        try {
            FileWriter writer = new FileWriter(FILENAME, false);
            for (Contact contact:contacts) {
                writer.write(contact.name + ";" + contact.phone + ";" + contact.address + ";" + contact.phone + ";\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            return false;
        }
        return true;
    }

    @Override
    public String getContacts() {
        return null;
    }

    @Override
    public String findContact(String name) {
        return null;
    }

    @Override
    public boolean addContact(String contact) {
        contacts.add(contact);
        return write();
    }

    @Override
    public boolean deleteContact(String name) {
        return false;
    }
}
