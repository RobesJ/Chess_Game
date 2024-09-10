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
        //options = new ArrayList<>();
    }
    public Icon getWhiteQueenIcon(){
        return whiteQueenIcon;
    }
    public Icon getBlackQueenIcon(){
        return blackQueenIcon;
    }

    @Override
    public void getMovingOption(int[] current_pos, Square[][] tiles){
        options.clear();
        int [][] directions = {
                {-1, 0}, {1, 0},
                { 0,-1}, {0, 1},
                {-1,-1}, {1, 1},
                {-1, 1}, {1,-1}
        };

        for(int[] direction : directions){
            int x = current_pos[0];
            int y = current_pos[1];
            while(true){
                x += direction[0];
                y += direction[1];
                if(x < 0 || x > 7 || y < 0 || y > 7){
                    break;
                }
                if(!tiles[x][y].containsFigure()){
                    options.add(tiles[x][y]);
                }
                else if(tiles[x][y].containsFigure() && (isWhite() != tiles[x][y].getFigure().isWhite())){
                    options.add(tiles[x][y]);
                    break;
                }
                else
                    break;
            }
        }
    }
}
