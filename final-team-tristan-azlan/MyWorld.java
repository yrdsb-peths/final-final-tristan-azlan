import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                int x = Greenfoot.getRandomNumber(12);
                
                if(x==1)
                {
                    TNT_Block block1 = new TNT_Block();
                    addObject(block1, 55 + j * 70, 50 + i * 70);
                }
                else if(x==2)
                {
                    Extra_Ball_Block block2 = new Extra_Ball_Block();
                    addObject(block2, 55 + j * 70, 50 + i * 70);
                }
                else
                {
                    Block block3 = new Block();
                    addObject(block3, 55 + j * 70, 50 + i * 70);
                }
            }
        }
    }
}
