import Figure.AbstractFigure;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Square extends JPanel {
    private AbstractFigure figure;
    private String position;
    private int x_pos;
    private int y_pos;

    public Square(int x_pos, int y_pos, AbstractFigure figure){
        this.figure = figure;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.setPreferredSize(new Dimension(100,100));
        this.setFocusable(true);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleClick();
            }
        });
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


    public int getX_Position(){
        return x_pos;
    }

    public int getY_Position(){
        return y_pos;
    }

    public String getPosition(){
        return position;
    }

    public void handleClick(){
        if(containsFigure()){
            System.out.println("Contains: " + figure.getClass().getSimpleName());
        }
        else{
            System.out.println("Empty square with location: " + getX_Position() +","+getY_Position());
        }
    }
}
