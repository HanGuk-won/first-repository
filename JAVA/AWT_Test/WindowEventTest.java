import java.awt.*;
import java.awt.event.*;

class MyListener implements WindowListener {
	public void windowClosing(WindowEvent ev) {
		System.exit(0);
	}
    public void windowClosed(WindowEvent ev) {}
    public void windowDeactivated(WindowEvent ev) {}
    public void windowDeiconified(WindowEvent ev) {}
    public void windowIconified(WindowEvent ev) {}
    public void windowOpened(WindowEvent ev) {}
	public void windowActivated(WindowEvent e) {}		
 }

class MyFrame extends Frame {
	private static final long serialVersionUID = 1L;
	public MyFrame(String title) {
		super(title);
		this.setSize(400,300);
		this.setVisible(true);
		this.addWindowListener(new MyListener());
	}
	public void paint(Graphics g) {
		g.drawString("Hello AWT",150,150);		
	}
}
public class WindowEventTest {
	private static MyFrame myFrame;

	public static void main(String[] args) {
     setMyFrame(new MyFrame("Hello AWT"));		
	}

	public static MyFrame getMyFrame() {
		return myFrame;
	}

	public static void setMyFrame(MyFrame myFrame) {
		WindowEventTest.myFrame = myFrame;
	}
}
