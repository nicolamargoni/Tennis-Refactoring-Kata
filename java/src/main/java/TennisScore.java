public class TennisScore {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisScore(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == player1Name)
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        if (m_score1 == m_score2) {
            score = getScoreWhenIsEqual();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = getScoreWhenAPlayerIsAdvantageOrWin();
        } else {
            score = getScoreWhenTheScoresAreDifferent();
        }
        return score;
    }

    private String getScoreWhenIsEqual() {
        String result;
        switch (m_score1) {
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
        int minusResult = m_score1 - m_score2;
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
            if (i == 1) tempScore = m_score1;
            else {
                result += "-";
                tempScore = m_score2;
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
