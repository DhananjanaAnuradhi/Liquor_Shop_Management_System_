package LiquorShop;

import java.awt.EventQueue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
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
	
	public JFrame getFrame5() {
        return frame;
    }
	
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1239, 754);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(164, 124, 72));
		panel_2.setBounds(0, 0, 1225, 101);
		frame.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Liquor Shop Management System");
		lblNewLabel_1_2.setForeground(new Color(249, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel_1_2.setBounds(385, 10, 521, 43);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lbltopicDashboard = new JLabel("DASHBOARD");
		lbltopicDashboard.setForeground(Color.WHITE);
		lbltopicDashboard.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		lbltopicDashboard.setBounds(530, 63, 228, 37);
		panel_2.add(lbltopicDashboard);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(167, 126, 78));
		panel_1_1.setBounds(0, 670, 1225, 47);
		frame.getContentPane().add(panel_1_1);
		
		JLabel lblWineStore = new JLabel("Wine Store");
		lblWineStore.setForeground(Color.WHITE);
		lblWineStore.setFont(new Font("Poor Richard", Font.BOLD, 24));
		lblWineStore.setBounds(581, 10, 181, 37);
		panel_1_1.add(lblWineStore);
		
		
		JPanel panel_C = new JPanel();
		panel_C.setLayout(null);
		panel_C.setBackground(new Color(244, 239, 232));
		panel_C.setBounds(109, 175, 273, 357);
		frame.getContentPane().add(panel_C);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(164, 124, 72));
		panel_3.setBounds(0, 0, 273, 64);
		panel_C.add(panel_3);
		
		JLabel lblCustomers = new JLabel("CUSTOMERS");
		lblCustomers.setForeground(new Color(253, 251, 249));
		lblCustomers.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblCustomers.setBounds(56, 10, 168, 30);
		panel_3.add(lblCustomers);
		
		JLabel lblImage1 = new JLabel("");
		lblImage1.setBounds(21, 74, 229, 179);
		panel_C.add(lblImage1);
		ImageIcon Image1 = new ImageIcon(this.getClass().getResource("/im8.png"));
		lblImage1.setIcon(Image1);
		
		JLabel Cuslbl = new JLabel("New label");
		Cuslbl.setForeground(new Color(171, 130, 109));
		Cuslbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		Cuslbl.setBounds(116, 295, 56, 39);
		panel_C.add(Cuslbl);
		
		JPanel panel_P = new JPanel();
		panel_P.setLayout(null);
		panel_P.setBackground(new Color(244, 239, 232));
		panel_P.setBounds(471, 175, 282, 357);
		frame.getContentPane().add(panel_P);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(164, 124, 72));
		panel_3_1.setBounds(0, 0, 282, 64);
		panel_P.add(panel_3_1);
		
		JLabel lblProduct_1 = new JLabel("PRODUCT");
		lblProduct_1.setForeground(new Color(253, 251, 249));
		lblProduct_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblProduct_1.setBounds(80, 10, 156, 30);
		panel_3_1.add(lblProduct_1);
		
		JLabel lblImage1_1 = new JLabel("");
		lblImage1_1.setBounds(20, 74, 241, 183);
		panel_P.add(lblImage1_1);
		ImageIcon Image2 = new ImageIcon(this.getClass().getResource("/im4.jpeg"));
		lblImage1_1.setIcon(Image2);
		
		JLabel Prolbl = new JLabel("New label");
		Prolbl.setForeground(new Color(171, 130, 109));
		Prolbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		Prolbl.setBounds(130, 296, 59, 36);
		panel_P.add(Prolbl);
		
		
		JPanel panel_U = new JPanel();
		panel_U.setForeground(new Color(171, 130, 109));
		panel_U.setLayout(null);
		panel_U.setBackground(new Color(244, 239, 232));
		panel_U.setBounds(861, 175, 273, 357);
		frame.getContentPane().add(panel_U);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBackground(new Color(164, 124, 72));
		panel_3_2.setBounds(0, 0, 273, 64);
		panel_U.add(panel_3_2);
		
		JLabel lblUsers = new JLabel("USERS");
		lblUsers.setForeground(new Color(253, 251, 249));
		lblUsers.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblUsers.setBounds(96, 10, 177, 30);
		panel_3_2.add(lblUsers);
		
		JLabel lblImage1_2 = new JLabel("");
		lblImage1_2.setBounds(21, 74, 231, 180);
		panel_U.add(lblImage1_2);
		ImageIcon Image3 = new ImageIcon(this.getClass().getResource("/A.jpg"));
		lblImage1_2.setIcon(Image3);
		
		JLabel Uselbl = new JLabel("New label");
		Uselbl.setForeground(new Color(171, 130, 109));
		Uselbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		Uselbl.setBounds(130, 298, 63, 33);
		panel_U.add(Uselbl);
		

		int customerCount = 0;
		int productCount = 0;
		int userCount = 0;

		try {
		    // Replace with your database URL, username, and password
			String dbUrl ="jdbc:mysql://localhost:3306/liquorshop";
		    String dbUser = "root";
		    String dbPassword = "";

		    // Load the JDBC driver
		    Class.forName("com.mysql.cj.jdbc.Driver");

		    // Create a database connection
		    Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

		    // Query the database to get the counts
		    String customerQuery = "SELECT COUNT(*) FROM customer";
		    String productQuery = "SELECT COUNT(*) FROM product";
		    String userQuery = "SELECT COUNT(*) FROM userlogin";

		    // Execute the queries and retrieve the counts
		    PreparedStatement customerStatement = connection.prepareStatement(customerQuery);
		    PreparedStatement productStatement = connection.prepareStatement(productQuery);
		    PreparedStatement userStatement = connection.prepareStatement(userQuery);

		    ResultSet customerResult = customerStatement.executeQuery();
		    ResultSet productResult = productStatement.executeQuery();
		    ResultSet userResult = userStatement.executeQuery();

		    if (customerResult.next()) {
		        customerCount = customerResult.getInt(1);
		    }

		    if (productResult.next()) {
		        productCount = productResult.getInt(1);
		    }

		    if (userResult.next()) {
		        userCount = userResult.getInt(1);
		    }

		    // Close the database connection
		    connection.close();
		} catch (SQLException | ClassNotFoundException e) {
		    e.printStackTrace();
		    System.err.println("Error: " + e.getMessage());
		    // Handle any exceptions that may occur during database connection or queries
		}

		// Update the labels with the counts
		Cuslbl.setText("" + customerCount);
		Prolbl.setText("" + productCount);
		Uselbl.setText("" + userCount);

		// ... (existing code)


        // ... (existing code)
    

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
		btnBack.setBounds(551, 582, 120, 41);
		frame.getContentPane().add(btnBack);
	}
}
