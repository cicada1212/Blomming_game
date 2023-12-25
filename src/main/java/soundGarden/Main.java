package soundGarden;

import soundGarden.logic.Mic;
import soundGarden.logic.Time;
import soundGarden.objects.*;
import soundGarden.logic.CameraFollow;
import soundGarden.logic.CameraManager;
import soundGarden.objects.ui.MySequence;
import soundGarden.objects.ui.Text;
import processing.core.*;

import processing.sound.*;

public class Main extends PApplet {

    public void setup() {
        AssetLoader.init(this);
        RenderedObject.init(this);
        frameRate(60);
        surface.setTitle("声音花园");

        // init scene
        Mic.init(this);
        Time.init(this);

        new CameraFollow(this);
        new Music();
        //Intro (600, -50);
        new MySequence();  // 环境音量测试
    }

    public void draw() {
        CameraManager.current.draw();
        Time.update();
    }

    public void settings() {
        size(1200, 600);
    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"soundGarden.Main"};


        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }
}
