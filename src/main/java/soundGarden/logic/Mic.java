package soundGarden.logic;

import processing.core.PApplet;
import processing.sound.Amplitude;
import processing.sound.AudioIn;

import java.util.ArrayList;

public class Mic {
    public static float blowThreshold = .18f;

    public static AudioIn audioIn;
    public static Amplitude amplitude;

    public static void init(PApplet app) {
        Mic.audioIn = new AudioIn(app, 0);
        Mic.audioIn.start();
        Mic.amplitude = new Amplitude(app);
        Mic.amplitude.input(audioIn);
    }

    // 说话返回true
    public static boolean isBlowing() {
        return Mic.amplitude.analyze() > blowThreshold;
    }

    // 返回麦克风的振幅
    public static float getAmplitude() {
        return Mic.amplitude.analyze();
    }

    // 说话返回振幅，否则返回0
    public static float getAmplitudeAbove() {
        return isBlowing() ? getAmplitude() : 0;
    }

    public static ArrayList<Float> silenceSamples = new ArrayList<Float>();
    public static void recordSilence() {
        silenceSamples.add(amplitude.analyze());
    }

    public static ArrayList<Float> blowSamples = new ArrayList<Float>();
    public static void recordBlow() {
        blowSamples.add(amplitude.analyze());
    }

    public static void calibrate() {
        float averageSilence = 0;
        for (int i = 0; i < silenceSamples.size(); i++) {
            averageSilence += silenceSamples.get(i);
        }
        averageSilence /= silenceSamples.size();

        float averageBlow = 0;
        for (int i = 0; i < blowSamples.size(); i++) {
            averageBlow += blowSamples.get(i);
        }
        averageBlow /= blowSamples.size();

        blowThreshold = (averageSilence + averageBlow) / 2;
    }
}