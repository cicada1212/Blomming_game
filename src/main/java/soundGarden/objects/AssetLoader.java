package soundGarden.objects;

import processing.core.PImage;
import processing.core.PApplet;
import processing.sound.SoundFile;

import java.util.HashMap;

// 单例+工厂模式，加载素材
public class AssetLoader {
    private static AssetLoader instance = null;
    private HashMap<String, PImage> imgMap = new HashMap<>();
    private HashMap<String, SoundFile> soundMap = new HashMap<>();
    private PApplet applet;

    public static void init(PApplet applet){
        if(instance == null){
            instance = new AssetLoader(applet);
        }
    }
    public static AssetLoader get(){
        if(instance == null)
            throw new RuntimeException("Please init first");
        return instance;
    }

    private AssetLoader(PApplet applet){
        this.applet = applet;
    }

    public PImage loadImage(String assetName){
        if(imgMap.containsKey(assetName)){
            return imgMap.get(assetName);
        }else{
            PImage asset = applet.loadImage("/assets/" + assetName);
            imgMap.put(assetName, asset);
            return asset;
        }
    }

    public SoundFile loadSound(String assetName){
        if(soundMap.containsKey(assetName)){
            return soundMap.get(assetName);
        }else{
            String path = applet.sketchPath("/assets/" + assetName);
            SoundFile asset = new SoundFile(applet, path);
            soundMap.put(assetName, asset);
            return asset;
        }
    }


}
