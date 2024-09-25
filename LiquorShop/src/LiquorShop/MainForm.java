package LiquorShop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainForm {

    JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainForm window = new MainForm();
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
    
    
    
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
        frame.getContentPane().setBackground(new Color(244, 237, 234));
        frame.setBounds(100, 100, 1129, 740);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
		
		 frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(167, 126, 78));
		panel.setBounds(0, 0, 1115, 92);
		frame.getContentPane().add(panel);
		
		JLabel lbltopicname = new JLabel("Liquor Shop Management System");
		lbltopicname.setForeground(Color.WHITE);
		lbltopicname.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lbltopicname.setBounds(354, 10, 581, 48);
		panel.add(lbltopicname);
		
		JLabel lblMainForm = new JLabel("Main Form");
		lblMainForm.setForeground(Color.WHITE);
		lblMainForm.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
		lblMainForm.setBounds(510, 55, 181, 37);
		panel.add(lblMainForm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(167, 126, 78));
		panel_1.setBounds(0, 656, 1115, 47);
		frame.getContentPane().add(panel_1);
		
		JLabel lblWineStore = new JLabel("Wine Store");
		lblWineStore.setForeground(Color.WHITE);
		lblWineStore.setFont(new Font("Poor Richard", Font.BOLD, 24));
		lblWineStore.setBounds(555, 10, 181, 37);
		panel_1.add(lblWineStore);
		
		// Navigate to the User form
		
		 
		JButton btnUser = new JButton("USER");
		btnUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserLogin userLogin = new UserLogin();
                userLogin.getFrame().setVisible(true);
            }
        });


		
		
		btnUser.setForeground(new Color(167, 126, 78));
		btnUser.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnUser.setBounds(64, 138, 204, 41);
		frame.getContentPane().add(btnUser);
		
		JButton btnProduct = new JButton("PRODUCT");
		btnProduct.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        Product productForm = new Product();
		        productForm.getFrame3().setVisible(true);
		    }
		});
		btnProduct.setForeground(new Color(167, 126, 78));
		btnProduct.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnProduct.setBounds(325, 138, 204, 41);
		frame.getContentPane().add(btnProduct);
		
		JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Customer customerForm = new Customer();
		        customerForm.getFrame4().setVisible(true);
		    }
		});
		btnCustomer.setForeground(new Color(167, 126, 78));
		btnCustomer.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnCustomer.setBounds(579, 138, 204, 41);
		frame.getContentPane().add(btnCustomer);
		
		JButton btnDashboard = new JButton("DASHBOARD");
		btnDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Dashboard dashbordForm = new Dashboard();
		        dashbordForm.getFrame5().setVisible(true);
		    }
		});
		btnDashboard.setForeground(new Color(167, 126, 78));
		btnDashboard.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnDashboard.setBounds(832, 138, 204, 41);
		frame.getContentPane().add(btnDashboard);
		
		JButton btnLogout = new JButton("LOGOUT");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the current MainForm frame
                frame.dispose();

                // Create and show the UserLogin frame (login form)
                Login login = new Login();
                login.getFrame1().setVisible(true);
                
            }
        });
		btnLogout.setForeground(new Color(167, 126, 78));
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnLogout.setBounds(487, 579, 204, 41);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblimg2 = new JLabel("");
		lblimg2.setBounds(205, 214, 813, 331);
		frame.getContentPane().add(lblimg2);
		ImageIcon Img1 = new ImageIcon(this.getClass().getResource("/image12.png"));
		lblimg2.setIcon(Img1);
	}

}
