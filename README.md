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

- Noels Visuals: There are 3 visuals being rendered. To view anyone by itself simply comment out the unwanted ones:
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

- Patricks Visuals:

- Larinas Visuals: 

- Michaels Visuals: 

# How it works
Before we began to code our project we agreed on a format to follow, which would keep our programs consistent, easy to understand and simple to diagnose. 

Each team member has their own folder, labelled with their student number. Inside these folders contain each persons visuals and a 'main' file, nameVisual.java, which would handle calling/combining visuals. This format prevented any individual bugs from affecting other peoples code and follows good OOP principles.
##### Heartbeat.java
Heartbeat.java is our main sketch, any global elements in our program such as screen sizing, color mode, frame size, and audio playing (pausing, restarting) is initialised here. 

Heartbeat.java inherits all the functionality and properties defined in Visual.java which is an abstract class that itself extends PApplet from the Processing libary. Visual.java acts as a framework for creating audio visualisations using the Minim library, providing many methods to handle audio input/output, calculating frequency bands.. etc.

We import and create objects of our classes, initialising instances of them inside our *setup()* method. In our *draw()* method we use a switch statement to display different visuals, providing a menu screen too with instructions.
##### NoelsVisual.java
Talk about main class and then how terrain + particles/nebula were implemented.
##### PatricksVisual.java

##### LarinasVisual.java

##### MichaelsVisual.java

# What I am most proud of in the assignment

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

