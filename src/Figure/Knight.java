package Figure;

import GameBoard.Square;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Knight extends AbstractFigure{
    static Icon whiteKnightIcon;
    static Icon blackKnightIcon;

    static {
        try {
            BufferedImage img = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/white-knight-svgrepo-com.png"));
            Image scaledImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            whiteKnightIcon = new ImageIcon(scaledImg);
            BufferedImage img2 = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/black-knight-svgrepo-com.png"));
            Image scaledImg2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            blackKnightIcon = new ImageIcon(scaledImg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Knight(boolean White, boolean killed){
        super(White, killed);
    }

    public Icon getWhiteKnightIcon(){
        return whiteKnightIcon;
    }

    public Icon getBlackKnightIcon(){
        return blackKnightIcon;
    }


    @Override
    public void getMovingOption(int[] current_pos, Square[][] tiles){
        options.clear();
        int [][] directions = {
                { 2,-1}, { 2, 1},
                {-2,-1}, {-2, 1},
                {-1, 2}, { 1, 2},
                {-1,-2}, { 1,-2}
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
