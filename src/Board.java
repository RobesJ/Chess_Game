import Figure.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board extends JPanel{
    private Square[][] tiles;
    private Map<String, Integer[]> coordinates;
    int x_pos = 0;
    int y_pos = 0;
    private List<AbstractFigure> figures;

    public Board(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(600,150);
        frame.setSize(new Dimension(800,837));

        tiles = new Square[8][8];
        coordinates = new HashMap<>();
        figures = new ArrayList<>();

        this.setSize(800,800);
        this.setBackground(Color.RED);
        frame.add(this);
        int letter = 'A';
        for(int i = 0; i <8; i++){
            for(int j = 0; j <8; j++){
                tiles[i][j] = new Square(Character.toString((char) letter) + String.valueOf(j+1),null);
                coordinates.put(tiles[i][j].getPosition(),new Integer[]{x_pos,y_pos});
                x_pos +=100;
            }
            x_pos = 0;
            y_pos +=100;
            letter++;
        }

    }

    private void initFigures(){
        King whiteKing = new King(true, false, 300, 700);
        Queen whiteQueen = new Queen(true, false, 300, 700);
        Rook whiteRook1 = new Rook(true, false, 300, 700);
        Rook whiteRook2 = new Rook(true, false, 300, 700);
        Bishop whiteBishop1 = new Bishop(true, false, 300, 700);
        Bishop whiteBishop2 = new Bishop(true, false, 300, 700);
        Knight whiteKnight1 = new Knight(true, false, 300, 700);
        Knight whiteKnight2 = new Knight(true, false, 300, 700);
        Pawn whitePawn1 = new Pawn(true, false, 300, 700);
        Pawn whitePawn2 = new Pawn(true, false, 300, 700);
        Pawn whitePawn3 = new Pawn(true, false, 300, 700);
        Pawn whitePawn4 = new Pawn(true, false, 300, 700);
        Pawn whitePawn5 = new Pawn(true, false, 300, 700);
        Pawn whitePawn6 = new Pawn(true, false, 300, 700);
        Pawn whitePawn7 = new Pawn(true, false, 300, 700);
        Pawn whitePawn8 = new Pawn(true, false, 300, 700);


        King blackKing = new King(false, false, 300, 700);
        Queen blackQueen = new Queen(false, false, 300, 700);
        Rook blackRook1 = new Rook(false, false, 300, 700);
        Rook blackRook2 = new Rook(false, false, 300, 700);
        Bishop blackBishop1 = new Bishop(false, false, 300, 700);
        Bishop blackBishop2 = new Bishop(false, false, 300, 700);
        Knight blackKnight1 = new Knight(false, false, 300, 700);
        Knight blackKnight2 = new Knight(false, false, 300, 700);
        Pawn blackPawn1 = new Pawn(false, false, 300, 700);
        Pawn blackPawn2 = new Pawn(false, false, 300, 700);
        Pawn blackPawn3 = new Pawn(false, false, 300, 700);
        Pawn blackPawn4 = new Pawn(false, false, 300, 700);
        Pawn blackPawn5 = new Pawn(false, false, 300, 700);
        Pawn blackPawn6 = new Pawn(false, false, 300, 700);
        Pawn blackPawn7 = new Pawn(false, false, 300, 700);
        Pawn blackPawn8 = new Pawn(false, false, 300, 700);
        figures.add(whiteKing);
        
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
                //g.drawRect(x, y, 100, 100);
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1)) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, 100, 100);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, 100, 100);
                }
                x += 100;
            }
            x = 0;
            y += 100;
        }
    }


    public static void main(String[] args) {
        Board board = new Board();
    }
}
