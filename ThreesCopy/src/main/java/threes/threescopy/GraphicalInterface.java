package threes.threescopy;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class GraphicalInterface implements Runnable {
    private ThreesGame game;
    private JFrame frame;
    private JPanel board;
    private JLabel[][] squares;
    
    public GraphicalInterface(ThreesGame game) {
        this.game = game;
        
        this.squares = new JLabel[4][4];
    }

    @Override
    public void run() {
        this.frame = new JFrame("Threes");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        KeyboardListener keys = new KeyboardListener(game, squares);
        frame.addKeyListener(keys);

        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        createBoard();

        container.add(board);
    }
    
    private void createBoard() {
        board = new JPanel(new GridLayout(4, 4));

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                JLabel label = new JLabel();
                label.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                if (game.getSquare(i, j) != 0) {
                    label.setText(" " + game.getSquare(i, j));
                    label.setFont(new Font("Serif", Font.BOLD, 40));
                }
                squares[i][j] = label;
                board.add(label);
            }
        }
    }
}
