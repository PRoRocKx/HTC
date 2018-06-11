public class Car extends BasicPart{
    private String name;

    public Car(String name){
        this.name = name;
        details.add(new Engine(2.0f, 200, 180, 4, 'L'));
        details.add(new Transmission("MT", 300, 6));
        details.add(new Body("red",2));
        details.add(new Suspension(4,20, 275,40));
    }

    @Override
    public String toString() {
        return "Car " + name + super.toString();
    }
}
