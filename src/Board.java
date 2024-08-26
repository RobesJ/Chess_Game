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
    int square_x_pos = 0;
    int square_y_pos = 0;
    private List<AbstractFigure> figures;
    private ArrayList<Integer> start_pos;
    private ArrayList<Integer> end_pos;
    
    public Board(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(600,150);
        frame.setSize(new Dimension(800,837));

        tiles = new Square[8][8];
        figures = new ArrayList<>();
        coordinates = new HashMap<>();
        this.setSize(800,800);
        this.setLayout(new GridLayout(8,8));
        frame.add(this);

        int letter = 'A';
        initFigures();
        for(int i = 0; i <8; i++){
            for(int j = 0; j <8; j++){
                //Character.toString((char) letter) + String.valueOf(j+1),
                tiles[i][j] = new Square(square_x_pos, square_y_pos,null);
                this.add(tiles[i][j]);
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1)) {
                    tiles[i][j].setBackground(Color.BLACK);
                }
                else{
                    tiles[i][j].setBackground(Color.WHITE);
                }

                for (AbstractFigure figure : figures) {
                    if (figure.getX_pos() == tiles[i][j].getX_Position() && figure.getY_pos() == tiles[i][j].getY_Position()) {
                        tiles[i][j].setFigure(figure);
                    }
                }
                for(AbstractFigure figure : figures){
                    if(figure.getX_pos() == square_x_pos && figure.getY_pos() == square_y_pos){
                        JPanel panel = new JPanel();
                        panel.setBounds(10,10, 50,50);
                        if(figure.isWhite()){
                            panel.setBackground(Color.gray);
                            tiles[i][j].add(panel);
                        }
                        else{
                            tiles[i][j].add(panel);
                            panel.setBackground(Color.RED);
                        }

                    }
                }
                //coordinates.put(tiles[i][j].getPosition(),new Integer[]{x_pos,y_pos});
                //if(letter == 'A' && (coordinates.get(tiles[i][j].getPosition()) == )){
                square_x_pos +=100;
            }

            square_x_pos = 0;
            square_y_pos +=100;
            letter++;
        }

    }

    private void initFigures(){
        King whiteKing = new King(true, false, 400, 700);
        Queen whiteQueen = new Queen(true, false, 300, 700);
        Rook whiteRook1 = new Rook(true, false, 0, 700);
        Rook whiteRook2 = new Rook(true, false, 700, 700);
        Bishop whiteBishop1 = new Bishop(true, false, 200, 700);
        Bishop whiteBishop2 = new Bishop(true, false, 500, 700);
        Knight whiteKnight1 = new Knight(true, false, 100, 700);
        Knight whiteKnight2 = new Knight(true, false, 600, 700);
        Pawn whitePawn1 = new Pawn(true, false, 0, 600);
        Pawn whitePawn2 = new Pawn(true, false, 100, 600);
        Pawn whitePawn3 = new Pawn(true, false, 200, 600);
        Pawn whitePawn4 = new Pawn(true, false, 300, 600);
        Pawn whitePawn5 = new Pawn(true, false, 400, 600);
        Pawn whitePawn6 = new Pawn(true, false, 500, 600);
        Pawn whitePawn7 = new Pawn(true, false, 600, 600);
        Pawn whitePawn8 = new Pawn(true, false, 700, 600);

        King blackKing = new King(false, false, 400, 0);
        Queen blackQueen = new Queen(false, false, 300, 0);
        Rook blackRook1 = new Rook(false, false, 0, 0);
        Rook blackRook2 = new Rook(false, false, 700, 0);
        Bishop blackBishop1 = new Bishop(false, false, 500, 0);
        Bishop blackBishop2 = new Bishop(false, false, 200, 0);
        Knight blackKnight1 = new Knight(false, false, 100, 0);
        Knight blackKnight2 = new Knight(false, false, 600, 0);
        Pawn blackPawn1 = new Pawn(false, false, 0, 100);
        Pawn blackPawn2 = new Pawn(false, false, 100, 100);
        Pawn blackPawn3 = new Pawn(false, false, 200, 100);
        Pawn blackPawn4 = new Pawn(false, false, 300, 100);
        Pawn blackPawn5 = new Pawn(false, false, 400, 100);
        Pawn blackPawn6 = new Pawn(false, false, 500, 100);
        Pawn blackPawn7 = new Pawn(false, false, 600, 100);
        Pawn blackPawn8 = new Pawn(false, false, 700, 100);
        figures.add(whiteKing);
        figures.add(whiteQueen);
        figures.add(whiteBishop1);
        figures.add(whiteBishop2);
        figures.add(whiteKnight1);
        figures.add(whiteKnight2);
        figures.add(whiteRook1);
        figures.add(whiteRook2);
        figures.add(whitePawn1);
        figures.add(whitePawn2);
        figures.add(whitePawn3);
        figures.add(whitePawn4);
        figures.add(whitePawn5);
        figures.add(whitePawn6);
        figures.add(whitePawn7);
        figures.add(whitePawn8);
        figures.add(blackKing);
        figures.add(blackQueen);
        figures.add(blackBishop1);
        figures.add(blackBishop2);
        figures.add(blackKnight1);
        figures.add(blackKnight2);
        figures.add(blackRook1);
        figures.add(blackRook2);
        figures.add(blackPawn1);
        figures.add(blackPawn2);
        figures.add(blackPawn3);
        figures.add(blackPawn4);
        figures.add(blackPawn5);
        figures.add(blackPawn6);
        figures.add(blackPawn7);
        figures.add(blackPawn8);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Board board = new Board();
            }
        });
    }
}
