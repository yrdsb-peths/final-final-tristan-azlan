import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    // This method helps move the paddle to allow to keep the ball up
    public void act()
    {
        // Add your action code here.
        // if key down is left, move 8 to the left 
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 8, getY());
        }
        // if key down is right, move 8 to the right
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 8, getY());
        }
    }
}
