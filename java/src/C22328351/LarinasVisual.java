package C22328351;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;
import processing.core.PConstants;
import ie.tudublin.Heartbeat;

public class LarinasVisual{

    private static final float TWO_PI = 0;

    private static float outerHue;
    private static float innerHue;

    //Declaring variable
    private static Heartbeat HB;

    //Rotating star variable
    static float rotX;
    static float rotY;

    //Star size and points variables
    static float radius = 200;
    static int points = 5;

    //int mode = 0;

    //Processing setup
    public void settings()
    {
        HB = new Heartbeat();
        HB.settings();
    }

    //Setup function that initializes the color mode and loads the audio file
    public void setup()
    {
        //Color mode and rotation variables
        HB.setup();
        rotX = rotY = 0;

    }

    /*public void keyPressed() 
    {
        if (key >= '0' && key <= '9') 
        {
            mode = key - '0';
        }
        if (keyCode == ' ') 
        {
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
    */

    public LarinasVisual()
    {
        //Initializes the visual object
        LarinasVisual.HB = HB;
    }

    //Draws function that calls every frame
    public static void render()
    {
        HB.draw();

        //Clear the background and set the lights
        HB.background (0);
        HB.lights();

        //Rotates the star on the x and y axis
        HB.rotateX(rotX);
        HB.rotateY(rotY);

        float rotationSpeedX = Heartbeat.map(HB.getAmplitude(), 0, 1, 0.02f, 0.1f);
        float rotationSpeedY = Heartbeat.map(HB.getAmplitude(), 0, 1, 0.02f, 0.05f);

        rotX += rotationSpeedX;
        rotY += rotationSpeedY;

        //Map the frame count to create the different colours
            innerHue = Heartbeat.map(HB.getAmplitude(), 0, 1, 0, 360);
            outerHue = Heartbeat.map(HB.getAmplitude(), 0, 1, 0, 360);

            //Set the fill color
            HB.fill(innerHue, 100, 360);
            HB.stroke(innerHue, 90, 90, 150);
            drawStar(HB, radius, points, points, outerHue, innerHue);
            HB.strokeWeight(4);

            HB.fill(outerHue, 200, 360);
            HB.stroke(innerHue, 90, 90, 150);
            drawStar(HB, radius, points, points, innerHue, outerHue);
            HB.strokeWeight(4);

        }

        //Gets the amplitude of the audio and maps it to the star
        float amplitude = HB.getAmplitude();
        //float radius = this.radius + (amplitude * 200);

        float starSize = radius + Heartbeat.sin(HB.frameCount * 0.1f) * 500 * HB.getAmplitude();
       
        //Draw the star outer
        static void drawStar(Heartbeat HB, float radius, float starSize, int points, float outerHue, float innerHue){
            //Calculates the angle and star angle
            float angle = PConstants.TWO_PI / points;
            float starAngle = angle / 2;

            //Draws the star shape
            HB.beginShape();
            for (float a = 0; a < PConstants.TWO_PI; a += angle) {
                float x = Heartbeat.cos(a) * starSize;
                float y = Heartbeat.sin(a) * starSize;
                float z1 = starSize / 2;
                float z2 = -starSize / 2;
                HB.stroke(HB.outerHue, 100, 360); // Use vibrant color with maximum saturation and brightness
                HB.vertex(x, y, z1);
                HB.vertex(0, 0, z2);
                float sx = Heartbeat.cos(a + starAngle) * starSize / 2;
                float sy = Heartbeat.sin(a + starAngle) * starSize / 2;
                HB.vertex(sx, sy, z1);
            }
            HB.endShape(PConstants.CLOSE);

            float innerRadius = starSize * 0.06f;
            HB.beginShape();
            for(float a = 0; a < PConstants.TWO_PI; a += angle)
            {
                float x = Heartbeat.cos(a) * innerRadius;
                float y = Heartbeat.sin(a) * innerRadius;
                float z1 = starSize / 2;
                float z2 = -starSize / 2;
                HB.stroke(HB.innerHue, 100, 100);
                HB.vertex(x, y, z1);
                HB.vertex(0, 0, z2);
                float sx = Heartbeat.cos(a + starAngle) * innerRadius / 2;
                float sy = Heartbeat.sin(a + starAngle) * innerRadius / 2;
            }
            HB.endShape(PConstants.CLOSE);
        }
    
        
        

    //Main function that runs the program
    public static void renderVisual(){
        Visual.render();
    }

}



