package ua.sns.fan;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SpyWindow extends JFrame {
	private JTable table;
	private JButton btnReset;
	private JScrollPane scrollPane;
	private SellerTableModel model;
	private Object seller;
	private JButton btnRefresh;
	private JLabel lblLabel2;
	private JLabel lblLabel;
	private String ss1;
	private String ss2;
	private JTextArea textArea;
	private JTextField tDelay;
	private JButton btnSetdelay;
	private JScrollPane scrollPane_1;
	private String text;



	public SpyWindow(String s){
		super(s);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 665, 428);
		getContentPane().add(scrollPane);
		
		model = new SellerTableModel();
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReset.setBounds(685, 11, 89, 23);
		getContentPane().add(btnReset);
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IfHtml();
			}
		});
		btnRefresh.setBounds(685, 45, 89, 23);
		getContentPane().add(btnRefresh);
		
		lblLabel = new JLabel("Last Update:");
		lblLabel.setBounds(685, 456, 78, 14);
		getContentPane().add(lblLabel);
		
		lblLabel2 = new JLabel("");
		lblLabel2.setBounds(685, 481, 78, 14);
		getContentPane().add(lblLabel2);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				spyfan.work = true;
				textArea.append("Start..." + "\n");
			}
		});
		btnStart.setBounds(685, 120, 89, 23);
		getContentPane().add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spyfan.work = false;
				textArea.append("Stop." + "\n");
			}
		});
		btnStop.setBounds(685, 150, 89, 23);
		getContentPane().add(btnStop);
		
		JLabel lblTimeDelay = new JLabel("Time delay:msec");
		lblTimeDelay.setBounds(685, 184, 89, 14);
		getContentPane().add(lblTimeDelay);
		
		JLabel lblDelayn = new JLabel("Delay:");
		lblDelayn.setBounds(695, 272, 46, 14);
		getContentPane().add(lblDelayn);
		
		JLabel lblDelay = new JLabel(Integer.toString(spyfan.delay/1000)+" sec");
		lblDelay.setBounds(695, 284, 56, 14);
		getContentPane().add(lblDelay);

		tDelay = new JTextField();
		tDelay.setBounds(685, 207, 89, 20);
		getContentPane().add(tDelay);
		tDelay.setColumns(10);
		
		btnSetdelay = new JButton("SetDelay");
		btnSetdelay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spyfan.delay = Integer.parseInt(tDelay.getText());
				lblDelay.setText(Integer.toString(spyfan.delay/1000)+" sec");
			}
		});
		btnSetdelay.setBounds(685, 238, 89, 23);
		getContentPane().add(btnSetdelay);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 450, 665, 101);
		getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);

		

	}

	
	
	
	
	
	
	public void IfHtml() {
        // ("E yyyy.MM.dd 'и врем€' hh:mm:ss a zzz")
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH:mm:ss");
 
	        try {
	            URL url = new URL("https://funpay.ru/chips/43/");
//	        	sitename = "http://funpay.ru/chips/43/";
//	        	System.out.println(sitename.length());
//	        	URL url = new URL(sitename);
	            try {
	                LineNumberReader reader = new LineNumberReader(new InputStreamReader(url.openStream(),"UTF-8"));
	                String string = reader.readLine();
	                // очищаю таблицу, что-б не накапливалась
	                if (!spyfan.sellersnew.isEmpty()) {
	                	spyfan.sellersnew.clear();
	                }
	                while (string != null) {
                		// заполн€ю Seller

                    	if (string.contains("<td>")) {
                    		Seller sellernew = new Seller();
                    		sellernew.setServer(string.substring(string.indexOf("<td>")+4, string.indexOf("</td>")));
                    		string = reader.readLine();
                    		sellernew.setSide(string.substring(string.indexOf("<td>")+4, string.indexOf("</td>")));
                    		string = reader.readLine();
                    		sellernew.setName(string.substring(string.indexOf("<div>")+5, string.indexOf("<span")));
                    		string = reader.readLine();
                    		sellernew.setSum(string.substring(0, string.indexOf("</td>")));
                    		string = reader.readLine();
                    		string = reader.readLine();
                    		sellernew.setPrice(string.substring(string.indexOf("<div>")+5, string.indexOf("</div")-1));
                    		sellernew.setSell("0");
                    		spyfan.sellersnew.add(sellernew);
                    		
//	                   		spyfan.sellers = spyfan.sellersnew;
//	                   		System.out.println("ѕолучилось: " + seller.getServer() + " "+seller.getSide()+ " "+seller.getName()+ " "+seller.getSum()+ " "+seller.getPrice());
                    	}
	                    string = reader.readLine();
	                }
	                if (!spyfan.sellers.isEmpty()) {
		                //  —читаем проданное
	        			System.out.println("11111" + formatForDateNow.format(new Date()));
	            		int a,b,c = 0;
	            		for (int i = 0; i < spyfan.sellersnew.size(); i++) {
	            			ss1 = spyfan.sellersnew.get(i).getServer() + spyfan.sellersnew.get(i).getSide() + spyfan.sellersnew.get(i).getName();
							for (int j = 0; j < spyfan.sellers.size(); j++) {
		            			ss2 = spyfan.sellers.get(j).getServer() + spyfan.sellers.get(j).getSide() + spyfan.sellers.get(j).getName();
								if (ss1.equals(ss2)) {
									a = Integer.parseInt(spyfan.sellers.get(j).getSell().replace(" ", ""));
									b = Integer.parseInt(spyfan.sellers.get(j).getSum().replace(" ", ""));
									c = Integer.parseInt(spyfan.sellersnew.get(i).getSum().replace(" ", ""));
									if (c < b) {
										spyfan.sellersnew.get(i).setSell(Integer.toString( a + b - c ));
										System.out.println("New trade: " + spyfan.sellersnew.get(i).getName() + " in " + formatForDateNow.format(new Date()));
										textArea.setAutoscrolls(true);
										text = "New: " + spyfan.sellersnew.get(i).getName() + " " + spyfan.sellersnew.get(i).getServer() + " " + spyfan.sellersnew.get(i).getSide() + " Sum: " + Integer.toString( b - c ) + "Price: " + spyfan.sellersnew.get(i).getPrice() + " in " + formatForDateNow.format(new Date()) + "\n";
										textArea.append(text);
										FileWriter writer = new FileWriter("Sells.txt", true);
//										writer.write("\n" + text);
										writer.close();
										java.awt.Toolkit tk = Toolkit.getDefaultToolkit();
										tk.beep();
									}
									else {
										spyfan.sellersnew.get(i).setSell(spyfan.sellers.get(j).getSell());
									}
								}
							}
	            		}
					}
	                // очищаю таблицу, что-б не накапливалась
	                if (!spyfan.sellers.isEmpty()) {
	                	spyfan.sellers.clear();
	                }
        			for (int i = 0; i < spyfan.sellersnew.size(); i++) {
    	                Seller seller = new Seller();
    	                seller.setServer(spyfan.sellersnew.get(i).getServer());
    	                seller.setSide(spyfan.sellersnew.get(i).getSide());
    	                seller.setName(spyfan.sellersnew.get(i).getName());
    	                seller.setSum(spyfan.sellersnew.get(i).getSum());
    	                seller.setPrice(spyfan.sellersnew.get(i).getPrice());
    	                seller.setSell(spyfan.sellersnew.get(i).getSell());
    	                spyfan.sellers.add(seller);
        			}
	                reader.close();
	                table.updateUI();
					lblLabel2.setText(formatForDateNow.format(new Date()));
	            } catch (IOException e) {
					System.out.println("Ќе смог заполнить таблицу");
					textArea.append("Ќе смог заполнить таблицу" + "\n");
					try {
						Thread.currentThread();
						Thread.sleep(2000) ;
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
//	                e.printStackTrace();
					return;
	            }

	        } catch (MalformedURLException ex) {
				System.out.println("Ќе смог прочитать сайт");
				textArea.append("Ќе смог прочитать сайт" + "\n");
				try {
					Thread.currentThread();
					Thread.sleep(10000) ;
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
//	            ex.printStackTrace();
				return;
	        }
    		
	    }
	}
