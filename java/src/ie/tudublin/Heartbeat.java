package ie.tudublin;

import C21325616.MichaelsVisuals;
import C22533826.NoelsVisual;
import c22371846.PatricksVisuals;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import ddf.minim.analysis.FFT;

public class Heartbeat extends Visual {

    int mode = 3;
    float[] lerpedBuffer;
    NoelsVisual noelsVisual;
    MichaelsVisuals michaelsVisuals;
    PatricksVisuals patricksVisuals;
    AudioPlayer ap;
    Minim minim;
    AudioInput ai;
    AudioBuffer ab;
    FFT fft;

    public void settings() {
        // size(800, 800, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D, SPAN);
        size(1024, 800, P3D);
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
        //loadAudio("/Users/michaelferents/Desktop/OOPAssignment/MusicVisuals/java/data/Heartbeat.mp3");
        //getAudioPlayer().play();
        // startListening();
        noelsVisual = new NoelsVisual();
        patricksVisuals = new PatricksVisuals();

        minim = new Minim(this);
        // Microphone
        //ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        //ab = ai.mix; 

        //Music
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        fft = new FFT(width, 44100);

        lerpedBuffer = new float[width];
    }

    public void draw() {
        switch (mode) {
            case 0:
                noelsVisual.render(this);
                break;
            case 2:
                patricksVisuals.draw();
                break;
            case 3:
                michaelsVisuals.testRender();
            default:
                break;
        }
    }
}
