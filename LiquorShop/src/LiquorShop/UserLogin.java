package LiquorShop;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserLogin {
    private JFrame frame;
    private JTextField txtUserName;
    private JTextField txtPassword;
    private JTable table;
    private DefaultTableModel tableModel;
    private int selectedRow = -1; // Keep track of the selected row

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin window = new UserLogin();
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
	
	public JFrame getFrame() {
        return frame;
    }
	
	public UserLogin() {
		initialize();
		loadUserList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 frame = new JFrame();
	        frame.setBounds(100, 100, 1094, 713);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);

	        tableModel = new DefaultTableModel();
	        tableModel.addColumn("Username");
	        tableModel.addColumn("Password");

	        table = new JTable(tableModel);
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(551, 198, 500, 406);
	        frame.getContentPane().add(scrollPane);

	        // Set the table selection mode to allow selecting a single row at a time
	        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	        // Add a ListSelectionListener to handle user selection
	        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	            public void valueChanged(ListSelectionEvent event) {
	                if (!event.getValueIsAdjusting()) {
	                    int selectedRowIndex = table.getSelectedRow();
	                    if (selectedRowIndex >= 0) {
	                        selectedRow = selectedRowIndex; // Update the selected row index
	                        // Display the selected user's details in text fields
	                        String selectedUserName = tableModel.getValueAt(selectedRowIndex, 0).toString();
	                        String selectedPassword = tableModel.getValueAt(selectedRowIndex, 1).toString();
	                        txtUserName.setText(selectedUserName);
	                        txtPassword.setText(selectedPassword);
	                    }
	                }
	            }
	        });


        
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1080, 92);
		panel.setBackground(new Color(167, 126, 78));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liquor Shop Management System");
		lblNewLabel.setBounds(305, 10, 581, 48);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		JLabel lblManageUsers = new JLabel("Manage Users");
		lblManageUsers.setForeground(Color.WHITE);
		lblManageUsers.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		lblManageUsers.setBounds(431, 55, 181, 37);
		panel.add(lblManageUsers);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 629, 1080, 47);
		panel_1.setBackground(new Color(167, 126, 78));
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblWineStore = new JLabel("Wine Store");
		lblWineStore.setForeground(Color.WHITE);
		lblWineStore.setFont(new Font("Poor Richard", Font.BOLD, 24));
		lblWineStore.setBounds(522, 10, 181, 37);
		panel_1.add(lblWineStore);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(43, 229, 158, 47);
		lblUsername.setForeground(new Color(167, 126, 78));
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 26));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(43, 286, 158, 47);
		lblPassword.setForeground(new Color(167, 126, 78));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 26));
		frame.getContentPane().add(lblPassword);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Times New Roman", Font.BOLD, 26));
		txtUserName.setForeground(new Color(107, 68, 63));
		txtUserName.setBounds(246, 243, 247, 28);
		txtUserName.setColumns(10);
		frame.getContentPane().add(txtUserName);
		
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("Times New Roman", Font.BOLD, 26));
		txtPassword.setForeground(new Color(107, 68, 63));
		txtPassword.setBounds(246, 300, 247, 28);
		txtPassword.setColumns(10);
		frame.getContentPane().add(txtPassword);
		
		// Add option 
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String userName = txtUserName.getText();
		        String password = txtPassword.getText();

		        // Check if any of the fields are empty
		        if (userName.isEmpty() || password.isEmpty()) {
		            JOptionPane.showMessageDialog(frame, "Username and Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
		        } else {
		            // Create the SQL query
		            String insertQuery = "INSERT INTO userlogin (UserName, Password) VALUES (?, ?)";

		            try {
		                // Create a connection
		                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/liquorshop", "root", "");

		                // Create a PreparedStatement for the query
		                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

		                // Set the values
		                preparedStatement.setString(1, userName);
		                preparedStatement.setString(2, password);

		                // Execute the query
		                int rowsInserted = preparedStatement.executeUpdate();

		                // Close the connection and statement
		                preparedStatement.close();
		                connection.close();

		                if (rowsInserted > 0) {
		                    // Successful insertion
		                    JOptionPane.showMessageDialog(frame, "User added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
		                } else {
		                    // Insertion failed
		                    JOptionPane.showMessageDialog(frame, "Error adding user.", "Error", JOptionPane.ERROR_MESSAGE);
		                }
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		                // Handle any database errors
		            }
		        }
		    }
		});

		
		
		btnAdd.setBounds(32, 404, 131, 41);
		btnAdd.setForeground(new Color(167, 126, 78));
		btnAdd.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		frame.getContentPane().add(btnAdd);
		
		// Edit Option
		
	      JButton btnEdit = new JButton("EDIT");
	        btnEdit.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (selectedRow != -1) {
	                    String newUsername = txtUserName.getText();
	                    String newPassword = txtPassword.getText();

	                    if (newUsername.isEmpty() || newPassword.isEmpty()) {
	                        JOptionPane.showMessageDialog(frame, "Username and Password cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
	                        return;
	                    }

	                    String oldUsername = tableModel.getValueAt(selectedRow, 0).toString();
	                    tableModel.setValueAt(newUsername, selectedRow, 0);
	                    tableModel.setValueAt(newPassword, selectedRow, 1);

	                    editUser(oldUsername, newUsername, newPassword);

	                    txtUserName.setText("");
	                    txtPassword.setText("");
	                }
	            }
	        });

	        btnEdit.setBounds(205, 404, 131, 41);
	        btnEdit.setForeground(new Color(167, 126, 78));
	        btnEdit.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
	        frame.getContentPane().add(btnEdit);
		
		// Delete Option
		
	        JButton btnDelete = new JButton("DELETE");
	        btnDelete.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                if (selectedRow != -1) {
	                    String userNameToDelete = tableModel.getValueAt(selectedRow, 0).toString();
	                    deleteUser(userNameToDelete);
	                    tableModel.removeRow(selectedRow);
	                    txtUserName.setText("");
	                    txtPassword.setText("");
	                }
	            }
	        });
	        btnDelete.setBounds(372, 404, 131, 41);
	        btnDelete.setForeground(new Color(167, 126, 78));
	        btnDelete.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
	        frame.getContentPane().add(btnDelete);
		
		
		// Reset Option
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
		        txtUserName.setText("");
		        txtPassword.setText("");
			}
		});
		
		
		btnReset.setBounds(117, 480, 120, 41);
		btnReset.setForeground(new Color(167, 126, 78));
		btnReset.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		frame.getContentPane().add(btnReset);
		
		// Back Option 
		
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
		
		btnBack.setBounds(216, 552, 120, 41);
		btnBack.setForeground(new Color(167, 126, 78));
		btnBack.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		frame.getContentPane().add(btnBack);
		
		
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(551, 198, 500, 406);
		frame.getContentPane().add(scrollPane1);
		
		JLabel lblUserList = new JLabel("User List");
		lblUserList.setForeground(new Color(167, 126, 78));
		lblUserList.setFont(new Font("Sitka Text", Font.BOLD, 26));
		lblUserList.setBounds(734, 141, 122, 47);
		frame.getContentPane().add(lblUserList);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				loadUserList();
			}
		});
		btnRefresh.setForeground(new Color(167, 126, 78));
		btnRefresh.setFont(new Font("Microsoft Tai Le", Font.BOLD, 24));
		btnRefresh.setBounds(294, 480, 142, 41);
		frame.getContentPane().add(btnRefresh);
	}
	private void loadUserList() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/liquorshop", "root", "");
            String selectQuery = "SELECT UserName, Password FROM userlogin";

            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

            tableModel.setRowCount(0);

            while (resultSet.next()) {
                String userName = resultSet.getString("UserName");
                String password = resultSet.getString("Password");

                tableModel.addRow(new Object[]{userName, password});
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	private void editUser(String oldUsername, String newUsername, String newPassword) {
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/liquorshop", "root", "");
	        String updateQuery = "UPDATE userlogin SET UserName = ?, Password = ? WHERE UserName = ?";

	        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
	        preparedStatement.setString(1, newUsername);
	        preparedStatement.setString(2, newPassword);
	        preparedStatement.setString(3, oldUsername);

	        int rowsUpdated = preparedStatement.executeUpdate();

	        preparedStatement.close();
	        connection.close();

	        if (rowsUpdated > 0) {
	            JOptionPane.showMessageDialog(frame, "User updated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(frame, "User update failed.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(frame, "Error updating user.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	private void deleteUser(String userName) {
	    try {
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/liquorshop", "root", "");
	        String deleteQuery = "DELETE FROM userlogin WHERE UserName = ?";

	        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
	        preparedStatement.setString(1, userName);

	        int rowsDeleted = preparedStatement.executeUpdate();

	        preparedStatement.close();
	        connection.close();

	        if (rowsDeleted > 0) {
	            JOptionPane.showMessageDialog(frame, "User deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(frame, "User deletion failed.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(frame, "Error deleting user.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

}