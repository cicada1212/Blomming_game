package soundGarden.objects.tree;

import soundGarden.objects.AssetLoader;
import soundGarden.objects.RenderedObject;
import processing.core.PImage;

import static processing.core.PConstants.CORNERS;
import static processing.core.PConstants.ROUND;

public class Plant3 extends RenderedObject {

    PImage plant3Petal = AssetLoader.get().loadImage("plant3_petal.png");
    PImage plant3PetalMirror = AssetLoader.get().loadImage("plant3_petal_mirror.png");

    float topRightY = 500;    // 顶端高度
    float stemSpeed = 4;    // 根茎生长速度

    float rFlower4;

    float flowerTimer = 0;    // init
    float flowerSpeed = 0.05f; // 花的生长速度

    float imgPetalWidth = plant3Petal.width/3.2f; // 图片太大了，缩小一点
    float imgPetalHeight = plant3Petal.height/3.2f;

    float offsetY = 5;
    float heightRand;
    float heightRand2;
    float heightRand3;
    float heightRand4;
    float heightRand5;
    int nPetals;

    // 5个花瓣
    float leftPetal1ScaleX;
    float leftPetal1ScaleY;

    float rightPetal1ScaleX;
    float rightPetal1ScaleY;
    float leftPetal2ScaleX;
    float leftPetal2ScaleY;

    float rightPetal2ScaleX;
    float rightPetal2ScaleY;
    float leftPetal3ScaleX;
    float leftPetal3ScaleY;

    float rightPetal3ScaleX;
    float rightPetal3ScaleY;
    float leftPetal4ScaleX;
    float leftPetal4ScaleY;

    float rightPetal4ScaleX;
    float rightPetal4ScaleY;
    float leftPetal5ScaleX;
    float leftPetal5ScaleY;

    float rightPetal5ScaleX;
    float rightPetal5ScaleY;


    Plant3(float posX, float posY) {
        super();
        position.x = posX;
        position.y = posY;
        nPetals = (int) applet.random(3, 6);
        sop = new SeedOnPlant(0, 0, 0, 0);

        // 根据花瓣的数量调整花瓣在茎上的位置
        if (nPetals == 3) {
            heightRand = (int) applet.random(360, 440);
        }

        if (nPetals == 4) {
            heightRand = (int) applet.random(400, 450);
        }

        if (nPetals == 5) {
            heightRand = 460;
        }

        // 通过第一个花瓣的位置推出其他的位置
        heightRand2 = heightRand - imgPetalHeight - offsetY;
        heightRand3 = heightRand2 - imgPetalHeight - offsetY;
        heightRand4 = heightRand3 - imgPetalHeight - offsetY;
        heightRand5 = heightRand4 - imgPetalHeight - offsetY;

        leftPetal1ScaleX = renderedPosition.x;
        leftPetal1ScaleY = heightRand;

        rightPetal1ScaleX = renderedPosition.x;
        rightPetal1ScaleY = heightRand;

        leftPetal2ScaleX = renderedPosition.x;
        leftPetal2ScaleY = heightRand2;

        rightPetal2ScaleX = renderedPosition.x;
        rightPetal2ScaleY = heightRand2;

        leftPetal3ScaleX = renderedPosition.x;
        leftPetal3ScaleY = heightRand3;

        rightPetal3ScaleX = renderedPosition.x;
        rightPetal3ScaleY = heightRand3;

        leftPetal4ScaleX = renderedPosition.x;
        leftPetal4ScaleY = heightRand4;

        rightPetal4ScaleX = renderedPosition.x;
        rightPetal4ScaleY = heightRand4;

        leftPetal5ScaleX = renderedPosition.x;
        leftPetal5ScaleY = heightRand5;

        rightPetal5ScaleX = renderedPosition.x;
        rightPetal5ScaleY = heightRand5;
    }

    SeedOnPlant sop;

    public void draw() {

        applet.imageMode(CORNERS);
        flowerTimer += flowerSpeed;

        applet.strokeWeight(3);
        applet.strokeCap(ROUND);
        applet.noFill();
        applet.stroke(0);
        applet.smooth();

        // 绘制根茎
        applet.line(renderedPosition.x, renderedPosition.y, renderedPosition.x, topRightY);

        applet.noStroke();
        //circle(renderedPosition.x, 180, rFlower4);   
        sop.position.x = position.x;
        sop.position.y = 180;
        sop.size = rFlower4;
        sop.maxSize = 25;

        // 随机3~5个花瓣

        if ((topRightY > 170) & (nPetals >= 3)) {
            if ((topRightY < heightRand) & (leftPetal1ScaleX <= imgPetalWidth)) {
                leftPetal1ScaleX += flowerTimer*1.26f;
                rightPetal1ScaleX -= flowerTimer*1.26f;
            }

            if ((topRightY < heightRand) & (leftPetal1ScaleY >= heightRand-imgPetalHeight)) {
                leftPetal1ScaleY -= flowerTimer;
                rightPetal1ScaleY -= flowerTimer;
            }

            if ((topRightY < heightRand2) & (leftPetal2ScaleX <= imgPetalWidth)) {
                leftPetal2ScaleX += flowerTimer*1.26f;
                rightPetal2ScaleX -= flowerTimer*1.26f;
            }

            if ((topRightY < heightRand2) & (leftPetal2ScaleY >= heightRand2-imgPetalHeight)) {
                leftPetal2ScaleY -= flowerTimer;
                rightPetal2ScaleY -= flowerTimer;
            }

            if ((topRightY < heightRand3) & (leftPetal3ScaleX <= imgPetalWidth)) {
                leftPetal3ScaleX += flowerTimer*1.26f;
                rightPetal3ScaleX -= flowerTimer*1.26f;
            }

            if ((topRightY < heightRand3) & (leftPetal3ScaleY >= heightRand3-imgPetalHeight)) {
                leftPetal3ScaleY -= flowerTimer;
                rightPetal3ScaleY -= flowerTimer;
            }

            if ((topRightY < 200) && (rFlower4 < 30)) {
                rFlower4 += flowerTimer;
            }



            topRightY -= stemSpeed;
            applet.imageMode(CORNERS);
            applet.image(plant3Petal, renderedPosition.x, heightRand, renderedPosition.x+leftPetal1ScaleX, leftPetal1ScaleY);
            applet.image(plant3PetalMirror, renderedPosition.x, heightRand, renderedPosition.x+rightPetal1ScaleX, rightPetal1ScaleY);
            applet.image(plant3Petal, renderedPosition.x, heightRand2, renderedPosition.x+leftPetal2ScaleX, leftPetal2ScaleY);
            applet.image(plant3PetalMirror, renderedPosition.x, heightRand2, renderedPosition.x+rightPetal2ScaleX, rightPetal2ScaleY);
            applet.image(plant3Petal, renderedPosition.x, heightRand3, renderedPosition.x+leftPetal3ScaleX, leftPetal3ScaleY);
            applet.image(plant3PetalMirror, renderedPosition.x, heightRand3, renderedPosition.x+rightPetal3ScaleX, rightPetal3ScaleY);

            if (nPetals >= 4) {
                if ((topRightY < heightRand4) & (leftPetal4ScaleX <= imgPetalWidth)) {
                    leftPetal4ScaleX += flowerTimer*1.26f;
                    rightPetal4ScaleX -= flowerTimer*1.26f;
                }

                if ((topRightY < heightRand4) & (leftPetal4ScaleY >= heightRand4-imgPetalHeight)) {
                    leftPetal4ScaleY -= flowerTimer;
                    rightPetal4ScaleY -= flowerTimer;
                }

                applet.image(plant3Petal, renderedPosition.x, heightRand4, renderedPosition.x+leftPetal4ScaleX, leftPetal4ScaleY);
                applet.image(plant3PetalMirror, renderedPosition.x, heightRand4, renderedPosition.x+rightPetal4ScaleX, rightPetal4ScaleY);

                if (nPetals >= 5) {
                    if ((topRightY < heightRand5) & (leftPetal5ScaleX <= imgPetalWidth)) {
                        leftPetal5ScaleX += flowerTimer*1.26f;
                        rightPetal5ScaleX -= flowerTimer*1.26f;
                    }

                    if ((topRightY < heightRand5) & (leftPetal5ScaleY >= heightRand5-imgPetalHeight)) {
                        leftPetal5ScaleY -= flowerTimer;
                        rightPetal5ScaleY -= flowerTimer;
                    }

                    applet.image(plant3Petal, renderedPosition.x, heightRand5, renderedPosition.x+leftPetal5ScaleX, leftPetal5ScaleY);
                    applet.image(plant3PetalMirror, renderedPosition.x, heightRand5, renderedPosition.x+rightPetal5ScaleX, rightPetal5ScaleY);
                }
            }
        }


        if (topRightY <= 170) { // 把花瓣绘制出来
            applet.image(plant3Petal, renderedPosition.x, heightRand, renderedPosition.x+leftPetal1ScaleX, leftPetal1ScaleY);
            applet.image(plant3PetalMirror, renderedPosition.x, heightRand, renderedPosition.x+rightPetal1ScaleX, rightPetal1ScaleY);
            applet.image(plant3Petal, renderedPosition.x, heightRand2, renderedPosition.x+leftPetal2ScaleX, leftPetal2ScaleY);
            applet.image(plant3PetalMirror, renderedPosition.x, heightRand2, renderedPosition.x+rightPetal2ScaleX, rightPetal2ScaleY);
            applet.image(plant3Petal, renderedPosition.x, heightRand3, renderedPosition.x+leftPetal3ScaleX, leftPetal3ScaleY);
            applet.image(plant3PetalMirror, renderedPosition.x, heightRand3, renderedPosition.x+rightPetal3ScaleX, rightPetal3ScaleY);
            if (nPetals >= 4) {
                applet.image(plant3Petal, renderedPosition.x, heightRand4, renderedPosition.x+leftPetal4ScaleX, leftPetal4ScaleY);
                applet.image(plant3PetalMirror, renderedPosition.x, heightRand4, renderedPosition.x+rightPetal4ScaleX, rightPetal4ScaleY);
            }

            if (nPetals >= 5) {
                applet.image(plant3Petal, renderedPosition.x, heightRand5, renderedPosition.x+leftPetal5ScaleX, leftPetal5ScaleY);
                applet.image(plant3PetalMirror, renderedPosition.x, heightRand5, renderedPosition.x+rightPetal5ScaleX, rightPetal5ScaleY);
            }
        }
    }
}