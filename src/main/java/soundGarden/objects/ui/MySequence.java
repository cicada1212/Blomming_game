package soundGarden.objects.ui;

import soundGarden.logic.Mic;
import soundGarden.logic.Time;
import soundGarden.logic.TimedElement;
import soundGarden.logic.Timer;
import soundGarden.objects.Intro;
import soundGarden.utils.EasingFunctions;

public class MySequence extends TimedSequence {

    public MySequence() {
        super();

        elements = new TimedElement[] {

                new TimedElement() {
                    public void setup() { Timer t = new Timer(this); t.start(); }
                    public void update() {}
                    public void onTimeout() { nextElement();}
                },

                new TimedElement() {
                    Text text;
                    int step = 0;
                    Timer t;
                    float time = 0;

                    public void setup() {
                        text = new Text("欢迎", 48, applet.width/2, applet.height/2, 0);
                    }
                    public void update() {
                        switch (step) {
                            case 0:
                                time += Time.deltaTime;
                                text.opacity = EasingFunctions.easeInCubic(time) * 100;
                                if (text.opacity >= 255)
                                    step++;
                                break;
                            case 1:
                                if (t != null) break;
                                time = 0;
                                t = new Timer(this);
                                t.start();
                                break;
                            case 2:
                                time += Time.deltaTime;
                                text.opacity = 255 - EasingFunctions.easeInCubic(time) * 100;
                                if (text.opacity <= 0) {
                                    text.visible = true;
                                    text.position.x = -1000;
                                    nextElement();
                                }
                                break;
                        }

                    }
                    public void onTimeout() { step++;}
                },



                new TimedElement() {
                    Text text;
                    int step = 0;
                    Timer t;
                    float time = 0;

                    public void setup() {
                        text = new Text("正在获取环境音量，请保持安静", 48, applet.width/2, applet.height/2, 0);
                    }
                    public void update() {
                        switch (step) {
                            case 0:
                                time += Time.deltaTime;
                                text.opacity = EasingFunctions.easeInCubic(time) * 100;
                                if (text.opacity >= 255)
                                    step++;
                                break;
                            case 1:
                                if (t != null) break;
                                time = 0;
                                t = new Timer(this);
                                t.start();
                                break;
                            case 2:
                                time += Time.deltaTime;
                                text.opacity = 255 - EasingFunctions.easeInCubic(time) * 100;
                                if (text.opacity <= 0) {
                                    text.visible = true;
                                    text.position.x = -1000;
                                    nextElement();
                                }
                                break;
                        }

                    }
                    public void onTimeout() { step++; }
                },


                new TimedElement() {
                    ProgressBar p;
                    Timer t;
                    ProgressBar s;

                    public void setup() {
                        t = new Timer(this);
                        t.start();
                        t.waitTime = 5;
                        p = new ProgressBar(applet.width/2, applet.height/2, 300, 30);
                        s = new ProgressBar(applet.width/2, applet.height/2 + 100, 100, 10);
                        s.maxValue = 1;
                        s.borderWidth = 3;
                        p.value = 0;
                        p.maxValue = 5;
                    }
                    public void update() {
                        p.value = 5 - t.timeLeft;
                        Mic.recordSilence();
                        s.value = Mic.getAmplitude();
                    }
                    public void onTimeout() {
                        nextElement();
                        s.visible = true;
                        s.position.x = -1000;
                        p.visible = true;
                        p.position.x = -1000;
                    }
                },



                new TimedElement() {
                    Text text;
                    int step = 0;
                    Timer t;
                    float time = 0;

                    public void setup() {
                        text = new Text("请吹气", 48, applet.width/2, applet.height/2, 0);
                        text.opacity = 0;
                    }
                    public void update() {
                        switch (step) {
                            case 0:
                                time += Time.deltaTime;
                                text.opacity = EasingFunctions.easeInCubic(time) * 100;
                                if (text.opacity >= 255)
                                    step++;
                                break;
                            case 1:
                                if (t != null) break;
                                time = 0;
                                t = new Timer(this);
                                t.start();
                                break;
                            case 2:
                                time += Time.deltaTime;
                                text.opacity = 255 - EasingFunctions.easeInCubic(time) * 100;
                                if (text.opacity <= 0) {
                                    text.visible = true;
                                    text.position.x = -1000;
                                    nextElement();
                                }
                                break;
                        }

                    }
                    public void onTimeout() { step++; }
                },


                new TimedElement() {
                    ProgressBar p;
                    Timer t;
                    ProgressBar s;

                    public void setup() {
                        t = new Timer(this);
                        t.start();
                        t.waitTime = 5;
                        p = new ProgressBar(applet.width/2, applet.height/2, 300, 30);
                        s = new ProgressBar(applet.width/2, applet.height/2 + 100, 100, 10);
                        s.borderWidth = 3;
                        s.maxValue = 1;
                        p.value = 0;
                        p.maxValue = 5;
                    }
                    public void update() {
                        p.value = 5 - t.timeLeft;
                        Mic.recordBlow();
                        s.value = Mic.getAmplitude();
                    }
                    public void onTimeout() {
                        nextElement();
                        s.visible = true;
                        s.position.x = -1000;
                        p.visible = true;
                        p.position.x = -1000;
                        Mic.calibrate();
                        System.out.println("Breath amp : " + Mic.blowThreshold);
                        new Intro(600, -50);
                    }
                },

        };
    }
}