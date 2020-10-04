package objectgame;

import userinterface.GameScreen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (mx >= 275 && mx <= 325) {
            if (my >= 70 && my <= 90) {
                GameScreen.State = GameScreen.STATE.GAME;
                GameScreen.setPressMouse(true);

            }
         }
        if (mx >= 275 && mx <= 325) {
                if (my >= 100 && my <= 120) {
                    System.exit(1);
                }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
