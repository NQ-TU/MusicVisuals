package C22328351;

import java.util.*;
import java.util.Arrays;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class C22328351 extends PApplet{

    public void settings() {
        fullScreen(P3D, SPAN);
        println("CWD: " + System.getProperty("user.dir"));
    }


    public void setup() {
        size(800, 200);
        background(255);
        drawPiano(10, 10, 25, 150);
    }
     
    public void drawPiano(float x, float y, float keyWidth, float keyHeight) {
        float whiteKeyGap = keyWidth * 0.2f;
        float blackKeyGap = keyWidth * 0.5f;
        int[] whiteKeys = {0, 2, 4, 5, 7, 9, 11};


        for(int i = 0; i < 14; i++){
            float xPos = x + (i * (keyWidth + whiteKeyGap));
            if(i % 7 !=2 && i % 7 != 6){
                fill(255);
                rect(xPos, y, keyWidth, keyHeight);
            }
            else{
                fill(0);
                int blackKeyWidth = 10; 
                float blackKeyHeight = 100; 
                rect(xPos - (blackKeyWidth / 2), y, blackKeyWidth, blackKeyHeight);
            }


            if(Arrays.binarySearch(whiteKeys, i % 7) >= 0){
                fill(0);
                text(i/7, (float) (xPos - (keyWidth * 0.5)), y + keyHeight + 12);
            }
            else{
                text(i/7, (float) (xPos + (keyWidth * 0.5)), y + keyHeight + 12);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("C22328351.C22328351");
    }
}




