package jdbcSwing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class jdbcfram extends JFrame {

	private JPanel contentPane;
	private JTextField nomTxt;
	private JTextField prenomTxt;
	private JTextField ageTxt;
	private JTextField villeTxt;
	private model modelobj = new model();
	private dbconnection conn = new dbconnection();
	private Statement stmt = null;
	private ResultSet result = null;
	private Vector<Vector<String>> data; //used for data from database
	private Vector<String> header;
	private DefaultTableModel model;
	private Container panel = null;
	private JTable table;
	                                            // The 0 argument is number rows.

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jdbcfram frame = new jdbcfram();
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
	public jdbcfram() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nom");
		lblNewLabel.setBounds(0, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("prenom");
		lblNewLabel_1.setBounds(0, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblAge = new JLabel("age");
		lblAge.setBounds(0, 61, 46, 14);
		contentPane.add(lblAge);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(0, 86, 46, 14);
		contentPane.add(label_1);
		
		nomTxt = new JTextField();
		nomTxt.setBounds(106, 8, 86, 20);
		contentPane.add(nomTxt);
		nomTxt.setColumns(10);
		
		prenomTxt = new JTextField();
		prenomTxt.setColumns(10);
		prenomTxt.setBounds(106, 33, 86, 20);
		contentPane.add(prenomTxt);
		
		ageTxt = new JTextField();
		ageTxt.setColumns(10);
		ageTxt.setBounds(106, 58, 86, 20);
		contentPane.add(ageTxt);
		
		villeTxt = new JTextField();
		villeTxt.setColumns(10);
		villeTxt.setBounds(106, 83, 86, 20);
		contentPane.add(villeTxt);
		 
		JButton btnInsert = new JButton("insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					modelobj.inserAll(nomTxt.getText(), prenomTxt.getText(), Integer.parseInt(ageTxt.getText()), villeTxt.getText());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnInsert.setBounds(318, 11, 89, 23);
		contentPane.add(btnInsert);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.setBounds(318, 36, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setBounds(318, 61, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnSelect = new JButton("select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
				
						try {
							data = modelobj.selectAll();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						

						    
					
			}
		});
		btnSelect.setBounds(318, 82, 89, 23);
		contentPane.add(btnSelect);
		
		
	}
}
