package ie.tudublin;

import C21325616.MichaelsVisuals;
import C22533826.NoelsVisual;
import c22371846.PatricksVisuals;
import C22328351.LarinasVisual;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;

public class Heartbeat extends Visual {

    int mode = 0;
    NoelsVisual noelsVisual;
    MichaelsVisuals michaelsVisuals;
z    LarinasVisual LarinasVisual;
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings() {
        //size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D, SPAN);
        size(1024, 800, P3D);
    }

    public void setup() {
        colorMode(HSB);
        // noCursor();
        setFrameSize(512);
        startMinim();
        getAudioPlayer().play();
        startListening();
        setFrameSize(512);
        startMinim();
        loadAudio("Heartbeat.mp3");

        noelsVisual = new NoelsVisual(this);
        michaelsVisuals = new MichaelsVisuals(this);
        //patricksVisuals = new patricksVisuals(this);
        LarinasVisual = new LarinasVisual();
    }

    public void draw() {

        switch (mode) {
            case 0:
                noelsVisual.render();
                break;
            case 1:
                patricksVisuals.render();
                break;
            case 2:
                michaelsVisuals.render();
            case 3:
                // Larina .render();
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
        if (keyCode >= '0' && keyCode <= '3') {
            mode = keyCode - '0';
        }

        // Restarts the song
        if (key == 'r') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }
}