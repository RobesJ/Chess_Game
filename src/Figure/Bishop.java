package Figure;

import GameBoard.Square;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bishop extends AbstractFigure{
    static Icon whiteBishopIcon;
    static Icon blackBishopIcon;

    static {
        try {
            BufferedImage img = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/white-bishop-svgrepo-com.png"));
            Image scaledImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            whiteBishopIcon = new ImageIcon(scaledImg);
            BufferedImage img2 = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/black-bishop-svgrepo-com.png"));
            Image scaledImg2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            blackBishopIcon = new ImageIcon(scaledImg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bishop(boolean White, boolean killed){
        super(White, killed);
    }

    public Icon getWhiteBishopIcon(){
        return whiteBishopIcon;
    }
    public Icon getBlackBishopIcon(){
        return blackBishopIcon;
    }

    public boolean move(int[] start_pos, int[] end_pos, Square[][] tiles){
        if(Math.abs(end_pos[0] - start_pos[0]) == Math.abs(end_pos[1] - start_pos[1])) {
            int stepRow = (end_pos[0] > start_pos[0]) ? 1 : -1;
            int stepCol = (end_pos[1] > start_pos[1]) ? 1 : -1;

            int x = start_pos[0] + stepRow;
            int y = start_pos[1] + stepCol;

            while (x != end_pos[0] && y != end_pos[1]) {
                if (tiles[x][y].containsFigure()) {
                    return false;
                }
                x += stepRow;
                y += stepCol;
            }
            return true;
        }
        return false;
    }
}
