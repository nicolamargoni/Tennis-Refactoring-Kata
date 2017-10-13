
public class TennisGame1 implements TennisGame {

    private TennisScore TennisScore;


    public TennisGame1(String player1Name, String player2Name) {
        TennisScore = new TennisScore(player1Name,player2Name);
    }

    public void wonPoint(String playerName) {
        TennisScore.wonPoint(playerName);
    }

    public String getScore() {
        return TennisScore.getScore();
    }


}
