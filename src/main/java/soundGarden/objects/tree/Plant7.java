package soundGarden.objects.tree;

import soundGarden.objects.AssetLoader;
import soundGarden.objects.RenderedObject;
import processing.core.PImage;

import static processing.core.PConstants.CORNERS;

public class Plant7 extends RenderedObject {

    PImage plant7Petal = AssetLoader.get().loadImage("plant7_petal.png");

    float topRightY = 500;    // 顶端高度
    float stemSpeed = 3;      // 根茎生长速度
    float rFlower1 = 0;


    float flowerTimer = 0;    // init
    float flowerSpeed = 0.05f; // 花的生长速度

    float imgPetalWidth = plant7Petal.width/3.2f;
    float imgPetalHeight = 88/3.2f;

    float hauteurCouplePetals1 = 390;
    float hauteurCouplePetals2 = 330;
    float hauteurCouplePetals3 = 280;

    int stemHeight = 240;


    Plant7(float posX, float posY) {
        super();
        position.x = posX;
        position.y = posY;
        sop = new SeedOnPlant(0, 0, 0, 0);
    }

    SeedOnPlant sop;

    // 三片花瓣
    float diameterLeftPetal1X = renderedPosition.x;
    float diameterLeftPetal1Y = hauteurCouplePetals1;

    float diameterRightPetal1X = renderedPosition.x;
    float diameterRightPetal1Y = hauteurCouplePetals1;

    float diameterLeftPetal2X = renderedPosition.x;
    float diameterLeftPetal2Y = hauteurCouplePetals2;

    float diameterRightPetal2X = renderedPosition.x;
    float diameterRightPetal2Y = hauteurCouplePetals2;

    float diameterLeftPetal3X = renderedPosition.x;
    float diameterLeftPetal3Y = hauteurCouplePetals3;

    float diameterRightPetal3X = renderedPosition.x;
    float diameterRightPetal3Y = hauteurCouplePetals3;


    public void draw() {

        flowerTimer += flowerSpeed;

        applet.smooth();
        applet.strokeWeight(3);
        applet.stroke(black);
        applet.line(renderedPosition.x, renderedPosition.y, renderedPosition.x, topRightY);
        applet.noStroke();

        applet.fill(red);

        sop.position.x = position.x;
        sop.position.y = 240;
        sop.size = rFlower1;
        sop.maxSize = 18;

        if (topRightY > stemHeight) {     // 根茎变高
            topRightY -= stemSpeed;
        }

        if ((topRightY <= stemHeight +10) & (rFlower1 <= 18)) {
            rFlower1 += 1;
        }

        if ((topRightY < hauteurCouplePetals1) & (diameterLeftPetal1X >= -imgPetalWidth)) {
            diameterLeftPetal1X -= flowerTimer;
            diameterLeftPetal1Y += flowerTimer/5;
        }

        if ((topRightY < hauteurCouplePetals1) & (diameterRightPetal1X <= imgPetalWidth)) {
            diameterRightPetal1X += flowerTimer;
            diameterRightPetal1Y += flowerTimer/5;
        }

        if ((topRightY < hauteurCouplePetals2) & (diameterLeftPetal2X >= -imgPetalWidth/1.5f)) {
            diameterLeftPetal2X -= flowerTimer;
            diameterLeftPetal2Y += flowerTimer/5;
        }

        if ((topRightY < hauteurCouplePetals2) & (diameterRightPetal2X <= imgPetalWidth/1.5f)) {
            diameterRightPetal2X += flowerTimer;
            diameterRightPetal2Y += flowerTimer/5;
        }

        if ((topRightY < hauteurCouplePetals3) & (diameterLeftPetal3X >= -imgPetalWidth/2.5f)) {
            diameterLeftPetal3X -= flowerTimer;
            diameterLeftPetal3Y += flowerTimer/5;
        }

        if ((topRightY < hauteurCouplePetals3) & (diameterRightPetal3X <= imgPetalWidth/2.5f)) {
            diameterRightPetal3X += flowerTimer;
            diameterRightPetal3Y += flowerTimer/5;
        }

        applet.imageMode(CORNERS);
        applet.image(plant7Petal, renderedPosition.x, hauteurCouplePetals1, renderedPosition.x+diameterLeftPetal1X, diameterLeftPetal1Y);
        applet.image(plant7Petal, renderedPosition.x, hauteurCouplePetals1, renderedPosition.x+diameterRightPetal1X, diameterRightPetal1Y);
        applet.image(plant7Petal, renderedPosition.x, hauteurCouplePetals2, renderedPosition.x+diameterLeftPetal2X, diameterLeftPetal2Y);
        applet.image(plant7Petal, renderedPosition.x, hauteurCouplePetals2, renderedPosition.x+diameterRightPetal2X, diameterRightPetal2Y);
        applet.image(plant7Petal, renderedPosition.x, hauteurCouplePetals3, renderedPosition.x+diameterLeftPetal3X, diameterLeftPetal3Y);
        applet.image(plant7Petal, renderedPosition.x, hauteurCouplePetals3, renderedPosition.x+diameterRightPetal3X, diameterRightPetal3Y);
    }
}