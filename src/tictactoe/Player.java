package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private final String playerCharacter;
    private boolean isWon;
    private boolean isComputer;
    private boolean isEasy;
    private boolean isMedium;
    private boolean isHard;
    private String winningCoordinates = "";
    private String opponentCharacter = "";

    public Player(String playerCharacter) {
        this.playerCharacter = playerCharacter;
        this.isWon = false;
        this.isComputer = false;
        this.isEasy = false;
        this.isMedium = false;
        this.isHard = false;

        if (playerCharacter.equals("X")) {
            opponentCharacter = "O";
        } else if (playerCharacter.equals("O")) {
            opponentCharacter = "X";
        }
    }

    public void setEasy(boolean easy) {
        isEasy = easy;
    }

    public void setMedium(boolean medium) {
        isMedium = medium;
    }

    public void setHard(boolean hard) {
        isHard = hard;
    }

    public boolean isHard() {
        return isHard;
    }

    public boolean isEasy() {
        return isEasy;
    }

    public boolean isMedium() {
        return isMedium;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    public String getPlayerCharacter() {
        return playerCharacter;
    }

    public boolean isWon() {
        return !isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }

    //Methods to use when Player is CPU

    //EASY
    public String computerCoordinates() {
        Random random = new Random();
        int lower = 1;
        int upper = 3;

        int intervalLength = upper - lower + 1; //Bound

        int coordX = (random.nextInt(intervalLength) + lower);
        int coordY = (random.nextInt(intervalLength) + lower);

        return coordX + " " + coordY;
    }

    //MEDIUM
    public boolean isWinPossible(Field field) {

        boolean result = false;
        int xCount = 0;
        int oCount = 0;
        int freeSpot = 0;

        //Rows
        List<String> topRow = List.of(new String[]{field.getField()[0][0],field.getField()[0][1], field.getField()[0][2]});
        List<String> midRow = List.of(new String[]{field.getField()[1][0],field.getField()[1][1], field.getField()[1][2]});
        List<String> botRow = List.of(new String[]{field.getField()[2][0],field.getField()[2][1], field.getField()[2][2]});

        //Columns
        List<String> firstCol = List.of(new String[]{field.getField()[0][0],field.getField()[1][0], field.getField()[2][0]});
        List<String> secondCol = List.of(new String[]{field.getField()[0][1],field.getField()[1][1], field.getField()[2][1]});
        List<String> thirdCol = List.of(new String[]{field.getField()[0][2],field.getField()[1][2], field.getField()[2][2]});

        //Diagonals
        List<String> topLeftDiag = List.of(new String[]{field.getField()[0][0],field.getField()[1][1], field.getField()[2][2]});
        List<String> topRightDiag = List.of(new String[]{field.getField()[0][2],field.getField()[1][1], field.getField()[2][0]});

        List<List> listsToCheck = new ArrayList<>();
        listsToCheck.add(topRow);
        listsToCheck.add(midRow);
        listsToCheck.add(botRow);
        listsToCheck.add(firstCol);
        listsToCheck.add(secondCol);
        listsToCheck.add(thirdCol);
        listsToCheck.add(topLeftDiag);
        listsToCheck.add(topRightDiag);

        int listIndex = 0;
        int characterIndex = 0;
        int temporaryIndex = 0;

        String indexOfSpot = "";
        String indexOfList = "";

        for (List list : listsToCheck) {
            for (Object character : list) {
                if (character.equals("X")) {
                    xCount++;
                } else if (character.equals("O")) {
                    oCount++;
                } else if (character.equals(" ")) {
                    temporaryIndex = characterIndex;
                    freeSpot++;
                }
                characterIndex++;
            }

            if (xCount == 2 && freeSpot == 1 || oCount == 2 && freeSpot == 1) {
                indexOfSpot = String.valueOf(temporaryIndex+1);
                indexOfList = String.valueOf(listIndex);
                result = true;
            }
            listIndex++;
            freeSpot = 0;
            characterIndex = 0;
            xCount = 0;
            oCount = 0;
        }

        if (!indexOfList.equals("") && !indexOfSpot.equals("")) {

            StringBuilder coordinate = new StringBuilder();

            switch (indexOfList) {
                case "0":
                    switch (indexOfSpot){
                        case "1":
                            coordinate.append("1 1");
                            break;
                        case "2":
                            coordinate.append("1 2");
                            break;
                        case "3":
                            coordinate.append("1 3");
                            break;
                    }
                    break;
                case "1":
                    switch (indexOfSpot){
                        case "1":
                            coordinate.append("2 1");
                            break;
                        case "2":
                            coordinate.append("2 2");
                            break;
                        case "3":
                            coordinate.append("2 3");
                            break;
                    }
                    break;
                case "2":
                    switch (indexOfSpot){
                        case "1":
                            coordinate.append("3 1");
                            break;
                        case "2":
                            coordinate.append("3 2");
                            break;
                        case "3":
                            coordinate.append("3 3");
                            break;
                    }
                    break;
                case "3":
                    switch (indexOfSpot){
                        case "1":
                            coordinate.append("1 1");
                            break;
                        case "2":
                            coordinate.append("2 1");
                            break;
                        case "3":
                            coordinate.append("3 1");
                            break;
                    }
                    break;
                case "4":
                    switch (indexOfSpot){
                        case "1":
                            coordinate.append("1 2");
                            break;
                        case "2":
                            coordinate.append("2 2");
                            break;
                        case "3":
                            coordinate.append("3 2");
                            break;
                    }
                    break;
                case "5":
                    switch (indexOfSpot){
                        case "1":
                            coordinate.append("1 3");
                            break;
                        case "2":
                            coordinate.append("2 3");
                            break;
                        case "3":
                            coordinate.append("3 3");
                            break;
                    }
                    break;
                case "6":
                    switch (indexOfSpot){
                        case "1":
                            coordinate.append("1 1");
                            break;
                        case "2":
                            coordinate.append("2 2");
                            break;
                        case "3":
                            coordinate.append("3 3");
                            break;
                    }
                    break;
                case "7":
                    switch (indexOfSpot){
                        case "1":
                            coordinate.append("1 3");
                            break;
                        case "2":
                            coordinate.append("2 2");
                            break;
                        case "3":
                            coordinate.append("3 1");
                            break;
                    }
                    break;
            }
            setWinningCoordinates(coordinate);
        }
        return result;
    }

    //HARD - MINIMAX ALGORITHM
    public String bestMove(Field field) {

        int bestScore = -1000;
        String move = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.getField()[i][j].equals(" ")) {
                    field.getField()[i][j] = getPlayerCharacter();
                    int score = minimax(field, 0, false);
                    field.getField()[i][j] = " ";
                    if (score > bestScore) {
                        bestScore = score;

                        int coordX = i+1;
                        int coordY = j+1;
                        move = coordX + " " + coordY;
                    }
                }
            }
        }

        return move;
    }

    private int scores(String result) {

        int score = 0;

        if (getPlayerCharacter().equals("X")) {
            switch (result) {
                case "X":
                    score = 10;
                    break;
                case "O":
                    score = -10;
                    break;
                case "tie":
                    break;
            }
        } else if (getPlayerCharacter().equals("O")) {
            switch (result) {
                case "O":
                    score = 10;
                    break;
                case "X":
                    score = -10;
                    break;
                case "tie":
                    break;
            }
        }
        return score;
    }



    private int minimax(Field field, int depth, boolean isMaximizing) {

        String result = checkWinner(field);

        if (result != null) {
            return scores(result);
        }
        int bestScore;
        if (isMaximizing) {
            bestScore = -2;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field.getField()[i][j].equals(" ")) {
                        field.getField()[i][j] = getPlayerCharacter();
                        int score = minimax(field, depth + 1, false);
                        field.getField()[i][j] = " ";
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }

        } else {
            bestScore = 2;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field.getField()[i][j].equals(" ")) {
                        field.getField()[i][j] = opponentCharacter;
                        int score = minimax(field, depth + 1, true);
                        field.getField()[i][j] = " ";
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }

        }
        return bestScore;
    }

    private String checkWinner(Field field) {
        String winner = null;

        // horizontal
        for (int i = 0; i < 3; i++) {
            if (field.getField()[i][0].equals(field.getField()[i][1]) && field.getField()[i][1].equals(field.getField()[i][2]) && !field.getField()[i][0].equals(" ")) {
                winner = field.getField()[i][0];
            }
        }

        // Vertical
        for (int i = 0; i < 3; i++) {
            if (field.getField()[0][i].equals(field.getField()[1][i]) && field.getField()[1][i].equals(field.getField()[2][i]) && !field.getField()[0][i].equals(" ")) {
                winner = field.getField()[0][i];
            }
        }

        // Diagonal
        if (field.getField()[0][0].equals(field.getField()[1][1]) && field.getField()[1][1].equals(field.getField()[2][2]) && !field.getField()[0][0].equals(" ")) {
            winner = field.getField()[0][0];
        }
        if (field.getField()[2][0].equals(field.getField()[1][1]) && field.getField()[1][1].equals(field.getField()[0][2]) && !field.getField()[2][0].equals(" ")) {
            winner = field.getField()[2][0];
        }

        int openSpots = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field.getField()[i][j].equals(" ")) {
                    openSpots++;
                }
            }
        }
        if (winner == null && openSpots == 0) {
            return "tie";
        } else {
            return winner;
        }
    }

    //---------------------------------------------------------------------------------------------------------------------
    private void setWinningCoordinates(StringBuilder winningCoordinate) {
        winningCoordinates = winningCoordinate.toString();
    }

    public String getWinningCoordinates() {
        return winningCoordinates;
    }

}
