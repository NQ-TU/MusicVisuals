package c22371846;

import ie.tudublin.VisualException;
import ie.tudublin.Heartbeat;

public class PatricksVisual {

    Heartbeat HB;
    Graph graphVisual;
    Animation animationVisual;

    int width, height;

    public PatricksVisual(Heartbeat HB) {
        this.HB = HB;
        this.graphVisual = new Graph(HB);
        this.animationVisual = new Animation(HB);

        this.width = HB.width;
        this.height = HB.height;
    }

    public void renderGraph() {
        graphVisual.render();
    }

    public void renderAnimation() {
        animationVisual.render();
    }
}