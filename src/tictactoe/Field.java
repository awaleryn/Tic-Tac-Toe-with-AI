package tictactoe;


import java.util.Arrays;

public class Field {

    private final String[][] field = new String[3][3];

    public String[][] getField() {
        return field;
    }

    public void putBlankCells() {
        for (String[] row : field) {
            Arrays.fill(row, " ");
        }
    }

    public boolean isNotOccupied(String coords) {
        String[] parts = coords.trim().split(" ");
        return field[Integer.parseInt(parts[0])-1][Integer.parseInt(parts[1])-1].equals(" ");
    }

    public void putInWantedCells(String coords) {

        String[] parts = coords.trim().split(" ");

        if (StateOfGame.getOCount() < StateOfGame.getxCount()) {
            field[Integer.parseInt(parts[0])-1][Integer.parseInt(parts[1])-1] = "O";
        } else if (StateOfGame.getOCount() == StateOfGame.getxCount()) {
            field[Integer.parseInt(parts[0])-1][Integer.parseInt(parts[1])-1] = "X";
        }
    }

    @Override
    public String toString() {
        return "---------" +
        "\n| " + field[0][0] + " " + field[0][1] + " " + field[0][2] + " |" +
                "\n| " + field[1][0] + " " + field[1][1] + " " + field[1][2] + " |" +
                "\n| " + field[2][0] + " " + field[2][1] + " " + field[2][2] + " |" +
                "\n---------";

    }

}
