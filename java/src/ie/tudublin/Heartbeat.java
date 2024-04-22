package ie.tudublin;

import C21325616.MichaelsVisuals;
import C22533826.NoelsVisual;
import c22371846.PatricksVisuals;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import C22328351.LarinasVisual;


public class Heartbeat extends Visual {

    int mode = 1;
    NoelsVisual noelsVisual;
    MichaelsVisuals michaelsVisuals;
    LarinasVisual LarinasVisual;
    PatricksVisual patricksVisuals;

    // Larinas ?
    public int innerHue;
    public int outerHue;

    public void settings() {
        println("CWD: " + System.getProperty("user.dir"));
        fullScreen(P3D, SPAN);
    }


    /*public void keyPressed() {
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
	}*/



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
        larinasVisual.setup();

        patricksVisuals = new PatricksVisual(this);
        

    }

    public void draw() {
        switch (mode) {
            case 1:
                noelsVisual.renderScene();
                break;
            case 2:
                patricksVisuals.renderAnimation();
                break;
            case 3:
                //michaelsVisuals.testRender();
                break;
            case 4:
                larinasVisual.render();
     

                michaelsVisuals.render();
                break;
            case 4:
                // LarinasVisual.render();
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

        if (keyCode >= '0' && keyCode <= '4') {

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