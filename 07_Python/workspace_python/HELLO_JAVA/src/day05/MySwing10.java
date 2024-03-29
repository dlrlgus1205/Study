package day05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MySwing10 extends JFrame {

	private JPanel contentPane;
	private JTextField tf_na;
	private JTextField tf_com;
	private JTextField tf_res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing10 frame = new MySwing10();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MySwing10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_na = new JLabel("나 : ");
		lbl_na.setBounds(97, 35, 57, 15);
		contentPane.add(lbl_na);
		
		JLabel lbl_com = new JLabel("컴 : ");
		lbl_com.setBounds(97, 81, 57, 15);
		contentPane.add(lbl_com);
		
		JLabel lbl_res = new JLabel("결과 : ");
		lbl_res.setBounds(97, 133, 57, 15);
		contentPane.add(lbl_res);
		
		tf_na = new JTextField();
		tf_na.setBounds(209, 32, 116, 21);
		contentPane.add(tf_na);
		tf_na.setColumns(10);
		
		tf_com = new JTextField();
		tf_com.setColumns(10);
		tf_com.setBounds(209, 78, 116, 21);
		contentPane.add(tf_com);
		
		tf_res = new JTextField();
		tf_res.setColumns(10);
		tf_res.setBounds(209, 130, 116, 21);
		contentPane.add(tf_res);
		
		JButton btn = new JButton("게임하기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myclick();
			}
		});
		btn.setBounds(97, 190, 228, 23);
		contentPane.add(btn);
	}
	
	void myclick() {
		double rnd = Math.random();
		String na = tf_na.getText();
		String com = "";
		String res = "";
		
		if(rnd > 0.66) {
			com = "보";
			if (na.equals("보")) {
				res = "무승부";
			}
			else if (na.equals("가위")) {
				res = "승리";
			}
			else {
				res = "패배";
			}
		}
		
		else if(rnd > 0.33) {
			com = "가위";
			if (na.equals("보")) {
				res = "패배";
			}
			else if (na.equals("가위")) {
				res = "무승부";
			}
			else {
				res = "승리";
			}
		}
		
		else {
			com = "바위";
			if (na.equals("보")) {
				res = "승리";
			}
			else if (na.equals("가위")) {
				res = "패배";
			}
			else {
				res = "무승부";
			}
		}
		tf_com.setText(com);
		tf_res.setText(res);
	}

}
