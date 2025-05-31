package game;

import model.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.Scanner;

public class SnakeAndLadderGame {
    Board board;
    Deque<Player> players;
    Dice dice;
    Scanner scanner = new Scanner(System.in);

    public void initializeGame(){
        //dice = new Dice(1);
        createPlayers(2);
        createBoard(10,5,5);

    }

    private void createPlayers(int num) {
        players = new ArrayDeque<>();
        for (int i = 0; i < num ; i++) {
            System.out.println("Enter player " + (i+1) + " name :");
            String playerName = scanner.nextLine();
            Player player = new Player(i+1, playerName);
            players.add(player);
        }
        //return players;
    }

    private void createBoard(int size, int nos, int nol) {
        board = new Board(size, nos,nol);
        Cell[][] cells = board.getCells();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                cells[i][j] = new Cell();
            }
        }
        board.setCells(cells);
        addSnakes(nos);
        addLadder(nol);

    }

    //private void create

    private void addSnakes(int nos) {
        Random random = new Random();
        Cell[][] cells = board.getCells();
        int min = 0;
        int max = board.getSize() * board.getSize() - 1;
        while (nos > 0) {
            int start = random.nextInt(max - min + 1) + min;
            int end = random.nextInt(max - min + 1) + min;
            int row = start / 10;
            int column = start % 10;
            Cell cell = cells[row][column];
            if (start <= end && cell.getSnakeLadder() != null) {
                continue;
            }
            SnakeLadder snake = new SnakeLadder(start, end);
            snake.setType("Snake");

            cells[row][column] = new Cell(snake);
            nos--;
        }
    }

    private void addLadder(int nol) {
        Random random = new Random();
        Cell[][] cells = board.getCells();
        int min = 0;
        int max = board.getSize() * board.getSize() - 1;
        while (nol > 0) {
            int start = random.nextInt(max - min + 1) + min;
            int end = random.nextInt(max - min + 1) + min;
            int row = start / 10;
            int column = start % 10;
            Cell cell = cells[row][column];
            if (start >= end && cell.getSnakeLadder() != null) {
                continue;
            }
            SnakeLadder ladder = new SnakeLadder(start, end);
            ladder.setType("Ladder");

            cells[row][column] = new Cell(ladder);
            nol--;
        }
    }

    public Player playGame() {
        Cell[][] cells = board.getCells();
        boolean isWinner = false;
        Player currPlayer = null;
        int playerCurrPosition;
        int playerNewPosition;
        while (!isWinner) {

            currPlayer = players.removeFirst();
            playerCurrPosition = currPlayer.getCurrentPosition();
            System.out.println("Rolling dice : enter roll");
            scanner.nextLine();
            dice = new Dice(1);
            int diceValue = dice.rollDice();
            System.out.println("dice shows : " + diceValue);
            playerCurrPosition += diceValue;
            if (playerCurrPosition >= board.getSize()* board.getSize() - 1) {
                return currPlayer;
            }

            int row = playerCurrPosition / board.getSize();
            int column = playerCurrPosition % board.getSize();
            if (cells[row][column].getSnakeLadder() != null) {
                SnakeLadder snakeLadder = cells[row][column].getSnakeLadder();
                if (snakeLadder.getType().equalsIgnoreCase("Snake")) {
                    System.out.println("Oh O!, a snake");
                }
                if (snakeLadder.getType().equalsIgnoreCase("Ladder")) {
                    System.out.println("YaY!, a ladder");
                }
                currPlayer = snakeLadder.jump(currPlayer);
                playerNewPosition = currPlayer.getCurrentPosition();
                System.out.println("Player " + currPlayer.getPlayerName() + " moved to " + playerNewPosition);
                currPlayer.setCurrentPosition(playerNewPosition);
            }
            else {
                currPlayer.setCurrentPosition(playerCurrPosition);
                System.out.println("Player " + currPlayer.getPlayerName() + " moved to " + playerCurrPosition);
            }
            players.addLast(currPlayer);
            //isWinner = isWinner(currPlayer);

        }
        return currPlayer;

    }

    public boolean isWinner(Player player) {
        return player.getCurrentPosition() > board.getSize() * board.getSize() - 1;
    }



//    public static void main(String[] args) {
//        SnakeAndLadderGame game = new SnakeAndLadderGame();
//        game.initializeGame();
//        Board board1 = game.board;
//    }

}
