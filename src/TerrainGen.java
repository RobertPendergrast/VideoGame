import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;
public class TerrainGen extends JPanel{
    public int terrainWidth;
    public int terrainHeight;
    public int spawnX;
    public int[][] terrain;
    public Block[][] BlockMap;
    private Random random = new Random();

    private ImprovedNoise noiseGenerator = new ImprovedNoise();

    public TerrainGen(int width, int height){
        terrainWidth = width;
        terrainHeight = height;
        spawnX = terrainWidth/2;

        BlockMap = new Block[terrainWidth][terrainHeight];
        terrain = new int[terrainWidth][terrainHeight];

        generateTerrain();
        renderTerrain();
    }
    //generate terrain adds randomly selected terrain points into the terrain array
    public void generateTerrain(){
        //create a ground level
        ArrayList<Integer> groundLevel = new ArrayList<Integer>();
        for(int i = 0; i <terrainWidth; i++){
            groundLevel.add(terrainHeight/2);
            //System.out.println(groundLevel.get(i));
        }

        double amplitude = 10*Math.random()+10; //noise strength
        double frequency = random.nextDouble(0.10-0.05); //noise scale

        for(int i = 0; i< terrainWidth;i++){
            double perlinNoise = noiseGenerator.noise(i * frequency, 0, 0);
            int adjustedGroundLevel = groundLevel.get(i) + (int) (perlinNoise * amplitude);
            for (int j = 0; j < terrainHeight; j++) {
                if (j == adjustedGroundLevel) {
                    terrain[i][j] = 1; // grass
                } else if (j > adjustedGroundLevel) {
                    terrain[i][j] = 2; // dirt
                } else {
                    terrain[i][j] = 0; // air
                }
            }
        }



        /* Flat terrain
        for(int i = 0; i< terrainWidth; i++){
            for(int j = 0; j<terrainHeight; j++){
                if(j==15){
                    terrain[i][j] = 1;
                } else if(j>15){
                    terrain[i][j] = 2;
                } else{
                    terrain[i][j] = 0;
                }
            }
        }

         */
    }

    //renderterrain iterates through the terrain and renders everything
    public void renderTerrain(){

        for(int i = 0; i<terrainHeight; i++){
            for(int j = 0; j<terrainWidth; j++){
                System.out.print(terrain[j][i]);
            }
            System.out.println();
        }

        int startX = 0;
        int startY = 0;
        for(int i =0; i<terrainWidth; i++){
            startY = 0;
            for(int j = 0; j<terrainHeight; j++){
                if(terrain[i][j] == 1) {
                    BlockMap[i][j] = new Block(startX, startY, "grass", 50);
                }
                else if(terrain[i][j] == 2) {
                    BlockMap[i][j] = new Block(startX, startY, "dirt", 50);
                }
                else{
                    BlockMap[i][j] = new Block(startX, startY, "AIR", 50);
                }
                startY += 50;
            }
            startX += 50;
        }

    }
    public int getWidth(){
        return terrainWidth;
    }
    public int getHeight(){
        return terrainHeight;
    }
    public Block[][] getBlockMap(){
        return BlockMap;
    }

    public int getSpawn(){
        return spawnX;
    }
}
