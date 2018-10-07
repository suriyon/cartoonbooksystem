package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.Frame;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CartoonBookSystem extends JFrame {
	
	private static final long serialVersionUID = 5784040612999635467L;		
	private JPanel contentPane;
	private CategoryFrame categoryFrame = null;
	private MemberFrame memberFrame = null;
	private WriterFrame writerFrame = null;
	private PublisherFrame publisherFrame = null;
	private BookFrame bookFrame = null;
	private JDesktopPane desktopPane;
	private LoginFrame loginFrame = null;
	private TestLoginFrame testlogin = null;
	private JButton toolbarBookRental;
	private JMenu mnDataManagement;
	private JMenu mnSettings;
	private JButton toolbarMember;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartoonBookSystem frame = new CartoonBookSystem();
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
	public CartoonBookSystem() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CartoonBookSystem.class.getResource("/images48/cartoonbookslogo.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Cartoon Book System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 670);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnDataManagement = new JMenu("Data Management");
		mnDataManagement.setEnabled(false);
		menuBar.add(mnDataManagement);
		
		JMenuItem mntmCategory = new JMenuItem("Category");
		mntmCategory.setIcon(new ImageIcon(CartoonBookSystem.class.getResource("/images16/category.png")));
		mntmCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(categoryFrame == null || categoryFrame.isClosed()) {
					categoryFrame = new CategoryFrame();
					categoryFrame.setVisible(true);
					desktopPane.add(categoryFrame);
				}
			}
		});
		
		JMenuItem mntmBook = new JMenuItem("Book");
		mntmBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(bookFrame == null || bookFrame.isClosed()) {
					bookFrame = new BookFrame();
					bookFrame.setVisible(true);
					desktopPane.add(bookFrame);
				}
			}
		});
		mnDataManagement.add(mntmBook);
		mnDataManagement.add(mntmCategory);
		
		JMenuItem mntmWriter = new JMenuItem("Writer");
		mntmWriter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(writerFrame == null || writerFrame.isClosed()) {
					writerFrame = new WriterFrame();
					writerFrame.setVisible(true);
					desktopPane.add(writerFrame);
				}
			}
		});
		
		JMenuItem mntmPublisher = new JMenuItem("Publisher");
		mntmPublisher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(publisherFrame == null || publisherFrame.isClosed()) {
					publisherFrame = new PublisherFrame();
					publisherFrame.setVisible(true);
					desktopPane.add(publisherFrame);
				}
			}
		});
		mnDataManagement.add(mntmPublisher);
		mnDataManagement.add(mntmWriter);
		
		mnSettings = new JMenu("Settings");
		mnSettings.setEnabled(false);
		menuBar.add(mnSettings);
		
		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.setIcon(new ImageIcon(CartoonBookSystem.class.getResource("/images16/settings16.png")));
		mnSettings.add(mntmChangePassword);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnSettings.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton toolbarLogin = new JButton("Login");
		toolbarLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(toolbarLogin.getText().equals("Login")) {
					loginFrame = new LoginFrame();
					loginFrame.setModal(true);
					loginFrame.setLocationRelativeTo(null);
					loginFrame.setVisible(true);
					boolean result = loginFrame.result;
					if(result) {
						toolbarLogin.setText("Logout");
						toolbarLogin.setIcon(new ImageIcon(CartoonBookSystem.class.getResource("/images32/logout32.png")));
						toolbarBookRental.setEnabled(true);
						toolbarMember.setEnabled(true);
						mnDataManagement.setEnabled(true);
						mnSettings.setEnabled(true);
					}else {
						//System.out.println("Failure!");
					}
					
				}else if(toolbarLogin.getText().equals("Logout")) {
					toolbarLogin.setText("Login");
					toolbarLogin.setIcon(new ImageIcon(CartoonBookSystem.class.getResource("/images32/login32.png")));
					toolbarBookRental.setEnabled(false);
					toolbarMember.setEnabled(false);
					mnDataManagement.setEnabled(false);
					mnSettings.setEnabled(false);
				}
				
				
				
			}
		});
		toolbarLogin.setIcon(new ImageIcon(CartoonBookSystem.class.getResource("/images32/login32.png")));
		toolBar.add(toolbarLogin);
		
		JButton toolbarExit = new JButton("Exit");
		toolbarExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		toolbarBookRental = new JButton("Book Rental");
		toolbarBookRental.setEnabled(false);
		toolbarBookRental.setIcon(new ImageIcon(CartoonBookSystem.class.getResource("/images32/books32.png")));
		toolBar.add(toolbarBookRental);
		
		toolbarMember = new JButton("Member");
		toolbarMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(memberFrame == null || memberFrame.isClosed()) {
					memberFrame = new MemberFrame();
					memberFrame.setVisible(true);
					desktopPane.add(memberFrame);
				}
			}
		});
		toolbarMember.setEnabled(false);
		toolbarMember.setIcon(new ImageIcon(CartoonBookSystem.class.getResource("/images32/adduser32.png")));
		toolBar.add(toolbarMember);
		toolbarExit.setIcon(new ImageIcon(CartoonBookSystem.class.getResource("/images32/exit32.png")));
		toolBar.add(toolbarExit);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
	}
}
