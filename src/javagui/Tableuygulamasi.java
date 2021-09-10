package javagui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tableuygulamasi extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextField txtAdSoyad;
	private JLabel lblNewLabel_1;
	private JTextField txtMeslek;
	private DefaultTableModel userModel;
	private Object[] userRowData;

	private List<User> users = new ArrayList<>();
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tableuygulamasi frame = new Tableuygulamasi();
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
	public Tableuygulamasi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		userModel = new DefaultTableModel();

		Object[] colUsers = new Object[3];
		colUsers[0] = "id";
		colUsers[1] = "Ad Soyad";
		colUsers[2] = "Meslek";
		userModel.setColumnIdentifiers(colUsers);

		table = new JTable(userModel);
		table.setBounds(66, 49, 386, 218);
		// contentPane.add(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 37, 290, 184);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);

		lblNewLabel = new JLabel("Ad Soyad");
		lblNewLabel.setBounds(416, 114, 63, 13);
		contentPane.add(lblNewLabel);

		txtAdSoyad = new JTextField();
		txtAdSoyad.setBounds(489, 111, 96, 19);
		contentPane.add(txtAdSoyad);
		txtAdSoyad.setColumns(10);

		lblNewLabel_1 = new JLabel("Meslek");
		lblNewLabel_1.setBounds(416, 143, 63, 13);
		contentPane.add(lblNewLabel_1);

		txtMeslek = new JTextField();
		txtMeslek.setColumns(10);
		txtMeslek.setBounds(489, 140, 96, 19);
		contentPane.add(txtMeslek);

		JButton btnAdd = new JButton("Ekle");
		btnAdd.setBounds(394, 195, 85, 21);
		contentPane.add(btnAdd);

		JButton btnDelete = new JButton("Sil");
		btnDelete.setBounds(500, 195, 85, 21);
		contentPane.add(btnDelete);

		JButton btnGuncelle = new JButton("Güncelle");

		btnGuncelle.setBounds(595, 195, 85, 21);
		contentPane.add(btnGuncelle);

		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(489, 82, 96, 19);
		contentPane.add(txtID);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(416, 85, 63, 13);
		contentPane.add(lblId);
		// --------------------------------------------->>
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtID.getText() != "") {

					int id = Integer.parseInt(txtID.getText());
					// int sayac=0;
					
					User updateUser=new User(id,txtAdSoyad.getText(),txtMeslek.getText());
					for (int i = 0; i < users.size(); i++) {

						if (id == users.get(i).getId()) {
							
							users.set(i, updateUser);
							listele();
							clear();
						}
					}
				}

			}
		});
		// --------Silme -------------------------------->>
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtID.getText() != "") {

					int id = Integer.parseInt(txtID.getText());
					// int sayac=0;
					for (int i = 0; i < users.size(); i++) {

						if (id == users.get(i).getId()) {
							users.remove(i);
							listele();
							clear();
						}
					}
				}

			}
		});
		// ----------Tablo tıklama----------------->>
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txtID.setText(userModel.getValueAt(table.getSelectedRow(), 0).toString());
				txtAdSoyad.setText(userModel.getValueAt(table.getSelectedRow(), 1).toString());
				txtMeslek.setText(userModel.getValueAt(table.getSelectedRow(), 2).toString());
			}
		});

		// ----------Ekleme -------->>
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User(txtAdSoyad.getText(), txtMeslek.getText());
				users.add(user);
				listele();
				clear();
			}
		});
	}

	// ----------textField temizleme----------->>
	private void clear() {
		txtAdSoyad.setText("");
		txtID.setText("");
		txtMeslek.setText("");
	}

	// ------------Listeleme-------------->>
	private void listele() {
		userModel.setRowCount(0);
		userRowData = new Object[3];
		for (int i = 0; i < users.size(); i++) {
			userRowData[0] = users.get(i).getId();
			userRowData[1] = users.get(i).getAdi();
			userRowData[2] = users.get(i).getMeslek();
			userModel.addRow(userRowData);
		}

	}
}
