package threes.threescopy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ThreesGame {

    private int[][] table;

    public ThreesGame() {
        this.table = new int[4][4];
        
        for (int i = 0; i < 4; i++) {
            generateNewNumber();
        }
    }

    public int getSquare(int y, int x) {
        return table[y][x];
    }

    public void moveUp() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] != 0 && (i - 1 >= 0)) {
                    int current = table[i][j];
                    int target = table[i - 1][j];

                    if (target == 0) {
                        table[i - 1][j] = table[i][j];
                        table[i][j] = 0;
                    }

                    if ((current == 1 && target == 2) || (current == 2 && target == 1)) {
                        table[i - 1][j] = 3;
                        table[i][j] = 0;
                    }

                    if ((current != 1 && current != 2) && current == target) {
                        table[i - 1][j] = (current + target);
                        table[i][j] = 0;
                    }
                }
            }
        }
    }

    public void moveDown() {
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] != 0 && (i + 1 < 4)) {
                    int current = table[i][j];
                    int target = table[i + 1][j];

                    if (target == 0) {
                        table[i + 1][j] = table[i][j];
                        table[i][j] = 0;
                    }

                    if ((current == 1 && target == 2) || (current == 2 && target == 1)) {
                        table[i + 1][j] = 3;
                        table[i][j] = 0;
                    }

                    if ((current != 1 && current != 2) && current == target) {
                        table[i + 1][j] = (current + target);
                        table[i][j] = 0;
                    }
                }
            }
        }
    }

    public void moveLeft() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] != 0 && (j - 1 >= 0)) {
                    int current = table[i][j];
                    int target = table[i][j - 1];

                    if (target == 0) {
                        table[i][j - 1] = table[i][j];
                        table[i][j] = 0;
                    }

                    if ((current == 1 && target == 2) || (current == 2 && target == 1)) {
                        table[i][j - 1] = 3;
                        table[i][j] = 0;
                    }

                    if ((current != 1 && current != 2) && current == target) {
                        table[i][j - 1] = (current + target);
                        table[i][j] = 0;
                    }
                }
            }
        }
    }

    public void moveRight() {
        for (int i = 0; i <= 3; i++) {
            for (int j = 3; j >= 0; j--) {
                if (table[i][j] != 0 && (j + 1 < 4)) {
                    int current = table[i][j];
                    int target = table[i][j + 1];

                    if (target == 0) {
                        table[i][j + 1] = table[i][j];
                        table[i][j] = 0;
                    }

                    if ((current == 1 && target == 2) || (current == 2 && target == 1)) {
                        table[i][j + 1] = 3;
                        table[i][j] = 0;
                    }

                    if ((current != 1 && current != 2) && current == target) {
                        table[i][j + 1] = (current + target);
                        table[i][j] = 0;
                    }
                }
            }
        }
    }

    public void generateNewNumber() {
        ArrayList<String> spaces = new ArrayList<String>();

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                if (table[i][j] == 0) {
                    spaces.add(i + ":" + j);
                }
            }
        }

        Collections.shuffle(spaces);
        String space = spaces.get(0);

        String[] parts = space.split(":");
        int i = Integer.parseInt(parts[0]);
        int j = Integer.parseInt(parts[1]);

        Random rnd = new Random();
        int newNumber = rnd.nextInt(2) + 1;

        table[i][j] = newNumber;
    }
}
