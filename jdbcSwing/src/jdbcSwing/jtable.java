package jdbcSwing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jtable extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField nom;
	private JTextField prenom;
	private JTextField age;
	private JTextField ville;
	private JTable table;
	private DefaultTableModel model;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jtable frame = new jtable();
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
	public jtable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(45, 30, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNom = new JLabel("nom");
		lblNom.setBounds(45, 58, 46, 14);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("prenom");
		lblPrenom.setBounds(45, 84, 46, 14);
		contentPane.add(lblPrenom);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(45, 109, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblVille = new JLabel("ville");
		lblVille.setBounds(45, 134, 46, 14);
		contentPane.add(lblVille);
		
		id = new JTextField();
		id.setBounds(127, 27, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(127, 55, 86, 20);
		contentPane.add(nom);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(127, 81, 86, 20);
		contentPane.add(prenom);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBounds(127, 106, 86, 20);
		contentPane.add(age);
		
		ville = new JTextField();
		ville.setColumns(10);
		ville.setBounds(127, 131, 86, 20);
		contentPane.add(ville);
		
		JButton btnInsert = new JButton("insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnInsert.setBounds(298, 26, 89, 23);
		contentPane.add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 204, 414, 146);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table_1);
		
		table = new JTable();
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Nom", "prenom", "age", "ville"
				}
			);
		
		table.setModel(model);
	
	}
}
