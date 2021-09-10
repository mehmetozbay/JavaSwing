package javagui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class TextAreaUygulamasi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextAreaUygulamasi frame = new TextAreaUygulamasi();
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
	public TextAreaUygulamasi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(61, 35, 220, 104);
		textArea.setText("asdasdasddddddddddddddddddddddddd"
				+ "asdddddddddddddddddddddddd"
				+ "asddddddddddddd"
				+ "asdadddddddddddd"
				+ "asdddddddddddddddddddddd"
				+ "asdddddddddddddddddddddd"
				+ "asddddddddddddddddddddd"
				+ "sdad"
				+ "asd"
				+ "das"
				+ "da"
				+ "adssssssssssssssssssssssssssssssssssssssssssss"
				+ "asddddddddddddddddddddddddddddddddddd"
				+ "asddddddddddddddddddddddddddddddd"
				+ "asdddddddddddd");
		textArea.setLineWrap(true);
		//contentPane.add(textArea);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 28, 155, 69);
		scrollPane.setViewportView(textArea);
		contentPane.add(scrollPane);
	}

}
