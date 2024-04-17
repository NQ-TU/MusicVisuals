package ie.tudublin;

<<<<<<< HEAD
import C21325616.MichaelsVisuals;
import c22371846.*;
import example.*;
import C21325616.*;
import C22533826.*;
 
// Test - Michael 
=======
import ie.tudublin.Heartbeat;
>>>>>>> e004797447396cb1645d51845a9680cc83308287

public class Main {

    public void startUI() {
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new Heartbeat());
    }

    public static void main(String[] args) 
    {
        Main main = new Main();
        main.startUI();
    }
}
