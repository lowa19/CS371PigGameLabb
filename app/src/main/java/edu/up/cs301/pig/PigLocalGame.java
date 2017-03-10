package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    PigGameState myGameState, copy;
    int tempPlayerScore, tempRunningScore,tempRoll;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        myGameState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(playerIdx == myGameState.getTurnId())
        {
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if(action instanceof PigHoldAction)
        {
            if(myGameState.getTurnId()==0)
            {
                tempPlayerScore = myGameState.getPlayer0Score();
                tempRunningScore = myGameState.getCurRunTotal();
                tempPlayerScore += tempRunningScore;
                myGameState.setPlayer0Score(tempPlayerScore);
                myGameState.setCurRunTotal(0);
                myGameState.setTurnId(1);
                return true;
            }
            else if(myGameState.getTurnId()==1)
            {
                tempPlayerScore = myGameState.getPlayer1Score();
                tempRunningScore = myGameState.getCurRunTotal();
                tempPlayerScore += tempRunningScore;
                myGameState.setPlayer1Score(tempPlayerScore);
                myGameState.setCurRunTotal(0);
                myGameState.setTurnId(0);
                return true;
            }
        }
        else if(action instanceof PigRollAction)
        {
            tempRoll = (int)(Math.random()*6)+1;
            myGameState.setCurVal(tempRoll);
            if (tempRoll == 1)
            {
                myGameState.setCurRunTotal(0);
                if(myGameState.getTurnId()==0) {
                    myGameState.setTurnId(1);
                }
                else{
                    myGameState.setTurnId(0);
                }
                return true;
            }
            else {
                tempRoll += myGameState.getCurRunTotal();
                myGameState.setCurRunTotal(tempRoll);
                return true;
            }
        }
            return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        copy = new PigGameState(myGameState);
        p.sendInfo((GameState)copy);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(myGameState.getPlayer0Score() >= 50 || myGameState.getPlayer1Score()>=50)
        {
            return "GAME OVER";
        }
        else {
            return null;
        }
    }

}// class PigLocalGame
