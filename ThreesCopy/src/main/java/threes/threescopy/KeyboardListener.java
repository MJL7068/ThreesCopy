package threes.threescopy;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;

public class KeyboardListener implements KeyListener {

    private ThreesGame game;
    private JLabel[][] squares;

    public KeyboardListener(ThreesGame game, JLabel[][] squares) {
        this.game = game;
        this.squares = squares;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            game.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            game.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            game.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            game.moveRight();
        }

        game.generateNewNumber();
        setSquares();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void setSquares() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (game.getSquare(i, j) == 0) {
                    squares[i][j].setText("");
                } else {
                    squares[i][j].setText(" " + game.getSquare(i, j));
                    squares[i][j].setFont(new Font("Serif", Font.BOLD, 40));
                }
            }
        }
    }

}
