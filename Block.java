import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    // this method creates the proper porportions for the image
    public void act()
    {
        GreenfootImage image = getImage();
        
        int newWidth = 80;
        int newHeight = 80;
        
        image.scale(newWidth, newHeight);
        
        setImage(image);
    }
}
