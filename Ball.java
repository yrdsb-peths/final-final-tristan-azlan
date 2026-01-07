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
    // speed
    private int x = 3;
    private int y = -3;
    public void act()
    {
        // Add your action code here.
        moveBall();
        bounceWalls();
        bouncePaddle();
        breakBlock();
    }
    
    private void moveBall()
    {
        setLocation(getX() + x, getY() + y); 
    }
    // make ball bounce off walls
    private void bounceWalls()
    {
        // reverse left/right movement
        if (getX() <= 0 || getX() >= getWorld().getWidth() - 1)
        x = -x;  
        // reverse vertical movement
        if (getY() <= 0)
        y = -y;  
    }
    // make ball bounce off paddle
    private void bouncePaddle()
    {
        if (isTouching(Paddle.class))
        {
            y = -Math.abs(y);
            setLocation(getX(), getY() - 0); // move ball slightly up
        }
    }
    private void breakBrick()
    {
        if (isTouching(Block.class))
        {
            ;
        }
    }
    
<<<<<<< HEAD
=======
    private void breakBlock()
    {       
        Block brokenBlock1 = (Block) getOneIntersectingObject(Block.class);
        Actor block1 = getOneIntersectingObject(Block.class);
        if(block1 != null)
        {
            int brokenBlock1X = brokenBlock1.getX();
            int brokenBlock1Y = brokenBlock1.getY();
            getWorld().removeObject(block1);
            
            if(getY()<brokenBlock1Y)
            {
                y = -y;
            }
            
            if(getY()>brokenBlock1Y)
            {
                y = -y;
            }
            
            if(getX()<brokenBlock1X)
            {
                x = -x;
            }
            
            if(getX()>brokenBlock1X)
            {
                x = -x;
            }
        }
        
        Extra_Ball_Block brokenBlock2 = (Extra_Ball_Block) getOneIntersectingObject(Extra_Ball_Block.class);
        Actor block2 = getOneIntersectingObject(Extra_Ball_Block.class);
        if(block2 != null)
        {
            int brokenBlock2X = brokenBlock2.getX();
            int brokenBlock2Y = brokenBlock2.getY();
            getWorld().removeObject(block2);
            
            Ball extraBall = new Ball();
            getWorld().addObject((extraBall), brokenBlock2X, brokenBlock2Y);
            
            if(getY()<brokenBlock2Y)
            {
                y = -y;
            }
            
            if(getY()>brokenBlock2Y)
            {
                y = -y;
            }
            
            if(getX()<brokenBlock2X)
            {
                x = -x;
            }
            
            if(getX()>brokenBlock2X)
            {
                x = -x;
            }
        }
        
        TNT_Block brokenBlock3 = (TNT_Block) getOneIntersectingObject(TNT_Block.class);
        Actor block3 = getOneIntersectingObject(TNT_Block.class);
        if(block3 != null)
        {
            int brokenBlock3X = brokenBlock3.getX();
            int brokenBlock3Y = brokenBlock3.getY();
            getWorld().removeObject(block3);
            
            if(getY()<brokenBlock3Y)
            {
                y = -y;
            }
            
            if(getY()>brokenBlock3Y)
            {
                y = -y;
            }
            
            if(getX()<brokenBlock3X)
            {
                x = -x;
            }
            
            if(getX()>brokenBlock3X)
            {
                x = -x;
            }
        }
    }
>>>>>>> b8d705993ed375c7e80c00071abaf9abdfe3874b
}
