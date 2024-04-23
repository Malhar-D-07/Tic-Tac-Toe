package Strategies.Winning;

import Models.Board;
import Models.Cell;
import Models.Symbol;
import Models.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {

    Map<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Cell c, Board b) {
        int col = c.getCol();
        Symbol s = c.getPlayer().getSymbol();
        if(!counts.containsKey(col)) {
            counts.put(col, new HashMap<>());
        }

        HashMap<Symbol, Integer> hs = counts.get(s);
        hs.put(s, hs.get(s)+1);
        return hs.get(s) == b.getSize();
    }
}
