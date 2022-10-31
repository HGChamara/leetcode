package leetcode.arrays;

import java.util.HashSet;

public class ValidSudoku {
	
	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}};
		
		boolean isValidSudoku = isValidSudoku(board);
		System.out.println(isValidSudoku);
	}

	private static boolean isValidSudoku(char[][] board) {
		
HashSet<String> h1 = new HashSet<String>();
        
        for(int i=0; i < 9; i++){
            for(int j=0; j< 9; j++){
                if(board[i][j] != '.'){
                    
                //Check whether HashSet contains duplicate elements in row and column 
                if(h1.contains("row" + i + board[i][j]) || h1.contains("col" + j + board[i][j]) || h1.contains("box"+ (i/3)*3 + j/3 + board[i][j]) ){
                    return false;
                }
                h1.add("row" + i + board[i][j]);
                h1.add("col" + j + board[i][j]);
                h1.add("box"+ (i/3)*3 + j/3 + board[i][j]);
            }
        }
        }
        return true;
	}

}