public class Gear extends BasicPart {
    private int num;

    public Gear(int num){
        this.num = num;
    }

    @Override
    public String toString() {
        return "Gear " + num;
    }
}
