package soundGarden.objects.tree;

import soundGarden.logic.Mic;
import soundGarden.objects.RenderedObject;

public class SeedOnPlant extends RenderedObject {

    public float rayon;

    float gravity = 5;      // 下降速度
    float size = 0;         // 当前大小
    float maxSize = 25;

    boolean hasBeenBlown = false; // 是否被吹起
    int amount = 0;
    int maxSeeds = 10;
    int minSeeds = 5;

    int seedOnPlant = applet.lerpColor(red, black, amount);

    public SeedOnPlant(float posX, float posY, float rSeed, float rMaxSeed) {
        super();
        position.x = posX;
        position.y = posY;
        this.size = rSeed;
        this.maxSize = rMaxSeed;
    }

    private void physics() {
        hasBeenBlown = Mic.isBlowing() || hasBeenBlown;
    }

    public void draw() {

        if ((hasBeenBlown) && (size >= maxSize)) {
            if (amount <= 80 && amount%10 == 0) {
                new Seed(position.x, position.y);
            }

            amount += 1;
            seedOnPlant = applet.lerpColor(red, black, amount * 0.002f);
        }

        // 检查下种子是否被吹起
        physics();

        if (size < maxSize) {
            size += 0.2f;
        }

        applet.fill(seedOnPlant);
        applet.noStroke();
        applet.circle(renderedPosition.x, renderedPosition.y, size);
    }
}