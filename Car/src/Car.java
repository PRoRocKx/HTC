public class Car {
    private String name;
    private Engine engine;
    private Transmission transmission;
    private Body body;
    private Suspension suspension;

    public Car(String name){
        this.name = name;
        engine = new Engine(2.0f, 200, 180, 4, 'L');
        transmission = new Transmission("MT", 300, 6);
        body = new Body("red",2);
        suspension = new Suspension(4,20, 275,40);
    }

    @Override
    public String toString() {
        String result = "Car " + name;
        result += "\n" + engine.toString();
        result += "\n" + transmission.toString();
        result += "\n" + body.toString();
        result += "\n" + suspension.toString();
        return result;

    }
}
