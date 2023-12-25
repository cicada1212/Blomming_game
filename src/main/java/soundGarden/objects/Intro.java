package soundGarden.objects;

import soundGarden.objects.tree.PlantStart;

// 种子落地动画
public class Intro extends RenderedObject {

    float gravity = 3;
    float size = 10;      // 半径
    boolean isPlanted = false; // 种子是否落地

    public Intro(float posX, float posY) {
        super();
        position.x = posX;
        position.y = posY;
    }

    public void draw() {
        // 落地了就不用绘制了
        if (isPlanted) return;

        // 下落
        if (position.y < applet.height-nivSol+size) {
            position.y += gravity;
        }

        if (position.y >= applet.height-nivSol+size) {   // 检测落地
            isPlanted = true;
            new PlantStart(position.x, position.y);
        }

        applet.fill(red);

        if (isPlanted == true )
        {
            applet.noStroke();
            applet.fill (black);
            applet.circle(renderedPosition.x, renderedPosition.y, size);
        }

        if (isPlanted == false )
        {
            applet.noStroke();
            applet.fill (red);
            applet.circle(renderedPosition.x, renderedPosition.y, size);
        }
    }
}