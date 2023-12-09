import java.util.Random;
import java.util.Scanner;

public class PlayerGame implements Game {

    public PlayerGame() {
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
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            game.placeMove(game.getBoard(), piece, option);
            piece = !piece;
            Winner winn = game.checkboard(game.getBoard());
            if (winn.getSwitcher() == true) {
                game.drawField(game.getBoard());
                System.out.printf("The winner is %s%n", winn.getValue());
                break;
            }
        }
    }
}
