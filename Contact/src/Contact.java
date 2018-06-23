public class Contact {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    private String name;
    private String phone;
    private String address;
    private String info;

    public Contact() {
    }

    public Contact(String name, String phone, String address, String info) {

        this.name = name;
        this.phone = phone;
        this.address = address;
        this.info = info;
    }

    @Override
    public String toString() {
        return name + " " + phone + " " + address + " " + info + "\n";
    }

}
