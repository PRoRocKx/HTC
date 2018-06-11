public class Engine extends BasicPart {
    private float capacity;
    private int horsepower;
    private int torque;
    private int cylinderCount;
    private char configuration;

    Engine(float capacity, int horsepower, int torque, int cylinderCount, char configuration){
        this.capacity = capacity;
        this.horsepower = horsepower;
        this.torque = torque;
        this.cylinderCount = cylinderCount;
        this.configuration = configuration;
        for (int i = 0; i < this.cylinderCount; i++) {
            details.add(new Piston(this.capacity / this.cylinderCount));
        }
    }

    @Override
    public String toString() {
        String result = "Engine " + capacity;
        result += " " + configuration + cylinderCount;
        result += " " + horsepower + "hp";

        return result + super.toString();
    }
}
