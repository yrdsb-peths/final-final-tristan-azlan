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
        // creates a world with width 600, height 400, cell 1
        super(600, 400, 1);
        // display "game over" text in middle of screen
        showText("Game Over", 300, 150);
        // display player's score
        showText("Final Score: " + score, 300, 200);
        // tell players to press space to play again
        showText("Press Space to Play Again", 300, 250); 
    }
    public void act() 
    {
        // if the player presses the space key start a new game by switching back to MyWorld
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
