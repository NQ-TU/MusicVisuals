package c22371846;

import ie.tudublin.*;


public class PatricksVisuals 
{
    Graph G;
    Animation A;
    Heartbeat HB;

    public PatricksVisuals(Heartbeat HB) {
        this.HB = HB;
        this.A = new Animation();
        this.G = new Graph();
    }

    public void render() {
        HB.background(0);
        A.render();
        G.render();
    }
}