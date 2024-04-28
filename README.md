# Music Visualiser Project
Name: Michael Ferents
Student Number: C21325616

Name: Patrick Akinsowon
Student Number: C22371846


Name: Larina Yu
Student Number: C22328351

Name: Noel McCarthy
Student Number: C22533826


## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment
This project is the combined work of 4 team members, to create visuals that are interactive with our song, [Heartbeat - Childish Gambino.](https://youtu.be/uN8VQiKgRrU?si=vwhKmCmouqWreZ4a) We analysed audio elements of the song and then, using different methods visualised them using Processing in Java, with the help of the minim library.

# Instructions
Run Main.java inside ie\tudublin, this will run our Heartbeat.java file where we handle rendering each persons visual.

To switch between each persons visuals select 1-6 keys or 0 to enter the menu. Press R to restart the song and Spacebar to pause the song.

- Noels Visuals: There are 3 visuals being rendered. To view anyone by itself simply comment out the unwanted ones inside the *renderScene()* method. 
```Java
public void renderScene() {
        resetCamera();
        HB.noLights();
        // nb.render(); example to remove nebula effect.
        sf.render();
        tn.render();
    }
```
It is possible to interact with the stars in the background (starField) by hovering the cursor over them, creating an effect where the stars group around the cursor. If you have a powerful device you can increase the number of nebula by changing nebulaCount. 

- Patricks Visuals: When you find my visual by going through the switch modes, my visual begins with a blank black screen. But when you use the arrow keys, magic happens.

You will see 4 shapes:

Up arrow: Circles
Down arrow: Cubes
Left arrow: Squares
Right arrow: Triangles


You’ll see a visual where the shape colours appear differently & rotate in an aesthetic manner.

If you move your mouse to the very right, the colours will disappear & the shape will appear white. Nice little effect.


- Larinas Visuals: 

- Michaels Visuals:
  
There are Two visuals to which you can select to render with either setting the state variable using the function setState() inside MichaelsVisual.java file or you can call either renderVisualOne() or renderVisualTwo().

You can also increase the amount of particles in the second visual by changing a value inside the parameter, when initializing the ParticleSystem class, the value you set squared will be the amount of particle, generally over 400 will require a desktop and would be difficult to run on a standard laptop.

# How it works
Before we began to code our project we agreed on a format to follow, which would keep our programs consistent, easy to understand and simple to diagnose. 

Each team member has their own folder, labelled with their student number. Inside these folders contain each persons visuals and a 'main' file, nameVisual.java, which would handle calling/combining visuals. This format prevented any individual bugs from affecting other peoples code and follows good OOP principles.
##### Heartbeat.java
Heartbeat.java is our main sketch, any global elements in our program such as screen sizing, color mode, frame size, and audio playing (pausing, restarting) is initialised here. 

Heartbeat.java inherits all the functionality and properties defined in Visual.java which is an abstract class that itself extends PApplet from the Processing libary. Visual.java acts as a framework for creating audio visualisations using the Minim library, providing many methods to handle audio input/output, calculating frequency bands.. etc.

We import and create objects of our classes, initialising instances of them inside our *setup()* method. In our *draw()* method we use a switch statement to display different visuals, providing a menu screen too with instructions.
##### NoelsVisual.java
My scene comprises of 3 files, each handling different visualisations of our song. 

*terrainNoel.java file creates an array to store values, which use the noise function and the amplitude of the song combined to give a pseudorandom assignment to each grid location (h&w/scale), creating a 'smooth' terrain which will react with the amplitude of the song. The color is a determined by the height at each grid position, higher corresponds to a brighter cube. The terrain is drawn in 2D space, iterating through each array value, drawing a cube with its value; translate and rotate are used to give it a "3D" affect. 

*starField()* populates an <arrayList> of PVectors, each representing a particle. The speed of these particles is determined by the amplitude, speeding up as it increases and slowing with it too. Mouse interaction is applied by using the distance from the mouse position and mapping a speed/direction to any particle inside that distance, creating an almost blackhole affect. 

*nebulaBackground.java* follows a very similar format to *starField.java* but instead creates an <arrayList> of nebulas, a class inside our file. A nebula is a point given a "random" radius and spawning point, moving around the screen. By loading the sketchs pixel array, we can map to it a color, determined by the distance of each nebula so that when they are in proximity to each other they appear as though they are merging together. I used the code for mouse interaction previously to apply that same effect to the particles, creating an instance of starField.java inside nebulaBackground.java, and then interating through the arrayList, for each nebula. This invovled a lot of processing power so its advised to reduce the number of nebula if you encounter any performance issues. 
Really rough draft, will be more technical when i am home from work 🙌
Talk about main class and then how terrain + particles/nebula were implemented.
##### PatricksVisual.java

##### LarinasVisual.java

##### MichaelsVisual.java
Inside the first visual I created a Box class which stores the position and dimensions of each cube inside a PVector and created a 2 Dimensional Array that stores a face of the cube in a BoxPlane Class, and so inside my MichaelsVisuals class I create six instances of the BoxPlane Class for each side of the cube, with the inside of the cube being hollow, using the AudioBuffer object I set the dimensions of the cubes to respond to it, increasing either the width or height depending on which side faces outwards of the bigger cube.

Inside the second visual I have a sphere which changes size depending on the amplitude, and similarly to how I impletented the big cube comprised of little cubes in the first visual I create six walls of points which renders a line when cycling through each point of adjacent points creating a mesh which i add a little extra to the direction that faces outwards of the sphere which lies in the center of those six walls, the mesh changes depending on the audio buffer similarly to the first visual, and I have a ParticleSystem class which stores an array of PVectors which act as the positions of particles, when initializing the class I set the values inside the PVectors randomly from -1500 to 1500 in the x, y and z coordinates, and with each draw call each particles position slowly gets closer to the sphere, creating an effect as if the sphere is sucking in everything around it, when the particle reaches the sphere i set its position randomly again and the process repeats.

# What I am most proud of in the assignment
- Noel McCarthy:

I am really happy with how the terrain is generated and looks. I wanted to create a visual similar to images of "synthwaves" but with my own spin on it, using cubes to create the terrain. I really like the "flying" affect and the user can imagine many different scenes, as the color may be changed easily using the hue variable. This means the user can imaine they are navigating through a highrise city, over a wavey ocean, desert dunes or hilly fields. 
I took a lot of inspiration in my visuals from TheCodingTrain, most significant of which is the nebulaBackground. This uses the concept of icosurfaces, which merges together points in proximity to each other. Had i more time i would've liked to change the colors so they represented nebula clouds, making them a more passive background feature, however I am still incredibly happy with how they turned out especially with how they interact with the particles. 


- Patrick Akinsowon: 
Really happy with how the assignment turned out. Followed the concept of throwing things at the wall and picking was sticks. Turns out that it can be the best approach method sometimes. I liked all the shapes in my visual but I think the square one could've looked a bit better. Maybe I could've tried another shape thinking about it now. 

It's unfortunate, but I had the background and the colours of the shapes change automatically. But I guess as I was working on it, it seemed that it was gone. I tried to get it to work again, but never got it back. But still happy with the end result.

With more time, I would've tried to add more than one shape going at the same time. For example, I'd have 2 trangle visuals going at the same time in inverse. One on the left, one on the right. Maybe I'd have them going in contrasting colours. But as it is, I'm happy with the work I've done.

The graph was pretty simple and I wish I could've improved it more. The original idea was to have cubes going across the screen. I tried this using a 2D array but didn't get it to work, so I had to deal with what I had.



- Larina Yu:
- Michael Ferents: 
I am most proud of the commitment I made to learning how the java proccessing library works and try to place myself out of my comfort zone and explore a myriad of artistic styles, implementing various features using what the library provides, I am also proud of the collaboration and commitment that the entire team displayed each week, working towards completing the project and helping each other in figuring out how to approach certain aspects of our visuals.

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

