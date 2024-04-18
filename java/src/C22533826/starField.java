package C22533826;

import ie.tudublin.Heartbeat;
import ie.tudublin.VisualException;
import processing.core.PVector;
import java.util.ArrayList;

// 1. Need to rename a few variables to be more appropriate. -Can be worked on.
// 2. Change to add depth/more colors. -Not attempted yet. (create a nebula affect, where the stars are in a galaxy with stronger/faster pulls towards the center. Potentially new file for isospheres?)
// 3. Add comments to explain the code better for github. -Can be worked on.
// 4. Need to refactor render to better fit program/make better use of OOP principles. -DONE.
// 5. Add a way to interact with the stars. (potentially planets/hearts/ship idea).

public class starField {

    int visHeight;
    int visWidth;
    Heartbeat HB;

    int numParticles = 3000; // Number of particles in the star field.
    float noiseScalar = 0.05f; // Adjust the angle step for smoother transition.

    // Create an arraylist of particles.
    ArrayList<PVector> particles;

    public starField(int height, int width, Heartbeat HB) {
        // Initialize variables. Setting the height and width of the visual.
        this.visHeight = HB.floor(height / 2.7f);
        this.visWidth = width;
        this.HB = HB;
        particles = new ArrayList<PVector>();

        // Create particles at random positions.
        for (int i = 0; i < numParticles; i++) {
            particles.add(new PVector(HB.random(visWidth), HB.random(visHeight)));
        }
    }

    public void render() {
        // Handles audio processing for the visual.
        audioHandler();

        HB.background(0);
        HB.stroke(255);
        HB.fill(255, 150);

        // Loop through all particles and render them.
        for (PVector p : particles) {
            renderParticle(p);
            updateParticlePos(p);
            outOfBoundsCheck(p);
            mouseInteraction(p);
        }
    }

    // Simply renders a particle at the given position.
    private void renderParticle(PVector p) {
        HB.point(p.x, p.y);
    }

    // Updates the position of a particle based on noise and amplitude.
    private void updateParticlePos(PVector p) {
        float noiseAngle = HB.noise(p.x * noiseScalar, p.y * noiseScalar);
        float angle = HB.map(noiseAngle, 0, 1, 0, HB.TWO_PI);
        // Update particle position based on noise angle and amplitude.
        float amplitude = HB.getSmoothedAmplitude();
        float stepSize = HB.map(amplitude, 0, 1, 0, 10); // Adjust speed based on amplitude.
        p.x += HB.cos(angle) * stepSize;
        p.y += HB.sin(angle) * stepSize;
    }

    // Wraps the particle around the screen if it goes out of bounds.
    private void outOfBoundsCheck(PVector p) {
        if (p.x < 0) {
            p.x = visWidth;
        } else if (p.x > visWidth) {
            p.x = 0;
        }
        if (p.y < 0) {
            p.y = visHeight;
        } else if (p.y > visHeight) {
            p.y = 0;
        }
    }

    // Applies mouse interaction to the particle.
    // Creates something similar to a black hole effect, where the particles are
    // pulled towards the mouse position.
    private void mouseInteraction(PVector p) {
        float mouseDist = HB.dist(p.x, p.y, HB.mouseX, HB.mouseY);
        if (mouseDist < 100) {
            float pushStrength = HB.map(mouseDist, 0, 50, 10, 0);
            PVector pushDirection = new PVector(p.x - HB.mouseX, p.y - HB.mouseY);
            pushDirection.normalize();
            pushDirection.mult(pushStrength);
            p.add(pushDirection);
        }
    }

    // Handles audio processing for the visual.
    private void audioHandler() {
        HB.calculateAverageAmplitude();
        try {
            HB.calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }
        HB.calculateFrequencyBands();
    }
}