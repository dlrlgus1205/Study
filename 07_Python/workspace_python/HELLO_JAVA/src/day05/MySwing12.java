package day05;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MySwing12 extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	JTextArea ta;
	List<Integer> list = new ArrayList<Integer>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwing12 frame = new MySwing12();
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
	public MySwing12() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("숫자 입력 : ");
		lbl.setBounds(53, 61, 76, 15);
		contentPane.add(lbl);
		
		tf = new JTextField();
		tf.setBounds(153, 58, 116, 21);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btn = new JButton("게임 시작");
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				myclick();
			}
		});
		
		btn.setBounds(53, 98, 216, 23);
		contentPane.add(btn);
		
		ta = new JTextArea();
		ta.setBounds(53, 131, 216, 310);
		contentPane.add(ta);
	}
	
	void myclick() {
		String str = tf.getText();
		char[] arr = str.toCharArray();
		
		while(list.size() < 3) {
			int rnd = (int) ((Math.random() * 9) + 1);
			if(!list.contains(rnd)) list.add(rnd);
		}

		int s = 0;
		int b = 0;
		
		for (int i = 0; i < arr.length; i++) {
		    int num = Character.getNumericValue(arr[i]);
		    if (num == list.get(i)) {
		        s++;
		    } else if (list.contains(num)) {
		        b++;
		    }
		}
		
		ta.append(str + "\t" + s + "스트라이크" + b + "볼" + "\n");
		
		if(s == 3) {
			String txt = "정답\n";
			txt += list.get(0);
			txt += list.get(1);
			txt += list.get(2);
			JOptionPane.showMessageDialog(null, txt);
		}
	}
}
