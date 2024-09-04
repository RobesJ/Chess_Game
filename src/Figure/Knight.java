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
    public boolean move(int[] start_pos, int[] end_pos, Square[][] tiles){
        return  (Math.abs(end_pos[0] - start_pos[0]) == 2 && Math.abs(end_pos[1] -start_pos[1]) == 1) ||
                (Math.abs(end_pos[0] - start_pos[0]) == 1 && Math.abs(end_pos[1] -start_pos[1]) == 2);
    }
}
