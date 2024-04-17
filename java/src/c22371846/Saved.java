package c22371846;

public class Saved {
    
    public void setup()
    {
        HB.colorMode(HB.HSB);
        HB.background(0);
        minim = new Minim(this);
        // Microphone
        //ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        //ab = ai.mix; 

        //Music
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        fft = new FFT(HB.width, 44100);

        lerpedBuffer = new float[HB.width];
    }

    public void render()
	{
        float separated = 10;
        float sum = 0;
        float off = 0;
        float average = 0;
        float smoothedAmplitude = 0;
        int bar_values = (int) (HB.mouseX / 20.0f);
        float w = HB.width / (float) bar_values;
        float h = HB.height / separated;
        float H = HB.height / 2;
        float W = HB.width / 2;

        for(int i = 0 ; i < ab.size(); i ++)
        {
            sum += (ab.get(i));
            lerpedBuffer[i] = HB.lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }
        average = sum / (float) ab.size();

        smoothedAmplitude = HB.lerp(smoothedAmplitude, average, 0.75f);

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

		switch (mode)
		{
			case 0:
			{
                off += 10;
                HB.background(0);
                HB.text("Frequencies: " + freq, HB.width - 300, HB.height - 50);

                //bar values
				for (int i = 1; i < ab.size(); i++) 
				{
					float num = 50;
                    float f = lerpedBuffer[i] * H * 4.0f;
					float x = HB.map(num * i, HB.width - 450, HB.width, num, HB.width);
                    float c = HB.map((off), 0, 200, 0, 255);
                    float cc = c * i;
                    HB.fill(cc % 256, 255, 255);
                    HB.rect(x, 0, w, f * h * 0.15F);
                    HB.noStroke();
				}

                for (int i = 0; i < 20; i++) 
                {
                    HB.text(i * 50, 25, (i * 50) + 10);
                }
				break;
			}
            case 1:
            {   
                off+=10;
                HB.background((off) % 256, HB.mouseX);
                for(int i = 0 ; i < fft.specSize() / 2; i ++)
                {
                    float c = HB.map(i, 0, ab.size(), 0, 255);
                    float cc = c * i;
                    HB.translate(100, 0, 0);
                    HB.rotateY(angle);
                    HB.rotateX(angle);
                    if (HB.keyCode == HB.LEFT) 
                    {
                        HB.square(W, H, HB.lerp(0, smoothedAmplitude, (fft.getBand(i) * 100)));
                        HB.fill((cc + off) % 256, HB.mouseX, 255);
                    }

                    if (HB.keyCode == HB.RIGHT) 
                    {
                        HB.triangle(W, H, H, H, W, (fft.getBand(i)));
                        HB.fill((cc + off) % 256, HB.mouseX, 255);                    
                    } 

                    if (HB.keyCode == HB.UP) {
                        HB.circle(W, H, (fft.getBand(i) * 6));
                        HB.fill((cc + off) % 256, HB.mouseX, 255);
                                            
                    }

                    if (HB.keyCode == HB.DOWN) {
                        HB.box((fft.getBand(i) * 3));
                        HB.fill((cc + off) % 256, HB.mouseX, 255);   
                        HB.stroke(0);                 
                    }
                }
                angle += 0.01f;
				break;
            }
        }
    }
    float angle = 0;
}
}
