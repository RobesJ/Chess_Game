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
    private int begginingRow;

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
        this.begginingRow = begPosX;
    }

    public Icon getWhitePawnIcon(){
        return whitePawnIcon;
    }
    public Icon getBlackPawnIcon(){
        return blackPawnIcon;
    }

    //[0] = row, [1] = col
    @Override
    public boolean move(int[] start_pos, int[] end_pos, Square[][] tiles){
        if(isWhite()){
            if(start_pos[0] == begginingRow){
                return start_pos[1] == end_pos[1] && (start_pos[0] - end_pos[0] ==1 || start_pos[0] - end_pos[0] ==2);
            }
            return start_pos[1] == end_pos[1] && start_pos[0]-end_pos[0] ==1;
        }
        else {
            if (start_pos[0] == begginingRow) {
                return start_pos[1] == end_pos[1] && (end_pos[0] - start_pos[0] == 1 || end_pos[0] - start_pos[0] == 2);
            }
            return start_pos[1] == end_pos[1] && end_pos[0] - start_pos[0] == 1;
        }
    }
}
