package soundGarden.objects;

import soundGarden.logic.CameraManager;
import processing.core.PApplet;
import processing.core.PVector;

public abstract class RenderedObject {
    public PVector position = new PVector(0, 0);
    public PVector renderedPosition = new PVector(0, 0);
    public boolean visible = true;
    public boolean disabled = false;
    public static int black;
    public static int red;
    public static int nivSol=100;

    protected static PApplet applet;

    public static void init(PApplet papplet){
        applet = papplet;
        black = applet.color(0);
        red = applet.color(255, 0, 0);
    }


    public RenderedObject() {
        if (CameraManager.current != null)
            CameraManager.current.add(this);

    }

    public abstract void draw();
}