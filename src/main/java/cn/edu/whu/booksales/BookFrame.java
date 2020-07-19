package cn.edu.whu.booksales;

import java.awt.BorderLayout;
// import java.awt.Dimension;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class BookFrame {
	private BookList bookList;

	private JDialog mDialog;

	private JScrollPane mScrollPane;
	private JTextArea mTextArea;

	public BookFrame(JFrame owner, BookList p) {
		bookList = p;
		
		initTextArea();
		initPanel();
		initDialog(owner);
	}

	public void setVisible() {
		mDialog.setVisible(true);
	}

	private void initDialog(JFrame owner) {
		mDialog = new JDialog(owner, "Cards");
		mDialog.setSize(480, 360);
		mDialog.setDefaultCloseOperation(mDialog.HIDE_ON_CLOSE);
		
		mDialog.setLayout(new BorderLayout());
		mDialog.add(mScrollPane);
	}

	private void initPanel() {
		mScrollPane = new JScrollPane(mTextArea);
	}

	private void initTextArea() {
		mTextArea = new JTextArea(19, 50);
		mTextArea.setFont(new Font("宋体", Font.PLAIN, 14));
		
		for(int i = 0; i<bookList.size(); ++i) {
			Book book = bookList.get(i);
			String str = String.format( "%1$5s     %2$s", book.getCardCode(), book.getBookName());
			for(int j = 0; j<30-book.getBookName().length()*2; ++j) str += " ";
			str += String.format( "$%1$8.2f%2$5d", book.getValue(), book.getQuantity() );
			mTextArea.setText( mTextArea.getText() + str + "\n" );
		}
	}
}
