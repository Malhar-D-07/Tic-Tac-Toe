package Models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellStatus cellStatus;

    Cell(int r, int c) {
        this.row = r;
        this.col = c;
        this.player = null;
        this.cellStatus = CellStatus.EMPTY;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public void display() {
        if(player == null) {
            System.out.println("| - |");
        }
        else {
            System.out.println("| " + this.player.getSymbol() + " |");
        }
    }
}
