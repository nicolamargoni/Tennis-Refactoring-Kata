public class TennisScore {
    private TennisPlayer player1;
    private TennisPlayer player2;

    public TennisScore(String player1Name, String player2Name){
        player1 = new TennisPlayer(player1Name);
        player2 = new TennisPlayer(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName == player1.getName())
            player1.incrementPoint();
        else
            player2.incrementPoint();
    }

    public String getScore() {
        String score = "";
        if (areScoresEqual()) {
            score = getScoreWhenIsEqual();
        } else if (therIsAPlayerInTheLeadOrWinner()) {
            score = getScoreWhenAPlayerIsAdvantageOrWin();
        } else {
            score = getScoreWhenTheScoresAreDifferent();
        }
        return score;
    }

    private boolean areScoresEqual(){
        return player1.getScore() == player2.getScore();
    }

    private boolean therIsAPlayerInTheLeadOrWinner(){
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private String getScoreWhenIsEqual() {
        String result;
        switch (player1.getScore()) {
            case 0:
                result = "Love-All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            default:
                result = "Deuce";
                break;
        }
        return result;
    }

    private String getScoreWhenAPlayerIsAdvantageOrWin() {
        String result;
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) result = "Advantage player1";
        else if (minusResult == -1) result = "Advantage player2";
        else if (minusResult >= 2) result = "Win for player1";
        else result = "Win for player2";
        return result;
    }

    private String getScoreWhenTheScoresAreDifferent(){
        String result = "";
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1.getScore();
            else {
                result += "-";
                tempScore = player2.getScore();
            }
            switch (tempScore) {
                case 0:
                    result += "Love";
                    break;
                case 1:
                    result += "Fifteen";
                    break;
                case 2:
                    result += "Thirty";
                    break;
                case 3:
                    result += "Forty";
                    break;
            }
        }
        return result;
    }
}
