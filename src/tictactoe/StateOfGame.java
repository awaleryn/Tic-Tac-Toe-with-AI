package tictactoe;

public class StateOfGame {

    private static int xCount = 0;
    private static int OCount = 0;
    private static int freeSpots = 0;

    public StateOfGame() {
    }

    public static int getFreeSpots() {
        return freeSpots;
    }

    public static int getOCount() {
        return OCount;
    }

    public static int getxCount() {
        return xCount;
    }


    public static void spotsCounter(Field field) {
        xCount = 0;
        OCount = 0;
        freeSpots = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (field.getField()[i][j]) {
                    case " ":
                        freeSpots++;
                        break;
                    case "X":
                        xCount++;
                        break;
                    case "O":
                        OCount++;
                        break;
                }
            }
        }
    }

    public static boolean isWon(Field field, Player player) {
        boolean result = false;

        //TOP ROW
        if (field.getField()[0][0].equals(player.getPlayerCharacter()) && field.getField()[0][1].equals(player.getPlayerCharacter()) && field.getField()[0][2].equals(player.getPlayerCharacter())) {
            player.setWon(true);
            result = true;
        }
        //MID ROW
        if (field.getField()[1][0].equals(player.getPlayerCharacter()) && field.getField()[1][1].equals(player.getPlayerCharacter()) && field.getField()[1][2].equals(player.getPlayerCharacter())) {
            player.setWon(true);
            result = true;
        }
        //BOT ROW
        if (field.getField()[2][0].equals(player.getPlayerCharacter()) && field.getField()[2][1].equals(player.getPlayerCharacter()) && field.getField()[2][2].equals(player.getPlayerCharacter())) {
            player.setWon(true);
            result = true;
        }
        //LEFT COLUMN
        if (field.getField()[0][0].equals(player.getPlayerCharacter()) && field.getField()[1][0].equals(player.getPlayerCharacter()) && field.getField()[2][0].equals(player.getPlayerCharacter())) {
            player.setWon(true);
            result = true;
        }
        //MID COLUMN
        if (field.getField()[0][1].equals(player.getPlayerCharacter()) && field.getField()[1][1].equals(player.getPlayerCharacter()) && field.getField()[2][1].equals(player.getPlayerCharacter())) {
            player.setWon(true);
            result = true;
        }
        //RIGHT COLUMN
        if (field.getField()[0][2].equals(player.getPlayerCharacter()) && field.getField()[1][2].equals(player.getPlayerCharacter()) && field.getField()[2][2].equals(player.getPlayerCharacter())) {
            player.setWon(true);
            result = true;
        }
        //CROSS FROM TOP LEFT
        if (field.getField()[0][0].equals(player.getPlayerCharacter()) && field.getField()[1][1].equals(player.getPlayerCharacter()) && field.getField()[2][2].equals(player.getPlayerCharacter())) {
            player.setWon(true);
            result = true;
        }
        //CROSS FROM TOP RIGHT
        if (field.getField()[0][2].equals(player.getPlayerCharacter()) && field.getField()[1][1].equals(player.getPlayerCharacter()) && field.getField()[2][0].equals(player.getPlayerCharacter())) {
            player.setWon(true);
            result = true;
        }

        return result;
    }





}
