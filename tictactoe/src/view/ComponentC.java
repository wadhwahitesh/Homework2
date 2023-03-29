package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

import model.RowGameModel;
import model.RowGameModel.Player;
import controller.RowGameController;

public class ComponentC implements View{
    public JTextArea playerturn = new JTextArea();

    public ComponentC(JFrame gui){
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn);
        playerturn.setText("Player 1 to play 'X'");
        playerturn.setEditable(false);
    }

    public void update(RowGameModel model){

        if (model.getPlayer() == Player.PLAYER1)
            playerturn.setText("Player 1 to play 'X'");
        else 
            playerturn.setText("Player 2 to play 'O'");


    }
    
}
