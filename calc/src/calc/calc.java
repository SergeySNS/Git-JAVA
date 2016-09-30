package calc;

import javax.swing.JFrame;

public class calc {
	public static void main(String Arg[]){
		Reader r = new Reader("Калькулятор");
		r.setVisible(true);
		r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		r.setSize(200, 200);
		r.setResizable(false);
		r.setLocationRelativeTo(null);
	}
}
