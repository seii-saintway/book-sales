package cn.edu.whu.booksales;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class BookSalesFrame {
	private BookList bookList;
	private SaleList saleList;

	private JFrame mainFrame;
	private BookFrame bookFrame;
	private ChartFrame chartFrame;

	private JPanel tPanel;
	private JPanel mPanel;
	private JPanel bPanel;
	private JPanel blPanel;
	private JPanel bl1Panel;
	private JPanel bl2Panel;
	private JPanel brPanel;
	private JPanel br1Panel;
	private JPanel br2Panel;

	private JButton t1Button;
	private JButton t2Button;
	private JButton t3Button;

	private JScrollPane mScrollPane;
	private JTextArea mTextArea;

	private JButton bl1Button;
	private JButton bl2Button;

	private JLabel brtLable;
	private JTextField brtTextField;

	private JLabel brmLable;
	private JTextField brmTextField;

	private JLabel brbLable;
	private JTextField brbTextField;

	public BookSalesFrame() {
		bookList = new BookList();
		saleList = new SaleList();
		
		bookFrame = new BookFrame(mainFrame, bookList);
		chartFrame = new ChartFrame(bookList);
		
		initTextArea();
		initButton();
		initLabel();
		initTextFiled();
		initPanel();
		initFrame();
		addListener();
		mainFrame.setVisible(true);
	}

	private void initFrame() {
		mainFrame = new JFrame("Books Orders");
		mainFrame.setSize(640, 480);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainFrame.setLayout(new BorderLayout());

		mainFrame.add(tPanel, BorderLayout.NORTH);
		mainFrame.add(mPanel);
		mainFrame.add(bPanel, BorderLayout.SOUTH);
	}

	private void initPanel() {
		tPanel = new JPanel();
		mPanel = new JPanel();
		bPanel = new JPanel();
		blPanel = new JPanel();
		brPanel = new JPanel();
		
		tPanel.setPreferredSize(new Dimension(0, 60));
		tPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 15));
		tPanel.add(t1Button);
		tPanel.add(t2Button);
		tPanel.add(t3Button);
		
		mScrollPane = new JScrollPane(mTextArea);
		mPanel.add(mScrollPane);
		
		bl1Panel = new JPanel();
		bl1Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		bl1Panel.add(bl1Button);
		
		bl2Panel = new JPanel();
		bl2Panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		bl2Panel.add(bl2Button);
		
		blPanel = new JPanel();
		blPanel.setLayout(new GridLayout(2, 1));
		blPanel.add(bl1Panel);
		blPanel.add(bl2Panel);
		
		br1Panel = new JPanel();
		br1Panel.setLayout(new GridLayout(3, 1, 0, 5));
		br1Panel.add(brtLable);
		br1Panel.add(brmLable);
		br1Panel.add(brbLable);
		
		br2Panel = new JPanel();
		br2Panel.setLayout(new GridLayout(3, 1, 0, 5));
		br2Panel.add(brtTextField);
		br2Panel.add(brmTextField);
		br2Panel.add(brbTextField);
		
		brPanel = new JPanel();
		brPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 5));
		brPanel.add(br1Panel);
		brPanel.add(br2Panel);
		
		bPanel.setPreferredSize(new Dimension(0, 100));
		bPanel.setLayout(new GridLayout(1, 2));
		bPanel.add(blPanel);
		bPanel.add(brPanel);
	}

	private void initButton() {
		t1Button = new JButton("Display Cards");
		t2Button = new JButton("Display Bar Chart");
		t3Button = new JButton("Sort, Print and Exit");
		
		bl1Button = new JButton("Process Sale");
		// bl1Button.setPreferredSize(new Dimension(110, 28));
		
		bl2Button = new JButton("Clear");
		// bl2Button.setPreferredSize(new Dimension(110, 28));
	}

	private void initLabel(){
		brtLable = new JLabel("Staff Name");
		brmLable = new JLabel("Card Code");
		brbLable = new JLabel("Quantity");
	}

	private void initTextFiled() {
		brtTextField = new JTextField();
		brtTextField.setPreferredSize(new Dimension(140, 23));

		brmTextField = new JTextField();
		brmTextField.setPreferredSize(new Dimension(140, 23));

		brbTextField = new JTextField();
		brbTextField.setPreferredSize(new Dimension(140, 23));
	}

	private void initTextArea() {
		mTextArea = new JTextArea(19, 85);
		mTextArea.setFont(new Font("Courier New", Font.PLAIN, 12));
	}

	private void addListener() {
		t1Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				bookFrame.setVisible();
			}

		});

		t2Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				chartFrame.setVisible();
			}

		});

		t3Button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				saleList.printData(bookList);
				System.exit(0);
			}

		});
		
		bl1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( brtTextField.getText().equals("") || brmTextField.getText().equals("") || brbTextField.getText().equals("") )
						JOptionPane.showMessageDialog(mainFrame, "Make sure all have been inputed", "ERROR", JOptionPane.ERROR_MESSAGE);
				else {
					Book book = bookList.findBook(brmTextField.getText());
					if( book == null ) {
						JOptionPane.showMessageDialog(mainFrame, "Make sure the Card Code is true", "ERROR", JOptionPane.ERROR_MESSAGE);
						return ;
					}
					if( book.getQuantity() < Integer.parseInt(brbTextField.getText()) ) {
						JOptionPane.showMessageDialog(mainFrame, "Make sure the Quantity is true", "ERROR", JOptionPane.ERROR_MESSAGE);
						return ;
					}
					book.setQuantity( book.getQuantity()-Integer.parseInt(brbTextField.getText()) );
					
					saleList.add( brtTextField.getText(), book, Integer.parseInt(brbTextField.getText()) );
					Sale sale = saleList.back();
					String str = String.format( "C%1$03d%2$10s   %3$-20s%4$4d  @   %5$8.2f   %6$10.2f",
						sale.getNumber(), sale.getCardCode(), sale.getStaffName(), sale.getQuantity(), sale.getValue(), sale.getTotal() );
					mTextArea.setText( mTextArea.getText() + str + "\n" );
					JOptionPane.showMessageDialog(mainFrame, "Add successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
					brtTextField.setText("");
					brmTextField.setText("");
					brbTextField.setText("");
				}
			}
		});
		
		bl2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brtTextField.setText("");
				brmTextField.setText("");
				brbTextField.setText("");
			}
		});
	}

	public static void main(String args[]) {
		new BookSalesFrame();
	}
}
