package GameBoard;

import Figure.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Board extends JPanel {
    private final Player player1, player2;
    private Player currentPlayer;
    private final Square[][] tiles;
    int x_pos = 0;
    int y_pos = 0;
    private AbstractFigure selectedFigure;
    private int selectedFigure_col=0;
    private int selectedFigure_row=0;
    private boolean checkMate = false;

    public Board(){
        player1 = new Player("Džošua", "BLACK");
        player2 = new Player("Majkl", "WHITE");

        currentPlayer = (player1.getColor().equals("WHITE")) ? player1: player2;
        tiles = new Square[8][8];

        this.setSize(800,800);
        this.setBackground(Color.RED);
        this.setLayout(new GridLayout(8,8));

        for(int i = 0; i <8; i++){
            for(int j = 0; j <8; j++){
                tiles[i][j] = new Square(null);
                this.add(tiles[i][j]);
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1)) {
                    tiles[i][j].setBackground(Color.GRAY);
                } else {
                    tiles[i][j].setBackground(Color.WHITE);
                }
                x_pos+=100;
            }
            x_pos = 0;
            y_pos +=100;
        }

        initFigures();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!checkMate) {
                    handleMouseClick(e);
                }
            }
        });
    }

    private void initFigures() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0) {  // First row (Black major pieces)
                    if (j == 0 || j == 7) {
                        tiles[i][j].setFigure(new Rook(false, false));
                    } else if (j == 1 || j == 6) {
                        tiles[i][j].setFigure(new Knight(false, false));
                    } else if (j == 2 || j == 5) {
                        tiles[i][j].setFigure(new Bishop(false, false));
                    } else if (j == 3) {
                        tiles[i][j].setFigure(new Queen(false, false));
                    } else {
                        tiles[i][j].setFigure(new King(false, false));
                    }
                } else if (i == 1) {  // Second row (Black pawns)
                    tiles[i][j].setFigure(new Pawn(false, false, i));
                } else if (i == 6) {  // Seventh row (White pawns)
                    tiles[i][j].setFigure(new Pawn(true, false, i));
                } else if (i == 7) {  // Eighth row (White major pieces)
                    if (j == 0 || j == 7) {
                        tiles[i][j].setFigure(new Rook(true, false));
                    } else if (j == 1 || j == 6) {
                        tiles[i][j].setFigure(new Knight(true, false));
                    } else if (j == 2 || j == 5) {
                        tiles[i][j].setFigure(new Bishop(true, false));
                    } else if (j == 3) {
                        tiles[i][j].setFigure(new Queen(true, false));
                    } else {
                        tiles[i][j].setFigure(new King(true, false));
                    }
                }
            }
        }
    }

    public void handleMouseClick(MouseEvent e) {
        int row = e.getY() / 100;
        int col = e.getX() / 100;

        //if selected square contains figure
        if (tiles[row][col].containsFigure()) {
            if (tiles[row][col].getFigure().isWhite() && currentPlayer.getColor().equals("WHITE") ||
                (!tiles[row][col].getFigure().isWhite() && currentPlayer.getColor().equals("BLACK"))) {

                //if nothing is selected yet
                if (selectedFigure == null) {
                    selectedFigure = tiles[row][col].getFigure();
                    tiles[row][col].getLabel().setOpaque(true);
                    selectedFigure_col = col;
                    selectedFigure_row = row;
                }

                // clicked on already selected, same figure
                else if (selectedFigure.equals(tiles[row][col].getFigure())) {
                    selectedFigure = null;
                    tiles[row][col].getLabel().setOpaque(false);
                }

                //pick another figure of the same color
                else if (selectedFigure.isWhite() == tiles[row][col].getFigure().isWhite()) {
                    tiles[selectedFigure_row][selectedFigure_col].getLabel().setOpaque(false);
                    selectedFigure_row = row;
                    selectedFigure_col = col;
                    selectedFigure = tiles[selectedFigure_row][selectedFigure_col].getFigure();
                    tiles[selectedFigure_row][selectedFigure_col].getLabel().setOpaque(true);
                }
            }
            //kill figure of another color
            else if (selectedFigure != null) {
                if (!tiles[row][col].getFigure().isWhite() && currentPlayer.getColor().equals("WHITE") ||
                    (tiles[row][col].getFigure().isWhite() && currentPlayer.getColor().equals("BLACK"))) {
                    //AbstractFigure figureToKill = tiles[row][col].getFigure();
                    if (selectedFigure.move(new int[]{selectedFigure_row, selectedFigure_col}, new int[]{row, col}, tiles)) {
                        //change player
                        if (currentPlayer.equals(player1)) {
                            currentPlayer = player2;
                        } else {
                            currentPlayer = player1;
                        }
                        if(tiles[row][col].getFigure().getClass().getSimpleName().equals("King")){
                            checkMate =true;
                        }
                        tiles[row][col].getFigure().setKilled(true);
                        tiles[row][col].removeFigure();
                        tiles[selectedFigure_row][selectedFigure_col].removeFigure();
                        tiles[row][col].setFigure(selectedFigure);
                        selectedFigure = null;
                    }
                }
            }
        }

        //if square does not contain figure then move the selected figure, if the movement is valid for the selected figure
        else if (!tiles[row][col].containsFigure()) {
            if (selectedFigure != null) {
                if (selectedFigure.move(new int[]{selectedFigure_row, selectedFigure_col}, new int[]{row, col}, tiles)) {
                    //change player
                    if (currentPlayer.equals(player1)) {
                        currentPlayer = player2;
                    } else {
                        currentPlayer = player1;
                    }

                    tiles[selectedFigure_row][selectedFigure_col].removeFigure();
                    tiles[selectedFigure_row][selectedFigure_col].getLabel().setOpaque(false);
                    tiles[row][col].setFigure(selectedFigure);
                    selectedFigure = null;
                }
            }
        }
        revalidate();
        repaint();
    }

    public boolean isCheckMate(){
        return checkMate;
    }
}