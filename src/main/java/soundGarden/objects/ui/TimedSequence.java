package soundGarden.objects.ui;

import soundGarden.logic.TimedElement;
import soundGarden.objects.RenderedObject;

public class TimedSequence extends RenderedObject {
    protected TimedElement[] elements;
    private int curIndex = 0;
    public boolean paused = false;
    public boolean hasBeenSetup = false;

    TimedSequence() {
        super();
        visible = false;
    }

    public void draw() {
        if (paused) return;
        TimedElement cur = elements[curIndex];
        if (!hasBeenSetup) {
            cur.setup();
            hasBeenSetup = true;
        }
        cur.update();
    }

    public void nextElement() {
        if (curIndex < elements.length - 1) {
            curIndex++;
            hasBeenSetup = false;
        } else paused = true;
    }
}