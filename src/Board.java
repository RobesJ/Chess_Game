import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{
    private int[][] tiles;

    public Board(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocation(600,150);
        frame.setSize(new Dimension(800,800));

        tiles = new int[8][8];

        this.setSize(800,800);
        this.setBackground(Color.RED);
        frame.add(this);
        int letter = 'A';
        for(int i = 0; i <8; i++){
            for(int j = 0; j <8; j++){
                tiles[i][j] = letter + (char) j;
            }
            letter++;
        }

        for(int i = 0; i <8; i++){
            for(int j = 0; j <8; j++){
                System.out.print((char) tiles[i][j] +""+(j+1) +" ");
            }
            System.out.println();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        int x = 0;
        int y = 0;
        for(int i =0; i <8;i++) {
            for (int j = 0; j < 8; j++) {
                //g.drawRect(x, y, 100, 100);
                if ((j % 2 == 0 && i % 2 == 0) || (j % 2 == 1 && i % 2 == 1)) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, 100, 100);
                } else {
                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, 100, 100);
                }
                x += 100;
            }
            x = 0;
            y += 100;
        }
    }


    public static void main(String[] args) {
        Board board = new Board();
    }
}
