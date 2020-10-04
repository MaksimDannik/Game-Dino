package objectgame;

import userinterface.GameScreen;
import utils.Resources;
import java.util.List;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static userinterface.GameScreen.GROUND;

public class Land {

    private List<ImageLand> listImage;
    private BufferedImage imageLand1, imageLand2, imageLand3;

    public Land(GameScreen game) {
        imageLand1 = Resources.getResourcesImage("src/test/resources/image/land1.png");
        imageLand2 = Resources.getResourcesImage("src/test/resources/image/land2.png");
        imageLand3 = Resources.getResourcesImage("src/test/resources/image/land3.png");
        listImage = new ArrayList<ImageLand>();
        int numberOfLandTitle = 600 / imageLand1.getWidth() + 2;

        for (int i = 0; i < numberOfLandTitle; i++) {
            ImageLand imageLand = new ImageLand();
            imageLand.posX = (int) (i * imageLand1.getWidth());
            imageLand.image = imageLand1;
            listImage.add(imageLand);
        }
    }

    public void update() {
        for(ImageLand imageLand : listImage) {
            imageLand.posX --;
        }
        ImageLand firstElement = listImage.get(0);
        if(listImage.get(0).posX + imageLand1.getWidth() < 0) {
            firstElement.posX = listImage.get(listImage.size() - 1).posX + imageLand1.getWidth();
            listImage.add(firstElement);
            listImage.remove(0);
        }
    }

    public void draw(Graphics g) {
        for (ImageLand imageLand : listImage) {
            g.drawImage(imageLand.image, imageLand.posX, (int) GROUND - 15, null);
        }
    }

    private class ImageLand {
        int posX;
        BufferedImage image;
    }
}
