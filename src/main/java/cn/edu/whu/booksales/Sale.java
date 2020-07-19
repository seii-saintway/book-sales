package cn.edu.whu.booksales;

public class Sale {
	private int intNumber;
	private Book pBook;
	private String strStaffName;
	private int intQuantity;

	public int getNumber() {
		return intNumber;
	}

	public void setNumber(int number) {
		intNumber = number;
	}

	public Book getBook() {
		return pBook;
	}

	public void setBook(Book p) {
		pBook = p;
	}

	public String getStaffName() {
		return strStaffName;
	}

	public void setStaffName(String staffName) {
		strStaffName = staffName;
	}

	public int getQuantity() {
		return intQuantity;
	}

	public void setQuantity(int quantity) {
		intQuantity = quantity;
	}

	public float getTotal() {
		return pBook.getValue()*intQuantity;
	}

	public String getCardCode() {
		return pBook.getCardCode();
	}

	public String getBookName() {
		return pBook.getBookName();
	}

	public float getValue() {
		return pBook.getValue();
	}
}
