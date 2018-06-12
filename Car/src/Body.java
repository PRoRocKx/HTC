public class Body extends BasicContainerPart{
    private String color;
    private int doorCount;

    public Body(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
        for (int i = 0; i < doorCount; i++) {
            details.add(new Door(color,i+1));
        }
    }

    @Override
    public String toString() {
        String result = "Body " + color;
        return result + super.toString();
    }
}
