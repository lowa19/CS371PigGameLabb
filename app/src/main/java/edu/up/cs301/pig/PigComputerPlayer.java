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
public class PigComputerPlayer extends GameComputerPlayer {
    PigGameState myGameState;
    PigHoldAction hold;
    PigRollAction roll;
    double temp;
    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
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
        if(myGameState.getTurnId()==0)
        {
            return;
        }
        else{
            temp= Math.random();
            if(temp < 0.5)
            {
                hold = new PigHoldAction(this);
                game.sendAction(hold);
            }
            else
            {
                roll = new PigRollAction(this);
                game.sendAction(roll);
            }
        }

    }//receiveInfo

}
