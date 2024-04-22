package Models;
import java.util.*;

public class Board {
    private int size;
    private List<List<Cell>> grid;

    public Board(int dim) {
        this.size = dim;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<Cell>> grid) {
        this.grid = grid;
    }
}
