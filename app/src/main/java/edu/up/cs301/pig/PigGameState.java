package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by sterba19 on 3/9/2017.
 */
public class PigGameState extends GameState{


    int turnId;
    int player0Score;
    int player1Score;
    int curRunTotal;
    int curVal;

    public PigGameState(){
        this.turnId = 0;
        this.player0Score = 0;
        this.player1Score = 0;
        this.curRunTotal = 0;
        this.curVal = 1;
    }

    public PigGameState(PigGameState myState){
        this.turnId = myState.turnId;
        this.player0Score = myState.player0Score;
        this.player1Score = myState.player1Score;
        this.curRunTotal = myState.curRunTotal;
        this.curVal = myState.curVal;
    }

    public int getTurnId() {
        return turnId;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getCurRunTotal() {
        return curRunTotal;
    }

    public void setTurnId(int turnId) {
        this.turnId = turnId;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public void setCurRunTotal(int curRunTotal) {
        this.curRunTotal = curRunTotal;
    }

    public void setCurVal(int curVal) {
        this.curVal = curVal;
    }


}
