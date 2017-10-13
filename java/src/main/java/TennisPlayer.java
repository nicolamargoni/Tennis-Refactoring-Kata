public class TennisPlayer {
    private String name;
    private int score;

    public TennisPlayer(String name){
        this.name = name;
        this.score = 0;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void incrementPoint(){
        score++;
    }
}
