package Models;

public class Bot extends Player {

    private BotDifficulty difficulty;

    public Bot(String n, int id, PlayerType type, Symbol s, BotDifficulty d) {
        super(n, id, type, s);
        this.difficulty = d;
    }

    public BotDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BotDifficulty difficulty) {
        this.difficulty = difficulty;
    }

//    @Override
//    public Cell decideCell(Board b) {
//
//    }
}

