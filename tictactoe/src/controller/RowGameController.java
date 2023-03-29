package controller;


import java.util.Arrays;

import model.RowGameModel;
import model.RowGameModel.Player;
import view.RowGameGUI;


public class RowGameController {
    public RowGameModel gameModel;
    public RowGameGUI gameView;

	// public ComponentA componentA;
	// public ComponentC componentC;



    /**
     * Creates a new game initializing the GUI.
     */
    public RowGameController() {
	gameModel = new RowGameModel();
	gameView = new RowGameGUI(this);

	// componentA = gameView.getA();
	// componentC = gameView.getC();

        for(int row = 0; row<3; row++) {
            for(int column = 0; column<3 ;column++) {
	        gameModel.blocksData[row][column].setContents("");
		gameModel.blocksData[row][column].setIsLegalMove(true);

		// componentA.updateBlock(gameModel, row, column);
            }
        }
	gameView.update(gameModel);
    }

	

    /**
     * Moves the current player into the given block.
     *
     * @param block The block to be moved to by the current player
     */
    public void move(Integer[] index) {
	gameModel.movesLeft--;
	gameView.update(gameModel);
	// if(gameModel.movesLeft%2 == 1) {
	//     componentC.playerturn.setText("'X': Player 1");
	// } else{
	//     componentC.playerturn.setText("'O': Player 2");
	// }
	
	if(gameModel.getPlayer().equals(Player.PLAYER1)) {
	    // Check whether player 1 won
	    if(Arrays.equals(index, new Integer[]{0, 0})) {
		
		gameModel.blocksData[0][0].setContents("X");
		gameModel.blocksData[0][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER2);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,0,0);
		
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
				gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 0, 1 })) {
		gameModel.blocksData[0][1].setContents("X");
		gameModel.blocksData[0][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER2);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,0,1);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
				gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 0, 2 })) {
		gameModel.blocksData[0][2].setContents("X");
		gameModel.blocksData[0][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER2);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,0,2);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 1, 0 })) {
		gameModel.blocksData[1][0].setContents("X");
		gameModel.blocksData[1][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER2);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,1,0);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 1, 1 })) {
		gameModel.blocksData[1][1].setContents("X");
		gameModel.blocksData[1][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER2);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,1,1);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 1, 2 })) {
		gameModel.blocksData[1][2].setContents("X");
		gameModel.blocksData[1][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER2);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,1,2);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 2, 0 })) {
		gameModel.blocksData[2][0].setContents("X");
		gameModel.blocksData[2][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER2);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,2,0);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 2, 1 })) {
		gameModel.blocksData[2][1].setContents("X");
		gameModel.blocksData[2][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER2);
		gameView.update(gameModel);
		// componentA.updateBlock(gameModel,2,1);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{2, 2}) ){
		gameModel.blocksData[2][2].setContents("X");
		gameModel.blocksData[2][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER2);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,2,2);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 1 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    }
	} else {
	    // Check whether player 2 won
	    if(Arrays.equals(index, new Integer[]{ 0, 0 })) {
		gameModel.blocksData[0][0].setContents("O");
		gameModel.blocksData[0][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER1);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,0,0);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 0, 1 })) {
		gameModel.blocksData[0][1].setContents("O");
		gameModel.blocksData[0][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER1);
		gameView.update(gameModel);
		// componentA.updateBlock(gameModel,0,1);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{0, 2}) ){
		gameModel.blocksData[0][2].setContents("O");
		gameModel.blocksData[0][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER1);
		gameView.update(gameModel);
		//componentA.updateBlock(gameModel,0,2);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			//componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{1, 0}) ){
		gameModel.blocksData[1][0].setContents("O");
		gameModel.blocksData[1][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER1);
		gameView.update(gameModel);
		// componentA.updateBlock(gameModel,1,0);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			// componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 1, 1 })) {
		gameModel.blocksData[1][1].setContents("O");
		gameModel.blocksData[1][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER1);
		gameView.update(gameModel);
		// componentA.updateBlock(gameModel,1,1);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[1][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()) &&
			gameModel.blocksData[0][1].getContents().equals(gameModel.blocksData[2][1].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()) &&
			gameModel.blocksData[0][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			// componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 1, 2 })) {
		gameModel.blocksData[1][2].setContents("O");
		gameModel.blocksData[1][2].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER1);
		gameView.update(gameModel);
		// componentA.updateBlock(gameModel,1,2);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents()) &&
			gameModel.blocksData[0][2].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[1][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			// componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 2, 0 })) {
		gameModel.blocksData[2][0].setContents("O");
		gameModel.blocksData[2][0].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER1);
		gameView.update(gameModel);
		// componentA.updateBlock(gameModel,2,0);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][0].getContents()) &&
			gameModel.blocksData[1][0].getContents().equals(gameModel.blocksData[0][0].getContents())) ||
		       (gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][2].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			// componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 2, 1 })) {
		gameModel.blocksData[2][1].setContents("O");
		gameModel.blocksData[2][1].setIsLegalMove(false);
		gameModel.setPlayer(Player.PLAYER1);
		gameView.update(gameModel);
		// componentA.updateBlock(gameModel,2,1);
		
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents()) &&
			gameModel.blocksData[2][0].getContents().equals(gameModel.blocksData[2][2].getContents())) ||
		       (gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][1].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			// componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    } else if(Arrays.equals(index, new Integer[]{ 2, 2 })) {
		gameModel.blocksData[2][2].setContents("O");
		gameModel.blocksData[2][2].setIsLegalMove(false);
		gameView.update(gameModel);
		
		//componentA.updateBlock(gameModel,2,2);
		gameModel.setPlayer(Player.PLAYER1);
		if(gameModel.movesLeft<7) {
		    if((gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[2][1].getContents()) &&
			gameModel.blocksData[2][1].getContents().equals(gameModel.blocksData[2][0].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][2].getContents()) &&
			gameModel.blocksData[1][2].getContents().equals(gameModel.blocksData[0][2].getContents())) ||
		       (gameModel.blocksData[2][2].getContents().equals(gameModel.blocksData[1][1].getContents()) &&
			gameModel.blocksData[1][1].getContents().equals(gameModel.blocksData[0][0].getContents()))) {
			gameModel.setFinalResult("Player 2 wins!");
			endGame();
		    } else if(gameModel.movesLeft==0) {
			gameModel.setFinalResult(RowGameModel.GAME_END_NOWINNER);
		    }
		    if (gameModel.getFinalResult() != null) {
			gameView.update(gameModel);
			// componentC.playerturn.setText(gameModel.getFinalResult());
		    }
		}
	    }
	}
    }

    /**
     * Ends the game disallowing further player turns.
     */
    public void endGame() {
	for(int row = 0;row<3;row++) {
	    for(int column = 0;column<3;column++) {
			gameModel.blocksData[row][column].setIsLegalMove(false);
		//componentA.blocks[row][column].setEnabled(false);
	    }
	}
    }

    /**
     * Resets the game to be able to start playing again.
     */
    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                gameModel.blocksData[row][column].reset();
		gameModel.blocksData[row][column].setIsLegalMove(true);
            }
        }
        gameModel.setPlayer(Player.PLAYER1);
        gameModel.movesLeft = 9;
	gameModel.setFinalResult(null);
    gameView.update(gameModel);
    }
}
