package Strategies.BotStrategy;

import Models.Board;
import Models.Cell;

public interface BotStrategy {
    public Cell decideMove(Board b);
}
