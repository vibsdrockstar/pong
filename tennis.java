import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Tennis extends Applet implements Runnable, KeyListener{ 
	final int WIDTH=700, HEIGHT=500;
	Thread thread;
	HumanPaddle p; 
	Ball b;
public void init(){
	this.resize(WIDTH,HEIGHT);
	this.addKeyListener(this);
	p=new HumanPaddle(1);
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
	p.draw(g);
	b.draw(g);
	
}
public void update(Graphics g){
	paint(g);
}
public void run() {
for(;;)	{
	p.move();
	b.move();
	
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
