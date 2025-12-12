import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x = 3;
    private int y = -3;
    public void act()
    {
        // Add your action code here.
        moveBall();
    }
    private void moveBall()
    {
        setLocation(getX() + x, getY() + y); 
    }
}
