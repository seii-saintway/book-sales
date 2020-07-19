package cn.edu.whu.booksales;

public class Book {
	private String strCardCode;
	private String strBookName;
	private float fValue;
	private int intQuantity;

	public String getCardCode() {
		return strCardCode;
	}

	public void setCardCode(String cardCode) {
		strCardCode = cardCode;
	}

	public String getBookName() {
		return strBookName;
	}

	public void setBookName(String bookName) {
		strBookName = bookName;
	}

	public float getValue() {
		return fValue;
	}

	public void setValue(float value) {
		fValue = value;
	}

	public int getQuantity() {
		return intQuantity;
	}

	public void setQuantity(int quantity) {
		intQuantity = quantity;
	}
}
