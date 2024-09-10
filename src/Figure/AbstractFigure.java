package Figure;

import GameBoard.Board;
import GameBoard.Square;
import java.util.ArrayList;

public abstract class AbstractFigure {
    protected boolean white;
    protected boolean killed;
    protected ArrayList<Square> options;

    protected AbstractFigure(boolean white, boolean killed){
        this.white = white;
        this.killed = killed;
        options = new ArrayList<>();
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isWhite(){
        return white;
    }

    public abstract void getMovingOption(int[] current_pos, Square[][] tiles);

    public ArrayList<Square> getOptions(){
        return options;
    }

    public void checkKingThreat(Board board){
        for(Square option : getOptions()){
            if(option.containsFigure()) {
                if (isWhite() != option.getFigure().isWhite() && option.getFigure().getClass().getSimpleName().equals("King")) {
                    board.setCheck(true);
                }
            }
        }
    }

    public void showOptions(){
        for(Square option : getOptions()){
            option.setCurrentOption(true);
        }
    }

    public void removeOptions(){
        for(Square option : getOptions()){
            option.setCurrentOption(false);
        }
    }
}