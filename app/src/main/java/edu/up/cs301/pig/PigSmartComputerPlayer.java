package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigSmartComputerPlayer extends GameComputerPlayer {
    PigGameState myGameState;
    PigHoldAction hold;
    PigRollAction roll;
    double temp;
    /**
     * ctor does nothing extra
     */
    public PigSmartComputerPlayer(String name) {
        super(name);
        myGameState = new PigGameState();
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if(((PigGameState)info).getTurnId()!= playerNum)
        {
            return;
        }
        else{
            temp= Math.random();
            if(((PigGameState)info).getPlayer0Score()>((PigGameState)info).getPlayer1Score() + ((PigGameState)info).getCurRunTotal() || (((PigGameState) info).getCurRunTotal()) <10)
            {
                roll = new PigRollAction(this);
                game.sendAction((GameAction)roll);

            }
            else
            {

                hold = new PigHoldAction(this);
                game.sendAction((GameAction)hold);
            }
        }

    }//receiveInfo

}
