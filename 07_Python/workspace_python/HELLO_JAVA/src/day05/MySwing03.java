package day05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MySwing03 extends JFrame {

	private JPanel contentPane;
	JLabel lbl;
	private JTextField tf01;
	private JTextField tf02;
	private JTextField tf03;
	private JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing03 frame = new MySwing03();
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
	public MySwing03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl = new JLabel("+");
		lbl.setBounds(74, 10, 19, 15);
		contentPane.add(lbl);
		
		tf01 = new JTextField();
		tf01.setBounds(12, 10, 45, 15);
		contentPane.add(tf01);
		tf01.setColumns(10);
		
		tf02 = new JTextField();
		tf02.setColumns(10);
		tf02.setBounds(100, 10, 45, 15);
		contentPane.add(tf02);
		
		tf03 = new JTextField();
		tf03.setColumns(10);
		tf03.setBounds(223, 10, 45, 15);
		contentPane.add(tf03);
		
		btn = new JButton("=");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myclick();
			}
		});
		btn.setBounds(157, 6, 54, 23);
		contentPane.add(btn);
	}
	void myclick() {
		String a = tf01.getText();
		String b = tf02.getText();
		
		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		
		int c = aa + bb;
		
		tf03.setText(c + "");
	}
}
