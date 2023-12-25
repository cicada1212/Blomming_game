package soundGarden.objects.tree;

import soundGarden.logic.Mic;
import soundGarden.logic.Time;
import soundGarden.objects.RenderedObject;
import processing.core.PVector;

public class Seed extends RenderedObject {

    float size = applet.random(5, 10);               // rayon de la graine
    PVector speedMultiplier = new PVector(applet.random(13, 16), applet.random(10, 18));  // Remplace pushRatioX et y
    boolean isPlanted = false;               // Est-ce que la graine a été plantée ?

    boolean isFertile = true;                 // une graine isFertile pousse obligatoirement
    float growProb = 0.5f;                     // Probabilité que la graine pousse
    PVector speed = new PVector(0, 0);


    Seed(float posX, float posY) {
        super();
        position.x = posX;
        position.y = posY;
        SeedManager.add(this);
    }

    private void physics() {
        // Si graine au-dessus du sol, elle descend
        if (position.y < applet.height-nivSol+size) {
            speed.y += 5 * Time.deltaTime;
            speed.x -= .1f * Time.deltaTime;


            float amplitude = Mic.getAmplitudeAbove();

            speed.x += amplitude * Time.deltaTime * speedMultiplier.x;
            speed.y -= amplitude * Time.deltaTime * speedMultiplier.y;

            position.add(speed);

            if (position.y < 10)
                position.y = 10;

            speed.x = applet.constrain(speed.x, 0, 3.5f);
            speed.y = applet.constrain(speed.y, -5, 1);
        }

        if (position.y >= applet.height-nivSol+size && !isPlanted) {   // si touche sol, la plante pousse
            isPlanted = true;

            float rnd = applet.random(1);
            if (isFertile || rnd < growProb)
                createRandomPlant(position.x, position.y);
        }
    }

    public void draw() {
        // Si la graine a déjà été plantée, on ne fait rien
        if (isPlanted) return;

        // D'abord on calcule la physique
        physics();

        // Après, on affiche la graine
        applet.fill(black);
        applet.noStroke();
        applet.circle(renderedPosition.x, renderedPosition.y, size);   // dessin graine
    }

    public RenderedObject createRandomPlant(float x, float y) {
        int rnd = (int)applet.random(0, 7);
        //int rnd = 3;
        RenderedObject r = null;

        switch (rnd) {
            case 0:
                r = new Plant1(x, y);
                break;

            case 1:
                r = new Plant5(x, y);
                break;

            case 2:
                r = new Plant2(x, y);
                break;

            case 3:
                r = new Plant3(x, y);
                break;

            case 6:
                r = new Plant7(x, y);
                break;

            case 5:
                r = new Plant6((int)x, (int)y, 300);
        }

        return r != null ? r : null;
    }
}