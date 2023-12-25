package soundGarden.objects.ui;

import soundGarden.objects.RenderedObject;
import processing.core.PVector;

public class ProgressBar extends RenderedObject {
    public float value = 0;
    public float maxValue = 3;

    PVector size = new PVector(0, 0);
    int barColor = red;
    float borderWidth = 5;

    public ProgressBar(int xPos, int yPos, int xSize, int ySize) {
        position = new PVector(xPos, yPos);
        size = new PVector(xSize, ySize);
        visible = false;
    }

    public void draw() {
        value += .01f;

        // clamp
        value = applet.constrain(value, 0, maxValue);

        // 左上角
        renderedPosition = new PVector(position.x - size.x/2, position.y - size.y/2);

        // 画进度
        float barWidth = (value * size.x) / maxValue;
        applet.noStroke();
        applet.fill(red);
        applet.rect(renderedPosition.x, renderedPosition.y, barWidth, size.y);

        // 绘制边框
        applet.stroke(0, 0, 0);
        applet.strokeWeight(borderWidth);
        applet.noFill();
        applet.rect(renderedPosition.x, renderedPosition.y, size.x, size.y);
        applet.noStroke();
        applet.strokeWeight(0);
    }
}