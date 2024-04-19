package ie.tudublin;

import C21325616.MichaelsVisuals;
import C22533826.NoelsVisual;
import c22371846.PatricksVisuals;
// import C22328351.LarinasVisual;

public class Heartbeat extends Visual {

    int mode = 4;
    float[] lerpedBuffer;
    NoelsVisual noelsVisual;
    MichaelsVisuals michaelsVisuals;
    PatricksVisuals PatricksVisuals;
    LarinasVisual larinasVisual;
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    
    public Heartbeat(){
        this.ab = getAudioBuffer();
    }

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

    int mode = 0;
    NoelsVisual noelsVisual;
    MichaelsVisuals michaelsVisuals;
    PatricksVisuals PatricksVisuals;
    LarinasVisual LarinasVisual;


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
        PatricksVisuals = new PatricksVisuals();
        larinasVisual = new LarinasVisual();

        // LarinasVisual = new LarinasVisual();
    }

    public void settings() {
        fullScreen(P3D, SPAN);
        // size(1024, 768, P3D);
        println("CWD: " + System.getProperty("user.dir"));
    }

    public void draw() {

        switch (mode) {
            case 0:
                noelsVisual.render();
                break;
            case 1:
                // PatricksVisuals.render();
                // case 2:
                // //patricksVisuals.draw();
                break;
            case 2:
                michaelsVisuals.render();
            case 3:
                michaelsVisuals.testRender();
                break;
            case 4:
                larinasVisual.draw();
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
