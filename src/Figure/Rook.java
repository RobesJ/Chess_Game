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
    public void getMovingOption(int[] currentPos, Square[][] tiles) {
        options.clear();
        int [][] directions = {
            {-1,0}, {1,0},
            {0,-1}, {0,1}
        };

        for(int[] direction : directions){
            int x = currentPos[0];
            int y = currentPos[1];
            while(true){
                x += direction[0];
                y += direction[1];
                if(x<0 || x > 7 || y < 0 || y >7){
                    break;
                }
                if(!tiles[x][y].containsFigure()){
                    options.add(tiles[x][y]);
                }
                else if(tiles[x][y].containsFigure() && (this.isWhite() != tiles[x][y].getFigure().isWhite())){
                    options.add(tiles[x][y]);
                    break;
                }
                else
                    break;
            }
        }
    }
}