package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import model.RowGameModel;
import controller.RowGameController;

public class ComponentA implements View{
    public JButton[][] blocks = new JButton[3][3];

    Map<JButton, Integer[] > buttonMaps = new HashMap<JButton, Integer[]>();


    /**
     * Initialises component A
     * 
     * @param gui the UI where the component will be added
     * @param controller for passing the action listener method
     */
    public ComponentA(JFrame gui, RowGameController controller){
        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3, 3));
        gamePanel.add(game, BorderLayout.CENTER);

        gui.add(gamePanel, BorderLayout.NORTH);

        // Initialize a JButton for each cell of the 3x3 game board.
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75, 75));
                blocks[row][column].setEnabled(false);
                blocks[row][column].setFocusable(false);
                buttonMaps.put(blocks[row][column], new Integer[] {row, column});
                game.add(blocks[row][column]);
                blocks[row][column].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.move(buttonMaps.get((JButton) e.getSource()));
                    }
                });
            }
        }
}

/**
 * updated component A based on the model
 * 
 * @param gameModel current state of the game
 */
public void update(RowGameModel gameModel) {
    for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {

                blocks[row][column].setText(gameModel.blocksData[row][column].getContents());
                blocks[row][column].setEnabled(gameModel.blocksData[row][column].getIsLegalMove());



            }

        }


}
}
