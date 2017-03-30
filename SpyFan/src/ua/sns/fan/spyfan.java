package ua.sns.fan;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;

public class spyfan {
	public static ArrayList<Seller> sellers = new ArrayList<Seller>();
	public static ArrayList<Seller> sellersnew = new ArrayList<Seller>();
	public static ArrayList<Seller> sellerst = new ArrayList<Seller>();
	private static SpyWindow w;
	
	public static void main(String[] args) {
		w = new SpyWindow("Spy FanPay");
		w.setVisible(true);
		w.setSize(800, 600);
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setLocationRelativeTo(null);
		w.IfHtml();
//        spyfan.sellers.get(0).setSum("221");
//        spyfan.sellersnew.get(0).setSum("223");
//		System.out.println("11111 " + spyfan.sellers.get(0).getSum());
//		System.out.println("22222 " + spyfan.sellersnew.get(0).getSum());

	}


}
