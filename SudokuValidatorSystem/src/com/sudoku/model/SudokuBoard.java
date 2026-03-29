package com.sudoku.model;

public class SudokuBoard{
	
	private int[][] sudokuBoard;

    public SudokuBoard() {
    	sudokuBoard = new int[9][9];
    }

    public void setCell(int row, int col, int num) {
        if (row < 0 || row > 9 || col < 0 || col > 9){
        	throw new IllegalArgumentException("row or col must be between 0 and 8");
        }
        if(num < 0 || num > 9) {
        	throw new IllegalArgumentException("Number must be between 0 and 9");
        }
            
        	sudokuBoard[row][col] = num;
        
        	}
        
    
    public int getCell(int row, int col) {
        return sudokuBoard[row][col];
    }
    
    public void display() {

		for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(sudokuBoard[r][c] + " ");
                if ((c + 1) % 3 == 0 && c != 8) System.out.print("| ");
            }
            System.out.println();
            if ((r + 1) % 3 == 0 && r != 8) System.out.println("---------------------");
        }	
	}

    public boolean isValid(int row, int col, int num) {

        for (int i = 0; i < 9; i++) {
            if (sudokuBoard[row][i] == num) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (sudokuBoard[i][col] == num) {
                return false;
            }
        }

        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (sudokuBoard[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }

	public boolean isFull() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (sudokuBoard[r][c] == 0) return false;
            }
        }
        return true;
    }
	
}

	
