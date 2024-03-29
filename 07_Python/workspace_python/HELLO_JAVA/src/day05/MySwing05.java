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

public class MySwing05 extends JFrame {

	private JPanel contentPane;
	JLabel lbl01;
	JLabel lbl02;
	JLabel lbl03;
	private JTextField tf01;
	private JTextField tf02;
	private JTextField tf03;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing05 frame = new MySwing05();
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
	public MySwing05() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl01 = new JLabel("나");
		lbl01.setBounds(30, 42, 57, 15);
		contentPane.add(lbl01);
		
		lbl02 = new JLabel("컴");
		lbl02.setBounds(30, 83, 57, 15);
		contentPane.add(lbl02);
		
		lbl03 = new JLabel("결과");
		lbl03.setBounds(30, 126, 57, 15);
		contentPane.add(lbl03);
		
		tf01 = new JTextField();
		tf01.setBounds(136, 39, 75, 21);
		contentPane.add(tf01);
		tf01.setColumns(10);
		
		tf02 = new JTextField();
		tf02.setColumns(10);
		tf02.setBounds(136, 80, 75, 21);
		contentPane.add(tf02);
		
		tf03 = new JTextField();
		tf03.setColumns(10);
		tf03.setBounds(136, 123, 75, 21);
		contentPane.add(tf03);
		
		JButton btn = new JButton("게임하기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myclick();
			}
		});
		btn.setBounds(30, 175, 181, 23);
		contentPane.add(btn);
	}
	
	void myclick() {
		double rnd = Math.random();
		tf01.getText();
		
		if(rnd < 0.5) {
			tf02.setText("짝");
		}
		else {
			tf02.setText("홀");
		}
		
		if(tf01.getText().equals(tf02.getText())) {
			tf03.setText("승리");
		}
		else {
			tf03.setText("패배");
		}
	}

}
