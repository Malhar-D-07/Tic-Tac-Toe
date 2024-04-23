package Strategies.Winning;

import Models.Board;
import Models.Cell;
import Models.Symbol;
import Models.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    Map<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Cell c, Board b) {
        int row = c.getRow();
        int col = c.getCol();
        Symbol s = c.getPlayer().getSymbol();


        return false;
    }
}
