import java.awt.Color;
import java.awt.Graphics;


public class Ball {
double xVel,yVel,x,y;
public Ball(){
	x=300;
	y=200;
	xVel=4;
	yVel=1;
	
}

public void draw(Graphics g){
	g.setColor(Color.white);
	g.fillOval((int)x-10,(int) y-10, 20, 20);
}
public void move(){
	x+=xVel;
	y+=yVel;
	if(y<10)
	yVel=-yVel;
	if(y>490)
		yVel=-yVel;
	
}

public int getX(){
	return (int)x;
}
public int getY(){
	return (int)y;
	
}
}
