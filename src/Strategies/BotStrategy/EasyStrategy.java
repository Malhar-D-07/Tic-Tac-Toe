package Strategies.BotStrategy;

import Models.Board;
import Models.Cell;
import Models.CellStatus;

import java.util.List;

public class EasyStrategy implements BotStrategy {

    @Override
    public Cell decideMove(Board b) {
        for(List<Cell> row: b.getGrid()) {
            for(Cell c: row) {
                if(c.getCellStatus().equals(CellStatus.EMPTY)) {
                    return c;
                }
            }
        }
        return null;
    }
}
