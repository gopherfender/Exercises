package Tennis;
public class Match {

    Player p1;
    Player p2;
    int p1SetWins = 0;
    int p2SetWins = 0;

    public Match(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String CheckWinner() {
        for (int set = 0; set <= p1.sets.length-1; set++) {
            if (p1.sets[set] > p2.sets[set]) {
                p1SetWins++;
            } else {
                p2SetWins++;
            }
        }
        if (p1SetWins > p2SetWins) {
            return p1.name;
        } else {
            return p2.name;
        }
    }
    
}
