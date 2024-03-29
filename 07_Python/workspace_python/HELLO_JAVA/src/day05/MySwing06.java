package day05;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MySwing06 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;
	JButton btn8;
	JButton btn9;
	JButton btn0;
	JButton btnCall;
	String txt = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing06 frame = new MySwing06();
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
	public MySwing06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 362, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tf = new JTextField();
		tf.setBounds(29, 29, 282, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		btn1 = new JButton("1");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "1";
				tf.setText(txt);
			}
		});
		btn1.setBounds(29, 78, 81, 23);
		contentPane.add(btn1);
		
		btn2 = new JButton("2");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "2";
				tf.setText(txt);
			}
		});
		btn2.setBounds(132, 78, 81, 23);
		contentPane.add(btn2);
		
		btn3 = new JButton("3");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "3";
				tf.setText(txt);
			}
		});
		btn3.setBounds(230, 78, 81, 23);
		contentPane.add(btn3);
		
		btn4 = new JButton("4");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "4";
				tf.setText(txt);
			}
		});
		btn4.setBounds(29, 122, 81, 23);
		contentPane.add(btn4);
		
		btn5 = new JButton("5");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "5";
				tf.setText(txt);
			}
		});
		btn5.setBounds(132, 122, 81, 23);
		contentPane.add(btn5);
		
		btn6 = new JButton("6");
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "6";
				tf.setText(txt);
			}
		});
		btn6.setBounds(230, 122, 81, 23);
		contentPane.add(btn6);
		
		btn7 = new JButton("7");
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "7";
				tf.setText(txt);
			}
		});
		btn7.setBounds(29, 167, 81, 23);
		contentPane.add(btn7);
		
		btn8 = new JButton("8");
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "8";
				tf.setText(txt);
			}
		});
		btn8.setBounds(132, 167, 81, 23);
		contentPane.add(btn8);
		
		btn9 = new JButton("9");
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "9";
				tf.setText(txt);
			}
		});
		btn9.setBounds(230, 167, 81, 23);
		contentPane.add(btn9);
		
		btn0 = new JButton("0");
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt += "0";
				tf.setText(txt);
			}
		});
		btn0.setBounds(29, 211, 81, 23);
		contentPane.add(btn0);
		
		btnCall = new JButton("CALL");
		btnCall.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Calling To\n" + tf.getText());
			}
		});
		btnCall.setBounds(132, 211, 179, 23);
		contentPane.add(btnCall);
	}
}
