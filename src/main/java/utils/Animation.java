package utils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Animation {
    private List <BufferedImage> frames;
    private int frameIndex = 0;

    public Animation() {
        frames = new ArrayList<BufferedImage>();
    }

    public void update() {
        frameIndex ++;
        if(frameIndex >= frames.size()) {
            frameIndex = 0;
        }
    }

    public void addFrame(BufferedImage frame) {
        frames.add(frame);
    }

    public BufferedImage getFrame() {
        if (frames.size() > 0) {
            return frames.get(frameIndex);
        }
        return null;
    }
}

