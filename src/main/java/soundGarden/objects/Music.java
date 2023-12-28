package soundGarden.objects;

import processing.sound.SoundFile;

public class Music {

    SoundFile file;
    String Music = ("aprilsun.mp3");

    public Music() {
        file = AssetLoader.get().loadSound(Music);
        file.play();
    }

}