import Figure.AbstractFigure;

public class Square {
    private AbstractFigure figure;
    private int x_pos;
    private int y_pos;

    public Square(int x_pos, int y_pos, AbstractFigure figure){
        this.figure = figure;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
    }

    public void setFigure(AbstractFigure figure) {
        this.figure = figure;
    }

    public void removeFigure(AbstractFigure figure){
        this.figure = null;
    }

    public AbstractFigure getFigure(){
        return figure;
    }

    public boolean containsFigure(){
        return figure != null;
    }

    public int getY_Position(){
        return y_pos;
    }

    public int getX_Position(){
        return x_pos;
    }
}
