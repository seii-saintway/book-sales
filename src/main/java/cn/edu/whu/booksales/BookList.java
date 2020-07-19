package cn.edu.whu.booksales;

//import java.io.FileInputStream;
//import java.io.DataInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookList {
	public BookList() {
		bookList = new ArrayList<Book>();
		setAllBookList();
	}

	public List<Book> getList() {
		return bookList;
	}

	public Book get(int i) {
		return bookList.get(i);
	}

	public int size() {
		return bookList.size();
	}

	public Book findBook(String strCardCode) {
		for(int i = 0; i<bookList.size(); ++i)
			if(bookList.get(i).getCardCode().equals(strCardCode))
				return bookList.get(i);
		return null;
	}

	private List<Book> bookList;

	private void setAllBookList() {
		// DataInputStream din = new DataInputStream(new FileInputStream("book.txt"));
		File file = new File("books.txt");
		if(!file.exists()){
			return;
		}

		try {
			BufferedReader fin = new BufferedReader(new FileReader(file));
			String strLine;
			while( (strLine = fin.readLine()) != null ) {
				String[] str = strLine.split(" +");
				
				Book book = new Book();
				book.setCardCode(str[0]);
				book.setBookName(str[1]);
				book.setValue(Float.parseFloat(str[2]));
				book.setQuantity(100);
				bookList.add(book);
			}
			fin.close();
		} catch( FileNotFoundException e ) {
			e.printStackTrace();
		} catch( IOException e ) {
			e.printStackTrace();
		}
	}
}
