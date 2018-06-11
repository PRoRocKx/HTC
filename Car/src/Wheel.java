public class Wheel extends BasicPart {
    private int rad;
    private int width;
    private int height;

    public Wheel(int rad, int width, int height) {
        this.rad = rad;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Wheel " + width + "/" + height + " R" + rad;
    }
}
