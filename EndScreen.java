import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen(int score)
    {
        super(600, 400, 1);
        showText("Game Over", 300, 150);
        showText("Final Score: " + score, 300, 200);
        showText("Press Space to Play Again", 300, 250); 
    }
    //test 
}
