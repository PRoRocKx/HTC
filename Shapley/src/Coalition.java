import java.util.ArrayList;
import java.util.List;

public class Coalition {
    List<Player> players = new ArrayList<>();

    public Coalition(int gain) {
        this.gain = gain;
    }

    public Coalition addPlayer(Player player){
        players.add(player);
        return this;
    }



    int gain;


}
