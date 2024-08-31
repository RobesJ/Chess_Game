package Figure;

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

    public boolean isKilled(){
        return killed;
    }

    public boolean isWhite(){
        return white;
    }
    /*
    protected void canMoveDiagonally(int[] start_pos, int[] end_pos){
        if(Math.abs(end_pos[1]-start_pos[1]) == Math.abs(end_pos[0] - start_pos[0]) ){
            System.out.println("moves diagonally");
        }
    }

    protected void canMoveVertically(int[] start_pos, int[] end_pos){
        if(start_pos[0] == end_pos[0] && (start_pos[1] > end_pos[1] || start_pos[1] < end_pos[1]) ){
            System.out.println("moves vertically");
        }
    }

    protected void canMoveHorizontally(int[] start_pos, int[] end_pos){
        if(start_pos[1] == end_pos[1] && (start_pos[0] > end_pos[0] || start_pos[0] < end_pos[0]) ){
            System.out.println("moves horizontally");
        }
    }*/
}