import java.util.Random;
import java.util.Scanner;

public class CPUgame implements Game {
    public CPUgame() {
        run();
    }

    @Override
    public void run() {
        GameBoard game = new GameBoard();
        Random rnd = new Random();
        boolean piece = rnd.nextBoolean();
        game.clearFields(game.getBoard());

        for (int i = 0; i < 9; i++) {
            game.drawField(game.getBoard());
            game.showPiece(piece);

            int option;

            if (piece) {
                Scanner scanner = new Scanner(System.in);
                option = scanner.nextInt();
            } else {
                option = game.generateCPUmove();
            }

            while (!game.isCellEmpty(game.getBoard(), option)) {
                System.out.println("Invalid move. The selected cell is already filled. Please choose another cell.");
                if (piece) {
                    Scanner scanner = new Scanner(System.in);
                    option = scanner.nextInt();
                } else {
                    option = game.generateCPUmove();
                }
            }
            game.placeMove(game.getBoard(), piece, option);
            piece = !piece;
            Winner winn = game.checkboard(game.getBoard());
            if (winn.getSwitcher()) {
                game.drawField(game.getBoard());
                System.out.printf("The winner is %s%n", winn.getValue());
                break;
            }
        }
    }
}
