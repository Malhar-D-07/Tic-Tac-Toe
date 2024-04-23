import Controllers.GameController;
import Exceptions.InvalidBotCountException;
import Models.*;
import Strategies.Winning.ColumnWinningStrategy;
import Strategies.Winning.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameController gameController = new GameController();

        int dim = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Player("Malhar", 1, PlayerType.HUMAN, new Symbol('x')));
        players.add(new Bot("Bot", 2, PlayerType.BOT, new Symbol('o'),BotDifficulty.EASY));

        List<WinningStrategy> ws = new ArrayList<>();
        ws.add(new ColumnWinningStrategy());
        ws.add(new RowWinningStrategy());

        try {
            Game g1 = gameController.startGame(3, new ArrayList<>(), new ArrayList<>());
            gameController.displayBoard(g1);
            while (g1.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
                gameController.makeMove(g1);
                gameController.displayBoard(g1);
            }

            if(g1.getGameStatus().equals(GameStatus.SUCCESS)) {
                System.out.println("Winner is: " + g1.getWinner());
            }
            else {
                System.out.println("Game ended as draw");
            }

        } catch (InvalidBotCountException e) {
            throw new RuntimeException(e);
        }
    }
}