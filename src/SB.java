import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

//Scoreboard code where all scores data in inserted into database
public class SB {

	public JFrame frame;
	private JTextField teamA;
	private JTextField teamB;
	private JTextField goalA;
	private JTextField goalB;
	private JTextField penaltyA;
	private JTextField penaltyB;
	private JTextField r_cardA;
	private JTextField r_cardB;
	private JTextField y_cardA;
	private JTextField y_cardB;
	private JTextField faulA;
	private JTextField faulB;
	private JTextField off_sideA;
	private JTextField off_sideB;
	private JTextField cornerA;
	private JTextField cornerB;
	private JTextField free_kickA;
	private JTextField free_kickB;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JTextField match_no;
	public JLabel label;
	public JLabel label_1;
	private JTextField Date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SB window = new SB();
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
	public SB() {
		initialize();
		showimg();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(-8, 2, 356, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Score Board");
		lblNewLabel.setBounds(95, 47, 141, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBackground(SystemColor.activeCaptionBorder);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Goals");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(119, 170, 99, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Penalty");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(119, 195, 99, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Red Card");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(119, 220, 99, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Yellow Card");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(119, 245, 99, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Faul");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(119, 270, 99, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Off Side");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(119, 295, 99, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Corner");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(119, 320, 99, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Free Kick");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(119, 345, 99, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login s=new Login();
				s.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(226, 404, 104, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnAddEntry = new JButton("Add Entry");
		btnAddEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String date = Date.getText();
				String Mtch_no=match_no.getText();
				int Match_no= Integer.parseInt(Mtch_no);
				String Team_nameA=teamA.getText();
				String Team_nameB=teamB.getText();
				String GoalA=goalA.getText();
				int goal_A= Integer.parseInt(GoalA);
				String GoalB=goalB.getText();
				int goal_B= Integer.parseInt(GoalB);
				String PenaltyA=penaltyA.getText();
				int penalty_A= Integer.parseInt(PenaltyA);
				String PenaltyB=penaltyB.getText();
				int penalty_B= Integer.parseInt(PenaltyB);
				String Red_CardA=r_cardA.getText();
				int red_cardA= Integer.parseInt(Red_CardA);
				String Red_CardB=r_cardB.getText();
				int red_cardB= Integer.parseInt(Red_CardB);
				String Yellow_CardA=y_cardA.getText();
				int yellow_cardA= Integer.parseInt(Yellow_CardA);
				String Yellow_CardB=y_cardB.getText();
				int yellow_cardB= Integer.parseInt(Yellow_CardB);
				String faul_A=faulA.getText();
				int Faul_A= Integer.parseInt(faul_A);
				String faul_B=faulB.getText();
				int Faul_B= Integer.parseInt(faul_B);
				String Off_SideA=off_sideA.getText();
				int Off_Side_A= Integer.parseInt(Off_SideA);
				String Off_SideB=off_sideB.getText();
				int Off_Side_B= Integer.parseInt(Off_SideB);
				String corner_A=cornerA.getText();
				int Corner_A= Integer.parseInt(corner_A);
				String corner_B=cornerB.getText();
				int Corner_B= Integer.parseInt(corner_B);	
				String free_kick_A=free_kickA.getText();
				int Free_Kick_A= Integer.parseInt(free_kick_A);
				String free_kick_B=free_kickA.getText();
				int Free_Kick_B= Integer.parseInt(free_kick_B);
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/MatchSB","root","2000");
					conn.createStatement();
					String query= "INSERT INTO sb VALUES('"+date+"',"+Match_no+",'"+Team_nameA+"',"+goal_A+","+penalty_A+","+red_cardA+","+yellow_cardA+","+Faul_A+","+Off_Side_A+","+Corner_A+","+Free_Kick_A+")";
					String query1= "INSERT INTO sb VALUES('"+date+"',"+Match_no+",'"+Team_nameB+"',"+goal_B+","+penalty_B+","+red_cardB+","+yellow_cardB+","+Faul_B+","+Off_Side_B+","+Corner_B+","+Free_Kick_B+")";
					PreparedStatement dml=conn.prepareStatement(query);
					PreparedStatement dml1=conn.prepareStatement(query1);
					dml.executeUpdate(query);
					dml1.executeUpdate(query1);
					JOptionPane.showMessageDialog(null, "Inserted");
					conn.close();
				}catch(Exception e1) {
					System.out.println(e1);
				}
				match_no.setText("");
				Date.setText("");
				teamA.setText("");
				teamB.setText("");
				goalA.setText("");
				goalB.setText("");
				penaltyA.setText("");
				penaltyB.setText("");
				r_cardA.setText("");
				r_cardB.setText("");
	
				y_cardA.setText("");
			   	y_cardB.setText("");
			   	faulA.setText("");
			   	faulB.setText("");
			   	off_sideA.setText("");
			   	off_sideB.setText("");
			   	cornerA.setText("");
			   	cornerB.setText("");
			   	free_kickA.setText("");
			   	free_kickB.setText("");
			}
		});
		btnAddEntry.setBounds(10, 404, 107, 23);
		frame.getContentPane().add(btnAddEntry);
		
		JLabel lblNewLabel_9 = new JLabel("Teams");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(119, 140, 99, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		teamA = new JTextField();
		teamA.setBounds(33, 139, 86, 20);
		frame.getContentPane().add(teamA);
		teamA.setColumns(10);
		
		teamB = new JTextField();
		teamB.setBounds(226, 136, 86, 20);
		frame.getContentPane().add(teamB);
		teamB.setColumns(10);
		
		goalA = new JTextField();
		goalA.setBounds(33, 167, 86, 20);
		frame.getContentPane().add(goalA);
		goalA.setColumns(10);
		
		goalB = new JTextField();
		goalB.setBounds(226, 164, 86, 20);
		frame.getContentPane().add(goalB);
		goalB.setColumns(10);
		
		penaltyA = new JTextField();
		penaltyA.setBounds(33, 192, 86, 20);
		frame.getContentPane().add(penaltyA);
		penaltyA.setColumns(10);
		
		penaltyB = new JTextField();
		penaltyB.setBounds(226, 189, 86, 20);
		frame.getContentPane().add(penaltyB);
		penaltyB.setColumns(10);
		
		r_cardA = new JTextField();
		r_cardA.setBounds(33, 217, 86, 20);
		frame.getContentPane().add(r_cardA);
		r_cardA.setColumns(10);
		
		r_cardB = new JTextField();
		r_cardB.setBounds(226, 214, 86, 20);
		frame.getContentPane().add(r_cardB);
		r_cardB.setColumns(10);
		
		y_cardA = new JTextField();
		y_cardA.setBounds(33, 242, 86, 20);
		frame.getContentPane().add(y_cardA);
		y_cardA.setColumns(10);
		
		y_cardB = new JTextField();
		y_cardB.setBounds(226, 239, 86, 20);
		frame.getContentPane().add(y_cardB);
		y_cardB.setColumns(10);
		
		faulA = new JTextField();
		faulA.setBounds(33, 267, 86, 20);
		frame.getContentPane().add(faulA);
		faulA.setColumns(10);
		
		faulB = new JTextField();
		faulB.setBounds(226, 264, 86, 20);
		frame.getContentPane().add(faulB);
		faulB.setColumns(10);
		
		off_sideA = new JTextField();
		off_sideA.setBounds(33, 292, 86, 20);
		frame.getContentPane().add(off_sideA);
		off_sideA.setColumns(10);
		
		off_sideB = new JTextField();
		off_sideB.setBounds(226, 289, 86, 20);
		frame.getContentPane().add(off_sideB);
		off_sideB.setColumns(10);
		
		cornerA = new JTextField();
		cornerA.setBounds(33, 317, 86, 20);
		frame.getContentPane().add(cornerA);
		cornerA.setColumns(10);
		
		cornerB = new JTextField();
		cornerB.setBounds(226, 314, 86, 20);
		frame.getContentPane().add(cornerB);
		cornerB.setColumns(10);
		
		free_kickA = new JTextField();
		free_kickA.setBounds(33, 342, 86, 20);
		frame.getContentPane().add(free_kickA);
		free_kickA.setColumns(10);
		
		free_kickB = new JTextField();
		free_kickB.setBounds(226, 342, 86, 20);
		frame.getContentPane().add(free_kickB);
		free_kickB.setColumns(10);
		
		lblNewLabel_10 = new JLabel("English Premier League");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setBounds(29, 0, 283, 36);
		frame.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Match No:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(174, 100, 64, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		match_no = new JTextField();
		match_no.setBounds(248, 98, 64, 20);
		frame.getContentPane().add(match_no);
		match_no.setColumns(10);
		
		label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setBackground(Color.CYAN);
		label.setBounds(0, 0, 71, 72);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("");
		label_1.setBackground(new Color(0, 255, 255));
		label_1.setBounds(269, 0, 71, 72);
		frame.getContentPane().add(label_1);
		
		JLabel lblNewLabel_12 = new JLabel("Date:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(33, 98, 38, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		Date = new JTextField();
		Date.setText("DD-MM-YYYY");
		Date.setBounds(72, 98, 86, 20);
		frame.getContentPane().add(Date);
		Date.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Football");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_13.setBounds(95, 34, 136, 14);
		frame.getContentPane().add(lblNewLabel_13);
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Search s=new Search();
				s.frame.setVisible(true);
			}
		});
		search.setBounds(129, 404, 89, 23);
		frame.getContentPane().add(search);
		
		JButton del = new JButton("Delete");
	      del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				delete d=new delete();
				d.frame.setVisible(true);
			}
		});
	      del.setFont(new Font("Tahoma", Font.BOLD, 12));
		del.setBounds(133, 373, 85, 21);
		frame.getContentPane().add(del);
	}
	public void showimg() //displaying image on frame
	{
		ImageIcon icon=new ImageIcon("C:/Users/Rushikesh/Downloads/download.jpg");
		Image img=icon.getImage();
		Image imgsc=img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img2=new ImageIcon(imgsc);
		label.setIcon(img2);
		
		ImageIcon icon2=new ImageIcon("C:/Users/Rushikesh/Downloads/download1.jpg");
		Image img3=icon2.getImage();
		Image imgsc1=img3.getScaledInstance(label_1.getWidth(), label_1.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img4=new ImageIcon(imgsc1);
		label_1.setIcon(img4);
	}
}
