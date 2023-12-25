package soundGarden.logic;

import soundGarden.objects.RenderedObject;

public class Timer extends RenderedObject {
    public float waitTime = 1;
    public float timeLeft = 1;

    public boolean autoStart = false;
    public boolean paused = true;

    public TimeoutCallback timeoutCallback;

    private float startMillis;

    public Timer(TimeoutCallback callback) {
        super();
        visible = false;
        timeoutCallback = callback;
        if (autoStart) start();
    }

    public void draw() {
        if (paused) return;

        float elapsedTime = (applet.millis() - startMillis)/1000;
        timeLeft = waitTime - elapsedTime;

        if (timeLeft <= 0) {
            stop();
            timeLeft = waitTime;
            timeoutCallback.onTimeout();
        }
    }

    public void start() {
        if (!paused) return;

        startMillis = applet.millis();
        paused = false;
        timeLeft = waitTime;
    }

    public void resume() {
        if (!paused) return;

        paused = false;
    }

    public void stop() {
        if (paused) return;

        paused = true;
    }
}
