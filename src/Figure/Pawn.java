package Figure;

import GameBoard.Square;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pawn extends AbstractFigure{
    static Icon whitePawnIcon;
    static Icon blackPawnIcon;
    private final int beginningRow;

    static {
        try {
            BufferedImage img = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/black-pawn-svgrepo-com.png"));
            Image scaledImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            blackPawnIcon = new ImageIcon(scaledImg);
            BufferedImage img2 = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/white-pawn-svgrepo-com.png"));
            Image scaledImg2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            whitePawnIcon = new ImageIcon(scaledImg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pawn(boolean White, boolean killed, int begPosX){
        super(White, killed);
        this.beginningRow = begPosX;
    }

    public Icon getWhitePawnIcon(){
        return whitePawnIcon;
    }
    public Icon getBlackPawnIcon(){
        return blackPawnIcon;
    }

    @Override
    public void getMovingOption(int[] current_pos, Square[][] tiles){
        options.clear();
        int [][] directionsUp = {
            {-1, 0},
            {-1,-1}, {-1, 1} //killing when going up
        };
        int [][] directionsDown = {
            {1, 0},
            {1,-1}, {1, 1} //killing when going down
        };

        if(beginningRow == 1) {
            int x = current_pos[0] + directionsDown[0][0];
            int y = current_pos[1];
            if(!tiles[x][y].containsFigure()){
                options.add(tiles[x][y]);
                if(beginningRow == current_pos[0] && !tiles[x + directionsDown[0][0]][y].containsFigure()){
                    options.add(tiles[x + directionsDown[0][0]][y]);
                }
            }
            for(int i =1; i < directionsDown.length; i++){
                x = current_pos[0] + directionsDown[i][0];
                y = current_pos[1] + directionsDown[i][1];
                if (y < 0 || y > 7) {
                    continue;
                }
                if(tiles[x][y].containsFigure() && (isWhite() != tiles[x][y].getFigure().isWhite())){
                    options.add(tiles[x][y]);
                }
            }
        }

        else if(beginningRow ==6){
            int x = current_pos[0] + directionsUp[0][0];
            int y = current_pos[1];
            if(!tiles[x][y].containsFigure()){
                options.add(tiles[x][y]);
                if(beginningRow == current_pos[0] && !tiles[x + directionsUp[0][0]][y].containsFigure()){
                    options.add(tiles[x + directionsUp[0][0]][y]);
                }
            }
            for(int i =1; i < directionsUp.length; i++){
                x = current_pos[0] + directionsUp[i][0];
                y = current_pos[1] + directionsUp[i][1];
                if (y < 0 || y > 7) {
                    continue;
                }
                if(tiles[x][y].containsFigure() && (isWhite() != tiles[x][y].getFigure().isWhite())){
                    options.add(tiles[x][y]);
                }
            }
        }
    }
}
