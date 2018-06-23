import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContactMain {

    public static void main(String... arg){
        ContactBook contactBook = new Contacts();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            while (true) {

                System.out.println("Enter command : ");
                String input = br.readLine();

                if (input.equals("exit")) {
                    System.out.println("Exit!");
                    System.exit(0);
                }

                if (input.equals("help") || input.equals("?") || input.equals("h") || input.isEmpty()) {
                    System.out.println("list - show all contact");
                    System.out.println("add - add new contact (example: add Petrov Ivan;Phone number;address;some info about Ivan)");
                    System.out.println("find - find contact (example: find ivan)");
                    System.out.println("delete - delete one contact from name (example: delete Petrov Ivan)");
                    System.out.println("exit - exit from program)");
                    continue;
                }

                int space = input.indexOf(' ');
                if (space > 0 && input.length() > space) {
                    switch (input.substring(0, space)){
                        case "add" : System.out.println(contactBook.addContact(input.substring(space + 1, input.length())));
                            break;
                        case "find" : System.out.println(contactBook.findContact(input.substring(space + 1, input.length())));
                            break;
                        case "delete" : System.out.println(contactBook.deleteContact(input.substring(space + 1, input.length())));
                            break;
                        default: System.out.println("Unknown command");
                    }
                }else
                    if (input.equals("list")) {
                        System.out.println(contactBook.getContacts());
                    }
                    else {
                        System.out.println("Unknown command");
                    }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
