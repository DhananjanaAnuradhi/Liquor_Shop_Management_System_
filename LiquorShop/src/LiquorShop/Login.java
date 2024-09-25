package LiquorShop;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	    private static final String DB_URL = "jdbc:mysql://localhost:3306/liquorshop";
	    private static final String DB_USERNAME = "root";
	    private static final String DB_PASSWORD = "";

	    private JFrame frame;
	    private JTextField txtUserName;
	    private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					
					Login window = new Login();
					window.frame.setVisible(true);
					
				}
                  catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public JFrame getFrame1() {
        return frame;
        
    }
	public Login() 
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(167, 126, 78));
		frame.setBounds(100, 100, 1051, 656);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(134, 95, 51));
		panel.setBounds(0, 0, 424, 619);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLiquorShop = new JLabel("Liquor Shop");
		lblLiquorShop.setForeground(Color.WHITE);
		lblLiquorShop.setFont(new Font("Sitka Text", Font.BOLD, 28));
		lblLiquorShop.setBounds(107, 30, 200, 41);
		panel.add(lblLiquorShop);
		
		JLabel lblEveryBrand = new JLabel("Every Brand");
		lblEveryBrand.setForeground(Color.WHITE);
		lblEveryBrand.setFont(new Font("Sitka Text", Font.BOLD, 28));
		lblEveryBrand.setBounds(37, 425, 200, 41);
		panel.add(lblEveryBrand);
		
		JLabel lblQualityGuaranty = new JLabel("Quality Guaranty");
		lblQualityGuaranty.setForeground(Color.WHITE);
		lblQualityGuaranty.setFont(new Font("Sitka Text", Font.BOLD, 28));
		lblQualityGuaranty.setBounds(37, 476, 239, 41);
		panel.add(lblQualityGuaranty);
		
		JLabel lblBestPrice = new JLabel("Best Price");
		lblBestPrice.setForeground(Color.WHITE);
		lblBestPrice.setFont(new Font("Sitka Text", Font.BOLD, 28));
		lblBestPrice.setBounds(37, 527, 200, 41);
		panel.add(lblBestPrice);
		
		JLabel lblimage1 = new JLabel("");
		lblimage1.setBounds(73, 81, 252, 323);
		panel.add(lblimage1);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/image12.png"));
		lblimage1.setIcon(img);
		
		JLabel lbltopiclogin = new JLabel("Login");
		lbltopiclogin.setForeground(new Color(255, 255, 255));
		lbltopiclogin.setFont(new Font("Times New Roman", Font.BOLD, 32));
		lbltopiclogin.setBounds(685, 35, 97, 41);
		frame.getContentPane().add(lbltopiclogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblUsername.setBounds(536, 207, 115, 41);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblPassword.setBounds(536, 299, 115, 41);
		frame.getContentPane().add(lblPassword);

		
		// Exit Option
		
		JLabel lblExit = new JLabel("Exit");
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblExit.setBounds(974, 568, 53, 41);
		frame.getContentPane().add(lblExit);
		
		lblExit.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        // Add code to handle the exit action, such as closing the application
		        System.exit(0); // This line exits the application
		    }
		});

		
		
		// Login Button
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String username = txtUserName.getText();
		        String password = txtPassword.getText();

		        // Check the database for the provided username and password
		        try {
		            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		            String query = "SELECT * FROM userlogin WHERE UserName = ? AND Password = ?";
		            PreparedStatement statement = connection.prepareStatement(query);
		            statement.setString(1, username);
		            statement.setString(2, password);

		            ResultSet resultSet = statement.executeQuery();

		            if (resultSet.next()) {
		                // Login successful
		                openMainForm(); // Implement the method to open the MainForm
		                frame.dispose(); // Close the login form
		            } else {
		                // Login failed
		                JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
		            }

		            resultSet.close();
		            statement.close();
		            connection.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnLogin.setForeground(new Color(167, 126, 78));
		btnLogin.setBounds(685, 387, 120, 41);
		frame.getContentPane().add(btnLogin);
		
		txtUserName = new JTextField();
		txtUserName.setForeground(new Color(107, 68, 63));
		txtUserName.setFont(new Font("Times New Roman", Font.BOLD, 26));
		txtUserName.setBounds(730, 207, 196, 35);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setForeground(new Color(107, 68, 63));
		txtPassword.setFont(new Font("Times New Roman", Font.BOLD, 26));
		txtPassword.setColumns(10);
		txtPassword.setBounds(730, 299, 196, 35);
		frame.getContentPane().add(txtPassword);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Clear the username and password fields
		        txtUserName.setText("");
		        txtPassword.setText("");
		    }
		});
		btnClear.setForeground(new Color(167, 126, 78));
		btnClear.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnClear.setBounds(685, 460, 120, 41);
		frame.getContentPane().add(btnClear);
	}
		
	private void openMainForm() {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                MainForm mainForm = new MainForm();
	                mainForm.frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	
	}

}


