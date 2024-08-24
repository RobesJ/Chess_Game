import Figure.AbstractFigure;

public class Square {
    private AbstractFigure figure;
    private boolean hasFigure;
    private String position;

    public Square(String position, boolean hasFigure){
        this.hasFigure = hasFigure;
        this.position = position;
    }

    public void setFigure(AbstractFigure figure) {
        this.figure = figure;
    }

    public AbstractFigure getFigure(){
        return figure;
    }

    public boolean containsFigure(){
        return hasFigure;
    }

    public String getPosition(){
        return position;
    }
}
