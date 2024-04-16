package C21325616;

import example.MyVisual;
import ie.tudublin.Heartbeat;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class MichaelsVisuals {

    Heartbeat mv;

    Icosahedron ico;

    int width;
    int height;

    PVector pos = new PVector( 50f, 50f);
    PVector dir = new PVector(0, -10);

    public MichaelsVisuals(Heartbeat mv)
    {
        this.mv = mv; 
        ico = new Icosahedron();

        width = mv.displayWidth;
        height = mv.displayHeight;
    }

    void rotate2D(PVector v, float theta) {
        float xTemp = v.x;
        v.x = v.x * (float)Math.cos(theta) - v.y * (float)Math.sin(theta);
        v.y = xTemp*(float) Math.sin(theta) + v.y*(float) Math.cos(theta);
      }

    public void testRender()
    {
        mv.beginCamera();
        mv.noFill();
        mv.background(188, 67, 76);
        mv.camera(70.0f, 35.0f, 120.0f, 50.0f, 50.0f, 0.0f, 0.0f, 1.0f, 0.0f);

        mv.translate(pos.x, pos.y);
        mv.rotate(PApplet.atan2(dir.y, dir.x));
        rotate2D(dir, PApplet.radians(3)); 
        /* 
        mv.translate(50, 50, 0);
        mv.rotateX(-PConstants.PI/6);
        mv.rotateY(PConstants.PI/3);
        */
        //mv.box(45);
        ico.render(mv);
        mv.endCamera();
    }
    
}
