package javagui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Color;

public class Menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnFormattedText;
	private FormattedTextUygulamasi formattedTextUygulamasi;
	private PasswordFieldUygulamasi passwordFieldUygulamasi;
	private JButton btnPasswordField; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 496);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnFormattedText = new JButton("FormattedTextUygulamasi");
		btnFormattedText.setBackground(new Color(128, 128, 128));
		btnFormattedText.setBounds(192, 51, 263, 45);
		btnFormattedText.addActionListener(this);
		contentPane.add(btnFormattedText);

		btnPasswordField = new JButton("PasswordFieldUygulamas\u0131");
		btnPasswordField.setBackground(Color.GRAY);
		btnPasswordField.setBounds(192, 133, 263, 45);
		contentPane.add(btnPasswordField);
		btnPasswordField.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == btnFormattedText) {
			if (formattedTextUygulamasi == null) {
				formattedTextUygulamasi = new FormattedTextUygulamasi();
				formattedTextUygulamasi.setVisible(true);
			} else {
				formattedTextUygulamasi.dispose();
				formattedTextUygulamasi = null;
				formattedTextUygulamasi = new FormattedTextUygulamasi();
				formattedTextUygulamasi.setVisible(true);
			}
		}else if(e.getSource()==btnPasswordField) {
			if (passwordFieldUygulamasi == null) {
				passwordFieldUygulamasi = new PasswordFieldUygulamasi();
				passwordFieldUygulamasi.setVisible(true);
			} else {
				passwordFieldUygulamasi.dispose();
				passwordFieldUygulamasi = null;
				passwordFieldUygulamasi = new PasswordFieldUygulamasi();
				passwordFieldUygulamasi.setVisible(true);
			}
		}

	}

}
