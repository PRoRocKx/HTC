import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Contacts implements ContactBook {
    private List<Contact> contacts;

    private static final String FILENAME = "contact.txt";

    private boolean parse(String s){
        String[] strings = s.split(";");
        if (strings.length != 4)
            return false;
        Contact contact = new Contact();
        contact.name = strings[0];
        contact.phone = strings[1];
        contact.address = strings[2];
        contact.info = strings[3];
        contacts.add(contact);
        return true;
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
        StringBuilder stringBuilder = new StringBuilder();
        for (Contact contact:contacts) {
            stringBuilder.append(contact.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public String findContact(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Contact contact:contacts) {
            if (contact.name.toLowerCase(Locale.getDefault()).contains(name.toLowerCase(Locale.getDefault())))
                stringBuilder.append(contact.toString());
        }
        if (stringBuilder.length() == 0)
            return "Contact not found";
        return stringBuilder.toString();
    }

    @Override
    public String addContact(String contact) {
        if (!parse(contact))
            return "Error parse contact";
        if (!write())
            return "Error save contact";
        return "ok!";
    }

    @Override
    public String deleteContact(String name) {
        for (Contact contact:contacts) {
            if (contact.name.equals(name)) {
                contacts.remove(contact);
                if (!write())
                    return "Error save contact";
                return "ok!";
            }
        }
        return "Contact not found";
    }
}
