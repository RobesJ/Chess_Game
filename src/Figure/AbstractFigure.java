package Figure;
import GameBoard.Square;


public abstract class AbstractFigure {

    protected boolean white;
    protected boolean killed;

    protected AbstractFigure(boolean white, boolean killed){
        this.white = white;
        this.killed = killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isWhite(){
        return white;
    }

    public abstract boolean move(int[] start_pos, int[] end_pos, Square[][] tiles);
}