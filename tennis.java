import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Tennis extends Applet implements Runnable, KeyListener{ 
	final int WIDTH=700, HEIGHT=500;
	Thread thread;
	HumanPaddle p; 
	AIPaddle p2;
	Ball b;
	Graphics gfx;
	Image img;
	boolean gameStarted;
	
public void init(){
	this.resize(WIDTH,HEIGHT);
	gameStarted=false;
	this.addKeyListener(this);
	p=new HumanPaddle(1);
	p2=new AIPaddle(2,b);
	img=createImage(WIDTH,HEIGHT);
	gfx=img.getGraphics();
	b=new Ball();
	thread=new Thread(this);
	thread.start();
}
public void paint(Graphics g){
	g.setColor(Color.black);
	g.fillRect(0, 0, WIDTH, HEIGHT);
	if(b.getX()<-10 || b.getX()> 710){
		g.setColor(Color.red);
		g.drawString("Game Over", 300, 200);
		
	}
	else {	
	p.draw(gfx);
	b.draw(gfx);
	p2.draw(gfx);
	}
	if(!gameStarted){
		gfx.setColor(Color.green);
		gfx.drawString("Lawn Tennis", 340, 100);
		gfx.drawString("Press Enter to Begin", 320, 130);
	}
	g.drawImage(img, 0, 0, this);
}
public void update(Graphics g){
	paint(g);
}
public void run() {
for(;;)	{
	if(gameStarted){
	p.move();
	b.move();
	p2.move();
	b.checkPaddleCollision(p, p2);
	}
	repaint();
	try {
		Thread.sleep(10);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
	
} 

public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_UP){
	p.setupAccel(true);	
	}
	else if(e.getKeyCode()== KeyEvent.VK_DOWN){
	p.setdownAccel(true);	
	} else if(e.getKeyCode()==KeyEvent.VK_ENTER){
		gameStarted=true;
	}
}

public void keyReleased(KeyEvent e) {
if(e.getKeyCode() == KeyEvent.VK_UP){
	p.setupAccel(false);	
	}
	else if(e.getKeyCode()== KeyEvent.VK_DOWN){
		p.setdownAccel(false);
	}
}
	


public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
