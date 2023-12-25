package soundGarden.objects.ui;

import soundGarden.objects.AssetLoader;
import soundGarden.objects.RenderedObject;
import processing.core.PImage;
import processing.core.PVector;

public class Background extends RenderedObject {
    PImage fond;
    float ground = 500;

    public Background() {
        super();
        position = new PVector(0, 0);
        fond = AssetLoader.get().loadImage("fond.png");
    }

    public void draw() {
        applet.background(242, 238, 226);
        applet.fill(0);
        applet.stroke(0);
        applet.strokeWeight(1);
        float groundLevel = renderedPosition.y + ground;
        applet.rect(0, groundLevel, applet.width, applet.height - groundLevel);   // 地面

    }
}