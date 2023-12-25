package soundGarden.objects.tree;

import soundGarden.objects.AssetLoader;
import soundGarden.objects.ui.MicIcon;
import soundGarden.objects.RenderedObject;
import processing.core.PImage;

import static processing.core.PConstants.CORNERS;

public class PlantStart extends RenderedObject {

    float topRightY = 500;    // bout de la fleur
    float stemSpeed = 3;      // vitesse de pousse de la tige

    float imgPetalWidth = 66/2; // dimension X fichier png des pétales
    float imgPetalHeight = 379/2; // dimension Y fichier png des pétales

    float flowerTimer = 0; // timer pour animer la taille des pétales en fonction du temps
    float flowerTimer2 = 0; // timer pour animer la pousse des graines au sommet
    float flowerSpeed = 0.05f; // vitesse de pousse des fleurs

    float rFlower1; // rayon de la graine rouge
    float rFlower2; // rayon de la graine noire

    float anglePetalGauche = 30;
    float anglePetalDroite = -30;
    float angleD;
    float angleG;

    boolean animGrowShrink;
    float angle1=0;
    float angle2=0;
    float da=0.05f; // valeur augmentation des angles par frame
    float radiusSeed1;
    float radiusSeed2;

    int minRSeed1 = 20;
    int maxRSeed1 = 30;

    float petalScaleX; // scaling X de la pétale de droite
    float petalScaleY; // scaling Y de la pétale de droite
    float petalScaleXMirror; // scaling X de la pétale de gauche
    float petalScaleYMirror; // scaling Y de la pétale de gauche

    boolean open = false; // quand open = true, la fleur s'ouvre
    boolean icon = true;

    private PImage petalStart;
    private PImage petalStartMirror;


    public PlantStart(float posX, float posY) {
        super();
        position.x = posX;
        position.y = posY;
        petalStart = AssetLoader.get().loadImage("petal_start.png");
        petalStartMirror = AssetLoader.get().loadImage("petal_start_mirror.png");

        seedOnPlant = new SeedOnPlant(0, 0, 0, 0);
    }

    SeedOnPlant seedOnPlant;

    public void draw() {

        applet.smooth();
        applet.strokeWeight(3);
        applet.stroke(0);
        applet.line(renderedPosition.x, applet.height-nivSol, renderedPosition.x, topRightY); // dessin de la tige, topRightY évolue dans le temps
        flowerTimer += flowerSpeed;
        applet.noStroke();

        applet.fill(black);
        applet.circle(renderedPosition.x, 180, rFlower2); // dessin de la graine noire


        // Animation de l'ouverture des pétales

        // affichage du pétale de droite
        applet.imageMode(CORNERS);
        applet.pushMatrix();
        applet.translate(renderedPosition.x, 300);
        applet.rotate(angleG);
        applet.image(petalStart, -1, -1, petalScaleX, petalScaleY);
        //image(petalStart, -1, -1, imgPetalWidth, -imgPetalHeight);
        //imgPetalWidth = 66/2
        //imgPetalHeight = 379/2
        applet.popMatrix();

        // affichage du pétale de gauche
        applet.pushMatrix();
        applet.translate(renderedPosition.x, 300);
        applet.rotate(angleD);
        applet.image(petalStartMirror, 0, 0, petalScaleXMirror, petalScaleYMirror);
        //image(petalStartMirror, 0, 0, -imgPetalWidth, -imgPetalHeight);
        applet.popMatrix();

        seedOnPlant.position.x = position.x;
        seedOnPlant.position.y = 180;
        seedOnPlant.size = radiusSeed1;
        seedOnPlant.maxSize = minRSeed1;

        // variation des angles g et d pour animer les pétales
        if (open) {
            flowerTimer2 += flowerSpeed;
            if (angleG < 2) {
                angleG = (flowerTimer2/2)*applet.radians(anglePetalGauche);
            }

            if (angleD > -2) {
                angleD = (flowerTimer2/2)*applet.radians(anglePetalDroite);
            }
        }

        int m = applet.millis();

        if (m >= 30000) { // Ouverture de la fleur d'intro après 7 secondes de jeu
            open = true;
        }

        if (m >= 34000 && icon) {
            new MicIcon(renderedPosition.x, 50);
            icon = false;

        }

        if (topRightY > 200) { // tant que la hauteur de la tige n'atteint pas y = 200, pousse de la tige
            topRightY -= stemSpeed;
        }

        if (topRightY <= 200) {
            topRightY = 200;
        }


        if (topRightY == 200) { // animation des graines au sommet une fois la tige à hauteur maximale
            topRightY = 200;
            //animGrowShrink = true;
            if (rFlower1 <= 25) {
                rFlower1 += 0.6f;
            }

            if (rFlower2 <= 50) {
                rFlower2 += 0.9f;
            }
        }

        if (animGrowShrink == true) { // animation de clignotement de la graine rouge
            radiusSeed1 = applet.map(applet.sin(angle1), -1, 1, minRSeed1, maxRSeed1);
        }

        angle1 +=da;

        // Animation de pousse des pétales (de scale = 0 à état fermé)
        if ((topRightY < 310) & (petalScaleX <= imgPetalWidth)) {
            petalScaleX += flowerTimer/8;
        }

        if ((topRightY < 310) & (petalScaleY >= -imgPetalHeight)) {
            petalScaleY -= flowerTimer/1.3f;
        }

        if ((topRightY < 310) & (petalScaleXMirror >= -imgPetalWidth)) {
            petalScaleXMirror -= flowerTimer/8;
        }

        if ((topRightY < 310) & (petalScaleYMirror >= -imgPetalHeight)) {
            petalScaleYMirror -= flowerTimer/1.3f;
        }

        if ((petalScaleYMirror <= -imgPetalHeight) & (petalScaleY <= -imgPetalHeight)) { // déclenchement du clignotement de la graine rouge
            animGrowShrink = true;
        }
    }
}
