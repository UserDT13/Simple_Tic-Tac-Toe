import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] charField = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
        boolean gameFinished = false;
        boolean validInput = false;
        String inputMove;
        char[] validNums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        boolean validRow = false;
        boolean validColumn = false;
        char setPlayer;
        int counterTurn = 0;
    
        System.out.print("""
        ---------
        |       |
        |       |
        |       |
        ---------
        """);

        while (!validInput || !gameFinished) {
            validInput = false;
            inputMove = scanner.nextLine();

            for (char charNum : validNums) {
                if (charNum == inputMove.charAt(0)) validRow = true;
                if (charNum == inputMove.charAt(2)) validColumn = true;
            }

            if (!(validRow && validColumn)) {
                System.out.println("You should enter numbers!");
            } else {
                int row = Character.getNumericValue(inputMove.charAt(0));
                int column = Character.getNumericValue(inputMove.charAt(2));

                if (row > 3 || row < 1 || column > 3 || column < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (charField[row - 1][column - 1] == 'X' || charField[row - 1][column - 1] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    counterTurn++;
                    System.out.println("Aktueller Zug: " + counterTurn);
                    setPlayer = counterTurn % 2 == 0 ? 'O' : 'X';
                    charField[row -1][column - 1] = setPlayer;
                    validInput = true;

                    System.out.println("---------");
                    for (int r = 0; r < charField.length; r++) {
                        System.out.print("| ");
                        for (int c = 0; c < charField[r].length; c++) {
                            if (charField[r][c] != '_') {
                                System.out.print(charField[r][c] + " ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.print("|\n");
                    }
                    System.out.println("---------");

                    if(charField[0][0] == setPlayer && charField[0][1] == setPlayer && charField[0][2] == setPlayer) {
                        System.out.println(setPlayer + " wins 1");
                        gameFinished = true;
                    } else if (charField[1][0] == setPlayer && charField[1][1] == setPlayer && charField[1][2] == setPlayer) {
                        System.out.println(setPlayer + " wins 2");
                        gameFinished = true;
                    } else if (charField[2][0] == setPlayer && charField[2][1] == setPlayer && charField[2][2] == setPlayer) {
                        System.out.println(setPlayer + " wins 3");
                        gameFinished = true;
                    } else if (charField[0][0] == setPlayer && charField[1][0] == setPlayer && charField[2][0] == setPlayer) {
                        System.out.println(setPlayer + " wins 4");
                        gameFinished = true;
                    } else if (charField[0][1] == setPlayer && charField[1][1] == setPlayer && charField[2][1] == setPlayer) {
                        System.out.println(setPlayer + " wins 5");
                        gameFinished = true;
                    } else if (charField[0][2] == setPlayer && charField[1][2] == setPlayer && charField[2][2] == setPlayer) {
                        System.out.println(setPlayer + " wins 6");
                        gameFinished = true;
                    } else if (charField[0][0] == setPlayer && charField[1][1] == setPlayer && charField[2][2] == setPlayer) {
                        System.out.println(setPlayer + " wins 7");
                        gameFinished = true;
                    } else if (charField[0][2] == setPlayer && charField[1][1] == setPlayer && charField[2][0] == setPlayer) {
                        System.out.println(setPlayer + " wins 8");
                        gameFinished = true;
                    } else if (counterTurn == 9) {
                        System.out.println("Draw");
                        gameFinished = true;
                    }
                }
            } 
        }
        scanner.close();
    }
}
