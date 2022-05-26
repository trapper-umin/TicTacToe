public class TicTacToe {
    public static void main(String[] args) {
        char[][] board=new char[][]{{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
        printTicTacToeBoard(board);

    }
    public static void printTicTacToeBoard(char[][] board){
        for (char[] row : board){
            for (char volume : row){
                System.out.print(volume);
            }
            System.out.println();
        }
    }
}

