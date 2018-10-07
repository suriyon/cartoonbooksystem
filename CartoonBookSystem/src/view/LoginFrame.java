package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.UserDAO;
import model.User;

import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textUser;
	private JPasswordField textPassword;
	public boolean result = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			LoginFrame dialog = new LoginFrame();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/images32/adduser32.png")));
		setAlwaysOnTop(true);
		setTitle("Login Frame");
		setBounds(100, 100, 574, 411);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 556, 280);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images128/login128.png")));
			lblNewLabel.setBounds(175, 13, 195, 150);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Username");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(111, 176, 89, 16);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Password");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2.setBounds(111, 217, 89, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			textUser = new JTextField();
			textUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
			textUser.setBounds(212, 168, 211, 25);
			contentPanel.add(textUser);
			textUser.setColumns(10);
		}
		{
			textPassword = new JPasswordField();
			textPassword.setBounds(212, 214, 211, 25);
			contentPanel.add(textPassword);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 293, 556, 58);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton btnOK = new JButton("OK");
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String username = textUser.getText().toString();
						String password = new String(textPassword.getPassword());
						if(username.equals("") || password.equals("")) {
							JOptionPane.showMessageDialog(null, 
									"Please enter enter username and password!", 
									"Information", 
									JOptionPane.INFORMATION_MESSAGE);
							return;
						}else {
							User user = new User(username, password);
							UserDAO dao = new UserDAO();
							result = dao.checkUser(user);
							if(result) {
								JOptionPane.showMessageDialog(null, 
										"Your Welcome!, Admin", 
										"Information", 
										JOptionPane.INFORMATION_MESSAGE);
								dispose();
							}else {
								JOptionPane.showMessageDialog(null, 
										"Incorrect username and password!", 
										"Error", 
										JOptionPane.ERROR_MESSAGE);
								textPassword.setText("");
								textUser.setText("");
								return;
							}
						}
					}
				});
				btnOK.setIcon(new ImageIcon(LoginFrame.class.getResource("/images32/check32.png")));
				btnOK.setBounds(154, 5, 95, 40);
				btnOK.setActionCommand("OK");
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images32/close32.png")));
				btnCancel.setBounds(261, 5, 107, 40);
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}

}
