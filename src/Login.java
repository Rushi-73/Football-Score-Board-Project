import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
* This is login class
 */
public class Login {

	public JFrame frame;
	public JLabel label_1;
	public JLabel label_6;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		showimg();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(-8, 2, 385, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label_3 = new JLabel("English Premier League");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_3.setBounds(47, 11, 283, 36);
		frame.getContentPane().add(label_3);

		label_1 = new JLabel("");
		label_1.setBackground(Color.CYAN);
		label_1.setBounds(10, 11, 71, 72);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Football");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(110, 45, 136, 14);
		frame.getContentPane().add(label_2);

		JLabel label_5 = new JLabel("Score Board");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_5.setBackground(SystemColor.activeCaptionBorder);
		label_5.setBounds(105, 58, 141, 25);
		frame.getContentPane().add(label_5);

		label_6 = new JLabel("");
		label_6.setBackground(Color.CYAN);
		label_6.setBounds(300, 11, 71, 72);
		frame.getContentPane().add(label_6);

		JLabel lblMatchSearch = new JLabel("Search Match:");
		lblMatchSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMatchSearch.setBounds(53, 128, 104, 14);
		frame.getContentPane().add(lblMatchSearch);

		JButton btnClick = new JButton("Search Here");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				UserSearch s = new UserSearch();
				s.frame.setVisible(true);
			}
		});
		btnClick.setBounds(156, 125, 89, 23);
		frame.getContentPane().add(btnClick);


		JLabel lblLoginForAuthor = new JLabel("User Name:");
		lblLoginForAuthor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLoginForAuthor.setBounds(53, 240, 71, 14);
		frame.getContentPane().add(lblLoginForAuthor);

		JButton btnClick_1 = new JButton("Login");
		btnClick_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClick_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username = username.getText();
				String Password = password.getText();
				int flag=0;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MatchSB", "root","2000");
					Statement st = conn.createStatement();
					String sql = "SELECT * FROM user where username='" + Username + "' and password='" + Password + "'";
					ResultSet rs = st.executeQuery(sql);
					while (rs.next()) {
						if(rs.getString("username").equals(Username)&&rs.getString("password").equals(Password))
						{
							frame.dispose();
							SB s = new SB();
							s.frame.setVisible(true);
							flag=1;
						}
					}
					if(flag==0)
					{
						JOptionPane.showMessageDialog(null, "Invalid Administrator");
						username.setText("");
						password.setText("");
					}
					if(Username.isEmpty()&&Password.isEmpty())
					{
						JOptionPane.showMessageDialog(null, "Enter User Name and Password");
					}

				} catch (Exception e1) {
					System.out.println(e);
				}
			}
		});
		btnClick_1.setBounds(125, 323, 89, 23);
		frame.getContentPane().add(btnClick_1);

		username = new JTextField();
		username.setBounds(146, 237, 123, 20);
		frame.getContentPane().add(username);
		username.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(53, 279, 71, 14);
		frame.getContentPane().add(lblPassword);

		JLabel lblLoginForAuthor_1 = new JLabel("Login For Administrator");
		lblLoginForAuthor_1.setForeground(new Color(0, 0, 128));
		lblLoginForAuthor_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoginForAuthor_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForAuthor_1.setBounds(23, 184, 307, 25);
		frame.getContentPane().add(lblLoginForAuthor_1);

		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.BOLD, 11));
		password.setBounds(146, 276, 123, 20);
		frame.getContentPane().add(password);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(125, 370, 89, 23);
		frame.getContentPane().add(btnExit);
	}

	public void showimg() {
		ImageIcon icon = new ImageIcon("C:/Users/Rushikesh/Downloads/download.jpg");
		Image img = icon.getImage();
		Image imgsc = img.getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img2 = new ImageIcon(imgsc);
		label_1.setIcon(img2);

		ImageIcon icon2 = new ImageIcon("C:/Users/Rushikesh/Downloads/download1.jpg");
		Image img3 = icon2.getImage();
		Image imgsc1 = img3.getScaledInstance(label_6.getWidth(), label_6.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img4 = new ImageIcon(imgsc1);
		label_6.setIcon(img4);
	}
}
