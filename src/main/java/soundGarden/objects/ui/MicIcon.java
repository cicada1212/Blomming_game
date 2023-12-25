package soundGarden.objects.ui;

import processing.core.PApplet;
import soundGarden.objects.AssetLoader;
import soundGarden.objects.RenderedObject;
import processing.core.PImage;

import static processing.core.PConstants.CENTER;

public class MicIcon extends RenderedObject {

    PImage[] images = new PImage [54];

    int numFrames = 54;
    int currentFrame = 0;

    float printRatio = 0.4f;

    public MicIcon(float posX, float posY) {
        super();
        position.x = posX;
        position.y = posY;
        for (int i = 0; i < 54; i ++) {
            String icon = "mic/micro_" + PApplet.nf(i, 5) + ".png";
            images[i] = AssetLoader.get().loadImage(icon);
        }
    }

    public void draw() {
        applet.imageMode(CENTER);
        currentFrame = (currentFrame+1) % numFrames;  // 一共54帧
        for (int x = -100; x < applet.width; x += images[0].width) {
            applet.image(images[currentFrame], renderedPosition.x, renderedPosition.y, images[currentFrame].width * printRatio, images[currentFrame].height * printRatio);
        }
    }
}