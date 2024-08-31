import Figure.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel {
    private final Square[][] tiles;
    int x_pos = 0;
    int y_pos = 0;
    private List<AbstractFigure> figures;
    private AbstractFigure selectedFigure;

    public Board(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(600,150);
        frame.setSize(new Dimension(800,837));

        tiles = new Square[8][8];
        figures = new ArrayList<>();

        this.setSize(800,800);
        this.setBackground(Color.RED);
        frame.add(this);
        for(int i = 0; i <8; i++){
            for(int j = 0; j <8; j++){
                tiles[i][j] = new Square(x_pos,y_pos,null);

                x_pos +=100;
            }
            x_pos = 0;
            y_pos +=100;
        }
        initFigures();

        /*this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
            }
        });*/
    }

    private void initFigures(){
        for (Square[] tile : tiles) {
            for (int j = 0; j < tiles[0].length; j++) {

                if (tile[j].getY_Position() == 0 && tile[j].getX_Position() == 0) {
                    tile[j].setFigure(new Rook(false, false));
                } else if (tile[j].getY_Position() == 0 && tile[j].getX_Position() == 700) {
                    tile[j].setFigure(new Rook(false, false));
                } else if (tile[j].getY_Position() == 0 && tile[j].getX_Position() == 100) {
                    tile[j].setFigure(new Knight(false, false));
                } else if (tile[j].getY_Position() == 0 && tile[j].getX_Position() == 600) {
                    tile[j].setFigure(new Knight(false, false));
                } else if (tile[j].getY_Position() == 0 && tile[j].getX_Position() == 200) {
                    tile[j].setFigure(new Bishop(false, false));
                } else if (tile[j].getY_Position() == 0 && tile[j].getX_Position() == 500) {
                    tile[j].setFigure(new Bishop(false, false));
                } else if (tile[j].getY_Position() == 0 && tile[j].getX_Position() == 300) {
                    tile[j].setFigure(new King(false, false));
                } else if (tile[j].getY_Position() == 0 && tile[j].getX_Position() == 400) {
                    tile[j].setFigure(new Queen(false, false));
                } else if (tile[j].getY_Position() == 100 && tile[j].getX_Position() == 0) {
                    tile[j].setFigure(new Pawn(false, false));
                } else if (tile[j].getY_Position() == 100 && tile[j].getX_Position() == 100) {
                    tile[j].setFigure(new Pawn(false, false));
                } else if (tile[j].getY_Position() == 100 && tile[j].getX_Position() == 200) {
                    tile[j].setFigure(new Pawn(false, false));
                } else if (tile[j].getY_Position() == 100 && tile[j].getX_Position() == 300) {
                    tile[j].setFigure(new Pawn(false, false));
                } else if (tile[j].getY_Position() == 100 && tile[j].getX_Position() == 400) {
                    tile[j].setFigure(new Pawn(false, false));
                } else if (tile[j].getY_Position() == 100 && tile[j].getX_Position() == 500) {
                    tile[j].setFigure(new Pawn(false, false));
                } else if (tile[j].getY_Position() == 100 && tile[j].getX_Position() == 600) {
                    tile[j].setFigure(new Pawn(false, false));
                } else if (tile[j].getY_Position() == 100 && tile[j].getX_Position() == 700) {
                    tile[j].setFigure(new Pawn(false, false));
                } else if (tile[j].getY_Position() == 700 && tile[j].getX_Position() == 0) {
                    tile[j].setFigure(new Rook(true, false));
                } else if (tile[j].getY_Position() == 700 && tile[j].getX_Position() == 700) {
                    tile[j].setFigure(new Rook(true, false));
                } else if (tile[j].getY_Position() == 700 && tile[j].getX_Position() == 100) {
                    tile[j].setFigure(new Knight(true, false));
                } else if (tile[j].getY_Position() == 700 && tile[j].getX_Position() == 600) {
                    tile[j].setFigure(new Knight(true, false));
                } else if (tile[j].getY_Position() == 700 && tile[j].getX_Position() == 200) {
                    tile[j].setFigure(new Bishop(true, false));
                } else if (tile[j].getY_Position() == 700 && tile[j].getX_Position() == 500) {
                    tile[j].setFigure(new Bishop(true, false));
                } else if (tile[j].getY_Position() == 700 && tile[j].getX_Position() == 300) {
                    tile[j].setFigure(new King(true, false));
                } else if (tile[j].getY_Position() == 700 && tile[j].getX_Position() == 400) {
                    tile[j].setFigure(new Queen(true, false));
                } else if (tile[j].getY_Position() == 600 && tile[j].getX_Position() == 0) {
                    tile[j].setFigure(new Pawn(true, false));
                } else if (tile[j].getY_Position() == 600 && tile[j].getX_Position() == 100) {
                    tile[j].setFigure(new Pawn(true, false));
                } else if (tile[j].getY_Position() == 600 && tile[j].getX_Position() == 200) {
                    tile[j].setFigure(new Pawn(true, false));
                } else if (tile[j].getY_Position() == 600 && tile[j].getX_Position() == 300) {
                    tile[j].setFigure(new Pawn(true, false));
                } else if (tile[j].getY_Position() == 600 && tile[j].getX_Position() == 400) {
                    tile[j].setFigure(new Pawn(true, false));
                } else if (tile[j].getY_Position() == 600 && tile[j].getX_Position() == 500) {
                    tile[j].setFigure(new Pawn(true, false));
                } else if (tile[j].getY_Position() == 600 && tile[j].getX_Position() == 600) {
                    tile[j].setFigure(new Pawn(true, false));
                } else if (tile[j].getY_Position() == 600 && tile[j].getX_Position() == 700) {
                    tile[j].setFigure(new Pawn(true, false));
                }
            }
        }

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        int x = 0;
        int y = 0;
        for(int i =0; i <8;i++) {
            for (int j = 0; j < 8; j++) {
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1)) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, 100, 100);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, 100, 100);
                }

                if(tiles[i][j].containsFigure()){
                    if(tiles[i][j].getFigure().isWhite()){
                        g.setColor(Color.gray);
                    }
                    else{
                        g.setColor(Color.RED);
                    }
                    g.fillRect(x+20, y+20, 60,60);
                }
                x += 100;
            }
            x = 0;
            y += 100;
        }
    }

    /*public void handleMouseClick(MouseEvent e){
        int row = e.getY()/100;
        int col = e.getX()/100;

        int selectedFigure_col=0;
        int selectedFigure_row=0;
        if(tiles[row][col].containsFigure()) {
            if(selectedFigure == null){
                selectedFigure = tiles[col][row].getFigure();
                selectedFigure_col = col;
                selectedFigure_row = row;
            }
            System.out.println("Selected figure "+ tiles[row][col].getFigure() +" at pos "+row+ ", "+col);
        } else if (!tiles[row][col].containsFigure()){
            if(selectedFigure != null){
                tiles[selectedFigure_row][selectedFigure_col].removeFigure(selectedFigure);
                tiles[row][col].setFigure(selectedFigure);
                selectedFigure = null;
            }
            System.out.println("Selected figure "+ tiles[row][col].getFigure() +" at pos "+row+ ", "+col);
        }
        revalidate();
        repaint();
    }*/

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Board::new);
    }
}