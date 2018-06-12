import java.util.ArrayList;
import java.util.List;

public class BasicContainerPart extends BasicPart{
    protected List<BasicPart> details = new ArrayList<>();

    @Override
    public String toString() {
        String result = "\n";
        if (details.size() > 0){
            result += "Contains : ";
            for (BasicPart basicPart: details) {
                result += "\n" + basicPart.toString();
            }
        }
        return result;
    }
}
