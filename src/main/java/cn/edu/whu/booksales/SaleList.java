package cn.edu.whu.booksales;

import java.io.File;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class SaleList {
	public SaleList(){
		saleList = new ArrayList<Sale>();
	}

	public List<Sale> getList() {
		return saleList;
	}

	public Sale begin() {
		return saleList.get(0);
	}

	public Sale back() {
		return saleList.get(saleList.size()-1);
	}

	public void add(String strStaffName, Book pBook, int intQuantity) {
		Sale sale = new Sale();
		sale.setNumber(saleList.size()+1);
		sale.setBook(pBook);
		sale.setStaffName(strStaffName);
		sale.setQuantity(intQuantity);
		saleList.add(sale);
	}

	public void printData(BookList bookList) {
		Collections.sort(saleList, new SortByTotal());
		
		try {
			FileOutputStream fout = new FileOutputStream("sales.txt");
			fout.write(new String("").getBytes());
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file = new File("sales.txt");
		file.setWritable(true);
		
		try {
			BufferedWriter fout = new BufferedWriter(new FileWriter(file,true));
			
			int intQuantity = 0;
			float fTotal = 0;
			
			fout.write("                         图书销售统计");
			fout.newLine();
			fout.write("==================================================================");
			fout.newLine();
			for(int i = 0; i<bookList.size(); ++i) {
				fout.write( String.format("%1$4s%2$20s", bookList.get(i).getCardCode(), bookList.get(i).getBookName()) );
				fout.newLine();
				fout.write("==================================================================");
				fout.newLine();
				for(int j = 0; j<saleList.size(); ++j)
					if( bookList.get(i) == saleList.get(j).getBook() ) {
						Sale sale = saleList.get(j);
						intQuantity += sale.getQuantity();
						fTotal += sale.getTotal();
						String str = String.format( "     C%1$03d   %2$-20s%3$4d  @  $%4$8.2f  =  $%5$10.2f",
							sale.getNumber(), sale.getStaffName(), sale.getQuantity(), sale.getValue(), sale.getTotal() );
						fout.write( str );
						fout.newLine();
						fout.write( "==================================================================" );
						fout.newLine();
					}
			}
			fout.write("    总销量 :  " + intQuantity + "                              $ " + fTotal);
			fout.newLine();
			fout.write("==================================================================");
			fout.newLine();
			
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private List<Sale> saleList;
}
