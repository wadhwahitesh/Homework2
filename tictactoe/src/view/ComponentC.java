package view;


import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.*;


import model.RowGameModel;
import model.RowGameModel.Player;

public class ComponentC implements View{
    public JTextArea playerturn = new JTextArea();


    /**
     * Initialises component C
     * 
     * @param gui the UI where the component will be added
     */
    public ComponentC(JFrame gui){
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn);
        playerturn.setText("Player 1 to play 'X'");
        playerturn.setEditable(false);
    }

    /**
     * updated component C based on the model
     * 
     * @param model current state of the game
     */
    public void update(RowGameModel model){

        if (model.getFinalResult()!=null)
            playerturn.setText(model.getFinalResult());
        else
            if (model.getPlayer() == Player.PLAYER1)
                playerturn.setText("Player 1 to play 'X'");
            else 
                playerturn.setText("Player 2 to play 'O'");
    }
    
}
