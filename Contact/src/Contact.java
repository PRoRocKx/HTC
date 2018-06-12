public class Contact {
    String name;
    String phone;
    String address;
    String info;

    public Contact() {
    }

    public Contact(String name, String phone, String adress, String info) {

        this.name = name;
        this.phone = phone;
        this.address = adress;
        this.info = info;
    }

    @Override
    public String toString() {
        return name + " " + phone + " " + address + " " + info;
    }

}
