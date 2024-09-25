package LiquorShop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;

public class Product {

	private JFrame frame;
	private JTextField txtProductCode;
	private JTextField txtName;
	private JTextField txtBrand;
	private JTextField txtCategory;
	private JTextField txtPrice;
	private Connection connection;
	private JComboBox<String> cmbAvailability;
	private JTextField textField;
	private DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Product Code", "Product Name", "Brand", "Category", "Price", "Availability"}, 0);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product window = new Product();
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
	
	public JFrame getFrame3() {
        return frame;
    }
	
	public Product() {
		initialize();
		connectToDatabase();
		 loadProductList();
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
	
	private void insertProductData() {
        try {
        	String sql = "INSERT INTO product (ProductCode, ProductName, Brand, Category, Price, Availability) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, txtProductCode.getText());
            statement.setString(2, txtName.getText());
            statement.setString(3, txtBrand.getText());
            statement.setString(4, txtCategory.getText());
            statement.setDouble(5, Double.parseDouble(txtPrice.getText()));
            statement.setString(6, cmbAvailability.getSelectedItem().toString());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(frame, "Product added successfully.");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(244, 237, 234));
		frame.setBounds(100, 100, 1259, 774);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Create a JTable to display product details
	    
	    // Existing code...

	    // Create a JTable to display product details
	    JTable table = new JTable(tableModel);

	    // Create a JScrollPane to host the JTable
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(648, 219, 500, 406);
	    frame.getContentPane().add(scrollPane);

	    // Set the table selection mode to allow selecting a single row at a time
	    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	    // Add a ListSelectionListener to handle user selection
	    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	        public void valueChanged(ListSelectionEvent event) {
	            if (!event.getValueIsAdjusting()) {
	                int selectedRowIndex = table.getSelectedRow();
	                if (selectedRowIndex >= 0) {
	                    // Assuming your tableModel contains product details
	                    String productCode = tableModel.getValueAt(selectedRowIndex, 0).toString();
	                    String productName = tableModel.getValueAt(selectedRowIndex, 1).toString();
	                    String brand = tableModel.getValueAt(selectedRowIndex, 2).toString();
	                    String category = tableModel.getValueAt(selectedRowIndex, 3).toString();
	                    String price = tableModel.getValueAt(selectedRowIndex, 4).toString();
	                    String availability = tableModel.getValueAt(selectedRowIndex, 5).toString();
	                    
	                    // Update your text fields or labels with the selected product details
	                    txtProductCode.setText(productCode);
	                    txtName.setText(productName);
	                    txtBrand.setText(brand);
	                    txtCategory.setText(category);
	                    txtPrice.setText(price);
	                    cmbAvailability.setSelectedItem(availability);
	                }
	            }
	        }
	    });

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(167, 126, 78));
		panel.setBounds(0, 0, 1245, 92);
		frame.getContentPane().add(panel);
		
		JLabel lbltopicname = new JLabel("Liquor Shop Management System");
		lbltopicname.setForeground(Color.WHITE);
		lbltopicname.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbltopicname.setBounds(386, 10, 581, 48);
		panel.add(lbltopicname);
		
		JLabel lbltopicProduct = new JLabel("Manage Product");
		lbltopicProduct.setForeground(Color.WHITE);
		lbltopicProduct.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		lbltopicProduct.setBounds(514, 55, 228, 37);
		panel.add(lbltopicProduct);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(167, 126, 78));
		panel_1.setBounds(0, 690, 1245, 47);
		frame.getContentPane().add(panel_1);
		
		JLabel lblWineStore = new JLabel("Wine Store");
		lblWineStore.setForeground(Color.WHITE);
		lblWineStore.setFont(new Font("Poor Richard", Font.BOLD, 24));
		lblWineStore.setBounds(556, 10, 181, 37);
		panel_1.add(lblWineStore);
		
		JLabel lblProductCode = new JLabel("PRODUCT CODE");
		lblProductCode.setForeground(new Color(167, 126, 78));
		lblProductCode.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblProductCode.setBackground(UIManager.getColor("Button.background"));
		lblProductCode.setBounds(44, 141, 196, 35);
		frame.getContentPane().add(lblProductCode);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setForeground(new Color(158, 128, 90));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblName.setBackground(UIManager.getColor("Button.background"));
		lblName.setBounds(44, 192, 173, 35);
		frame.getContentPane().add(lblName);
		
		JLabel lblBrand = new JLabel("BRAND");
		lblBrand.setForeground(new Color(158, 128, 90));
		lblBrand.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblBrand.setBackground(UIManager.getColor("Button.background"));
		lblBrand.setBounds(44, 247, 173, 35);
		frame.getContentPane().add(lblBrand);
		
		JLabel lblCategory = new JLabel("CATEGORY");
		lblCategory.setForeground(new Color(158, 128, 90));
		lblCategory.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblCategory.setBackground(UIManager.getColor("Button.background"));
		lblCategory.setBounds(44, 292, 173, 35);
		frame.getContentPane().add(lblCategory);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setForeground(new Color(158, 128, 90));
		lblPrice.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblPrice.setBackground(UIManager.getColor("Button.background"));
		lblPrice.setBounds(44, 337, 173, 35);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblAvailability = new JLabel("AVAILABILITY");
		lblAvailability.setForeground(new Color(158, 128, 90));
		lblAvailability.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblAvailability.setBackground(UIManager.getColor("Button.background"));
		lblAvailability.setBounds(44, 390, 173, 35);
		frame.getContentPane().add(lblAvailability);
		
		txtProductCode = new JTextField();
		txtProductCode.setForeground(new Color(107, 68, 63));
		txtProductCode.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtProductCode.setColumns(10);
		txtProductCode.setBounds(267, 141, 241, 30);
		frame.getContentPane().add(txtProductCode);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtName.setForeground(new Color(107, 68, 63));
		txtName.setColumns(10);
		txtName.setBounds(267, 192, 241, 30);
		frame.getContentPane().add(txtName);
		
		txtBrand = new JTextField();
		txtBrand.setForeground(new Color(107, 68, 63));
		txtBrand.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBrand.setColumns(10);
		txtBrand.setBounds(267, 237, 241, 30);
		frame.getContentPane().add(txtBrand);
		
		txtCategory = new JTextField();
		txtCategory.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtCategory.setForeground(new Color(107, 68, 63));
		txtCategory.setColumns(10);
		txtCategory.setBounds(267, 284, 241, 30);
		frame.getContentPane().add(txtCategory);
		
		txtPrice = new JTextField();
		txtPrice.setForeground(new Color(107, 68, 63));
		txtPrice.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtPrice.setColumns(10);
		txtPrice.setBounds(267, 334, 241, 30);
		frame.getContentPane().add(txtPrice);
		
		cmbAvailability = new JComboBox<>();
		cmbAvailability.setFont(new Font("Times New Roman", Font.BOLD, 20));
		cmbAvailability.setForeground(new Color(134, 95, 51));
		cmbAvailability.addItem("Yes");
		cmbAvailability.addItem("No");
		cmbAvailability.setBounds(267, 395, 241, 30);
		frame.getContentPane().add(cmbAvailability);

		
		JButton btnAdd = new JButton("ADD");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertProductData(); 
            }
        });
		btnAdd.setForeground(new Color(167, 126, 78));
		btnAdd.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnAdd.setBounds(44, 452, 131, 41);
		frame.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRowIndex = table.getSelectedRow();
		        if (selectedRowIndex >= 0) {
		            // Retrieve data from input fields
		            String productCode = txtProductCode.getText();
		            String productName = txtName.getText();
		            String brand = txtBrand.getText();
		            String category = txtCategory.getText();
		            double price = Double.parseDouble(txtPrice.getText());
		            String availability = cmbAvailability.getSelectedItem().toString();
		            
		            // Update the selected row in the table
		            tableModel.setValueAt(productCode, selectedRowIndex, 0);
		            tableModel.setValueAt(productName, selectedRowIndex, 1);
		            tableModel.setValueAt(brand, selectedRowIndex, 2);
		            tableModel.setValueAt(category, selectedRowIndex, 3);
		            tableModel.setValueAt(price, selectedRowIndex, 4);
		            tableModel.setValueAt(availability, selectedRowIndex, 5);

		            // Update the corresponding data in the database
		            updateProductInDatabase(productCode, productName, brand, category, price, availability);
		        }
		    }
		});
		btnEdit.setForeground(new Color(167, 126, 78));
		btnEdit.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnEdit.setBounds(235, 452, 131, 41);
		frame.getContentPane().add(btnEdit);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int selectedRowIndex = table.getSelectedRow();
		        if (selectedRowIndex >= 0) {
		            // Retrieve the product code from the selected row
		            String productCode = tableModel.getValueAt(selectedRowIndex, 0).toString();

		            // Remove the selected row from the table
		            tableModel.removeRow(selectedRowIndex);

		            // Delete the corresponding data from the database
		            deleteProductFromDatabase(productCode);
		        }
		    }
		});
		btnDelete.setForeground(new Color(167, 126, 78));
		btnDelete.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnDelete.setBounds(402, 452, 131, 41);
		frame.getContentPane().add(btnDelete);
		
		//Reset Option
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				txtProductCode.setText("");
		        txtName.setText("");
		        txtBrand.setText("");
		        txtCategory.setText("");
		        txtPrice.setText("");
		        
			}
		});
		
		
		btnReset.setForeground(new Color(167, 126, 78));
		btnReset.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnReset.setBounds(140, 519, 131, 41);
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
		btnBack.setBounds(246, 597, 120, 41);
		frame.getContentPane().add(btnBack);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    }
		});
		btnSearch.setForeground(new Color(158, 128, 90));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSearch.setBounds(927, 162, 138, 32);
		frame.getContentPane().add(btnSearch);
		
		/*JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(575, 215, 639, 428);
		frame.getContentPane().add(scrollPane);*/
		
		JLabel lblLiquorList = new JLabel("Liquor List");
		lblLiquorList.setForeground(new Color(167, 126, 78));
		lblLiquorList.setFont(new Font("Sitka Text", Font.BOLD, 24));
		lblLiquorList.setBounds(823, 102, 181, 47);
		frame.getContentPane().add(lblLiquorList);
		
		textField = new JTextField();
		textField.setForeground(new Color(134, 95, 51));
		textField.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textField.setBounds(749, 162, 168, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				loadProductList();
			}
		});
		btnRefresh.setForeground(new Color(167, 126, 78));
		btnRefresh.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnRefresh.setBounds(330, 519, 138, 41);
		frame.getContentPane().add(btnRefresh);
	}
	
	private void loadProductList() {
	    try {
	        // Your existing code here to connect to the database

	        String selectQuery = "SELECT ProductCode, ProductName, Brand, Category, Price, Availability FROM product";
	        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        tableModel.setRowCount(0); // Clear the existing data in the table

	        while (resultSet.next()) {
	            String productCode = resultSet.getString("ProductCode");
	            String productName = resultSet.getString("ProductName");
	            String brand = resultSet.getString("Brand");
	            String category = resultSet.getString("Category");
	            double price = resultSet.getDouble("Price");
	            String availability = resultSet.getString("Availability");

	            // Add the retrieved data to the tableModel
	            tableModel.addRow(new Object[]{productCode, productName, brand, category, price, availability});
	        }

	        resultSet.close();
	        preparedStatement.close();
	        // connection.close(); // You might want to close the connection after use, but not recommended to close it here
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	private void updateProductInDatabase(String productCode, String productName, String brand, String category, double price, String availability) {
	    try {
	        String updateQuery = "UPDATE product SET ProductName=?, Brand=?, Category=?, Price=?, Availability=? WHERE ProductCode=?";
	        PreparedStatement statement = connection.prepareStatement(updateQuery);
	        statement.setString(1, productName);
	        statement.setString(2, brand);
	        statement.setString(3, category);
	        statement.setDouble(4, price);
	        statement.setString(5, availability);
	        statement.setString(6, productCode);
	        
	        int rowsUpdated = statement.executeUpdate();
	        if (rowsUpdated > 0) {
	            JOptionPane.showMessageDialog(frame, "Product updated successfully.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	private void deleteProductFromDatabase(String productCode) {
	    try {
	        String deleteQuery = "DELETE FROM product WHERE ProductCode=?";
	        PreparedStatement statement = connection.prepareStatement(deleteQuery);
	        statement.setString(1, productCode);

	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted > 0) {
	            JOptionPane.showMessageDialog(frame, "Product deleted successfully.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	

}

