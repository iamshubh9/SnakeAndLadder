import game.SnakeAndLadderGame;
import model.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("Lets Play Snake and Ladder!");
        SnakeAndLadderGame game = new SnakeAndLadderGame();
        game.initializeGame();
        Player player = game.playGame();
        System.out.println("Winner is " + player.getPlayerName());
    }
}