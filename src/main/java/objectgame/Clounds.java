package objectgame;

import utils.Resources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import  java.util.List;

public class Clounds {

    private BufferedImage cloudImage;
    private List<Cloud> clouds;

    public Clounds() {
        cloudImage = Resources.getResourcesImage("src/test/resources/image/cloud1.png");
        clouds = new ArrayList<Cloud>();

        Cloud cloud1 = new Cloud();
        cloud1.posX = 100;
        cloud1.posY = 110;
        clouds.add(cloud1);

        cloud1 = new Cloud();
        cloud1.posX = 200;
        cloud1.posY = 30;
        clouds.add(cloud1);

        cloud1 = new Cloud();
        cloud1.posX = 300;
        cloud1.posY = 80;
        clouds.add(cloud1);

        cloud1 = new Cloud();
        cloud1.posX = 450;
        cloud1.posY = 100;
        clouds.add(cloud1);

    }

    public void update() {
        for(Cloud cloud : clouds) {
            cloud.posX --;
        }
        Cloud firstCloud = clouds.get(0);
        if (firstCloud.posX + cloudImage.getWidth() < 0) {
            firstCloud.posX = 600;
            clouds.add(firstCloud);
            clouds.remove(firstCloud);
        }
    }



    public void draw(Graphics g) {
        for(Cloud clouds : clouds) {
            g.drawImage(cloudImage, (int) clouds.posX, (int) clouds.posY, null);
        }
    }

    private  class Cloud {
        float posX;
        float posY;
    }
}
