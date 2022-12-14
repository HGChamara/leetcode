package leetcode.graphs;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(board);
    }

    public static void solve(char[][] board) {

        //mark border not surrounded nodes as T
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='O' && (i==0 || i== board.length-1 || j==0 || j== board[0].length-1)){
                    System.out.println(i+" "+j);
                    mark(i, j, board);
                }
            }
        }

        //mark other 0s as Xs
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='O') board[i][j] = 'X';
                if(board[i][j]=='T') board[i][j] = 'O';
            }
        }

        // mark Ts as 0s
    }

    public static void mark(int i, int j, char[][] board) {
        if(i<0 || i== board.length || j<0 || j == board[0].length || board[i][j]!='O') {

        }
        else {
            board[i][j] = 'T';
            mark(i-1, j, board);
            mark(i+1, j, board);
            mark(i, j-1, board);
            mark(i, j+1, board);
        }
    }


}
