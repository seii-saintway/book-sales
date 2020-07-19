package cn.edu.whu.booksales;

import java.util.Comparator;

public class SortByTotal implements Comparator<Sale> {
	public int compare(Sale sale1, Sale sale2) {
		if(sale1.getTotal() < sale2.getTotal())
			return 1;
		else
			return 0;
	}
}
