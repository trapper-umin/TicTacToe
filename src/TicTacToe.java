import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        char[][] board=new char[][]{{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
        printTicTacToeBoard(board);

        System.out.print("Enter your placement (1-9): ");
        int position=keyboard.nextInt();

        placePiece(board,position,"player");

        printTicTacToeBoard(board);

    }
    public static void printTicTacToeBoard(char[][] board){
        for (char[] row : board){
            for (char symbol : row){
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
    public static void placePiece(char[][] board,int position, String user){
        char symbol=' ';

        if(user.equals("player")){
            symbol='X';
        }else if (user.equals("cpu")){
            symbol='O';
        }

        switch (position){
            case 1:
                board[0][0]=symbol;
                break;
            case 2:
                board[0][2]=symbol;
                break;
            case 3:
                board[0][4]=symbol;
                break;
            case 4:
                board[2][0]=symbol;
                break;
            case 5:
                board[2][2]=symbol;
                break;
            case 6:
                board[2][4]=symbol;
                break;
            case 7:
                board[4][0]=symbol;
                break;
            case 8:
                board[4][2]=symbol;
                break;
            case 9:
                board[4][4]=symbol;
                break;
            default:
                break;
        }
    }
}

