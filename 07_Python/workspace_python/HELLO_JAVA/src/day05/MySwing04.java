package day05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MySwing04 extends JFrame {

	private JPanel contentPane;
	JLabel lbl;
	private JTextField tf;
	JButton btn;
	JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing04 frame = new MySwing04();
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
	public MySwing04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl = new JLabel("출력단수");
		lbl.setBounds(83, 32, 57, 15);
		contentPane.add(lbl);
		
		tf = new JTextField();
		tf.setBounds(154, 29, 107, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		btn = new JButton("출력하기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myclick();
			}
		});
		btn.setBounds(83, 61, 178, 23);
		contentPane.add(btn);
		
		ta = new JTextArea();
		ta.setBounds(83, 94, 178, 272);
		contentPane.add(ta);
	}
	
	void myclick() {
		String txt = "";
		String a = tf.getText();
		int aa = Integer.parseInt(a);
		
		
		for(int i = 1; i < 10; i++) {
			txt += a + " * " + i + " = " + Integer.toString(aa * i) + "\n";
		}
		ta.setText(txt);
	}
}
