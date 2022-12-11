import java.awt.*;
import java.awt.event.*;

class MMyyListener extends WindowAdapter {
	public void windowClosing(WindowEvent ev) {
		System.exit(0);
	}
}

class MMyyFrame extends Frame {
	private static final long serialVersionUID = 1L;
	public MMyyFrame(String title) {
		super(title);
		this.setSize(400,300);
		this.setVisible(true);
		this.addWindowListener(new MMyyListener());
	}
    public void paint(Graphics g) {
    	g.drawString("Hello AWT",150,150);
    }
}

public class WindowEventTest2 {
	private static MMyyFrame myFrame;

	public static void main(String[] args) {
     setMyFrame(new MMyyFrame("Hello AWT"));
	}

	public static MMyyFrame getMyFrame() {
		return myFrame;
	}

	public static void setMyFrame(MMyyFrame myFrame) {
		WindowEventTest2.myFrame = myFrame;
	}
}
