package soundGarden.objects.tree;

import soundGarden.objects.RenderedObject;

public class Plant1 extends RenderedObject {

    float topRightY = 500;    // 顶端高度
    float stemSpeed = 3;      // 根茎生长速度

    float flowerTimer = 0;    // init
    float flowerSpeed = 0.05f; // 花的生长速度
    float rFlower1 = 0;         // 花的半径
    float rFlower2 = 0;
    float rFlower3 = 0;
    float rFlower4 = 0;


    float root1X1 = renderedPosition.x;
    float root1X2 = renderedPosition.x+60;
    float root1X3 = renderedPosition.x+50;
    float root1X4 = renderedPosition.x+50;

    float root1Y1 = applet.random(150, 200);
    float root1Y2;
    float root1Y3;
    float root1Y4 = 100;

    float root2X1 = renderedPosition.x-(root1X1-renderedPosition.x);
    float root2X2 = renderedPosition.x-(root1X2-renderedPosition.x);
    float root2X3 = renderedPosition.x-(root1X3-renderedPosition.x);
    float root2X4 = renderedPosition.x-(root1X4-renderedPosition.x);

    float root2Y1 = applet.random(150, 200);
    float root2Y2;
    float root2Y3;
    float root2Y4 = 100;

    float root3X1 = renderedPosition.x+51;
    float root3X2 = renderedPosition.x+81;
    float root3X3 = renderedPosition.x+76;
    float root3X4 = renderedPosition.x+76;

    float root3Y1 = applet.random(120, 140);
    float root3Y2;
    float root3Y3;
    float root3Y4 = 100;

    float root4X1 = renderedPosition.x-(root3X1-renderedPosition.x);
    float root4X2 = renderedPosition.x-(root3X2-renderedPosition.x);
    float root4X3 = renderedPosition.x-(root3X3-renderedPosition.x);
    float root4X4 = renderedPosition.x-(root3X4-renderedPosition.x);

    float root4Y1 = applet.random(120, 140);
    float root4Y2;
    float root4Y3;
    float root4Y4 = 100;

    int nRoots = (int) applet.random(1, 5); // 随机几个根
    int posSeedOnPlant = (int) applet.random(1, 5);

    int opacity1 = 0;
    int opacity2 = 0;
    int opacity3 = 0;
    int opacity4 = 0;

    public Plant1(float posX, float posY) {
        super();
        position.x = posX;
        position.y = posY;
        sop = new SeedOnPlant(0, 0, 0, 0);
    }

    SeedOnPlant sop;

    public void draw() {

        root1X1 = renderedPosition.x;
        root1X2 = renderedPosition.x+60;
        root1X3 = renderedPosition.x+50;
        root1X4 = renderedPosition.x+50;

        root2X1 = renderedPosition.x-(root1X1-renderedPosition.x);
        root2X2 = renderedPosition.x-(root1X2-renderedPosition.x);
        root2X3 = renderedPosition.x-(root1X3-renderedPosition.x);
        root2X4 = renderedPosition.x-(root1X4-renderedPosition.x);

        root3X1 = renderedPosition.x+51;
        root3X2 = renderedPosition.x+81;
        root3X3 = renderedPosition.x+76;
        root3X4 = renderedPosition.x+76;

        root4X1 = renderedPosition.x-(root3X1-renderedPosition.x);
        root4X2 = renderedPosition.x-(root3X2-renderedPosition.x);
        root4X3 = renderedPosition.x-(root3X3-renderedPosition.x);
        root4X4 = renderedPosition.x-(root3X4-renderedPosition.x);

        flowerTimer += flowerSpeed;


        applet.smooth();
        applet.strokeWeight(3);
        applet.stroke(0);
        applet.line(renderedPosition.x, applet.height-nivSol, renderedPosition.x, topRightY);
        applet.noStroke();

        if (posSeedOnPlant == 1) {
            applet.fill(black);

            sop.position.x = position.x +27;
            sop.position.y = 360;
            sop.size = rFlower1;
            sop.maxSize = 50;
            applet.circle(renderedPosition.x-27, 300, rFlower2);
            applet.circle(renderedPosition.x+27, 240, rFlower3);
            applet.circle(renderedPosition.x, 180, rFlower4);
        }

        if (posSeedOnPlant == 2) {
            applet.fill(black);
            applet.circle(renderedPosition.x+27, 360, rFlower1);

            sop.position.x = position.x - 27;
            sop.position.y = 300;
            sop.size = rFlower2;
            sop.maxSize = 50;
            applet.circle(renderedPosition.x+27, 240, rFlower3);
            applet.circle(renderedPosition.x, 180, rFlower4);
        }

        if (posSeedOnPlant == 3) {
            applet.fill(black);
            applet.circle(renderedPosition.x+27, 360, rFlower1);
            applet.circle(renderedPosition.x-27, 300, rFlower2);

            sop.position.x = position.x+27;
            sop.position.y = 240;
            sop.size = rFlower3;
            sop.maxSize = 50;
            applet.circle(renderedPosition.x, 180, rFlower4);
        }

        if (posSeedOnPlant == 4) {
            applet.fill(black);
            applet.circle(renderedPosition.x+27, 360, rFlower1);
            applet.circle(renderedPosition.x-27, 300, rFlower2);
            applet.circle(renderedPosition.x+27, 240, rFlower3);

            sop.position.x = position.x;
            sop.position.y = 180;
            sop.size = rFlower4;
            sop.maxSize = 30;
        }


        if (topRightY > 170) { // 高度足够时就画花瓣
            if ((topRightY < 425) && (rFlower1 < 50)) {
                rFlower1 += flowerTimer;
                opacity1 += flowerTimer*5;
            }

            if ((topRightY < 340) && (rFlower2 < 50)) {
                rFlower2 += flowerTimer;
                opacity2 += flowerTimer*5;
            }

            if ((topRightY < 290) && (rFlower3 < 50)) {
                rFlower3 += flowerTimer;
                opacity3 += flowerTimer*6;
            }

            if ((topRightY < 190) && (rFlower4 < 30)) {
                rFlower4 += flowerTimer;
                opacity4 += flowerTimer*7;
            }
            topRightY -= stemSpeed;
        }

        applet.strokeWeight(3);
        applet.noFill();


        if (nRoots >= 1) {
            root1Y2 = root1Y1;
            root1Y3 = root1Y1+10;
            applet.stroke(0, 0, 0, opacity1);
            applet.bezier(root1X1, 600-root1Y1, root1X2, 600-root1Y2, root1X3, 600-root1Y3, root1X4, 600-root1Y4);
            if (nRoots >= 2) {
                root2Y2 = root2Y1;
                root2Y3 = root2Y1+10;
                applet.stroke(0, 0, 0, opacity2);
                applet.bezier(root2X1, 600-root2Y1, root2X2, 600-root2Y2, root2X3, 600-root2Y3, root2X4, 600-root2Y4);
                if (nRoots >= 3) {
                    root3Y2 = root3Y1;
                    root3Y3 = root3Y1+5;
                    applet.stroke(0, 0, 0, opacity3);
                    applet.bezier(root3X1, 600-root3Y1, root3X2, 600-root3Y2, root3X3, 600-root3Y3, root3X4, 600-root3Y4);
                    if (nRoots == 4) {
                        root4Y2 = root4Y1;
                        root4Y3 = root4Y1+5;
                        applet.stroke(0, 0, 0, opacity4);
                        applet.bezier(root4X1, 600-root4Y1, root4X2, 600-root4Y2, root4X3, 600-root4Y3, root4X4, 600-root4Y4);
                    }
                }
            }
        }
    }
}