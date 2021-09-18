import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this class is for user search
public class UserSearch {

	public JFrame frame;
	public static JTextField srch;
	public JLabel label;
	public JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserSearch window = new UserSearch();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	//constructor
	public UserSearch() {
		initialize();
		showImg();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 224, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDate = new JLabel("Enter Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(10, 111, 73, 14);
		frame.getContentPane().add(lblDate);

		srch = new JTextField();
		srch.setBounds(93, 108, 86, 20);
		frame.getContentPane().add(srch);
		srch.setColumns(10);

		JButton Search_Match = new JButton("Search Match");
		Search_Match.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (srch.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter Date");
				} else {
					frame.dispose();
					UserDisp d = new UserDisp();
					d.frame.setVisible(true);
				}
			}
		});
		Search_Match.setFont(new Font("Tahoma", Font.BOLD, 11));
		Search_Match.setBounds(42, 136, 137, 23);
		frame.getContentPane().add(Search_Match);

		JLabel lblSearchForMatch = new JLabel("Search For Match");
		lblSearchForMatch.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSearchForMatch.setBounds(42, 58, 137, 14);
		frame.getContentPane().add(lblSearchForMatch);

		label = new JLabel("");
		label.setBounds(10, 11, 58, 43);
		frame.getContentPane().add(label);

		label_1 = new JLabel("");
		label_1.setBounds(140, 11, 58, 43);
		frame.getContentPane().add(label_1);

		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(42, 204, 137, 23);
		frame.getContentPane().add(btnExit);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login s = new Login();
				s.frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(42, 170, 137, 23);
		frame.getContentPane().add(btnBack);
	}

	public void showImg() {
		ImageIcon icon = new ImageIcon("C:/Users/Rushikesh/Downloads/download.jpg");
		Image img = icon.getImage();
		Image imgsc = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img2 = new ImageIcon(imgsc);
		label.setIcon(img2);

		ImageIcon icon2 = new ImageIcon("C:/Users/Rushikesh/Downloads/download1.jpg");
		Image img3 = icon2.getImage();
		Image imgsc1 = img3.getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img4 = new ImageIcon(imgsc1);
		label_1.setIcon(img4);
	}
}
