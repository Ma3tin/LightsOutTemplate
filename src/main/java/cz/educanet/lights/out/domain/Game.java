package cz.educanet.lights.out.domain;

import cz.educanet.lights.out.domain.interfaces.ILightsOut;

import java.util.Random;

public class Game implements ILightsOut {
    private int moves = 0;
    private boolean[][] grid = new boolean[5][5];

    public Game() {
        Random rd = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int nbr = rd.nextInt(100-1) + 1;
                grid[i][j] = nbr % 2 == 0;
            }
        }
    }

    @Override
    public int getMoveCount() {
        return moves;
    }

    @Override
    public boolean isGameOver() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j]) return false;
            }
        }
        return true;
    }


    @Override
    public boolean[][] getGrid() {
        return grid;
    }

    @Override
    public void makeMove(int x, int y) {
        toggleField(x, y);
        toggleField(x - 1, y);
        toggleField(x + 1, y);
        toggleField(x, y + 1);
        toggleField(x, y - 1);


        moves++;
        getMoveCount();
    }

    public void toggleField(int x, int y) {
        if (isInField(x, y)) grid[x][y] = !grid[x][y];
    }

    public boolean isInField(int x, int y) {
        return (x >= 0 && x < grid.length && y >= 0 && y < grid.length);
    }
}
