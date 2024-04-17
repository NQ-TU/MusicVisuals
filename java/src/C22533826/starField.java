package C22533826;

import ie.tudublin.Heartbeat;
import ie.tudublin.VisualException;
import processing.core.PVector;
import java.util.ArrayList;

// 1. Need to rename a few variables to be more appropriate. -Can be worked on.
// 2. Change to add depth/more colors. -Not attempted yet. (create a nebula affect, where the stars are in a galaxy with stronger/faster pulls towards the center.)
// 3. Add comments to explain the code better for github. -Can be worked on.
// 4. Need to refactor render to better fit program/make better use of OOP principles. -Needs to be worked on.
// 5. Add a way to interact with the stars. (potentially planets/hearts/ship idea).

public class starField {

    int visHeight;
    int visWidth;
    Heartbeat HB;

    int numPoints = 2000;
    float noiseScalar = 0.05f; // Adjust the angle step for smoother transition.

    // Create an arraylist of particles.
    ArrayList<PVector> particles;

    public starField(int height, int width, Heartbeat HB) {
        this.visHeight = height / 3;
        this.visWidth = width;
        this.HB = HB;

        // init_particles();
    }

    // Refactor needed for the following code, took from previous project.
    public void render() {
        HB.calculateAverageAmplitude();
        try {
            HB.calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }
        HB.calculateFrequencyBands();
        HB.background(0);

        float height = HB.height;
        float width = HB.width;

        float amplitude = HB.getSmoothedAmplitude();

        if (particles == null) {
            particles = new ArrayList<PVector>();
            for (int i = 0; i < numPoints; i++) {
                particles.add(new PVector(HB.random(width), HB.random(height)));
            }
        }

        HB.stroke(255);
        HB.fill(255, 150);

        for (int i = 0; i < numPoints; i++) {
            PVector p = particles.get(i);
            HB.point(p.x, p.y);

            // Calculate noise angle
            float n = HB.noise(p.x * noiseScalar, p.y * noiseScalar);
            float angle = HB.map(n, 0, 1, 0, HB.TWO_PI);

            // Update particle position based on noise angle and amplitude
            float stepSize = HB.map(amplitude, 0, 1, 0, 10); // Adjust speed based on amplitude
            p.x += HB.cos(angle) * stepSize;
            p.y += HB.sin(angle) * stepSize;

            // Wrap particle around the screen if it goes out of bounds
            if (p.x < 0) {
                p.x = width;
            } else if (p.x > width) {
                p.x = 0;
            }
            if (p.y < 0) {
                p.y = height;
            } else if (p.y > height) {
                p.y = 0;
            }

            // Apply mouse interaction
            float mouseDist = HB.dist(p.x, p.y, HB.mouseX, HB.mouseY);
            if (mouseDist < 50) {
                float pushStrength = HB.map(mouseDist, 0, 50, 10, 0);
                PVector pushDirection = new PVector(p.x - HB.mouseX, p.y - HB.mouseY);
                pushDirection.normalize();
                pushDirection.mult(pushStrength);
                p.add(pushDirection);
            }
        }
    }
}