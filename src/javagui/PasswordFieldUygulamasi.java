package javagui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PasswordFieldUygulamasi extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JButton btnKayit;
	private JLabel lblPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordFieldUygulamasi frame = new PasswordFieldUygulamasi();
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
	public PasswordFieldUygulamasi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordField.setBounds(121, 41, 173, 29);
		passwordField.setEchoChar('*');
		contentPane.add(passwordField);

		JCheckBox chcbxPassShow = new JCheckBox("Göster");
		chcbxPassShow.setBounds(323, 47, 93, 21);
		contentPane.add(chcbxPassShow);

		btnKayit = new JButton("Kay\u0131t");
		btnKayit.setBounds(331, 85, 85, 21);
		contentPane.add(btnKayit);

		lblPass = new JLabel("");
		lblPass.setBounds(131, 89, 156, 29);
		contentPane.add(lblPass);
		chcbxPassShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chcbxPassShow.isSelected()) {
					passwordField.setEchoChar((char) 0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});

		btnKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(passwordField.getPassword());
				if(doPassControl(pass)) {
				lblPass.setForeground(Color.green);
				lblPass.setText("Sifre Dogru");
				}else {
					lblPass.setForeground(Color.red);
					lblPass.setText("Sifre Yalnış");
				}
			}
		});
	}

	// ^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$
	public boolean doPassControl(String pass) {
		Pattern pattern = Pattern
				.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;.',?/*~$^+=<>]).{8,20}$");
		Matcher matcher=pattern.matcher(pass);
		return matcher.matches();
	}

}
