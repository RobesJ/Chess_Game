package GameBoard;

import Figure.*;

import javax.swing.*;
import java.awt.*;

public class Square extends JPanel {
    private AbstractFigure figure;
    private final JLabel label;

    public Square(AbstractFigure figure){
        this.figure = figure;
        label = new JLabel();
        label.setOpaque(false);
        //label.setPreferredSize(new Dimension(100,100));
        label.setVisible(false);
        label.setBackground(new Color(204,229,255));
        this.add(label);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(100,100));
    }

    public void setFigure(AbstractFigure figure) {
        this.figure = figure;
        label.setVisible(true);
        if(figure instanceof King && figure.isWhite()){
            label.setIcon(((King) figure).getWhiteKingIcon());
        }
        else if((figure instanceof King) && !figure.isWhite()){
            label.setIcon(((King) figure).getBlackKingIcon());
        }
        else if(figure instanceof Bishop && figure.isWhite()){
            label.setIcon(((Bishop) figure).getWhiteBishopIcon());
        }
        else if((figure instanceof Bishop) && !figure.isWhite()){
            label.setIcon(((Bishop) figure).getBlackBishopIcon());
        }
        else if(figure instanceof Pawn && figure.isWhite()){
            label.setIcon(((Pawn) figure).getWhitePawnIcon());
        }
        else if((figure instanceof Pawn) && !figure.isWhite()){
            label.setIcon(((Pawn) figure).getBlackPawnIcon());
        }
        else if(figure instanceof Knight && figure.isWhite()){
            label.setIcon(((Knight) figure).getWhiteKnightIcon());
        }
        else if((figure instanceof Knight) && !figure.isWhite()){
            label.setIcon(((Knight) figure).getBlackKnightIcon());
        }
        else if(figure instanceof Queen && figure.isWhite()){
            label.setIcon(((Queen) figure).getWhiteQueenIcon());
        }
        else if((figure instanceof Queen) && !figure.isWhite()){
            label.setIcon(((Queen) figure).getBlackQueenIcon());
        }
        else if(figure instanceof Rook && figure.isWhite()){
            label.setIcon(((Rook) figure).getWhiteRookIcon());
        }
        else if((figure instanceof Rook) && !figure.isWhite()){
            label.setIcon(((Rook) figure).getBlackRookIcon());
        }
    }

    public void removeFigure(){
        this.figure = null;
        label.setVisible(false);
    }

    public AbstractFigure getFigure(){
        return figure;
    }

    public boolean containsFigure(){
        return figure != null;
    }

    public JLabel getLabel(){
        return label;
    }
}
