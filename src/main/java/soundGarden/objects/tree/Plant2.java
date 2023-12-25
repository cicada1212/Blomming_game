package soundGarden.objects.tree;

import soundGarden.objects.RenderedObject;

public class Plant2 extends RenderedObject {

    boolean needInit = true;
    float flowerTimer = 0;    // init
    float flowerSpeed = 0.05f; // 花的生长速度
    float rFlower1 = 0;         // 花的半径
    float rFlower2 = 0;
    float rFlower3 = 0;
    float rFlower4 = 0;
    float rFlower5 = 0;
    float rFlower6 = 0;

    float linear1X = renderedPosition.x;
    float linear1Y = renderedPosition.y;
    float bez1X = renderedPosition.x;
    float bez1Y = renderedPosition.y;
    float bez2X = renderedPosition.x;
    float bez2Y = renderedPosition.y;

    boolean growPlant2 = true;
    int posSeedOnPlant = (int) applet.random(1, 7);

    Plant2(float posX, float posY) {
        super();
        position.x = posX;
        position.y = posY;
        sop = new SeedOnPlant(0, 0, 0, 0);
    }

    SeedOnPlant sop;

    public void draw() {

        while (needInit == true) {
            linear1X = renderedPosition.x;
            linear1Y = renderedPosition.y;
            bez1X = renderedPosition.x;
            bez1Y = renderedPosition.y;
            bez2X = renderedPosition.x;
            bez2Y = renderedPosition.y;

            needInit = false;
        }

        flowerTimer += flowerSpeed;

        applet.strokeWeight(3);
        applet.noFill();
        applet.stroke(0);
        applet.bezier(linear1X, linear1Y, bez1X, bez1Y, bez2X, bez2Y, renderedPosition.x, renderedPosition.y);
        applet.noStroke();

        if (posSeedOnPlant == 1) {
            applet.fill(black);
            //circle(renderedPosition.x, renderedPosition.y-49, rFlower1);
            applet.circle(renderedPosition.x-2, renderedPosition.y-124, rFlower2);
            applet.circle(renderedPosition.x-9, renderedPosition.y-176, rFlower3);
            applet.circle(renderedPosition.x-27, renderedPosition.y-225, rFlower4);
            applet.circle(renderedPosition.x-60, renderedPosition.y-253, rFlower5);
            applet.circle(renderedPosition.x-87, renderedPosition.y-252, rFlower6);

            sop.position.x = position.x;
            sop.position.y = position.y-49;
            sop.size = rFlower1;
            sop.maxSize = 35;
        }

        if (posSeedOnPlant == 2) {
            applet.fill(black);
            applet.circle(renderedPosition.x, renderedPosition.y-49, rFlower1);
            //circle(renderedPosition.x-2, renderedPosition.y-124, rFlower2);
            applet.circle(renderedPosition.x-9, renderedPosition.y-176, rFlower3);
            applet.circle(renderedPosition.x-27, renderedPosition.y-225, rFlower4);
            applet.circle(renderedPosition.x-60, renderedPosition.y-253, rFlower5);
            applet.circle(renderedPosition.x-87, renderedPosition.y-252, rFlower6);

            sop.position.x = position.x-2;
            sop.position.y = position.y-124;
            sop.size = rFlower2;
            sop.maxSize = 30;
        }

        if (posSeedOnPlant == 3) {
            applet.fill(black);
            applet.circle(renderedPosition.x, renderedPosition.y-49, rFlower1);
            applet.circle(renderedPosition.x-2, renderedPosition.y-124, rFlower2);
            //circle(renderedPosition.x-9, renderedPosition.y-176, rFlower3);
            applet.circle(renderedPosition.x-27, renderedPosition.y-225, rFlower4);
            applet.circle(renderedPosition.x-60, renderedPosition.y-253, rFlower5);
            applet.circle(renderedPosition.x-87, renderedPosition.y-252, rFlower6);

            sop.position.x = position.x - 9;
            sop.position.y = position.y-176;
            sop.size = rFlower3;
            sop.maxSize = 25;
        }

        if (posSeedOnPlant == 4) {
            applet.fill(black);
            applet.circle(renderedPosition.x, renderedPosition.y-49, rFlower1);
            applet.circle(renderedPosition.x-2, renderedPosition.y-124, rFlower2);
            applet.circle(renderedPosition.x-9, renderedPosition.y-176, rFlower3);
            //circle(renderedPosition.x-27, renderedPosition.y-225, rFlower4);
            applet.circle(renderedPosition.x-60, renderedPosition.y-253, rFlower5);
            applet.circle(renderedPosition.x-87, renderedPosition.y-252, rFlower6);

            sop.position.x = position.x - 27;
            sop.position.y = position.y - 225;
            sop.size = rFlower4;
            sop.maxSize = 20;
        }

        if (posSeedOnPlant == 5) {
            applet.fill(black);
            applet.circle(renderedPosition.x, renderedPosition.y-49, rFlower1);
            applet.circle(renderedPosition.x-2, renderedPosition.y-124, rFlower2);
            applet.circle(renderedPosition.x-9, renderedPosition.y-176, rFlower3);
            applet.circle(renderedPosition.x-27, renderedPosition.y-225, rFlower4);
            //circle(renderedPosition.x-60, renderedPosition.y-253, rFlower5);
            applet.circle(renderedPosition.x-87, renderedPosition.y-252, rFlower6);

            sop.position.x = position.x - 60;
            sop.position.y = position.y - 253;
            sop.size = rFlower5;
            sop.maxSize = 15;
        }

        if (posSeedOnPlant == 6) {
            applet.fill(black);
            applet.circle(renderedPosition.x, renderedPosition.y-49, rFlower1);
            applet.circle(renderedPosition.x-2, renderedPosition.y-124, rFlower2);
            applet.circle(renderedPosition.x-9, renderedPosition.y-176, rFlower3);
            applet.circle(renderedPosition.x-27, renderedPosition.y-225, rFlower4);
            applet.circle(renderedPosition.x-60, renderedPosition.y-253, rFlower5);
            //circle(renderedPosition.x-87, renderedPosition.y-252, rFlower6);

            sop.position.x = position.x - 87;
            sop.position.y = position.y - 252;
            sop.size = rFlower6;
            sop.maxSize = 10;
        }


        if ((flowerTimer >= 1.5f) && (rFlower1 < 35)) {
            rFlower1 += flowerTimer;
        }
        if ((flowerTimer >= 2) && (rFlower2 < 30)) {
            rFlower2 += flowerTimer;
        }
        if ((flowerTimer >= 2.5f) && (rFlower3 < 25)) {
            rFlower3 += flowerTimer;
        }
        if ((flowerTimer >= 3) && (rFlower4 < 20)) {
            rFlower4 += flowerTimer;
        }
        if ((flowerTimer >= 3.5f) && (rFlower5 < 15)) {
            rFlower5 += flowerTimer;
        }
        if ((flowerTimer >= 3.7f) && (rFlower6 < 10)) {
            rFlower6 += flowerTimer;
        }

        if (growPlant2 == true) {
            if (linear1X >= renderedPosition.x-87)
            {
                linear1X -= flowerTimer/1.5f;
            }

            if (linear1Y >= renderedPosition.y-246)
            {
                linear1Y -= flowerTimer*2.28f;
            }

            if (bez1X >= renderedPosition.x+2)
            {
                bez1X -= flowerTimer*1.8f;
            }

            if (bez1Y >= renderedPosition.y-276)
            {
                bez1Y -= flowerTimer*2.6f;
            }

            if (bez2X >= renderedPosition.x+19)
            {
                bez2X -= flowerTimer*3;
            }

            if (bez2Y >= renderedPosition.y-112)
            {
                bez2Y -= flowerTimer*1.8f;
            }
        }

        if (rFlower6 >= 10) {
            rFlower6 = 10;
            growPlant2 = false;
            linear1X = renderedPosition.x-87.59995f;
            linear1Y = renderedPosition.y-252.05394f;
            bez1X = renderedPosition.x;
            bez1Y = renderedPosition.y-278.8499f;
            bez2X = renderedPosition.x;
            bez2Y = renderedPosition.y-114.75f;
        }
    }
}
