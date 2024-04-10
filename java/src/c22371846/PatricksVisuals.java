package c22371846;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import ddf.minim.analysis.FFT;
import ie.tudublin.Visual;



public class PatricksVisuals extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    Visual V;
    FFT fft;

    int mode = 0;
    float separated = 10;
    float[] lerpedBuffer;

    public void settings()
    {
        size(1024, 800, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        colorMode(HSB);
        background(0);
        minim = new Minim(this);
        // Microphone
        //ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        //ab = ai.mix; 

        //Music
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        fft = new FFT(width, 44100);

        lerpedBuffer = new float[width];
    }

    public void keyPressed() 
    {
		if (key >= '0' && key <= '9') 
        {
			mode = key - '0';
		}
		if (keyCode == ' ') 
        {
            if (ap.isPlaying()) 
            {
                ap.pause();
            } 
            else 
            {
                ap.rewind();
                ap.play();
            }
        }
	}

    float smoothedBoxSize = 0;
    float off = 0;

    public void draw()
	{
        float sum = 0;
        float average = 0;
        float smoothedAmplitude = 0;
        float bar_values = 30;
        float w = width / separated;
        float h = height / separated;
        float H = height / 2;
        float W = width / 2;

        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }
        average = sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.75f);

		switch (mode)
		{
			case 0:
			{
                background(0);
                off += 1;

                fft.forward(ab);

                int maxFFTIndex = 0;
                for(int i = 0 ; i < fft.specSize() /2  ; i ++)
                {
                    if (fft.getBand(i) > fft.getBand(maxFFTIndex))
                    {
                        maxFFTIndex = i;
                    }
                }
                float freq = fft.indexToFreq(maxFFTIndex);
                text("Frequencies: " + freq, width - 300, height - 50);

                //bar values
				for (int i = 1; i < ab.size(); i++) 
				{
					float num = 50;
                    float f = lerpedBuffer[i] * H * 4.0f;
					float x = map(num * i, width - 450, width, num, width);
                    int c = (int)map(i, 0, 25, 0, 255);
                    int cc = c * i;
                    fill((cc + off) % 256, mouseY, mouseX);
                    rect(x + 50, 0, w, f * h * 0.1F);
				}

                for (int i = 0; i < bar_values; i++) 
                {
                    text(i * 50, 25, (i * 50) + 50);
                }
				break;
			}
            case 1:
            {
                background((off) % 256);
                off += 1;

                fft.forward(ab);

                int maxFFTIndex = 0;
                for(int i = 0 ; i < fft.specSize() /2  ; i ++)
                {
                    int c = (int)map(i, 0, 25, 0, 1000);
                    int cc = c * i;
                    translate(100, 0, 0);
                    rotateY(angle);
                    rotateX(angle);

                    if (fft.getBand(i) > fft.getBand(maxFFTIndex))
                    {
                        maxFFTIndex = i;
                    }

                    if (keyCode == LEFT) 
                    {
                        square(W, H, lerp(0, smoothedAmplitude, (fft.getBand(i) * 100)));
                        fill((cc + off) % 500, mouseY, mouseX);
                    }

                    if (keyCode == RIGHT) 
                    {
                        //triangle(W, H, (fft.getBand(i) * 6));
                        //fill((cc + off) % 500, mouseY, mouseX);
                    }

                    if (keyCode == UP) {
                        circle(W, H, (fft.getBand(i) * 6));
                        fill((cc + off) % 500, mouseY, mouseX);
                    }

                    if (keyCode == DOWN) {
                        box((fft.getBand(i) * 3));
                        fill((cc + off) % 500, mouseY, mouseX);
                        stroke((off) % 256, mouseY);
                    }
                    
                }
                angle += 0.01f;
				break;
            }
        }
    }
    float angle = 0;
}
