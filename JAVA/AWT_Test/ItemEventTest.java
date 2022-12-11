import java.awt.*;
import java.awt.event.*;

class MyLLListener implements ItemListener {        //리스너 구현
	public void itemStateChanged(ItemEvent ev) {    //getItem : 컨트롤 네임 출력 
		String item = (String)ev.getItem();
		System.out.print(item+"\t");
		if(ev.getStateChange()==ItemEvent.SELECTED)
			System.out.println("SELECTED");
		else
			System.out.println("DESELECTED");
		}
}
public class ItemEventTest extends Frame {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
     ItemEventTest f = new ItemEventTest();
     MyLLListener ml = new MyLLListener();
     Checkbox cb1, cb2, cb3, cb4;
     f.setLayout(new FlowLayout());
     f.setSize(300,80);
     cb1 = new Checkbox("Whiskey");
     cb1.addItemListener(ml);
     cb2 = new Checkbox("Beer");
     cb2.addItemListener(ml);
     f.add(cb1);
     f.add(cb2);
     
     CheckboxGroup group = new CheckboxGroup(); // group으로 묶여진 cb3,4는 라디오 버튼들로 묶이며
     cb3 = new Checkbox("Yes",false,group);        //한번에 하나만 선택할 수 있다.
     cb3.addItemListener(ml);
     cb4 = new Checkbox("No",true,group);
     cb4.addItemListener(ml);
     f.add(cb3);
     f.add(cb4);
     f.setVisible(true);
	}
}
