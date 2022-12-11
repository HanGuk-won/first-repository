import java.awt.*;
import java.awt.event.*;

class ButtonLabels {
	static String OK = "OK";
	static String CANCEL = "Cancel";
}

class MMyListener implements ActionListener {
	public void actionPerformed(ActionEvent ev) {
		if(ButtonLabels.OK.equals(ev.getActionCommand())) {
			System.out.println("OK버튼이 눌렸습니다.");
		}else if(ButtonLabels.CANCEL.equals(ev.getActionCommand())) {
		    System.out.println("Cancel버튼이 눌렸습니다.");
		}
	}
}
public class ButtonTest extends Frame {
	private static final long serialVersionUID = 1L;
	public ButtonTest(String title) {
		super(title);
		this.setLayout(new FlowLayout());
        this.setSize(400,100);
}

public static void main(String[] args) {
	ButtonTest bt = new ButtonTest("ActionEvent");
	Button b_ok = new Button(ButtonLabels.OK);
	Button b_cancel = new Button(ButtonLabels.CANCEL);
	MMyListener ml = new MMyListener();
	b_ok.addActionListener(ml);
	b_cancel.addActionListener(ml);
	
	bt.add(b_ok);
	bt.add(b_cancel);
	bt.setVisible(true);
	}
}
