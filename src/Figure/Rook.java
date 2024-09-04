package Figure;
import GameBoard.Square;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Rook extends AbstractFigure {
    static Icon whiteRookIcon;
    static Icon blackRookIcon;

    static {
        try {
            BufferedImage img = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/white-rook-svgrepo-com.png"));
            Image scaledImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            whiteRookIcon = new ImageIcon(scaledImg);
            BufferedImage img2 = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/black-rook-svgrepo-com.png"));
            Image scaledImg2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            blackRookIcon = new ImageIcon(scaledImg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Rook(boolean White, boolean killed){
        super(White, killed);
    }

    public Icon getWhiteRookIcon(){
        return whiteRookIcon;
    }
    public Icon getBlackRookIcon(){
        return blackRookIcon;
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
        else
            return false;
    }
}