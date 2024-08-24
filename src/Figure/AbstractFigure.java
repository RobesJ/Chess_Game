package Figure;

public abstract class AbstractFigure {
    protected boolean white;
    protected int x_pos;
    protected int y_pos;
    protected boolean killed;

    protected AbstractFigure(int x_pos, int y_pos, boolean white, boolean killed){
        this.white = white;
        this.y_pos = y_pos;
        this.x_pos = x_pos;
        this.killed = killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isKilled(){
        return killed;
    }
}
