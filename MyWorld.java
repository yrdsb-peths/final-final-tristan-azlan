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
    }
}
