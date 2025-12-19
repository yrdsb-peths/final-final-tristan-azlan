import greenfoot.*;

public class MyWorld extends World {
    private Paddle paddle;
    private Ball ball;
    public MyWorld() {
        super(600, 400, 1);
        // add paddle
        paddle = new Paddle();
        addObject(paddle, 300, 350);
        
        // add ball
        ball = new Ball();
        addObject(ball, 300, 335);
        

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
    // make game reset when ball touches ground
    
}
