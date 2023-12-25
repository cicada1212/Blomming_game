package soundGarden.logic;

import soundGarden.objects.RenderedObject;
import soundGarden.objects.tree.SeedManager;
import processing.core.PApplet;
import processing.core.PVector;

public class CameraFollow extends Camera {
    public float speed = 1;
    public int followMargin = 1;

    public RenderedObject targetObj;
    public PVector targetPos;

    public CameraFollow(PApplet applet) {
        super(applet);
    }

    public void draw() {
        super.draw();

        targetObj = SeedManager.getFurthestSeed();
        // Get the target object position
        if (targetObj != null)
            targetPos = targetObj.position;

        if (targetPos != null)
            if (!isNear(targetPos)) {
                int dx = (int)(targetPos.x - (position.x + applet.width/2));
                position.x = dx * 0.05f;
            }
    }



    private boolean isNear(PVector pos) {
        int center = applet.round(position.x + applet.width/2);
        int dist = (int)applet.abs(targetPos.x - center);
        return dist < followMargin;
    }
}