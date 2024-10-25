import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        char [][] board = new char[3][3];
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col <board.length; col++){
                board[row][col] = ' ';
            }
        }

        Scanner scanner = new Scanner(System.in);

        char player = 'X';
        boolean end = false;

        while (!end){
            printBoard(board);
            System.out.println("Player " + player + ": Your move: ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' '){
                board[row][col] = player;
                end = winner(board, player);
                if(end){
                    System.out.println(player + " has won.");
                }
            } else {
                //player = (player == 'X')? 'O' : 'X';
                if (player == 'X'){
                    player = 'O';
                } else {
                    player = 'X';
                }
                System.out.println("Invalid move.");
            }
        }
        printBoard(board);
    }

    private static boolean winner(char[][] board, char player) {
        for (int row = 0; row < board.length; row++){
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        for (int col = 0; col < board[0].length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player){
                return true;
            }
            if (board[0][2] == player && board[1][1] == player && board[2][0] == player){
                return true;
            }
        return false;
        }
//    private static int getPlayerMove(Scanner scanner, char[][] board, char player) {
//        int move;
//        while (true) {
//            System.out.println("Player " + player + ": Enter your move (1-9): ");
//            move = scanner.nextInt();
//
//            if (move < 1 || move > 9) {
//                System.out.println("Invalid move! Please enter a number between 1 and 9.");
//            } else {
//                int row = (move - 1) / 3;
//                int col = (move - 1) % 3;
//
//                if (board[row][col] != ' ') {
//                    System.out.println("This spot is already taken! Try another move.");
//                } else {
//                    break;  // Valid move
//                }
//            }
//        }
//        return move;
//    }


    public static void printBoard (char[][] board){
                for (int row = 0; row < board.length; row++) {
                    for (int col = 0; col < board.length; col++) {
                        System.out.print(board[row][col] + " | ");
                    }
                    System.out.println();
                }
            }
 }

