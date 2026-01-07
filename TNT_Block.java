import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TNT_Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TNT_Block extends Actor
{
    /**
     * Act - do whatever the TNT_Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        GreenfootImage image = getImage();
        
        int newWidth = 80;
        int newHeight = 80;
        
        image.scale(newWidth, newHeight);
        
        setImage(image);
    }
}
