import  Exceptions.InvalidBotCountException;
import  Exceptions.PlayerSizeInvalid;
import  controller.GameController;
import  models.*;
import  stratergy.winning.DiagonalWinningStrategy;
import  stratergy.winning.RowWinningStrategy;
import  stratergy.winning.WinningStrategy;
import  stratergy.winning.columnWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws InvalidBotCountException, PlayerSizeInvalid {

        Scanner s = new Scanner(System.in);
        GameController gc = new GameController();

        int dimension = 3;
        List<Player> p = new ArrayList<>();
        p.add(new Player("Karan", 1, playerType.HUMAN, new Symbol('x')));
        p.add(new Bot(2, "Bot", new Symbol('O'), BotDificulty.EASY));

        List<WinningStrategy> ws = new ArrayList<>();
        ws.add(new columnWinningStrategy());
        ws.add(new RowWinningStrategy());
        ws.add(new DiagonalWinningStrategy());


        Game g1 = gc.startGame(3, p, ws);

        gc.displayBoard(g1);

        while(g1.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            gc.takeMove(g1);

            System.out.println("Do you want to undo?, if yes press 1");
            int undoAnswer = s.nextInt();
            if(undoAnswer==1){
                System.out.println("Undoying..");
                gc.undo(g1);
            }
            gc.displayBoard(g1);
        }

        if (g1.getGameStatus().equals(GameStatus.SUCCESS)){
            System.out.println("winner is " + g1.getWinner().getName());
        }
        else if (g1.getGameStatus().equals(GameStatus.DRAW)){
            System.out.println("game ended as draw...");
        }


    }
}
