package soundGarden.objects.tree;

import processing.core.PApplet;
import soundGarden.objects.RenderedObject;

import static processing.core.PConstants.CHORD;

public class Plant5 extends RenderedObject {

    float topRightY = 500;    // 顶端高度
    float stemSpeed = 5;      // 根茎生长速度

    float flowerTimer = 0;    // init
    float flowerSpeed = 0.05f; // 花的生长速度
    float rFlower4 = 0;

    int stemHeight = (int) applet.random(50, 300);
    int deg1 = 90;
    int deg2 = 90;
    float angle1 = PApplet.radians(deg1);
    float angle2 = PApplet.radians(deg2);
    int diameterX = 200;
    int diameterY = 150;

    Plant5(float posX, float posY) {
        super();
        position.x = posX;
        position.y = posY;
        sop = new SeedOnPlant(0, 0, 0, 0);
    }

    SeedOnPlant sop;

    public void draw() {

        flowerTimer += flowerSpeed;


        applet.smooth();
        applet.strokeWeight(3);
        applet.stroke(black);
        applet.line(renderedPosition.x, renderedPosition.y, renderedPosition.x, topRightY);
        applet.noStroke();

        applet.fill(black);
        angle1 = PApplet.radians(deg1);
        angle2 = PApplet.radians(deg2);
        applet.arc(renderedPosition.x, stemHeight - 70, diameterX, diameterY, angle1, angle2, CHORD);

        applet.fill(red);

        sop.position.x = position.x;
        sop.position.y = stemHeight - 32;
        sop.size = rFlower4;
        sop.maxSize = 20;

        if (topRightY > stemHeight) {     // 根茎变高
            topRightY -= stemSpeed;
        }

        if ((topRightY < stemHeight + 54) && ( deg1 > 45)) {
            deg1 -= 2;
            deg2 += 2;
        }

        if ((deg1 == 44) && (rFlower4 < 20)) {
            rFlower4 += 10;
            rFlower4 = PApplet.constrain(rFlower4, 0, 20);
        }
    }
}