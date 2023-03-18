package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import controller.RowGameController;

public class ComponentA implements View{
    public JButton[][] blocks = new JButton[3][3];

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
                game.add(blocks[row][column]);
                blocks[row][column].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.move((JButton) e.getSource());
                    }
                });
            }
        }
}    

public void updateBlock(RowGameModel gameModel, int row, int column) {
    blocks[row][column].setText(gameModel.blocksData[row][column].getContents());
    blocks[row][column].setEnabled(gameModel.blocksData[row][column].getIsLegalMove());
}

public void update(RowGameModel model) {

}
}
