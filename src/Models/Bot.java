package Models;

public class Bot extends Player {

    private BotDifficulty difficulty;

    public BotDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BotDifficulty difficulty) {
        this.difficulty = difficulty;
    }
}

