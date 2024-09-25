package LiquorShop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JOptionPane;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;

public class Customer {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-48,374
	 */
	private final JPanel panel = new JPanel();
	/**
	 * @wbp.nonvisual location=-48,434
	 */
	private final JPanel panel_1 = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Connection connection;
	private DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Customer ID", "Customer Name", "Age", "Email"}, 0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	

	public JFrame getFrame4() {
        return frame;
    }
	public Customer() {
		initialize();
		connectToDatabase();
		loadCustomerDataFromDatabase();
		
	}

	
	private void connectToDatabase() {
        try {
            String dbURL = "jdbc:mysql://localhost:3306/liquorshop";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(dbURL, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void insertCustomerData() {
        try {
            String sql = "INSERT INTO customer (CusID, CustomerName, Age, Email) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, textField.getText());
            statement.setString(2, textField_1.getText());
            statement.setInt(3, Integer.parseInt(textField_2.getText()));
            statement.setString(4, textField_3.getText());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) { 
                JOptionPane.showMessageDialog(frame, "Customer added successfully.");
                // You can now update the customer list (query the database and populate the scroll pane).
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(164, 124, 72));
		
		JLabel lblNewLabel_1_1 = new JLabel("Liquor Shop Management System");
		lblNewLabel_1_1.setForeground(new Color(249, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_1_1.setBounds(259, 10, 521, 43);
		panel_1.add(lblNewLabel_1_1);
		
		

		
		JLabel lblManageCustomers_1 = new JLabel("Manage Customers");
		lblManageCustomers_1.setForeground(new Color(253, 251, 249));
		lblManageCustomers_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblManageCustomers_1.setBounds(417, 72, 211, 29);
		panel_1.add(lblManageCustomers_1);
		panel.setLayout(null);
		panel.setBackground(new Color(164, 124, 72));
		
		JLabel lblNewLabel_1 = new JLabel("Liquor Shop Management System");
		lblNewLabel_1.setForeground(new Color(249, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_1.setBounds(259, 10, 521, 43);
		panel.add(lblNewLabel_1);
		
		JLabel lblManageCustomers = new JLabel("Manage Customers");
		lblManageCustomers.setForeground(new Color(253, 251, 249));
		lblManageCustomers.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblManageCustomers.setBounds(417, 72, 211, 29);
		panel.add(lblManageCustomers);
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(244, 237, 234));
		frame.setBounds(100, 100, 1265, 732);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTable table = new JTable(tableModel);

	    // Create a JScrollPane to host the JTable
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(648, 219, 500, 406);
	    frame.getContentPane().add(scrollPane);
	    
	 // Assuming you have a JTable named 'table' and a DefaultTableModel named 'tableModel'

	 // Set the table selection mode to allow selecting a single row at a time
	 table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	 // Add a ListSelectionListener to handle user selection
	 table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	     public void valueChanged(ListSelectionEvent event) {
	         if (!event.getValueIsAdjusting()) {
	             int selectedRowIndex = table.getSelectedRow();
	             if (selectedRowIndex >= 0) {
	                 // Assuming your tableModel contains customer details
	                 String customerID = tableModel.getValueAt(selectedRowIndex, 0).toString();
	                 String customerName = tableModel.getValueAt(selectedRowIndex, 1).toString();
	                 String age = tableModel.getValueAt(selectedRowIndex, 2).toString();
	                 String email = tableModel.getValueAt(selectedRowIndex, 3).toString();

	                 // Update your text fields or labels with the selected customer details
	                 textField.setText(customerID);
	                 textField_1.setText(customerName);
	                 textField_2.setText(age);
	                 textField_3.setText(email);
	             }
	         }
	     }
	 });


	    // Set the table selection mode to allow selecting a single row at a time
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	 // Add a ListSelectionListener to handle user selection
	 table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	     public void valueChanged(ListSelectionEvent event) {
	         if (!event.getValueIsAdjusting()) {
	             int selectedRowIndex = table.getSelectedRow();
	             if (selectedRowIndex >= 0) {
	                 // Retrieve customer data from the selected row
	                 String customerID = tableModel.getValueAt(selectedRowIndex, 0).toString();
	                 String customerName = tableModel.getValueAt(selectedRowIndex, 1).toString();
	                 String age = tableModel.getValueAt(selectedRowIndex, 2).toString();
	                 String email = tableModel.getValueAt(selectedRowIndex, 3).toString();

	                 // Update your text fields with the selected customer details
	                 textField.setText(customerID);
	                 textField_1.setText(customerName);
	                 textField_2.setText(age);
	                 textField_3.setText(email);
	             }
	         }
	     }
	 });
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(164, 124, 72));
		panel_2.setBounds(0, 0, 1251, 101);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Liquor Shop Management System");
		lblNewLabel_1_2.setForeground(new Color(249, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_1_2.setBounds(439, 10, 521, 43);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblCustomertopic = new JLabel("Manage Customer");
		lblCustomertopic.setForeground(Color.WHITE);
		lblCustomertopic.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		lblCustomertopic.setBounds(560, 63, 228, 37);
		panel_2.add(lblCustomertopic);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(167, 126, 78));
		panel_1_1.setBounds(0, 648, 1251, 47);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblWineStore = new JLabel("Wine Store");
		lblWineStore.setForeground(Color.WHITE);
		lblWineStore.setFont(new Font("Poor Richard", Font.BOLD, 24));
		lblWineStore.setBounds(581, 10, 181, 37);
		panel_1_1.add(lblWineStore);
		
		JLabel txtCustomerID = new JLabel("CUSTOMER ID");
		txtCustomerID.setForeground(new Color(167, 126, 78));
		txtCustomerID.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtCustomerID.setBackground(UIManager.getColor("Button.background"));
		txtCustomerID.setBounds(42, 180, 196, 35);
		frame.getContentPane().add(txtCustomerID);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(167, 126, 78));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblName.setBackground(UIManager.getColor("Button.background"));
		lblName.setBounds(42, 236, 196, 35);
		frame.getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setForeground(new Color(167, 126, 78));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblEmail.setBackground(UIManager.getColor("Button.background"));
		lblEmail.setBounds(42, 338, 196, 35);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setForeground(new Color(167, 126, 78));
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAge.setBackground(UIManager.getColor("Button.background"));
		lblAge.setBounds(42, 287, 196, 35);
		frame.getContentPane().add(lblAge);
		
		textField = new JTextField();
		textField.setForeground(new Color(134, 95, 51));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setColumns(10);
		textField.setBounds(221, 180, 347, 30);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(134, 95, 51));
		textField_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(221, 241, 347, 30);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setForeground(new Color(134, 95, 51));
		textField_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(221, 287, 347, 30);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(134, 95, 51));
		textField_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField_3.setColumns(10);
		textField_3.setBounds(221, 338, 347, 30);
		frame.getContentPane().add(textField_3);
		
		JLabel lblCustomerList = new JLabel("Customer List");
		lblCustomerList.setForeground(new Color(167, 126, 78));
		lblCustomerList.setFont(new Font("Sitka Text", Font.BOLD, 24));
		lblCustomerList.setBounds(844, 125, 181, 47);
		frame.getContentPane().add(lblCustomerList);
		
		JButton btnAdd = new JButton("ADD");
        btnAdd.setForeground(new Color(167, 126, 78));
        btnAdd.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
        btnAdd.setBounds(39, 419, 131, 41);
        frame.getContentPane().add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertCustomerData();
            }
        });
		btnAdd.setForeground(new Color(167, 126, 78));
		btnAdd.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnAdd.setBounds(39, 419, 131, 41);
		frame.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the selected row from your customer list, similar to your product example.
		        int selectedRowIndex = table.getSelectedRow();
		        if (selectedRowIndex >= 0) {
		            // Retrieve data from input fields
		            String customerID = textField.getText();
		            String customerName = textField_1.getText();
		            int age = Integer.parseInt(textField_2.getText());
		            String email = textField_3.getText();
		            
		            // Update the selected row in your customer list
		            tableModel.setValueAt(customerID, selectedRowIndex, 0);
		            tableModel.setValueAt(customerName, selectedRowIndex, 1);
		            tableModel.setValueAt(age, selectedRowIndex, 2);
		            tableModel.setValueAt(email, selectedRowIndex, 3);

		            // Update the corresponding data in the database
		            updateCustomerInDatabase(customerID, customerName, age, email);
		        }
		    }
		});

		btnEdit.setForeground(new Color(167, 126, 78));
		btnEdit.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnEdit.setBounds(237, 419, 131, 41);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Get the selected row from your customer list
		        int selectedRowIndex = table.getSelectedRow();
		        if (selectedRowIndex >= 0) {
		            // Retrieve the customer ID from the selected row
		            String customerID = tableModel.getValueAt(selectedRowIndex, 0).toString();

		            // Remove the selected row from your customer list
		            tableModel.removeRow(selectedRowIndex);

		            // Delete the corresponding data from the database
		            deleteCustomerFromDatabase(customerID);
		        }
		    }
		});
		btnDelete.setForeground(new Color(167, 126, 78));
		btnDelete.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnDelete.setBounds(418, 419, 131, 41);
		frame.getContentPane().add(btnDelete);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
			    textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnReset.setForeground(new Color(167, 126, 78));
		btnReset.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnReset.setBounds(147, 495, 131, 41);
		frame.getContentPane().add(btnReset);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Close the current UserLogin frame
		        frame.dispose();

		        // Create and show the main form
		        MainForm mainForm = new MainForm();
		        mainForm.frame.setVisible(true);
		    }
		});
		btnBack.setForeground(new Color(167, 126, 78));
		btnBack.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnBack.setBounds(248, 573, 120, 41);
		frame.getContentPane().add(btnBack);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				loadCustomerDataFromDatabase();
			}
		});
		
		btnRefresh.setForeground(new Color(167, 126, 78));
		btnRefresh.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnRefresh.setBounds(347, 495, 142, 41);
		frame.getContentPane().add(btnRefresh);
		
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(612, 178, 603, 428);
		frame.getContentPane().add(scrollPane);*/
	}
	// Method to update customer data in the database
	private void updateCustomerInDatabase(String customerID, String customerName, int age, String email) {
	    try {
	        String updateQuery = "UPDATE customer SET CustomerName=?, Age=?, Email=? WHERE CusID=?";
	        PreparedStatement statement = connection.prepareStatement(updateQuery);
	        statement.setString(1, customerName);
	        statement.setInt(2, age);
	        statement.setString(3, email);
	        statement.setString(4, customerID);

	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            JOptionPane.showMessageDialog(frame, "Customer updated successfully.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	// Method to delete customer data from the database
	private void deleteCustomerFromDatabase(String customerID) {
	    try {
	        String deleteQuery = "DELETE FROM customer WHERE CusID=?";
	        PreparedStatement statement = connection.prepareStatement(deleteQuery);
	        statement.setString(1, customerID);

	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted > 0) {
	            JOptionPane.showMessageDialog(frame, "Customer deleted successfully.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	private void loadCustomerDataFromDatabase() {
	    try {
	        // Assuming 'tableModel' is your DefaultTableModel
	        tableModel.setRowCount(0); // Clear existing data in the table

	        String query = "SELECT * FROM customer";
	        PreparedStatement statement = connection.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            // Retrieve data from the database
	            String customerID = resultSet.getString("CusID");
	            String customerName = resultSet.getString("CustomerName");
	            int age = resultSet.getInt("Age");
	            String email = resultSet.getString("Email");

	            // Add a new row to the table with the retrieved data
	            tableModel.addRow(new Object[]{customerID, customerName, age, email});
	        }

	        // Close the ResultSet and Statement
	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
