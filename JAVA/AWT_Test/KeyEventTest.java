import java.awt.*;
import java.awt.event.*;

class MyKeyListener extends KeyAdapter {
	public void keyPressed(KeyEvent ev) {
		int keyCode = ev.getKeyCode();
		System.out.println(KeyEvent.getKeyText(keyCode));
	}
}
public class KeyEventTest {
	public static void main(String[] args) {
     Frame f = new Frame("KeyEvent");
     KeyListener kl = new MyKeyListener();
     f.addKeyListener(kl);
     f.setSize(200,100);
     f.setVisible(true);
	}
}
