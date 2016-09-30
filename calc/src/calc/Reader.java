package calc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reader extends JFrame{
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, b11, b12, b13, b14;
	JTextField t1;
	String Text1 = "";
	Integer i = 0;
	eHandler Handler = new eHandler();
	public Reader(String s){
		super(s);
		setLayout(new FlowLayout());
		t1 = new JTextField(16);
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		b0 = new JButton("0");
		b11 = new JButton("+");
		b12 = new JButton("-");
		b13 = new JButton("*");
		b14 = new JButton("/");
		add(t1);
		add(b1);
		add(b2);
		add(b3);
		add(b11);
		add(b4);
		add(b5);
		add(b6);
		add(b12);
		add(b7);
		add(b8);
		add(b9);
		add(b13);
		add(b0);
		add(b14);
		b1.addActionListener(Handler);
	}

	public class eHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				if (e.getSource() == b1){
					Text1 = Text1 + "1";
					t1.setText(Text1);
					i = Integer.parseInt(t1.getText());
					
				}
			}catch (Exception ex){ JOptionPane.showMessageDialog(null, "Сообщение об ошибке"); }
		}
		
	}
}
