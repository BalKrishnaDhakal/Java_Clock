import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
public class StopWatchDemo {

	private JFrame frame;
	static int milliSeconds=0;
	static int seconds=0;
	static int minutes=0;
	static int hours=0;
	static boolean state = true;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StopWatchDemo window = new StopWatchDemo();
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
	public StopWatchDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.controlLtHighlight);
		frame.setBounds(100, 100, 492, 246);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHour = new JLabel("00:\t");
		lblHour.setForeground(UIManager.getColor("ProgressBar.selectionBackground"));
		lblHour.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHour.setBounds(10, 102, 88, 38);
		frame.getContentPane().add(lblHour);
		
		JLabel lblMinute = new JLabel("00:");
		lblMinute.setForeground(UIManager.getColor("ProgressBar.selectionBackground"));
		lblMinute.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMinute.setBounds(135, 102, 88, 38);
		frame.getContentPane().add(lblMinute);
		
		JLabel lblSecond = new JLabel("00:");
		lblSecond.setForeground(UIManager.getColor("ProgressBar.selectionBackground"));
		lblSecond.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSecond.setBounds(255, 102, 71, 38);
		JLabel lblMilliSecond = new JLabel("00:");
		lblMilliSecond.setForeground(UIManager.getColor("ProgressBar.selectionBackground"));
		lblMilliSecond.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblSecond);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				state= true;
				Thread thread = new Thread() {
					public void run() {
						for(;;) {
						if(state==true) {
							try {
								sleep(1);
								if(milliSeconds>1000) {
									milliSeconds=0;
									seconds++;
									
								}
								if(seconds>60) {
									milliSeconds=0;
									seconds=0;
									minutes++;
									
								}
								if(minutes>60) {
									milliSeconds=0;
									seconds=0;
									minutes=0;
									hours++;
									
									
								}
						        lblMilliSecond.setText(" :"+milliSeconds);
						        lblSecond.setText(" :"+seconds);
						        lblMinute.setText(" :"+minutes);
						        lblHour.setText(" :"+hours);
								milliSeconds++;
								
								
							}
							catch(Exception e) {
								
							}
							
						}
						else {
							break;
						}
							
						}
					}
				};
				thread.start();
			
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(0, 149, 186, 58);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state=false;
			}
		});
		btnStop.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnStop.setBounds(185, 149, 158, 58);
		frame.getContentPane().add(btnStop);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				state=false;
				hours=0;
				minutes=0;
				seconds=0;
				milliSeconds=0;
				lblHour.setText("00 : ");
				lblMinute.setText("00 : ");
				lblSecond.setText("00 : ");
				lblMilliSecond.setText("00");
			
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBounds(342, 149, 134, 58);
		frame.getContentPane().add(btnReset);
		
		
		lblMilliSecond.setBounds(368, 102, 77, 38);
		frame.getContentPane().add(lblMilliSecond);
		
		JLabel lblNewLabel = new JLabel("Hours");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 55, 66, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Minutes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(100, 55, 66, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Seconds");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(217, 55, 77, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Milli Seconds");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(342, 55, 94, 38);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("       Wellcome to my Awesome Clock");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(0, 0, 476, 49);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
