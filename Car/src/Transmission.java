public class Transmission extends BasicContainerPart {
    private String type;
    private int maxPower;
    private int gears;

    public Transmission(String type, int maxPower, int gears) {
        this.type = type;
        this.maxPower = maxPower;
        this.gears = gears;
        for (int i = 0; i < gears; i++) {
            details.add(new Gear(i+1));
        }
    }

    @Override
    public String toString() {

        String result = "Transmission " + type + " Gears " + gears;
        result += " MaxPower " + maxPower;

        return result + super.toString();
    }
}
