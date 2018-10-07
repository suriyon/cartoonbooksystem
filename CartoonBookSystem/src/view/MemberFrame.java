package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.CategoryDAO;
import dao.MemberDAO;
import model.Category;
import model.Member;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class MemberFrame extends JInternalFrame {
	private JTextField textMemId;
	private JTextField textMemName;
	private JTextField textMemTel;
	private JTextArea textMemAddr;
	private JTextField textSearch;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private JTable table;

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
					MemberFrame frame = new MemberFrame();
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
	public MemberFrame() {
		setFrameIcon(new ImageIcon(MemberFrame.class.getResource("/images48/adduser48.png")));
		setTitle("Member Frame");
		setClosable(true);
		setBounds(100, 100, 870, 631);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Member Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 622, 233);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Member ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(22, 24, 101, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Member Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(22, 94, 101, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Member Address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(270, 24, 117, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Member Telephone");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(22, 156, 145, 16);
		panel.add(lblNewLabel_3);
		
		textMemId = new JTextField();
		textMemId.setEnabled(false);
		textMemId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMemId.setBounds(22, 53, 214, 28);
		panel.add(textMemId);
		textMemId.setColumns(10);
		
		textMemName = new JTextField();
		textMemName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMemName.setColumns(10);
		textMemName.setBounds(22, 115, 214, 28);
		panel.add(textMemName);
		
		textMemTel = new JTextField();
		textMemTel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMemTel.setColumns(10);
		textMemTel.setBounds(22, 185, 214, 28);
		panel.add(textMemTel);
		
		textMemAddr = new JTextArea();
		textMemAddr.setLineWrap(true);
		textMemAddr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textMemAddr.setBorder(new LineBorder(Color.LIGHT_GRAY));
		textMemAddr.setBounds(270, 53, 324, 160);
		panel.add(textMemAddr);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Member Commands", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(646, 13, 196, 569);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textMemName.getText().equals("") ||
						textMemAddr.getText().equals("") ||
						textMemTel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"Please enter full infos!", 
							"Information", 
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					String memId = textMemId.getText().toString();
					String memName = textMemName.getText().toString();
					String memAddr = textMemAddr.getText().toString();
					String memTel = textMemTel.getText().toString();
					
					Member member = new Member(memId, memName, memAddr, memTel);
					MemberDAO dao = new MemberDAO();
					boolean result = dao.insert(member);
					if(result) {
						JOptionPane.showMessageDialog(null, 
								"Insert member to table successfully.", 
								"Information", 
								JOptionPane.INFORMATION_MESSAGE);
						addDataToTable();
					}else {
						JOptionPane.showMessageDialog(null, 
								"Error in insert member!!!", 
								"Error", 
								JOptionPane.ERROR_MESSAGE);
					}
					clearText();
				}
			}
		});
		btnAdd.setIcon(new ImageIcon(MemberFrame.class.getResource("/images32/add32.png")));
		btnAdd.setBounds(41, 44, 117, 46);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textMemName.getText().equals("") ||
						textMemAddr.getText().equals("") ||
						textMemTel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"Please enter full infos!", 
							"Information", 
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					String memId = textMemId.getText().toString();
					String memName = textMemName.getText().toString();
					String memAddr = textMemAddr.getText().toString();
					String memTel = textMemTel.getText().toString();
					
					Member member = new Member(memId, memName, memAddr, memTel);
					MemberDAO dao = new MemberDAO();
					boolean result = dao.update(member);
					if(result) {
						JOptionPane.showMessageDialog(null, 
								"Update member to table successfully.", 
								"Information", 
								JOptionPane.INFORMATION_MESSAGE);
						addDataToTable();
					}else {
						JOptionPane.showMessageDialog(null, 
								"Error in update member!!!", 
								"Error", 
								JOptionPane.ERROR_MESSAGE);
					}
					clearText();
				}
			}			
		});
		btnUpdate.setIcon(new ImageIcon(MemberFrame.class.getResource("/images32/refresh32.png")));
		btnUpdate.setBounds(41, 103, 117, 46);
		panel_1.add(btnUpdate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearText();
			}
		});
		btnClear.setIcon(new ImageIcon(MemberFrame.class.getResource("/images32/clear32.png")));
		btnClear.setBounds(41, 162, 117, 46);
		panel_1.add(btnClear);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(MemberFrame.class.getResource("/images32/close32.png")));
		btnClose.setBounds(41, 221, 117, 46);
		panel_1.add(btnClose);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Search Member", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 259, 622, 95);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("Member Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(41, 42, 101, 16);
		panel_2.add(label);
		
		textSearch = new JTextField();
		textSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textSearch.setColumns(10);
		textSearch.setBounds(141, 37, 301, 28);
		panel_2.add(textSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textSearch.getText().trim();
				addDataToTable(name);
				textSearch.setText("");
			}
		});
		btnSearch.setIcon(new ImageIcon(MemberFrame.class.getResource("/images32/search32.png")));
		btnSearch.setBounds(454, 28, 117, 46);
		panel_2.add(btnSearch);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Member Infos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 370, 622, 212);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 27, 598, 172);
		panel_3.add(scrollPane);
		
		
		generateMemId();
		prepareTable();
		addDataToTable();

	}

	protected void clearText() {
		// TODO Auto-generated method stub
		generateMemId();
		textMemName.setText("");
		textMemAddr.setText("");
		textMemTel.setText("");
		textSearch.setText("");
		//addDataToTable();
	}

	private void addDataToTable() {
		// TODO Auto-generated method stub
		int rows = table.getRowCount();
		if(rows > 0)
			removeDataFromTable();
		
		MemberDAO dao = new MemberDAO();
		Vector members = dao.selectAll();
		
		int size = members.size();
		for(int i=0; i<size; i++) {
			model.addRow((Vector) members.get(i));
		}
	}
	protected void addDataToTable(String name) {
		int rows = table.getRowCount();
		if(rows > 0)
			removeDataFromTable();
		
		MemberDAO dao = new MemberDAO();
		Vector members = dao.selectByName(name);
		
		int size = members.size();
		for(int i=0; i<size; i++) {
			model.addRow((Vector) members.get(i));
		}
	}

	private void removeDataFromTable() {
		int rows = table.getRowCount();
		for(int i=0; i<rows; i++)
			model.removeRow(0);
	}
	
	private void prepareTable() {
		// TODO Auto-generated method stub
		model = new DefaultTableModel();
		model.addColumn("Member ID");
		model.addColumn("Member Name");
		model.addColumn("Member Address");
		model.addColumn("Member Telephone");
		
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
				textMemId.setText(table.getValueAt(row, 0).toString());
				textMemName.setText(table.getValueAt(row, 1).toString());
				textMemAddr.setText(table.getValueAt(row, 2).toString());
				textMemTel.setText(table.getValueAt(row, 3).toString());
				table.clearSelection();
			}
		});
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.getColumnModel().getColumn(2).setPreferredWidth(600);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		
		table.getTableHeader().setReorderingAllowed(false);
		
		table.setFillsViewportHeight(true);
		scrollPane.add(table);
		scrollPane.setViewportView(table);
	}

	private void generateMemId() {
		// TODO Auto-generated method stub
		MemberDAO dao = new MemberDAO();
		textMemId.setText(dao.genMemId());
	}
}
