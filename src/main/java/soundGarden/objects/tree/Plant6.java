package soundGarden.objects.tree;

import soundGarden.logic.Time;
import soundGarden.objects.RenderedObject;
import processing.core.PVector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Plant6 extends RenderedObject {
    private float timer = 0;
    private float flowerHeight;

    private float curHeight = 0;

    private int petalCount = 4;
    private HashMap<Branch, Petal> petalMap = new HashMap<Branch, Petal>();

    Plant6(int positionX, int positionY, int flowerHeight) {
        super();
        position = new PVector(positionX, positionY);
        this.flowerHeight = flowerHeight;

        petalCount = applet.round(applet.random(1, 6));

        // 绘制花瓣
        int petalRadius = 100/petalCount;
        for (int i = 1; i <= petalCount; i++) {
            float yPos = position.y - i * (flowerHeight/(petalCount+1));
            PVector pos = new PVector(position.x + petalRadius*2 * (i%2==0 ? -1 : 1), yPos);

            Petal p = new Petal(pos, petalRadius, .3f);
            Branch b = new Branch(new PVector(position.x, yPos + (flowerHeight/(2*(petalCount+1)))), pos);
            petalMap.put(b, p);
        }
    }

    SeedOnPlant sop;

    public void draw() {
        if (curHeight < flowerHeight)
            curHeight += .01f * (flowerHeight/3);   // 2s内画完，算下速度
        else if (sop == null)
            sop = new SeedOnPlant(position.x, position.y - flowerHeight, 0, 40);

        // 画根茎
        applet.stroke(black);
        applet.strokeWeight(3);
        applet.fill(black);
        applet.line(renderedPosition.x, renderedPosition.y, renderedPosition.x, renderedPosition.y - curHeight);

        // 是否需要画树枝
        for (Map.Entry<Branch, Petal> entry : petalMap.entrySet()) {
            Petal p = entry.getValue();
            Branch b = entry.getKey();

            b.isGrowing = renderedPosition.y - curHeight <= b.position.y || b.isGrowing;
            p.isGrowing = b.finished || p.isGrowing;
        }

        timer += Time.deltaTime;
    }



    private class Branch extends RenderedObject {
        public PVector endOffset;
        private PVector curOffset = new PVector(0, 0);
        private float timer = 0;
        public boolean isGrowing = false;

        private boolean finished = false;

        Branch(PVector pos, PVector endPos) {
            position = pos;
            endOffset = new PVector(endPos.x - pos.x, endPos.y - pos.y);
        }

        public void draw() {
            if (!isGrowing) return;

            // 是否已经长好
            PVector dist = new PVector(endOffset.x, endOffset.y);
            dist.sub(curOffset);

            finished = dist.mag() < 2 || finished;

            // 画枝杈
            curOffset.lerp(endOffset, .1f);

            applet.noFill();
            applet.stroke(black);
            applet.strokeWeight(3);
            PVector renderedEnd = new PVector(renderedPosition.x + curOffset.x, renderedPosition.y + curOffset.y);

            applet.bezier(renderedPosition.x, renderedPosition.y,
                    renderedEnd.x - curOffset.x/2, renderedPosition.y,
                    renderedEnd.x, renderedEnd.y - curOffset.y/2,
                    renderedEnd.x, renderedEnd.y);

            timer = Time.deltaTime;
        }
    }


}