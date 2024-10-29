package service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import model.Cell;
import model.Player;
import model.Symbol;

public class Board {

    private final Cell[][] grid;

    public Board(int size) {
        grid = new Cell[size][size];
        initialize();
    }

    private void initialize() {
        System.out.println("Initializing the game!");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                Cell cell= new Cell();
                cell.setSymbol(Symbol.EMPTY);
                grid[i][j]= cell;
            }
        }
    }

    public void assignCell(int i, int j, Player player) {
        if(i<0 || j<0 || i> grid.length || j>grid.length) {
            throw new IllegalArgumentException("Invalid position!");
        }

        if(grid[i][j].getSymbol()!=Symbol.EMPTY) {
            throw new IllegalArgumentException("Position is already taken");
        }

        grid[i][j].setSymbol(player.getSymbol());
    }

    public void displayGrid() {
        System.out.println("Board status");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("|");
            for (int j = 0; j < grid.length; j++) {
                Cell cell = grid[i][j];
                if (cell.getSymbol() == Symbol.EMPTY) {
                    System.out.print("   ");
                    System.out.print("|");
                } else {
                    System.out.print(" " + cell.getSymbol() + " ");
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public boolean isWin() {
        return isRowSame() || isColSame() || isDiagSame();
    }

    public boolean isDraw() {
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid.length;j++) {
                if(grid[i][j].getSymbol()==Symbol.EMPTY) return false;
            }
        }

        return true;
    }

    private boolean isRowSame() {
        boolean flag=false;
        for(int i=0;i<grid.length;i++) {
            Symbol symbol= grid[i][0].getSymbol();
            for(int j=1;j<grid.length;j++) {
                if (symbol != Symbol.EMPTY && symbol==grid[i][j].getSymbol()) {
                    flag=true;
                } else {
                    flag=false;
                }
            }

            if(flag) return true;
        }
        return flag;
    }

    private boolean isColSame() {
        boolean flag=false;
        for(int i=1;i<grid.length;i++) {
            Symbol symbol= grid[0][i].getSymbol();
            for(int j=0;j<grid.length;j++) {
                if (symbol != Symbol.EMPTY && symbol==grid[j][i].getSymbol()) {
                    flag=true;
                } else {
                    flag=false;
                }
            }
            if(flag) return true;
        }

        return flag;
    }

    private boolean isDiagSame() {
        Symbol symbol= grid[0][0].getSymbol();
        for(int i=1;i<grid.length;i++) {
            if (grid[i][i].getSymbol() != symbol) {
                return false;
            }
        }

        symbol= grid[0][grid.length-1].getSymbol();
        for(int i=1; i<grid.length;i++) {
            if (grid[i][grid.length-1-i].getSymbol() != symbol) {
                return false;
            }
        }

        return symbol==Symbol.EMPTY?false:true;
    }
}
