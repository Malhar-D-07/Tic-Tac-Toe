package Controllers;

import Exceptions.InvalidBotCountException;
import Models.Game;
import Models.Player;
import Models.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int size, List<Player> players, List<WinningStrategy> winningStrategies) throws InvalidBotCountException {
        return Game.getBuilderInstance().setDim(size).setPlayers(players).setWinningStrategies(winningStrategies).build();
    }

    public void displayBoard(Game g) {
        g.getBoard().printBoard();
    }

    public void makeMove(Game game) {

    }
}
