package LiquorShop;
import java.awt.EventQueue;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;

public class LiquorShop {

	private JFrame loadingframe;

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
					LiquorShop window = new LiquorShop();
					window.loadingframe.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LiquorShop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		loadingframe = new JFrame();
		loadingframe.getContentPane().setEnabled(false);
		loadingframe.getContentPane().setBackground(new Color(147, 89, 43));
		loadingframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Liquor Shop Management System");
		lblNewLabel.setForeground(new Color(249, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setBounds(178, 20, 559, 52);
		loadingframe.getContentPane().add(lblNewLabel);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setToolTipText("");
		progressBar.setBackground(new Color(248, 241, 241));
		progressBar.setStringPainted(true);
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		progressBar.setForeground(new Color(199, 148, 148));
		progressBar.setBounds(82, 587, 688, 23);
		loadingframe.getContentPane().add(progressBar);
		
		JLabel label = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/BestArracks.png"));
		label.setIcon(img);
		label.setBounds(49, 97, 750, 455);
		loadingframe.getContentPane().add(label);
		loadingframe.setBounds(100, 100, 862, 708);
		loadingframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
