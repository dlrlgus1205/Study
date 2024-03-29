package day05;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MySwing11 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	JTextArea ta;
	int rnd = (int) (Math.random() * 100) + 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing11 frame = new MySwing11();
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
	public MySwing11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("숫자(1 ~ 100)");
		lbl.setBounds(40, 50, 94, 15);
		contentPane.add(lbl);
		
		tf = new JTextField();
		tf.setBounds(131, 47, 116, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btn = new JButton("숫자 맞추기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myclick();
			}
		});
		btn.setBounds(40, 87, 207, 23);
		contentPane.add(btn);
		
		ta = new JTextArea();
		ta.setBounds(40, 134, 207, 369);
		contentPane.add(ta);
	}
	void myclick() {
		int n = Integer.parseInt(tf.getText());
		String txt = "";
		
		if(n == rnd) {
			txt += Integer.toString(n) + "\t정답\n";
		}
		else if(n > rnd) {
			txt += Integer.toString(n) + "\tDown\n";
		}
		else {
			txt += Integer.toString(n) + "\tUp\n";
		}
		ta.append(txt);
		tf.setText("");
	}
}
