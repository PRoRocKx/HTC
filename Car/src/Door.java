public class Door extends BasicPart{
    private String color;
    private int num;

    public Door(String color, int num) {
        this.color = color;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Door " + num;
    }
}
