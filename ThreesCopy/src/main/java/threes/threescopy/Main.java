package threes.threescopy;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        ThreesGame game = new ThreesGame();
        
        GraphicalInterface gui = new GraphicalInterface(game);
        SwingUtilities.invokeLater(gui);
    }
    
}
