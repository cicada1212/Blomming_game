package soundGarden.logic;

import soundGarden.objects.tree.Seed;
import soundGarden.objects.tree.SeedManager;
import soundGarden.objects.ui.Background;
import soundGarden.objects.RenderedObject;
import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class Camera {

    // 世界坐标系下的位置
    public PVector position = new PVector(0, 0);

    // 要渲染的物体
    public ArrayList<RenderedObject> renderedObjects = new ArrayList<>();

    private ArrayList<RenderedObject> queuedObjects = new ArrayList<>();

    Background background = new Background();
    protected PApplet applet;

    Camera(PApplet applet) {
        if (CameraManager.current == null)
            CameraManager.current = this;
        this.applet = applet;
    }

    // 渲染循环
    public void draw() {
        applet.clear();

        // 背景
        background.renderedPosition = background.position.sub(this.position);
        background.draw();

        // 绘制要渲染的物体
        for (RenderedObject obj : renderedObjects) {
            obj.renderedPosition = obj.position.sub(this.position);

            if (!obj.visible || isInBounds(obj)) {
                if (!obj.disabled)
                    obj.draw();
            } else if (obj instanceof Seed) {
                SeedManager.remove((Seed)obj);
            }
        }

        // 一帧结束后再把新增的物体加进来
        renderedObjects.addAll(queuedObjects);
        queuedObjects.clear();
    }

    public boolean isInBounds(RenderedObject obj) {
        return obj.renderedPosition.x >= -applet.width/4;
    }

    // 添加要渲染的物体
    public void add(RenderedObject obj) {
        queuedObjects.add(obj);
    }
}