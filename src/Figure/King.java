package Figure;
import GameBoard.Square;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class King extends AbstractFigure{

    static Icon whiteKingIcon;
    static Icon blackKingIcon;

    static {
        try {
            BufferedImage img = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/white-king-svgrepo-com.png"));
            Image scaledImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            whiteKingIcon = new ImageIcon(scaledImg);
            BufferedImage img2 = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/black-king-svgrepo-com.png"));
            Image scaledImg2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            blackKingIcon = new ImageIcon(scaledImg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public King(boolean White, boolean killed){
        super(White, killed);
    }

    public Icon getWhiteKingIcon(){
        return whiteKingIcon;
    }

    public Icon getBlackKingIcon(){
        return blackKingIcon;
    }

    @Override
    public void getMovingOption(int[] current_pos, Square[][] tiles){
        int [][] directions = {
                {-1, 0}, {1, 0},
                { 0,-1}, {0, 1},
                {-1,-1}, {1, 1},
                {-1, 1}, {1,-1}
        };
        for(int[] direction : directions){
            int x = current_pos[0] + direction[0];
            int y = current_pos[1] + direction[1];
            if(x < 0|| x > 7 || y < 0 || y >7){
                continue;
            }
            if(!tiles[x][y].containsFigure()){
                options.add(tiles[x][y]);
            }
            else if (tiles[x][y].containsFigure() && (isWhite() != tiles[x][y].getFigure().isWhite())) {
                options.add(tiles[x][y]);
            }
        }
    }
}
