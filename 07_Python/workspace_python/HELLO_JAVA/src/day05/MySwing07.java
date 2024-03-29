package day05;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MySwing07 extends JFrame {

	private JPanel contentPane;
	JLabel lbl1;
	JLabel lbl2;
	JLabel lbl3;
	JLabel lbl4;
	JLabel lbl5;
	JLabel lbl6;
	JButton btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing07 frame = new MySwing07();
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
	public MySwing07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lbl1 = new JLabel("__");
		lbl1.setBounds(75, 56, 22, 15);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("__");
		lbl2.setBounds(125, 56, 22, 15);
		contentPane.add(lbl2);
		
		lbl3 = new JLabel("__");
		lbl3.setBounds(175, 56, 22, 15);
		contentPane.add(lbl3);
		
		lbl4 = new JLabel("__");
		lbl4.setBounds(225, 56, 22, 15);
		contentPane.add(lbl4);
		
		lbl5 = new JLabel("__");
		lbl5.setBounds(275, 56, 22, 15);
		contentPane.add(lbl5);
		
		lbl6 = new JLabel("__");
		lbl6.setBounds(325, 56, 22, 15);
		contentPane.add(lbl6);
		
		btn = new JButton("로또 출력하기");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myclick();
			}
		});
		btn.setBounds(75, 129, 272, 23);
		contentPane.add(btn);
	}
	void myclick() {
		List list = new ArrayList();
		while(list.size() < 6) {
			int rnd = (int) ((Math.random() * 45) + 1);
			if(!list.contains(rnd)) list.add(rnd);
		}
		lbl1.setText(list.get(0)+"");
		lbl2.setText(list.get(1)+"");
		lbl3.setText(list.get(2)+"");
		lbl4.setText(list.get(3)+"");
		lbl5.setText(list.get(4)+"");
		lbl6.setText(list.get(5)+"");
	}
}
