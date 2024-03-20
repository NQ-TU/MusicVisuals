package C21325616;

import java.util.List;

import example.MyVisual;
import ie.tudublin.Heartbeat;

import java.util.*; 

import processing.core.PApplet;
import processing.core.PVector;

class Icosahedron{

  int edges = 30;

  float X = 35.525731112119133606f; 
  float Z = 35.850650808352039932f;

  PVector vertices[] = {       new PVector(-X, 0.0f, Z), new PVector(X, 0.0f, Z), new PVector(-X, 0.0f, -Z), new PVector(X, 0.0f, -Z),       
                               new PVector(0.0f, Z, X), new PVector(0.0f, Z, -X), new PVector(0.0f, -Z, X), new PVector(0.0f, -Z, -X),       
                               new PVector(Z, X, 0.0f), new PVector(-Z, X, 0.0f), new PVector(Z, -X, 0.0f), new PVector(-Z, -X, 0.0f) };

  PVector indices[] = { new PVector(0,4,1), new PVector(0,9,4), new PVector(9,5,4), new PVector(4,5,8), new PVector(4,8,1),      
                         new PVector(8,10,1), new PVector(8,3,10), new PVector(5,3,8), new PVector(5,2,3), new PVector(2,7,3),       
                         new PVector(7,10,3), new PVector(7,6,10), new PVector(7,11,6), new PVector(11,0,6), new PVector(0,1,6),    
                         new PVector(6,1,10), new PVector(9,0,11), new PVector(9,11,2), new PVector(9,2,5), new PVector(7,2,11) };
  
  public void render(Heartbeat mv)
  {
    for (int i = 0; i < 20; i++) 
    { 
      int pointOne = (int) indices[i].x;
      int pointTwo = (int) indices[i].y;
      int pointThree = (int) indices[i].z;

      mv.stroke(255,255,153);
      mv.strokeWeight(4);
      mv.line(vertices[pointOne].x, vertices[pointOne].y, vertices[pointOne].z, vertices[pointTwo].x, vertices[pointTwo].y, vertices[pointTwo].z);
      mv.line(vertices[pointTwo].x, vertices[pointTwo].y, vertices[pointTwo].z, vertices[pointThree].x, vertices[pointThree].y, vertices[pointThree].z);
      mv.line(vertices[pointOne].x, vertices[pointOne].y, vertices[pointOne].z, vertices[pointThree].x, vertices[pointThree].y, vertices[pointThree].z);
    }
  }
  /* 
    // Return the vertices for an icosahedron.
public void generate(double side_length)
{
    // t1 and t3 are actually not used in calculations.
    float S = (float) side_length;
    //double t1 = 2.0 * Math.PI / 5;
    float t2 = (float) Math.PI / 10.0f;
    float t4 = (float) Math.PI / 5.0f;
    //double t3 = -3.0 * Math.PI / 10.0;
    float R = (S / 2.0f) / (float) Math.sin(t4);
    float H = (float) Math.cos(t4) * R;
    float Cx = (float) (R * Math.sin(t2));
    float Cz = (float) (R * Math.cos(t2));
    float H1 = (float) Math.sqrt(S * S - R * R);
    float H2 = (float) Math.sqrt((H + R) * (H + R) - H * H);
    float Y2 = (float) (H2 - H1) / 2.0f;
    float Y1 = Y2 + H1;

    List<PVector> points = new List();
    points.add(new PVector (  0f, (float) Y1,    0f));
    points.add(new PVector ( (float) R, (float) Y2,    0));
    points.add(new PVector ( Cx,  Y2,   Cz));
    points.add(new PVector ( -H,  Y2,  S/2));
    points.add(new PVector ( -H,  Y2, -S/2));
    points.add(new PVector ( Cx,  Y2,  -Cz));
    points.add(new PVector ( -R, -Y2,    0));
    points.add(new PVector (-Cx, -Y2,  -Cz));
    points.add(new PVector (  H, -Y2, -S/2));
    points.add(new PVector (  H, -Y2,  S/2));
    points.add(new PVector (-Cx, -Y2,   Cz));
    points.add(new PVector (  0, -Y1,    0));

    vertices = (PVector[]) points.toArray();
}
*/
}