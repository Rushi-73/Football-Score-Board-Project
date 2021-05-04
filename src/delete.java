import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class delete {

	JFrame frame;
	private JTextField mdate;
	private JTextField mnum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete window = new delete();
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
	public delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter match date");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(49, 90, 201, 48);
		frame.getContentPane().add(lblNewLabel);
		
		mdate = new JTextField();
		mdate.setBounds(169, 106, 96, 19);
		frame.getContentPane().add(mdate);
		mdate.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("MatchNO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(93, 133, 123, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		mnum = new JTextField();
		mnum.setBounds(169, 140, 96, 19);
		frame.getContentPane().add(mnum);
		mnum.setColumns(10);
		
		JButton del = new JButton("Delete");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mdate.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Date not found");
				} else {
					String data=mdate.getText();
					String matchno=mnum.getText();
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						Connection conn = null;
						try {
							conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MatchSB","root","2000");
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						Statement st = null;
						try {
							st = conn.createStatement();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						String sql1="SELECT * FROM sb Where date='"+data+"'";
						ResultSet rs = null;
						try {
							rs = st.executeQuery(sql1);
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						try {
							while(rs.next())
							{
								if(rs.getString("date").equals(data) &&rs.getString("Match_no").equals(matchno) )
								{
								   String sql="delete from sb WHERE date='"+data+"'";
								   try {
									st.executeUpdate(sql);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								   JOptionPane.showMessageDialog(null, "Deleted");
								}
							}
						} catch (HeadlessException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
		});
			
		
						
		del.setBounds(142, 190, 85, 21);
		frame.getContentPane().add(del);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

}
}
