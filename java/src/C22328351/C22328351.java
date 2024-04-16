package C22328351;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class C22328351 extends PApplet{

    float rotX, rotY;
    float radius = 200;
    int points = 5;

    public void settings()
    {
        size(800, 800, P3D);
    }

    public void setup()
    {
        background(0);
        lights();

        translate(width/2, height/2);

        rotateX(rotX);
        rotateY(rotY);

        drawStar(radius, points);

        rotX += 0.01;
        rotY += 0.02;
    }

    public void drawStar(float radius, int points)
    {
        float angle = TWO_PI / points;
        float starAngle = angle / 2.0f;

        beginShape();
        for(float a = 0; a < TWO_PI; a += angle)
        {
            float x = cos(a) * radius;
            float y = sin(a) * radius;
            float z1 = radius/2;
            float z2 = -radius/2;
            vertex(x, y, z1);
            vertex(0, 0, z2);
            x = cos(a + starAngle) * radius / 2;
            y = sin(a + starAngle) * radius / 2;
            vertex(x, y, z1);
        }
        endShape(CLOSE);
    }

    public static void main(String[] args)
    {
        PApplet.main("C22328351.C22328351");
    }

}