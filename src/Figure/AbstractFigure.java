package Figure;

public abstract class AbstractFigure {
    protected boolean white;
    protected int x_pos;
    protected int y_pos;
    protected boolean killed;
    private int[] start_pos;
    private int[] end_pos;

    protected AbstractFigure(int x_pos, int y_pos, boolean white, boolean killed){
        this.white = white;
        this.y_pos = y_pos;
        this.x_pos = x_pos;
        this.killed = killed;
        //start_pos = new int [] {x_pos, y_pos};
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isKilled(){
        return killed;
    }

    public int getX_pos(){
        return x_pos;
    }

    public int getY_pos(){
        return y_pos;
    }

    public boolean isWhite(){
        return white;
    }

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
    }
}
