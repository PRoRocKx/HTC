public class Piston extends BasicPart {
    private float capacity;

    Piston(float capacity){
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Piston " + capacity;
    }
}
