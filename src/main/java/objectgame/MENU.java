package objectgame;

import java.awt.*;

public class MENU {

    public Rectangle playButton = new Rectangle(275, 70, 50, 20);
    public Rectangle GameOver = new Rectangle(275, 100, 50, 20);

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;


        Font fnt0 = new Font("arial", Font.BOLD, 15);
        g.setFont(fnt0);
        g.setColor(Color.black);
        g.drawString("Play", 285,85 );
        g.drawString("Exit", 285,115 );


        g2d.draw(playButton);
        g2d.draw(GameOver);
    }
}
