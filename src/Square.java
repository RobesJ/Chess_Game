import Figure.AbstractFigure;

public class Square {
    private AbstractFigure figure;
    private String position;

    public Square(String position, AbstractFigure figure){
        this.figure = figure;
        this.position = position;
    }

    public void setFigure(AbstractFigure figure) {
        this.figure = figure;
    }

    public AbstractFigure getFigure(){
        return figure;
    }

    public boolean containsFigure(){
        return figure != null;
    }

    public String getPosition(){
        return position;
    }
}
