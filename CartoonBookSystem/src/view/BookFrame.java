package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import dao.WriterDAO;
import model.Writer;
import utils.ComboBoxItem;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class BookFrame extends JInternalFrame {
	private JTextField textBookId;
	private JTextField textBookName;
	private JTextField textBookPrice;
	private JTextField textPriceRent;
	private JTextField textBookTatal;
	private JTextField textBookRemain;
	private JTextField textBookRent;
	private JComboBox comboBoxWriter;
	private JComboBox comboBoxPublisher;
	private JComboBox comboBoxCategory;

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
					BookFrame frame = new BookFrame();
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
	public BookFrame() {
		setTitle("Book Management");
		setClosable(true);
		setBounds(100, 100, 1098, 695);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Book Data", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 1058, 210);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBookId = new JLabel("Book Id");
		lblBookId.setBounds(51, 37, 99, 16);
		panel.add(lblBookId);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(168, 37, 99, 16);
		panel.add(lblBookName);
		
		JLabel lblBookPrice = new JLabel("Book Price");
		lblBookPrice.setBounds(393, 37, 99, 16);
		panel.add(lblBookPrice);
		
		JLabel lblPriceRent = new JLabel("Price Rent");
		lblPriceRent.setBounds(504, 37, 99, 16);
		panel.add(lblPriceRent);
		
		JLabel lblBookRent = new JLabel("Book Rent");
		lblBookRent.setBounds(168, 103, 99, 16);
		panel.add(lblBookRent);
		
		JLabel lblBookTotal = new JLabel("Book Total");
		lblBookTotal.setBounds(615, 37, 99, 16);
		panel.add(lblBookTotal);
		
		JLabel lblBookRemain = new JLabel("Book Remain");
		lblBookRemain.setBounds(51, 103, 99, 16);
		panel.add(lblBookRemain);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(484, 103, 99, 16);
		panel.add(lblPublisher);
		
		JLabel lblWriter = new JLabel("Writer");
		lblWriter.setBounds(300, 103, 99, 16);
		panel.add(lblWriter);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(678, 103, 99, 16);
		panel.add(lblCategory);
		
		textBookId = new JTextField();
		textBookId.setBounds(51, 66, 99, 22);
		panel.add(textBookId);
		textBookId.setColumns(10);
		
		textBookName = new JTextField();
		textBookName.setColumns(10);
		textBookName.setBounds(168, 68, 210, 22);
		panel.add(textBookName);
		
		textBookPrice = new JTextField();
		textBookPrice.setColumns(10);
		textBookPrice.setBounds(393, 68, 99, 22);
		panel.add(textBookPrice);
		
		textPriceRent = new JTextField();
		textPriceRent.setColumns(10);
		textPriceRent.setBounds(504, 68, 99, 22);
		panel.add(textPriceRent);
		
		textBookTatal = new JTextField();
		textBookTatal.setColumns(10);
		textBookTatal.setBounds(615, 68, 99, 22);
		panel.add(textBookTatal);
		
		textBookRemain = new JTextField();
		textBookRemain.setColumns(10);
		textBookRemain.setBounds(51, 132, 99, 22);
		panel.add(textBookRemain);
		
		textBookRent = new JTextField();
		textBookRent.setColumns(10);
		textBookRent.setBounds(168, 132, 99, 22);
		panel.add(textBookRent);
		
		comboBoxWriter = new JComboBox();
		comboBoxWriter.setBounds(300, 132, 170, 22);
		panel.add(comboBoxWriter);
		
		comboBoxPublisher = new JComboBox();
		comboBoxPublisher.setBounds(484, 132, 182, 22);
		panel.add(comboBoxPublisher);
		
		comboBoxCategory = new JComboBox();
		comboBoxCategory.setBounds(678, 132, 170, 22);
		panel.add(comboBoxCategory);
		
		
		addWriterToComboBox();

	}

	private void addWriterToComboBox() {
		// TODO Auto-generated method stub
		if(comboBoxWriter.getItemCount() > 0) {
			comboBoxWriter.removeAllItems();
		}
		
		WriterDAO dao = new WriterDAO();
		List<Writer> writers = dao.select();
		
		for (Writer writer : writers) {
			comboBoxWriter.addItem(
					new ComboBoxItem(
							writer.getWriterId(), 
							writer.getWriterName()
						)
					);
		}
	}
}
