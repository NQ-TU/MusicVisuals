package C22533826;

import ie.tudublin.VisualException;
import ie.tudublin.Heartbeat;

public class NoelsVisual {

    // Declare variables
    Heartbeat HB;
    starField sf;
    terrainNoel tn;

    int height;
    int width;

    public NoelsVisual(Heartbeat HB) {
        // Initialize variables
        this.HB = HB;
        height = HB.displayHeight;
        width = HB.displayWidth;
        // Create new instances of starField and terrainNoel
        this.sf = new starField(height, width, HB);
        this.tn = new terrainNoel(height, width, HB);
    }

    public void render() {
        // Render starField and terrainNoel, possible translate issue when rendering
        // with other visuals.
        HB.background(0);
        sf.render();
        tn.render();
    }
}
