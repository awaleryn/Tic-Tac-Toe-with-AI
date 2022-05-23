package tictactoe;

import java.util.Scanner;

public class UserInterface {

    private final Scanner scanner = new Scanner(System.in);
    Player playerX = new Player("X");
    Player playerO = new Player("O");
    private boolean isExit = false; // boolean to check if user wanted to exit the game
    private boolean isNewGame = true; // boolean to check if new game started
    private boolean isOver = false; // boolean to check if game is over / win, draw etc.

    public void launch() {
        Field TicTacToeGame = new Field();
        TicTacToeGame.putBlankCells();

        int index = 1; // Index to change players turn

        while (true) {

            if (isNewGame) { // if new game started we search for start commands
                while (true) { // checking if input is ok or not
                    System.out.print("Input command: ");
                    String input = scanner.nextLine();

                    if (input.equals("exit")) {
                        isExit = true;
                        break;
                    } else {
                        if (!isInputCommandOk(input)) {
                            System.out.println("\nBad parameters!");
                        } else {
                            isOver = false;
                            break;
                        }
                    }
                }
            }
            isNewGame = false;
            if (isExit) {
                break;
            }

            System.out.println(TicTacToeGame);

            if (index % 2 == 1) {  // switching betwen playerX and playerO

                if (!playerX.isComputer()) {
                    boolean isActivePlayer1 = true;

                    while (isActivePlayer1) {
                        System.out.println("Enter the coordinates: > ");
                        String input = scanner.nextLine();
                        if (isInputOk(input)) {
                            continue;
                        }

                        if (TicTacToeGame.isNotOccupied(input)) {
                            TicTacToeGame.putInWantedCells(input);

                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            continue;
                        }
                        StateOfGame.spotsCounter(TicTacToeGame);
                        printStateOfGame(TicTacToeGame, playerX, playerO);
                        isActivePlayer1 = false;
                    }
                } else if (playerX.isComputer()) { // if player is computer
                    boolean isActivePlayer1 = true;

                    while (isActivePlayer1) {

                        if (playerX.isHard()) {
                            String coords = playerX.bestMove(TicTacToeGame);
                            TicTacToeGame.putInWantedCells(coords);
                            StateOfGame.spotsCounter(TicTacToeGame);
                            printStateOfGame(TicTacToeGame, playerX, playerO);
                            break;
                        }

                        if (playerX.isMedium()) {
                            if (playerX.isWinPossible(TicTacToeGame)) {
                                String coords = playerX.getWinningCoordinates();
                                TicTacToeGame.putInWantedCells(coords);
                                StateOfGame.spotsCounter(TicTacToeGame);
                                printStateOfGame(TicTacToeGame, playerX, playerO);
                                break;
                            }
                        }

                        String input = playerX.computerCoordinates();

                        if (TicTacToeGame.isNotOccupied(input)) { // if cells aren't occupied put X
                            TicTacToeGame.putInWantedCells(input);

                        } else { // loop again
                            continue;
                        }

                        StateOfGame.spotsCounter(TicTacToeGame);
                        printStateOfGame(TicTacToeGame, playerX, playerO);

                        if (playerX.isEasy()) {
                            System.out.println("Making move level \"easy\"");
                        } else if (playerX.isMedium()) {
                            System.out.println("Making move level \"medium\"");
                        } else if (playerX.isHard()) {
                            System.out.println("Making move level \"hard\"");
                        }

                        isActivePlayer1 = false;
                    }
                }

            } else {
                if (!playerO.isComputer()) {
                    boolean isActivePlayer2 = true;

                    while (isActivePlayer2) {
                        System.out.println("Enter the coordinates: > ");
                        String input = scanner.nextLine();
                        if (isInputOk(input)) {
                            continue;
                        }

                        if (TicTacToeGame.isNotOccupied(input)) {
                            TicTacToeGame.putInWantedCells(input);

                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            continue;
                        }
                        StateOfGame.spotsCounter(TicTacToeGame);
                        printStateOfGame(TicTacToeGame, playerX, playerO);
                        isActivePlayer2 = false;
                    }
                } else if (playerO.isComputer()) {
                    boolean isActivePlayer2 = true;

                    while (isActivePlayer2) {

                        if (playerO.isHard()) {
                            String coords = playerO.bestMove(TicTacToeGame);
                            TicTacToeGame.putInWantedCells(coords);
                            StateOfGame.spotsCounter(TicTacToeGame);
                            printStateOfGame(TicTacToeGame, playerX, playerO);
                            break;
                        }

                        if (playerO.isMedium()) {
                            if (playerO.isWinPossible(TicTacToeGame)) {
                                String coords = playerO.getWinningCoordinates();
                                TicTacToeGame.putInWantedCells(coords);
                                StateOfGame.spotsCounter(TicTacToeGame);
                                printStateOfGame(TicTacToeGame, playerX, playerO);
                                break;
                            }
                        }

                        String input = playerO.computerCoordinates();

                        if (TicTacToeGame.isNotOccupied(input)) {
                            TicTacToeGame.putInWantedCells(input);

                        } else {
                            continue;
                        }
                        StateOfGame.spotsCounter(TicTacToeGame);
                        printStateOfGame(TicTacToeGame, playerX, playerO);

                        if (playerO.isEasy()) {
                            System.out.println("Making move level \"easy\"");
                        } else if (playerO.isMedium()) {
                            System.out.println("Making move level \"medium\"");
                        } else if (playerO.isHard()) {
                            System.out.println("Making move level \"hard\"");
                        }

                        isActivePlayer2 = false;
                    }
                }
            }
            index++;
            if (isOver) { // if game is over we switch bool new game to true and start looking for start commands again
                isNewGame = true;
            }

        }
    }

    private boolean isInputOk(String input) {
        boolean isOk = true;
        String[] parts = input.trim().split(" ");

        try {
            int coordX = Integer.parseInt(parts[0]);
            int coordY = Integer.parseInt(parts[1]);

            if (coordX < 1 || coordX > 3 || coordY <1 || coordY >3) {
                isOk = false;
                System.out.println("Coordinates should be from 1 to 3!");
            }

        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            isOk = false;
        }

        return !isOk;
    }

    private void printStateOfGame(Field TicTacToeGame, Player playerX, Player playerO) {
        if (StateOfGame.isWon(TicTacToeGame, playerX)) {
            System.out.println(TicTacToeGame);
            System.out.println("X wins");
            isOver = true;
        } else if (StateOfGame.isWon(TicTacToeGame, playerO)) {
            System.out.println(TicTacToeGame);
            System.out.println("O wins");
            isOver = true;
        } else if (StateOfGame.getFreeSpots() == 0 && playerX.isWon() && playerO.isWon()) {
            System.out.println(TicTacToeGame);
            System.out.println("Draw");
            isOver = true;
        }
    }

    private boolean isInputCommandOk(String input) {
        boolean result = false;
        String[] parts = input.split(" ");


        if (isInputOkToCheck(input)) {
            if (parts[0].equals("start") && parts[1].equals("user") && parts[2].equals("user")) {
                result = true;
            } else if (parts[0].equals("start") && parts[1].equals("easy") && parts[2].equals("user")) {
                playerX.setComputer(true);
                playerX.setEasy(true);
                result = true;
            } else if (parts[0].equals("start") && parts[1].equals("user") && parts[2].equals("easy")) {
                playerO.setComputer(true);
                playerO.setEasy(true);
                return true;
            } else if (parts[0].equals("start") && parts[1].equals("easy") && parts[2].equals("easy")) {
                playerX.setComputer(true);
                playerX.setEasy(true);
                playerO.setComputer(true);
                playerO.setEasy(true);
                return true;
            } else if (parts[0].equals("start") && parts[1].equals("medium") && parts[2].equals("user")) {
                playerX.setComputer(true);
                playerX.setMedium(true);
                result = true;
            }  else if (parts[0].equals("start") && parts[1].equals("user") && parts[2].equals("medium")) {
                playerO.setComputer(true);
                playerO.setMedium(true);
                result = true;
            } else if (parts[0].equals("start") && parts[1].equals("medium") && parts[2].equals("medium")) {
                playerX.setComputer(true);
                playerX.setMedium(true);
                playerO.setComputer(true);
                playerO.setMedium(true);
                return true;
            } else if (parts[0].equals("start") && parts[1].equals("user") && parts[2].equals("hard")) {
                playerO.setComputer(true);
                playerO.setHard(true);
                result = true;
            } else if (parts[0].equals("start") && parts[1].equals("hard") && parts[2].equals("user")) {
                playerX.setComputer(true);
                playerX.setHard(true);
                result = true;
            } else if (parts[0].equals("start") && parts[1].equals("hard") && parts[2].equals("hard")) {
                playerX.setComputer(true);
                playerX.setHard(true);
                playerO.setComputer(true);
                playerO.setHard(true);
                return true;
            }
        }

        return result;
    }

    private boolean isInputOkToCheck(String input) {
        boolean result = true;
        String[] parts = input.split(" ");

        if (parts.length == 0 || parts.length == 1 && !parts[0].equals("exit")|| parts.length == 2) {
            result = false;
        }

        return result;
    }

}
