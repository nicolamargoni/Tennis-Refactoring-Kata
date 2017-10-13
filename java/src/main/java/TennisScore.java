public class TennisScore {
    static final String SCORE_LOVE_ALL = "Love-All";
    static final String SCORE_FIFTEEN_ALL = "Fifteen-All";
    static final String SCORE_THIRTY_ALL = "Thirty-All";
    static final String SCORE_DEUCE = "Deuce";
    static final String SCORE_ADVANTAGE_PLAYER_ONE = "Advantage player1";
    static final String SCORE_ADVANTAGE_PLAYER_TWO = "Advantage player2";
    static final String SCORE_WIN_PLAYER_ONE = "Win for player1";
    static final String SCORE_WIN_PLAYER_TWO = "Win for player2";

    static final String SCORE_LOVE = "Love";
    static final String SCORE_FIFTEEN = "Fifteen";
    static final String SCORE_THIRTY = "Thirty";
    static final String SCORE_FORTY = "Forty";
    static final String SCORE_SEPARATOR = "-";
    
    static final String STRING_EMPTY = "";

    private TennisPlayer player1;
    private TennisPlayer player2;

    public TennisScore(String player1Name, String player2Name) {
        player1 = new TennisPlayer(player1Name);
        player2 = new TennisPlayer(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
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

    private boolean areScoresEqual() {
        return player1.getScore() == player2.getScore();
    }

    private boolean therIsAPlayerInTheLeadOrWinner() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private String getScoreWhenIsEqual() {
        String result;
        switch (player1.getScore()) {
            case 0:
                result = SCORE_LOVE_ALL;
                break;
            case 1:
                result = SCORE_FIFTEEN_ALL;
                break;
            case 2:
                result = SCORE_THIRTY_ALL;
                break;
            default:
                result = SCORE_DEUCE;
                break;
        }
        return result;
    }

    private String getScoreWhenAPlayerIsAdvantageOrWin() {
        String result;
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) result = SCORE_ADVANTAGE_PLAYER_ONE;
        else if (minusResult == -1) result = SCORE_ADVANTAGE_PLAYER_TWO;
        else if (minusResult >= 2) result = SCORE_WIN_PLAYER_ONE;
        else result = SCORE_WIN_PLAYER_TWO;
        return result;
    }

    private String getScoreWhenTheScoresAreDifferent() {
        String result = STRING_EMPTY;
        int tempScore = 0;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1.getScore();
            else {
                result += SCORE_SEPARATOR;
                tempScore = player2.getScore();
            }
            switch (tempScore) {
                case 0:
                    result += SCORE_LOVE;
                    break;
                case 1:
                    result += SCORE_FIFTEEN;
                    break;
                case 2:
                    result += SCORE_THIRTY;
                    break;
                case 3:
                    result += SCORE_FORTY;
                    break;
            }
        }
        return result;
    }
}
