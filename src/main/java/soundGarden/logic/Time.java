package soundGarden.logic;

import processing.core.PApplet;

public class Time {

    public static PApplet app;
    public static float prevMillis = 0;
    public static float deltaTime = 0;

    public static void init(PApplet a) {
        app = a;
    }

    public static void update() {
        deltaTime = (app.millis() - prevMillis)/1000;
        prevMillis = app.millis();
    }
}