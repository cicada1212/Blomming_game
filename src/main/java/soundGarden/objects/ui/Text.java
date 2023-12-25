package soundGarden.objects.ui;

import soundGarden.objects.RenderedObject;
import processing.core.PFont;

public class Text extends RenderedObject {

    PFont font;
    String text;
    int textColor = applet.color(0, 0, 0, 0);
    float opacity = 0;
    float size;
    float textWidth;

    public Text(String text, float size, float xPos, float yPos) {
        super();
        this.text = text;
        font = applet.createFont("font.ttf", size);
        position.x = xPos;
        position.y = yPos;
        textWidth = text.length() * size * 2;
        visible = false;
    }

    public Text(String text, float size, float xPos, float yPos, float op) {
        super();
        opacity = op;
        this.text = text;
        font = applet.createFont("font.ttf", size);
        position.x = xPos;
        position.y = yPos;
        textWidth = text.length() * size * 2;
        visible = false;
    }

    public void draw() {
        opacity = applet.constrain(opacity, 0, 255);

        applet.textFont(font);
        applet.fill(applet.color(applet.red(textColor), applet.green(textColor), applet.blue(textColor), opacity));
        applet.text(this.text, position.x - textWidth/4, position.y - size/2);
    }

}