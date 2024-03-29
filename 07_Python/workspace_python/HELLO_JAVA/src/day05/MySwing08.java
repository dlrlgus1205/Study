package day05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MySwing08 extends JFrame {

	private JPanel contentPane;
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
					MySwing08 frame = new MySwing08();
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
	public MySwing08() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf01 = new JTextField();
		tf01.setBounds(12, 63, 70, 21);
		contentPane.add(tf01);
		tf01.setColumns(10);
		
		JLabel lbl = new JLabel("에서");
		lbl.setBounds(94, 66, 27, 15);
		contentPane.add(lbl);
		
		tf02 = new JTextField();
		tf02.setColumns(10);
		tf02.setBounds(133, 63, 70, 21);
		contentPane.add(tf02);
		
		JButton btnNewButton = new JButton("까지 합은");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myclick();
			}
		});
		btnNewButton.setBounds(225, 62, 92, 23);
		contentPane.add(btnNewButton);
		
		tf03 = new JTextField();
		tf03.setColumns(10);
		tf03.setBounds(341, 63, 70, 21);
		contentPane.add(tf03);
	}
	void myclick() {
		int a = Integer.parseInt(tf01.getText());
		int b = Integer.parseInt(tf02.getText());
		int c = 0;
		for(int i = a; i < b + 1; i++) {
			c += i;
		}
		tf03.setText(c+"");
	}
}
