package C22328351;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;
import ie.tudublin.Heartbeat;

public class LarinasVisual {

    private static final float TWO_PI = 0;

    //Declaring variable
    private Heartbeat HB;

    //Rotating star variable
    float rotX, rotY;

    //Star size and points variables
    float radius = 200;
    int points = 5;

    //int mode = 0;

    //Processing setup
    public void settings()
    {
        HB = new Heartbeat();
        HB.settings();
    }

    //Setup function that intializes the color mode and loads the audio file
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

    //Draws function that calls every frame
    public void draw()
    {
        HB.draw();

        //Clear the background and set the lights
        HB.background (0);
        HB.lights();

        //Rotates the star on the x and y axis
        HB.rotateX(rotX);
        HB.rotateY(rotY);

        float rotationSpeedX = HB.map(HB.getAmplitude(), 0, 1, 0.02f, 0.1f);
        float rotationSpeedY = HB.map(HB.getAmplitude(), 0, 1, 0.02f, 0.05f);

        rotX += rotationSpeedX;
        rotY += rotationSpeedY;

        //Map the frame count to create the different colours
        float hue = HB.map(HB.getAmplitude(), 0, 1, 0, 360);

        //Set the fill color
        HB.fill(hue, 100, 360);

        //Gets the amplitude of the audio and maps it to the star
        float amplitude = HB.getAmplitude();
        //float radius = this.radius + (amplitude * 200);

        float starSize = radius + HB.sin(HB.frameCount * 0.1f) * 500 * HB.getAmplitude();

        //Draw the star
        drawStar(starSize, points);
    }

    //Draws the star shape
    public void drawStar(float radius, int points){

        //Calculates the angle and star angle
        float angle = TWO_PI / points;
        float starAngle = angle / 2;

        //Draws the star shape
        HB.beginShape();
        for(float a = 0; a < TWO_PI; a += angle)
        {
            float x = HB. cos(a) * radius;
            float y = HB.sin(a) * radius;
            float z1 = radius/2;
            float z2 = -radius/2;
            HB.vertex(x, y, z1);
            HB.vertex(0, 0, z2);
            float sx = HB.cos(a + starAngle) * radius / 2;
            float sy = HB.sin(a + starAngle) * radius / 2;
            HB.vertex(sx, sy, z1);
        }
        HB.endShape(HB.CLOSE);
    }

    //Main function that runs the program
    public static void main(String[] args)
    {
        LarinasVisual lv = new LarinasVisual();
        lv.settings();
        lv.setup();
    }
}
