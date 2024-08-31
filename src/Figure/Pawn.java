package Figure;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Pawn extends AbstractFigure{
    static Icon whitePawnIcon;
    static Icon blackPawnIcon;

    static {
        try {
            BufferedImage img = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/white-pawn-svgrepo-com.png"));
            Image scaledImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
            blackPawnIcon = new ImageIcon(scaledImg);
            BufferedImage img2 = ImageIO.read(new File("/home/robes/Plocha/Chess/svg_pieces/black-pawn-svgrepo-com.png"));
            Image scaledImg2 = img2.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            whitePawnIcon = new ImageIcon(scaledImg2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pawn(boolean White, boolean killed){
        super(White, killed);
    }
}
