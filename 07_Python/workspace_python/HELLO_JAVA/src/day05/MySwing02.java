package day05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MySwing02 extends JFrame {

	private JPanel contentPane;
	JLabel lbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing02 frame = new MySwing02();
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
	public MySwing02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl = new JLabel("100");
		lbl.setBounds(59, 33, 57, 15);
		contentPane.add(lbl);
		
		JButton btn = new JButton("INCREASE");
		btn.addMouseListener(new MouseAdapter() {
//			int a = 100;
			@Override
			public void mouseClicked(MouseEvent e) {
//				a++;
//				String b = Integer.toString(a);
//				lbl.setText(b);
				myclick();
			}
		});
		btn.setBounds(199, 29, 97, 23);
		contentPane.add(btn);
	}
	void myclick() {
		String a = lbl.getText();
		int aa = Integer.parseInt(a);
		aa++;
		lbl.setText(aa + "");
	}
}
