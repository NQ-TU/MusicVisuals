package ie.tudublin;

import C21325616.MichaelsVisuals;
import C22533826.NoelsVisual;
import c22371846.PatricksVisuals;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Heartbeat extends Visual {

    int mode = 3;
    NoelsVisual noelsVisual;

    PatricksVisuals PatricksVisuals;
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    MichaelsVisuals michaelsVisuals;

    public void settings() {
        // size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D, SPAN);
    }

    public void keyPressed() {
		if (key >= '0' && key <= '9') 
        {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) 
            {
                ap.pause();
            } 
            else 
            {
                ap.rewind();
                ap.play();
            }
        }
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

        PatricksVisuals = new PatricksVisuals();

        michaelsVisuals = new MichaelsVisuals(this);

    }

    public void draw() {
        switch (mode) {
            case 0:
                noelsVisual.render(this);
                break;
            case 2:
                PatricksVisuals.draw();
                break;
            case 3:
                michaelsVisuals.testRender();
            default:
                break;
        }
    }
}
