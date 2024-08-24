import Figure.AbstractFigure;

public class Square {
    private AbstractFigure figure;
    
    public Square(){

    }

    public void setFigure(AbstractFigure figure) {
        this.figure = figure;
    }

    public AbstractFigure getFigure(){
        return figure;
    }
}
