import greenfoot.*;  
import java.util.List;

    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

import greenfoot.*;
import java.util.List;

public class Explosion extends Actor 
{
    private GreenfootImage[] frames;
    private int frameIndex = 0;
    private int timer = 0;
    private int blocksDestroyedByThis = 0; // Local counter

    public Explosion(int w, int h) {
        frames = new GreenfootImage[12]; 
        for (int i = 0; i < frames.length; i++) {
            GreenfootImage img = new GreenfootImage("tile" + i + ".png");
            img.scale(200, 200); 
            frames[i] = img;
        }
        setImage(frames[0]);
    }

    public void act() {
        checkCollision(); // Check for nearby blocks
        animate();
    }

    private void checkCollision() {
        // Get a list of all Blocks touching the current explosion frame
        List<Block> touchingBlocks = getIntersectingObjects(Block.class);
        
        for (Block b : touchingBlocks) {
            blocksDestroyedByThis++;
            getWorld().removeObject(b);
        }
    }

    private void animate() {
        timer++;
        if (timer % 4 == 0) {
            if (frameIndex < frames.length) {
                setImage(frames[frameIndex]);
                frameIndex++;
            } else {
                // Before disappearing, tell the Ball how many blocks we broke
                updateTotalScore();
                getWorld().removeObject(this);
            }
        }
    }

    private void updateTotalScore() {
        // Find the Ball in the world to update its variables
        List<Ball> balls = getWorld().getObjects(Ball.class);
        if (!balls.isEmpty()) {
            Ball ball = balls.get(0);
            ball.addExplosionScore(blocksDestroyedByThis);
        }
    }
}

