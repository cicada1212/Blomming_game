package soundGarden.objects.tree;

import soundGarden.logic.Time;
import soundGarden.objects.RenderedObject;
import processing.core.PVector;

public class Petal extends RenderedObject {

    public boolean isGrowing = false;

    private float growTime = 1; // 秒
    private float radius = 30;  // px
    private float innerRadius;
    private float innerRadiusPercent = .7f;

    private float curRadius = 0;
    private float timer = 0;

    public Petal(PVector position, float size, float time) {
        super();
        this.position = position;
        this.growTime = time;
        this.radius = size;
        this.innerRadius = innerRadiusPercent * this.radius;  // 外面一圈
    }

    public void draw() {
        if (!isGrowing) return;

        // 发光
        if (curRadius <= radius) {
            curRadius = timer * (radius/(growTime+1));
        }

        // 外围
        applet.noStroke();
        applet.fill(black);
        applet.arc(renderedPosition.x, renderedPosition.y - curRadius,
                curRadius*2, curRadius*2,
                0, applet.PI);

        // 内部
        applet.fill(red);
        float offset = (1.1f*curRadius)/2;
        applet.arc(renderedPosition.x, renderedPosition.y - curRadius,
                innerRadiusPercent * curRadius * 2, innerRadiusPercent * curRadius * 2,
                0, applet.PI);

        timer += Time.deltaTime; // px/s
    }
}