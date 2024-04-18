package C22533826;

import ie.tudublin.VisualException;
import ie.tudublin.Heartbeat;

public class NoelsVisual {

    // Declare variables.
    Heartbeat HB;
    starField sf;
    terrainNoel tn;

    int height;
    int width;

    // Declaring camera values, names took from processing documentation.
    // Used to ensure that visual remains consistent when rendering with other
    // visuals, even if other visuals use camera functions.
    float eyeX, eyeY, eyeZ;
    float centerX, centerY, centerZ;
    float upX, upY, upZ;

    public NoelsVisual(Heartbeat HB) {
        // Initialize variables.
        this.HB = HB;
        height = HB.displayHeight;
        width = HB.displayWidth;
        // Create new instances of starField and terrainNoel.
        this.sf = new starField(height, width, HB);
        this.tn = new terrainNoel(height, width, HB);
        // Set default camera values.
        setDefaultCamera();
    }

    // Render starField and terrainNoel. Reset camera to ensure that visuals are
    // consistent.
    public void render() {
        HB.background(0);
        resetCamera();
        sf.render();
        tn.render();
    }

    // Reset camera to default values.
    private void resetCamera() {
        HB.camera(eyeX, eyeY, eyeZ,
                centerX, centerY, centerZ,
                upX, upY, upZ);
    }

    // Set default camera values, ensures consistency when rendering with other
    // visuals.
    private void setDefaultCamera() {
        eyeX = HB.width / 2.0f;
        eyeY = HB.height / 2.0f;
        eyeZ = (HB.height / 2.0f) / HB.tan(HB.PI / 6.0f); // FOV is 60 degrees by default.
        centerX = HB.width / 2.0f;
        centerY = HB.height / 2.0f;
        centerZ = 0;
        upX = 0;
        upY = 1;
        upZ = 0;
    }
}
