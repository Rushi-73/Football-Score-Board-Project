import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Disp {

	public JFrame frame;
	public JLabel label_9;
	public JLabel label_13;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Disp window = new Disp();
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
	public Disp() {
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
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Search s=new Search();
				s.frame.setVisible(true);
			}
		});
		JLabel label_10 = new JLabel("English Premier League");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_10.setBounds(29, 11, 283, 36);
		frame.getContentPane().add(label_10);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnOk.setBounds(124, 392, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel label = new JLabel("Teams");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(114, 105, 99, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Goals");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(114, 135, 99, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Penalty");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(114, 160, 99, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Red Card");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(114, 185, 99, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Yellow Card");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(114, 210, 99, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Faul");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(114, 235, 99, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Off Side");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(114, 260, 99, 14);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Corner");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(114, 285, 99, 14);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Free Kick");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_8.setBounds(114, 310, 99, 14);
		frame.getContentPane().add(label_8);
		
		label_9 = new JLabel("");
		label_9.setBounds(0, 11, 98, 89);
		frame.getContentPane().add(label_9);
		
		JLabel label_11 = new JLabel("Football");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(95, 45, 136, 14);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("Score Board");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_12.setBackground(SystemColor.activeCaptionBorder);
		label_12.setBounds(95, 58, 141, 25);
		frame.getContentPane().add(label_12);
		
		label_13 = new JLabel("");
		label_13.setBounds(242, 11, 98, 89);
		frame.getContentPane().add(label_13);
		
		JLabel teamA = new JLabel("");
		teamA.setHorizontalAlignment(SwingConstants.CENTER);
		teamA.setBounds(58, 107, 46, 14);
		frame.getContentPane().add(teamA);
		
		JLabel goalA = new JLabel("");
		goalA.setHorizontalAlignment(SwingConstants.CENTER);
		goalA.setBounds(58, 135, 46, 14);
		frame.getContentPane().add(goalA);
		
		JLabel penaltyA = new JLabel("");
		penaltyA.setHorizontalAlignment(SwingConstants.CENTER);
		penaltyA.setBounds(58, 160, 46, 14);
		frame.getContentPane().add(penaltyA);
		
		JLabel red_cardA = new JLabel("");
		red_cardA.setHorizontalAlignment(SwingConstants.CENTER);
		red_cardA.setBounds(58, 185, 46, 14);
		frame.getContentPane().add(red_cardA);
		
		JLabel yellow_cardA = new JLabel("");
		yellow_cardA.setHorizontalAlignment(SwingConstants.CENTER);
		yellow_cardA.setBounds(58, 210, 46, 14);
		frame.getContentPane().add(yellow_cardA);
		
		JLabel faulA = new JLabel("");
		faulA.setHorizontalAlignment(SwingConstants.CENTER);
		faulA.setBounds(58, 235, 46, 14);
		frame.getContentPane().add(faulA);
		
		JLabel off_sideA = new JLabel("");
		off_sideA.setHorizontalAlignment(SwingConstants.CENTER);
		off_sideA.setBounds(58, 260, 46, 14);
		frame.getContentPane().add(off_sideA);
		
		JLabel cornerA = new JLabel("");
		cornerA.setHorizontalAlignment(SwingConstants.CENTER);
		cornerA.setBounds(58, 285, 46, 14);
		frame.getContentPane().add(cornerA);
		
		JLabel free_kickA = new JLabel("");
		free_kickA.setHorizontalAlignment(SwingConstants.CENTER);
		free_kickA.setBounds(58, 310, 46, 14);
		frame.getContentPane().add(free_kickA);
		
		JLabel teamB = new JLabel("");
		teamB.setHorizontalAlignment(SwingConstants.CENTER);
		teamB.setBounds(223, 105, 46, 14);
		frame.getContentPane().add(teamB);
		
		JLabel goalB = new JLabel("");
		goalB.setHorizontalAlignment(SwingConstants.CENTER);
		goalB.setBounds(223, 135, 46, 14);
		frame.getContentPane().add(goalB);
		
		JLabel penaltyB = new JLabel("");
		penaltyB.setHorizontalAlignment(SwingConstants.CENTER);
		penaltyB.setBounds(223, 160, 46, 14);
		frame.getContentPane().add(penaltyB);
		
		JLabel red_cardB = new JLabel("");
		red_cardB.setHorizontalAlignment(SwingConstants.CENTER);
		red_cardB.setBounds(223, 185, 46, 14);
		frame.getContentPane().add(red_cardB);
		
		JLabel yellow_cardB = new JLabel("");
		yellow_cardB.setHorizontalAlignment(SwingConstants.CENTER);
		yellow_cardB.setBounds(223, 210, 46, 14);
		frame.getContentPane().add(yellow_cardB);
		
		JLabel faulB = new JLabel("");
		faulB.setHorizontalAlignment(SwingConstants.CENTER);
		faulB.setBounds(223, 235, 46, 14);
		frame.getContentPane().add(faulB);
		
		JLabel off_sideB = new JLabel("");
		off_sideB.setHorizontalAlignment(SwingConstants.CENTER);
		off_sideB.setBounds(223, 260, 46, 14);
		frame.getContentPane().add(off_sideB);
		
		JLabel cornerB = new JLabel("");
		cornerB.setHorizontalAlignment(SwingConstants.CENTER);
		cornerB.setBounds(223, 285, 46, 14);
		frame.getContentPane().add(cornerB);
		
		JLabel free_kickB = new JLabel("");
		free_kickB.setHorizontalAlignment(SwingConstants.CENTER);
		free_kickB.setBounds(223, 310, 46, 14);
		frame.getContentPane().add(free_kickB);
		
		JLabel win = new JLabel("");
		win.setHorizontalAlignment(SwingConstants.CENTER);
		win.setFont(new Font("Tahoma", Font.BOLD, 11));
		win.setBounds(100, 335, 136, 14);
		frame.getContentPane().add(win);
		
		JLabel Winner = new JLabel("");
		Winner.setHorizontalAlignment(SwingConstants.CENTER);
		Winner.setBounds(139, 367, 59, 14);
		frame.getContentPane().add(Winner);
		
		String data=Search.srch.getText();
		int flag=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/MatchSB","root","2000");
			Statement st=conn.createStatement();
			String sql1="SELECT * FROM sb Where date='"+data+"'";
			ResultSet rs=st.executeQuery(sql1);
			while(rs.next())
			{
				if(rs.getString("date").equals(data))
				{
				    String team_A = rs.getString("Teams");
				    teamA.setText(team_A);
				    String goal_A = rs.getString("Goals");
				    goalA.setText(goal_A);
				    String penalty_A = rs.getString("Penalty");
				    penaltyA.setText(penalty_A);
				    String red_card_A = rs.getString("Red_Card");
				    red_cardA.setText(red_card_A );
				    String yellow_card_A = rs.getString("Yellow_card");
				    yellow_cardA.setText(yellow_card_A);
				    String faul_A = rs.getString("Faul");
				    faulA.setText(faul_A);
				    String off_side_A = rs.getString("Off_Side");
				    off_sideA.setText(off_side_A);
				    String corner_A = rs.getString("Corner");
				    cornerA.setText(corner_A);
				    String free_kick_A = rs.getString("Free_Kick");
				    free_kickA.setText(free_kick_A);
				    
				    rs.next();
				    
				    String team_B = rs.getString("Teams");
				    teamB.setText(team_B);
				    String goal_B = rs.getString("Goals");
				    goalB.setText(goal_B);
				    String penalty_B = rs.getString("Penalty");
				    penaltyB.setText(penalty_B);
				    String red_card_B = rs.getString("Red_Card");
				    red_cardB.setText(red_card_B);
				    String yellow_card_B = rs.getString("Yellow_card");
				    yellow_cardB.setText(yellow_card_B);
				    String faul_B = rs.getString("Faul");
				    faulB.setText(faul_B);
				    String off_side_B = rs.getString("Off_Side");
				    off_sideB.setText(off_side_B);
				    String corner_B = rs.getString("Corner");
				    cornerB.setText(corner_B);
				    String free_kick_B = rs.getString("Free_Kick");
				    free_kickB.setText(free_kick_B);
				    
				    if(Integer.parseInt(goal_A)>Integer.parseInt(goal_B)){
				    	win.setText("Winner Team Is: ");
				    	Winner.setText(team_A);
				    	flag=1;
				    }
				    if(Integer.parseInt(goal_A)<Integer.parseInt(goal_B)) {
				    	win.setText("Winner Team Is: ");
				    	Winner.setText(team_B);
				    	flag=1;
				    }
				    if(Integer.parseInt(goal_A)==Integer.parseInt(goal_B)){
				    	win.setText("Match Is Draw");
				    	flag=1;
				    }
				}
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(null, "No Match held on This Date");
				win.setText("NO Data Found");
				conn.close();
			}
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
	public void showimg()
	{
		ImageIcon icon=new ImageIcon("C:/Users/Rushikesh/Downloads/download.jpg");
		Image img=icon.getImage();
		Image imgsc=img.getScaledInstance(label_9.getWidth(), label_9.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img2=new ImageIcon(imgsc);
		label_9.setIcon(img2);
		
		ImageIcon icon2=new ImageIcon("C:/Users/Rushikesh/Downloads/download1.jpg");
		Image img3=icon2.getImage();
		Image imgsc1=img3.getScaledInstance(label_13.getWidth(), label_13.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon img4=new ImageIcon(imgsc1);
		label_13.setIcon(img4);
	}
}
