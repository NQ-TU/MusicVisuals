package ie.tudublin;

import C21325616.MichaelsVisuals;
import C22533826.NoelsVisual;
import processing.core.PApplet;

public class Heartbeat extends Visual {

    int mode = 3;
    NoelsVisual noelsVisual;
    MichaelsVisuals michaelsVisuals;

    public void settings() {
        // size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D, SPAN);
    }

    public void setup() {
        colorMode(HSB);
        // noCursor();
        setFrameSize(256);
        startMinim();
        loadAudio("/Users/michaelferents/Desktop/OOPAssignment/MusicVisuals/java/data/Heartbeat.mp3");
        getAudioPlayer().play();
        // startListening();
        noelsVisual = new NoelsVisual();
        michaelsVisuals = new MichaelsVisuals(this);
    }

    public void draw() {
        switch (mode) {
            case 0:
                noelsVisual.render(this);
                break;
            case 2:
                // PatricksVisuals.render();
                break;
            case 3:
                michaelsVisuals.testRender();
            default:
                break;
        }
    }
}
