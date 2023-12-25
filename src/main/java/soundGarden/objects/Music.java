package soundGarden.objects;

import processing.sound.SoundFile;

public class Music {

    SoundFile file;
    String Music = ("aprilsun.wav");

    public Music() {
        file = AssetLoader.get().loadSound(Music);
        file.play();
    }

}