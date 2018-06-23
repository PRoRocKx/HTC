import java.util.ArrayList;
import java.util.List;

public class ShapleyMain {

    private static int getFact(int f) {
        if (f == 0) {
            return 1;
        }
        if(f == 1) {
            return f;
        }
        return f * getFact(--f);
    }


    private static int getCoalition(List<Coalition> coalitions, List<Player> players){
        for (Coalition coalition : coalitions) {
            if (coalition.players.size() == players.size()){
                if (coalition.players.containsAll(players)) {
                    return coalition.gain;
                }
            }
        }
        return 0;
    }

    public static void main(String... args) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            players.add(new Player(i));
        }
        List<Coalition> coalitions = new ArrayList<>();
        coalitions.add(new Coalition(200).addPlayer(players.get(0)));
        coalitions.add(new Coalition(0).addPlayer(players.get(1)));
        coalitions.add(new Coalition(300).addPlayer(players.get(0)).addPlayer(players.get(1)));

        int n = 2;
        int factN = getFact(n);

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            for (Coalition coalition : coalitions) {
                if (coalition.players.contains(player)) {
                    double s = getFact(coalition.players.size() - 1) * getFact(players.size() - coalition.players.size());
                    s = s / factN;
                    List<Player> players2 = new ArrayList<>(coalition.players);
                    players2.remove(player);
                    player.shapley += s * (coalition.gain - getCoalition(coalitions, players2));
                }
            }

        }
        System.out.print("Shapley : (");

        for (int i = 0; i < players.size() - 1; i++) {
            System.out.print(players.get(i).shapley + " ; ");
        }
        System.out.print(players.get(players.size() - 1).shapley + ")");

    }
}
