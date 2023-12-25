package soundGarden.logic;

public interface TimedElement extends TimeoutCallback {
    void update();
    void setup();
    void onTimeout();
}