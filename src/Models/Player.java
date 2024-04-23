package Models;
import java.lang.*;
import java.util.*;
public class Player {
    private int id;
    private String name;
    private PlayerType type;
    private Symbol symbol;

    Scanner sc;
    public Player(String n, int id, PlayerType type, Symbol s) {
        this.name = n;
        this.id = id;
        this.type = type;
        this.symbol = s;
        sc = new Scanner(System.in);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean validateInput(int entry, Board b) {
        if(entry > b.getSize()) {
            return false;
        }
        return true;
    }

    public Cell decideCell(Board b) {
        System.out.println("Please mention the row number");
        int row = sc.nextInt();

        while(!validateInput(row, b)) {
            System.out.println("Row number is greater then board size. Please specify a lower number");
            row = sc.nextInt();
        }

        System.out.println("Please mention the column number");
        int col = sc.nextInt();

        while(!validateInput(col, b)) {
            System.out.println("Column number is greater then board size. Please specify a lower number");
            col = sc.nextInt();
        }

        return b.getGrid().get(row).get(col);
    }
}
