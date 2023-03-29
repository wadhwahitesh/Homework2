package model;


public class RowGameModel 
{
    public static final String GAME_END_NOWINNER = "Game ends in a draw";

    public RowBlockModel[][] blocksData = new RowBlockModel[3][3];

    

    public enum Player{PLAYER1, PLAYER2};

    /**
     * The current player taking their turn
     */
    private Player player = Player.PLAYER1;
    public int movesLeft = 9;

    private String finalResult = null;

    /**
     * Creates the 9 blocks where data is stored
     */
    public RowGameModel() {
	super();

	for (int row = 0; row < 3; row++) {
	    for (int col = 0; col < 3; col++) {
		blocksData[row][col] = new RowBlockModel(this);
	    } // end for col
	} // end for row
    }

    /**
     * gets final result string
     *
     * 
     * @return return final result string
     */
    public String getFinalResult() {
	return this.finalResult;
    }

    /**
     * sets final result string
     *
     * 
     * @param finalResult takes the string to which final result is updated
     */
    public void setFinalResult(String finalResult) {
	this.finalResult = finalResult;
    }


    /**
     * get what player is currently playing
     *
     * 
     * @return current Player
     */
    public Player getPlayer(){
        return this.player;
    }


    /**
     * sets the current player
     *
     * 
     * @param player player to be set as current player
     */
    public void setPlayer(Player player){
        this.player = player;
    }
}
