import java.util.Random;
import java.util.Scanner;

public class GameBoard {
    private static String[][] board = new String[3][3];

    public GameBoard() {
    }

    public static boolean isCellEmpty(String[][] board, int option) {
        int row = (option - 1) / 3;
        int col = (option - 1) % 3;
        // Check if the cell is within bounds and is empty
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col].equals(" ");
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public String[][] clearFields(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = " ";
            }
        }
        return arr;
    }

    public void drawField(String[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.println("-----------------------------------\n");
            System.out.print("||    ");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "    ||    ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------\n");
    }

    public void showPiece(boolean b) {
        if (b) {
            System.out.println("player X please place the sign ");
        } else {
            System.out.println("player O please place the sign ");
        }

    }

    public void placeMove(String[][] a, boolean b, int option) {
        char piece;
        if (b) {
            piece = 'X';
        } else {
            piece = 'O';
        }
        while (true) {
            if (isCellEmpty(a, option)) {
                switch (option) {
                    case 1:
                        a[0][0] = String.valueOf(piece);
                        break;
                    case 2:
                        a[0][1] = String.valueOf(piece);
                        break;
                    case 3:
                        a[0][2] = String.valueOf(piece);
                        break;
                    case 4:
                        a[1][0] = String.valueOf(piece);
                        break;
                    case 5:
                        a[1][1] = String.valueOf(piece);
                        break;
                    case 6:
                        a[1][2] = String.valueOf(piece);
                        break;
                    case 7:
                        a[2][0] = String.valueOf(piece);
                        break;
                    case 8:
                        a[2][1] = String.valueOf(piece);
                        break;
                    case 9:
                        a[2][2] = String.valueOf(piece);
                        break;
                }
                break; //exit the loop if walid move was made
            } else {
                System.out.println("Invalid move. The selected cell is already filled. Please choose another cell.");
                option = getNewOption();
            }
        }
    }

    public int getNewOption() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public Winner checkboard(String[][] board) {
        Winner r1 = new Winner();

        // rows
        if (board[0][0] != " " && board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) {
            r1.setValue(board[0][0], true);
        }
        if (board[1][0] != " " && board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) {
            r1.setValue(board[1][0], true);
        }
        if (board[2][0] != " " && board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) {
            r1.setValue(board[2][0], true);
        }

        // columns
        if (board[0][0] != " " && board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0])) {
            r1.setValue(board[0][0], true);
        }
        if (board[0][1] != " " && board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1])) {
            r1.setValue(board[0][1], true);
        }
        if (board[0][2] != " " && board[0][2].equals(board[2][1]) && board[2][1].equals(board[2][2])) {
            r1.setValue(board[0][2], true);
        }

        // diagonals
        if (board[0][0] != " " && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
            r1.setValue(board[0][0], true);
        }
        if (board[2][0] != " " && board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
            r1.setValue(board[2][0], true);
        }

        return r1;
    }

    public int generateCPUmove() {
        Random rnd = new Random();
        int piece;

        do {
            piece = rnd.nextInt(10); // Add 1 to generate values between 1 and 9
        } while (!isCellEmpty(getBoard(), piece));

        return piece;
    }
}


