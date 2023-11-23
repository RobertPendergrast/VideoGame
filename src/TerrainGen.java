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

    public TerrainGen(int width, int height){
        terrainWidth = width;
        terrainHeight = height;
        spawnX = terrainWidth/2;

        BlockMap = new Block[terrainWidth][terrainHeight];

        generateTerrain();
    }
    //generate terrain adds randomly selected terrain points into the terrain array
    public void generateTerrain(){

    }

    //renderterrain iterates through the terrain and renders everything
    public void renderTerrain(){

    }
    public int getWidth(){
        return terrainWidth;
    }
    public int getHeight(){
        return terrainHeight;
    }
}
