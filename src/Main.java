import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        drawmenu();
    }

    public static void drawmenu() {
        System.out.print("" +
                " /$$$$$$$$ /$$                   /$$                                 /$$                        \n" +
                "|__  $$__/|__/                  | $$                                | $$                        \n" +
                "   | $$    /$$  /$$$$$$$       /$$$$$$    /$$$$$$   /$$$$$$$       /$$$$$$    /$$$$$$   /$$$$$$ \n" +
                "   | $$   | $$ /$$_____/      |_  $$_/   |____  $$ /$$_____/      |_  $$_/   /$$__  $$ /$$__  $$\n" +
                "   | $$   | $$| $$              | $$      /$$$$$$$| $$              | $$    | $$  \\ $$| $$$$$$$$\n" +
                "   | $$   | $$| $$              | $$ /$$ /$$__  $$| $$              | $$ /$$| $$  | $$| $$_____/\n" +
                "   | $$   | $$|  $$$$$$$        |  $$$$/|  $$$$$$$|  $$$$$$$        |  $$$$/|  $$$$$$/|  $$$$$$$\n" +
                "   |__/   |__/ \\_______/         \\___/   \\_______/ \\_______/         \\___/   \\______/  \\_______/\n" +
                "                                                                                                \n" +
                "This is a simple Tic tac toe game. Choose an option");
        System.out.println();
        System.out.print("" +
                "<1: Player vs PLayer>    <2: Player vs Computer>    <3: Exit the game>\n");

        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        menuHandler(option);
    }

    public static void menuHandler(int option) {
        switch (option) {
            case 1: {
                System.out.println("Staring PVP game!");
                Game pvp = new PlayerGame();
                break;
            }
            case 2: {
                System.out.println("starting game with computer!");
                Game cpu = new CPUgame();
                break;
            }
            case 3: {
                System.out.println("Goodbye!");
                System.exit(0);
            }
            default:
                break;
        }
    }
}

