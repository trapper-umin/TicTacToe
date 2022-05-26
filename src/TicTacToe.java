import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions=new ArrayList<>();
    static ArrayList<Integer> cpuPositions=new ArrayList<>();
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        Random random=new Random();
        char[][] board=new char[][]{{' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '},
                {'-','+','-','+','-'},
                {' ','|',' ','|',' '}};
        printTicTacToeBoard(board);

        while (true){
            System.out.print("Enter your placement (1-9): ");
            int playerPosition=keyboard.nextInt();
            while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition) || playerPosition>9){
                System.out.print("Position taken! Enter a correct position: ");
                playerPosition=keyboard.nextInt();
            }

            placePiece(board,playerPosition,"player");

            String result =checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }

            int cpuPosition=random.nextInt(9)+1;
            while (cpuPositions.contains(cpuPosition) || playerPositions.contains(cpuPosition)){
                cpuPosition=random.nextInt(9)+1;
            }
            placePiece(board,cpuPosition,"cpu");

            printTicTacToeBoard(board);

            result =checkWinner();
            if(result.length()>0){
                System.out.println(result);
                break;
            }
        }
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
            playerPositions.add(position);
        }else if (user.equals("cpu")){
            symbol='O';
            cpuPositions.add(position);
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
    public static String checkWinner(){

        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> botRow = Arrays.asList(7,8,9);

        List<Integer> leftColumn = Arrays.asList(1,4,7);
        List<Integer> midColumn = Arrays.asList(2,5,8);
        List<Integer> rightColumn = Arrays.asList(3,6,9);

        List<Integer> crossOne = Arrays.asList(1,5,9);
        List<Integer> crossTwo = Arrays.asList(7,5,3);

        List<List> winning =new ArrayList<>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftColumn);
        winning.add(midColumn);
        winning.add(rightColumn);
        winning.add(crossOne);
        winning.add(crossTwo);

        for (List list : winning){
            if (playerPositions.containsAll(list)){
                return "Congratulation you won!";
            }else if (cpuPositions.containsAll(list)){
                return "CPU won! Sorry:(";
            }else if(playerPositions.size()+cpuPositions.size()==9){
                return "CAT!";
            }
        }
    return "";
    }
}

