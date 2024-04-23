package stratergy.winning;

import  models.Board;
import  models.Cell;
import  models.Player;

public interface WinningStrategy {
    public boolean checkWinner(Cell c, Board b);

    public void handleUndo(Cell c, Board b);
}
