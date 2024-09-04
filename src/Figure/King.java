package Figure;

import GameBoard.Board;
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
    public boolean move(int[] start_pos, int[] end_pos, Square[][] tiles){
        return (Math.abs(end_pos[0] - start_pos[0]) == 0 || Math.abs(end_pos[0] - start_pos[0]) == 1) &&
                (Math.abs(end_pos[1] - start_pos[1]) == 0 || Math.abs(end_pos[1] - start_pos[1]) == 1);

    }
}
