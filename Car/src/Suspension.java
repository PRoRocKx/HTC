public class Suspension extends BasicPart{
    private int wheelCount;
    private int rad;
    private int width;
    private int height;

    public Suspension(int wheelCount, int rad, int width, int height) {
        this.wheelCount = wheelCount;
        this.rad = rad;
        this.width = width;
        this.height = height;
        for (int i = 0; i < wheelCount; i++) {
            details.add(new Wheel(rad,width,height));
        }
    }

    @Override
    public String toString() {
        String result = "Wheels " + wheelCount;
        return result + super.toString();
    }
}
