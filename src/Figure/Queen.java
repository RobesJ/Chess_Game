package Figure;

import GameBoard.Square;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Queen extends AbstractFigure{
    static Icon whiteQueenIcon;
    static Icon blackQueenIcon;

    static {
        try {
            BufferedImage img = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/black-queen-svgrepo-com.png"));
            Image scaledImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            blackQueenIcon = new ImageIcon(scaledImg);
            BufferedImage img2 = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/white-queen-svgrepo-com.png"));
            Image scaledImg2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            whiteQueenIcon = new ImageIcon(scaledImg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Queen(boolean White, boolean killed){
        super(White, killed);
    }
    public Icon getWhiteQueenIcon(){
        return whiteQueenIcon;
    }
    public Icon getBlackQueenIcon(){
        return blackQueenIcon;
    }

    @Override
    public boolean move(int[] start_pos, int[] end_pos, Square[][] tiles){
        if(start_pos[0] == end_pos[0] && (Math.abs(end_pos[1] - start_pos[1]) !=0)){
            int step = (end_pos[1] > start_pos[1]) ? 1 : -1;
            for (int x = start_pos[1] + step; x != end_pos[1]; x += step) {
                if(tiles[start_pos[0]][x].containsFigure()){
                    return false;
                }
            }
            return true;
        }
        else if (start_pos[1] == end_pos[1] && (Math.abs(end_pos[0] - start_pos[0]) != 0)) {
            int step = (end_pos[0] > start_pos[0]) ? 1 : -1;
            for (int x = start_pos[0] + step; x != end_pos[0]; x += step) {
                if (tiles[x][start_pos[1]].containsFigure()) {
                    return false;
                }
            }
            return true;
        }
        else if (Math.abs(end_pos[0] - start_pos[0]) == Math.abs(end_pos[1]) - start_pos[1]) {
            int xStep = (end_pos[0] > start_pos[0]) ? 1 : -1;
            int yStep = (end_pos[1] > start_pos[1]) ? 1 : -1;

            // Check each square along the diagonal path
            int x = start_pos[0] + xStep;
            int y = start_pos[1] + yStep;
            while (x != end_pos[0] && y != end_pos[1]) {
                if (tiles[x][y].containsFigure()) {
                    return false;
                }
                x += xStep;
                y += yStep;
            }
            return true;
        }
        else
            return false;
    }
}
