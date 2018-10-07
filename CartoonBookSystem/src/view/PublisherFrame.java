package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.CategoryDAO;
import dao.PublisherDAO;
import dao.WriterDAO;
import model.Category;
import model.Publisher;
import model.Writer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PublisherFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textPubId;
	private JTextField textPubName;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;
	private JTextField textSearch;

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
					PublisherFrame frame = new PublisherFrame();
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
	public PublisherFrame() {
		setFrameIcon(new ImageIcon(PublisherFrame.class.getResource("/images48/category48.png")));
		setTitle("Publisher Management");
		setClosable(true);
		setBounds(100, 100, 551, 586);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Publisher Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 511, 94);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Publisher ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(39, 29, 116, 20);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Publisher Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(203, 29, 155, 20);
		panel.add(lblNewLabel_1);
		
		textPubId = new JTextField();
		textPubId.setEnabled(false);
		textPubId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPubId.setBounds(39, 52, 140, 25);
		panel.add(textPubId);
		textPubId.setColumns(10);
		
		textPubName = new JTextField();
		textPubName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPubName.setBounds(203, 52, 275, 25);
		panel.add(textPubName);
		textPubName.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Category Commands", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 120, 511, 82);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textPubName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"Please enter publisher name!", 
							"Information", 
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					String pubId = textPubId.getText().toString();
					String pubName = textPubName.getText().toString();
					
					Publisher publisher = new Publisher(pubId, pubName);
					PublisherDAO dao = new PublisherDAO();
					boolean result = dao.insert(publisher);
					if(result) {
						JOptionPane.showMessageDialog(null, 
								"Insert pubisher to table successfully.", 
								"Information", 
								JOptionPane.INFORMATION_MESSAGE);
						addDataToTable();
					}else {
						JOptionPane.showMessageDialog(null, 
								"Error in insert publisher!!!", 
								"Error", 
								JOptionPane.ERROR_MESSAGE);
					}
					clearText();
				}
			}
		});
		btnAdd.setIcon(new ImageIcon(PublisherFrame.class.getResource("/images32/add32.png")));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBounds(14, 21, 97, 45);
		panel_1.add(btnAdd);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(PublisherFrame.class.getResource("/images32/close32.png")));
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClose.setBounds(381, 21, 114, 45);
		panel_1.add(btnClose);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textPubName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"Please enter publisher name!", 
							"Information", 
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					String pubId = textPubId.getText().toString();
					String pubName = textPubName.getText().toString();
					
					Publisher publisher = new Publisher(pubId, pubName);
					PublisherDAO dao = new PublisherDAO();
					boolean result = dao.update(publisher);
					if(result) {
						JOptionPane.showMessageDialog(null, 
								"Update publisher to table successfully.", 
								"Information", 
								JOptionPane.INFORMATION_MESSAGE);
						addDataToTable();
					}else {
						JOptionPane.showMessageDialog(null, 
								"Error in update publisher!!!", 
								"Error", 
								JOptionPane.ERROR_MESSAGE);
					}
					clearText();
				}
			}
		});
		btnUpdate.setIcon(new ImageIcon(PublisherFrame.class.getResource("/images32/refresh32.png")));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(125, 21, 114, 45);
		panel_1.add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
		btnClear.setIcon(new ImageIcon(PublisherFrame.class.getResource("/images32/clear32.png")));
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClear.setBounds(253, 21, 114, 45);
		panel_1.add(btnClear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Show Categories", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 321, 511, 216);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 28, 487, 173);
		panel_2.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Category Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(12, 215, 511, 82);
		getContentPane().add(panel_3);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textSearch.getText().trim();
				addDataToTable(name);
				textSearch.setText("");
			}
		});
		btnSearch.setIcon(new ImageIcon(PublisherFrame.class.getResource("/images32/search32.png")));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBounds(385, 21, 114, 45);
		panel_3.add(btnSearch);
		
		JLabel lblCategoryName = new JLabel("Category Name");
		lblCategoryName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCategoryName.setBounds(23, 36, 116, 20);
		panel_3.add(lblCategoryName);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textSearch.setColumns(10);
		textSearch.setBounds(128, 33, 245, 25);
		panel_3.add(textSearch);
		
		generatePubId();
		prepareTable();
		addDataToTable();
	}

	@SuppressWarnings("rawtypes")
	protected void addDataToTable(String name) {
		int rows = table.getRowCount();
		if(rows > 0)
			removeDataFromTable();
		
		PublisherDAO dao = new PublisherDAO();
		Vector publishers = dao.selectByName(name);
		
		int size = publishers.size();
		for(int i=0; i<size; i++) {
			model.addRow((Vector) publishers.get(i));
		}
	}

	@SuppressWarnings({ "rawtypes" })
	private void addDataToTable() {
		int rows = table.getRowCount();
		if(rows > 0)
			removeDataFromTable();
		
		PublisherDAO dao = new PublisherDAO();
		Vector publishers = dao.selectAll();
		
		int size = publishers.size();
		for(int i=0; i<size; i++) {
			model.addRow((Vector) publishers.get(i));
		}
	}

	private void removeDataFromTable() {
		int rows = table.getRowCount();
		for(int i=0; i<rows; i++)
			model.removeRow(0);
	}

	private void prepareTable() {
		model = new DefaultTableModel();
		model.addColumn("Publisher ID");
		model.addColumn("Publisher Name");
		
		table = new JTable(model) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				int row = table.getSelectedRow();
				textPubId.setText(table.getValueAt(row, 0).toString());
				textPubName.setText(table.getValueAt(row, 1).toString());
				table.clearSelection();
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		
		table.getTableHeader().setReorderingAllowed(false);
		
		table.setFillsViewportHeight(true);
		scrollPane.add(table);
		scrollPane.setViewportView(table);
	}

	protected void clearText() {
		generatePubId();
		textPubName.setText("");
		addDataToTable();
	}

	private void generatePubId() {
		PublisherDAO dao = new PublisherDAO();
		textPubId.setText(dao.genPubId());
	}
}
