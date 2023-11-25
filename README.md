# Video Game Engine
Author: Robert Pendergrast

## Project Description
This Video Game Engine provides the foundation for a visually appealing gaming experience that utilizes Java programming and graphics in the Swing interface. This engine features completely customizable 
terrain generation, which is made to be realistically generated through a Perlin Noise algorithm. It is also capable of collision detection, making the terrain easy to navigate. 

Also I drew all the art so if you want to hire me for art stuff instead of coding im all ears :)

## Programing
This generation is built in Java with the Swing GUI. This was chosen as opposed to a more robust framework like JavaFx because I wanted to build this from scratch, and not rely on anyone's previous programming.
It's far more challenging and thus far more rewarding.

<img width="554" alt="Screenshot 2023-11-25 at 4 44 36 PM" src="https://github.com/RobertPendergrast/VideoGame/assets/121700465/695d57b2-0ea9-47b9-ae2a-eee356e7ae42">

## Terrain Generation
The terrain is randomly generated using a Perlin Noise algorithm. This is to ensure that it forms naturally, and is navigatable. The parameters of this algorithm can be changed at the user's will.
<img width="1478" alt="Screenshot 2023-11-24 at 1 08 58 AM" src="https://github.com/RobertPendergrast/VideoGame/assets/121700465/4273dd91-d9d7-45c3-b87f-62dcde0842ac">
The tile based nature of the terrain also allows for the creation of new tiles with different properies, adding variety to the landscape. 

## Variability
To showcase the various terrain generations, here are some images:
Steep Terrain:
<img width="1659" alt="Screenshot 2023-11-25 at 4 48 02 PM" src="https://github.com/RobertPendergrast/VideoGame/assets/121700465/f5ee34fa-9eca-4730-a207-a88a841f943d">

Flat Terrain:
<img width="1483" alt="Screenshot 2023-11-25 at 4 04 50 PM" src="https://github.com/RobertPendergrast/VideoGame/assets/121700465/330e1ba4-6895-41f4-af99-645b46e6d22e">

### Customization
This terrain generation is customizable as well. A simple adjustment in the perlin noise parameters yeild new terrain. This could be done to create different biomes.

## Future Plans
I have several planned features that I will be working on to advance the capabilities of this engine, including but not limited to:
  1. Improved collision detection with hitboxes
  2. An entity class that generates autonomously controlled creatures and ememies. Entities will be customizable. 
  3. Health bars for entities
  4. Biomes


