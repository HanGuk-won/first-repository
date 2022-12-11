import java.awt.*;
import java.awt.event.*;

class MyLListener implements ActionListener {
	public void actionPerformed(ActionEvent ev) {
		System.out.println(ev.getActionCommand());
	}
}
public class MenuEventTest extends Frame {
	private static final long serialVersionUID = 1L;
	MenuBar mb;
	ActionListener al;
	public void setMenu() {
		Menu m,sm;
		mb = new MenuBar();
		m = new Menu("Menu1");
		m.add(new MenuItem("MenuItem1"));
		sm = new Menu("SubMenu1",true);
		sm.add(new MenuItem("SubMenuItem1"));
		sm.add(new MenuItem("SubMenuItem2"));
		m.add(sm);
		m.add(new MenuItem("MenuItem2"));
		mb.add(m);
		setMenuBar(mb);
		for(int i=0;i<mb.getMenuCount();i++) {
			m = mb.getMenu(i);
			registerListener((MenuItem)m);
	}
}
private void registerListener(MenuItem mi) {
	mi.addActionListener(al);
	if(mi instanceof Menu) {
		Menu mm = (Menu)mi;
		for(int i=0;i<mm.getItemCount();i++) {
			registerListener(mm.getItem(i));
		}
	}
}
public MenuEventTest() {
	super("Pulldown");
	al = new MyLListener();
	setSize(200,200);
	setVisible(true);
	}
public static void main(String[] args) {
	MenuEventTest f = new MenuEventTest();
	f.setMenu();
    }
}
