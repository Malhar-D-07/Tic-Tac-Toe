package Strategies.Winning;

import Models.Board;
import Models.Cell;
import Models.Symbol;
import Models.WinningStrategy;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements WinningStrategy {

    // For a row a Symbol is coming how many times which is given by 2nd Map
    // |0| -> {'x': 0, 'y': 1}
    // |1| -> {'x': 0, 'y': 0}
    // |2| -> {'x': 0, 'y': 0}
    Map<Integer, HashMap<Symbol, Integer>> counts = new HashMap<>();

    @Override
    public boolean checkWinner(Cell c, Board b) {
        int row = c.getRow();
        Symbol s = c.getPlayer().getSymbol();

        if(!counts.containsKey(row)) {
            counts.put(row, new HashMap<>());
        }

        HashMap<Symbol, Integer> hs = counts.get(row);

        if(!hs.containsKey(s)) {
            hs.put(s, 0);
        }
        hs.put(s, hs.get(s)+1);
        return hs.get(s) == b.getSize();
    }
}
