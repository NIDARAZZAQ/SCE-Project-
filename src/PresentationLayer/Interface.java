package PresentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import LogicLayer.Bussiness_Logic;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class Interface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 494);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(Color.RED);
		textField.setBackground(Color.WHITE);
		textField.setBounds(296, 185, 233, 46);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Address Area");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel.setBounds(161, 185, 125, 46);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Upload Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String path=textField.getText();
				
				File Folder= new File(path);
				File[] files = Folder.listFiles();

						
						Bussiness_Logic f=new Bussiness_Logic();
					
		      			Bussiness_Logic.ReadXML(files);
						
					
				
				textField.setText("");
			}
		});
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 14));
		btnNewButton.setBounds(340, 295, 149, 39);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("SPELL CHECKER");
		lblNewLabel_1.setFont(new Font("Tempus Sans ITC", Font.BOLD, 29));
		lblNewLabel_1.setBounds(296, 66, 244, 51);
		contentPane.add(lblNewLabel_1);
	}
}
