package ie.tudublin;

import C21325616.MichaelsVisuals;
import C22533826.NoelsVisual;
import c22371846.PatricksVisual;
import C22328351.LarinasVisual;

public class Heartbeat extends Visual {

    int mode = 4;
    NoelsVisual noelsVisual;
    MichaelsVisuals michaelsVisuals;
    LarinasVisual LarinasVisual;
    PatricksVisual patricksVisuals;

    public void settings() {
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D, SPAN);
    }

    public void setup() {
        colorMode(HSB);
        setFrameSize(512);
        startMinim();
        loadAudio("Heartbeat.mp3");
        getAudioPlayer().play();
        // startListening();
        // noCursor();

        noelsVisual = new NoelsVisual(this);
        michaelsVisuals = new MichaelsVisuals(this);
        patricksVisuals = new PatricksVisual(this);
        LarinasVisual = new LarinasVisual(this);
    }

    public void draw() {
        switch (mode) {
            case 1:
                noelsVisual.renderScene();
                break;
            case 2:
                noelsVisual.resetCamera();
                noelsVisual.setDefaultCamera();
                patricksVisuals.renderAnimation();
                break;
            case 3:
                michaelsVisuals.render();
                break;
            case 4:
                noelsVisual.resetCamera();
                noelsVisual.setDefaultCamera();
                LarinasVisual.render();
                break;
            case 5:
                // Addtional renderings...
                break;
            default:
                break;
        }
    }

    public void keyPressed() {
        // Pauses playback of the song
        if (key == ' ') {
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            } else {
                getAudioPlayer().play();
            }
        }

        // Uses mode variable to switch between visuals
        if (keyCode >= '0' && keyCode <= '9') {
            mode = keyCode - '0';
        }

        // Restarts the song
        if (key == 'r') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }
}