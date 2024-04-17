package C22328351;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class LarinasVisual extends PApplet{

    //Rotating star variable
    float rotX, rotY;

    //Star size and points variables
    float radius = 200;
    int points = 5;

    //Audio library objects
    //Minim minim;
    //AudioPlayer ap;
    //AudioBuffer ab;

    //int mode = 0;

    //Processing setup
    public void settings()
    {
        size(800, 800, P3D);
    }

    //Setup function that intializes the color mode and loads the audio file
    public void setup()
    {
        //Color mode and rotation variables
        colorMode(HSB, 360, 100, 100);

        //Intialize the rotation variables
        rotX = rotY;

        //Load the audio file
        //minim = new Minim(this);
        //ap = minim.loadFile("data/track.mp3", 1024);
        //ap.play();

        //Get the audio buffer
        //ab = ap.mix;
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
        //Clear the background and set the lights
        background (0);
        lights();

        //Translate the origin to the center of the screen
        translate(width/2, height/2);

        //Rotates the star on the x and y axis
        rotateX(rotX);
        rotateY(rotY);

        //Map the frame count to create the different colours
        float hue = map(frameCount, 0, 360, 0, 360);

        //Set the fill color
        fill(hue, 100, 100);

        float radius = this.radius + sin(frameCount * 0.05f) * 100;

        //Gets the amplitude of the audio and maps it to the star
        //float amplitude = getAmplitude();

        //Draw the star
        drawStar(radius, points);

        //Increments the rotation variables
        rotX += 0.05;
        rotY += 0.01;
    }

    //Draws the star shape
    public void drawStar(float radius, int points){

        //Calculates the angle and star angle
        float angle = TWO_PI / points;
        float starAngle = angle / 2;

        //Draws the star shape
        beginShape();
        for(float a = 0; a < TWO_PI; a += angle)
        {
            float x = cos(a) * radius;
            float y = sin(a) * radius;
            float z1 = radius/2;
            float z2 = -radius/2;
            vertex(x, y, z1);
            vertex(0, 0, z2);
            float sx = cos(a + starAngle) * radius / 2;
            float sy = sin(a + starAngle) * radius / 2;
            vertex(sx, sy, z1);
        }
        endShape(CLOSE);
    }

    //Gets the amplitude of the audio
    /*public float getAmplitude()
    {
        float total = 0;
        for(int i = 0; i < ab.size(); i++){
            total += abs(ab.get(i));
        }

        return total / ab.size();
    }
    */

    //Main function that runs the program
    public static void main(String[] args)
    {
        PApplet.main("C22328351.LarinasVisual");
    }

}