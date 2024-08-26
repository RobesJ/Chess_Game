package Figure;

public class Pawn extends AbstractFigure{
    int new_x_pos, new_y_pos;
    private int[] valid_positions;
    int old_x_pos, old_y_pos;

    public Pawn(boolean White, boolean killed, int x_pos, int y_pos){

        super(x_pos, y_pos, White, killed);
        new_x_pos = x_pos;
        new_y_pos =y_pos;
    }


   /* public void checkValidMoves(){
        if(new_y_pos == 600){
            if (new_y_pos == x_pos && new_x_pos == x_pos){
                valid_positions = [new_y_pos-100, new_y_pos-200];
            }
            else if()
        }
    }*/

}
