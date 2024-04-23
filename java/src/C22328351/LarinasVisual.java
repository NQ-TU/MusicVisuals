package C22328351;

import ie.tudublin.VisualException;
import processing.core.PVector;
import ie.tudublin.Heartbeat;

public class LarinasVisual {

    static Heartbeat HB;
    float rotX, rotY;

    float radius = 200;
    int points = 5;

    

    public LarinasVisual(Heartbeat HB) {
        this.HB = HB;
        HB.colorMode(HB.HSB, 360, 100, 100);
        rotX = rotY = 0;
    }

    public void render() {
        HB.background(0);
        HB.pushMatrix();
        HB.lights();

        HB.translate(HB.width / 2, HB.height / 2);

        HB.rotateX(rotX);
        HB.rotateY(rotY);

        float rotationSpeedX = HB.map(HB.getAmplitude(), 0, 1, 0.02f, 0.15f);
        float rotationSpeedY = HB.map(HB.getAmplitude(), 0, 1, 0.02f, 0.3f);

        rotX += rotationSpeedX;
        rotY += rotationSpeedY;

        HB.calculateAverageAmplitude();

        float innerHue = HB.map(HB.getAmplitude(), 0, 1, 0, 360);
        float outerHue = HB.map(HB.getAmplitude(), 0, 1, 0, 360);

        HB.fill(innerHue, 100, 360);
        HB.stroke(innerHue, 90, 90, 150);
        drawStar(radius, points, innerHue, outerHue);
        HB.strokeWeight(4);

        HB.fill(outerHue, 200, 360);
        HB.stroke(innerHue, 90, 90, 150);
        drawStar(radius, points, innerHue, outerHue);
        HB.strokeWeight(4);

        float starSize = radius + HB.sin(HB.frameCount * 0.1f) * 500 * HB.getAmplitude();

        drawStar(starSize, points, outerHue, innerHue);

        // Draw the star inner
        drawStar(starSize * 0.5f, points, outerHue, innerHue);
        HB.popMatrix();
    }

    

    

    public void drawStar(float radius, int points, float innerHue, float outerHue) {
        float angle = HB.TWO_PI / points;
        float starAngle = angle / 2;

        HB.beginShape();
        for (float a = 0; a < HB.TWO_PI; a += angle) {
            float x = HB.cos(a) * radius;
            float y = HB.sin(a) * radius;
            float z1 = radius / 2;
            float z2 = -radius / 2;
            HB.stroke(outerHue, 100, 360); // Use vibrant color with maximum saturation and brightness
            HB.vertex(x, y, z1);
            HB.vertex(0, 0, z2);
            float sx = HB.cos(a + starAngle) * radius / 2;
            float sy = HB.sin(a + starAngle) * radius / 2;
            HB.vertex(sx, sy, z1);
        }
        HB.endShape(HB.CLOSE);

        float innerRadius = radius * 0.06f;
        HB.beginShape();
        for (float a = 0; a < HB.TWO_PI; a += angle) {
            float x = HB.cos(a) * innerRadius;
            float y = HB.sin(a) * innerRadius;
            float z1 = radius / 2;
            float z2 = -radius / 2;
            HB.stroke(innerHue, 100, 100);
            HB.vertex(x, y, z1);
            HB.vertex(0, 0, z2);
            float sx = HB.cos(a + starAngle) * innerRadius / 2;
            float sy = HB.sin(a + starAngle) * innerRadius / 2;
        }
        HB.endShape(HB.CLOSE);
    }
}
