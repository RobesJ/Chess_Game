package GameBoard;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    public Game(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocation(500,130);
        this.setSize(new Dimension(1000,832));
        this.setLayout(null);
        JPanel boardPanel = new JPanel();
        boardPanel.setBounds(0,-5,800,800);
        boardPanel.add(new Board());
        this.add(boardPanel);
        JPanel gamePanel = new JPanel();
        gamePanel.setBounds(800,-5,200,800);
        gamePanel.setBackground(Color.BLUE);
        this.add(gamePanel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Game();
            }
        });
    }
}
