package GameBoard;

import Figure.*;
import javax.swing.*;
import java.awt.*;

public class Square extends JPanel {
    private AbstractFigure figure;
    private final JLabel label;
    private int row;
    private int col;
    private boolean currentOption = false;

    public Square(AbstractFigure figure){
        this.figure = figure;
        label = new JLabel();
        label.setOpaque(false);
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

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCurrentOption(boolean currentOption){
        this.currentOption = currentOption;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (currentOption) {
            g.setColor(Color.RED);  // Color for the circles
            // Calculate the center of the square
            int centerX = 100 / 2;
            int centerY = 100 / 2;

            // Draw a circle in the center of the square
            int radius = 100 / 4;
            g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        }
    }
}
