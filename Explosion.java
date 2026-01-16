import greenfoot.*;  
import java.util.List;

    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

import greenfoot.*;
import java.util.List;

// This class is created for the purpose of the explosion animation and
// function after a TNT block is broken
public class Explosion extends Actor 
{
    // these variables are used to keep track of the frames and the time of 
    // the animation used
    private GreenfootImage[] frames;
    private int frameIndex = 0;
    private int timer = 0;
    private int blocksDestroyedByThis = 0; 
    
    // This method creates the actual explosion animation
    public Explosion(int w, int h) {
        frames = new GreenfootImage[12]; 
        for (int i = 0; i < frames.length; i++) {
            GreenfootImage img = new GreenfootImage("tile" + i + ".png");
            img.scale(200, 200); 
            frames[i] = img;
        }
        setImage(frames[0]);
    }
    
    // this method helps keep track of the nearby blocks before initializing
    // the explosion sequence
    public void act() {
        checkCollision();
        animate();
    }

    // this method keeps track of all the blocks that would be touched by the
    // explosion sprite and destroys any of which caught in range
    private void checkCollision() {
        List<Block> touchingBlocks = getIntersectingObjects(Block.class);
        
        for (Block b : touchingBlocks) {
            blocksDestroyedByThis++;
            getWorld().removeObject(b);
        }
    }

    // this method keeps track of the animation and score based on the timer
    private void animate() {
        timer++;
        if (timer % 4 == 0) {
            if (frameIndex < frames.length) {
                setImage(frames[frameIndex]);
                frameIndex++;
            } else {
                updateTotalScore();
                getWorld().removeObject(this);
            }
        }
    }

    // this method updates the score based on the blocks broken by the
    // explosion as it works differntly from the ball yet needs to be added
    // into the total amount
    private void updateTotalScore() {
        // Find the Ball in the world to update its variables
        List<Ball> balls = getWorld().getObjects(Ball.class);
        if (!balls.isEmpty()) {
            Ball ball = balls.get(0);
            ball.addExplosionScore(blocksDestroyedByThis);
        }
    }
}

