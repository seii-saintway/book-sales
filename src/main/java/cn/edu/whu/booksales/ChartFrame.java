package cn.edu.whu.booksales;

// import java.awt.BorderLayout;
// import java.awt.Dimension;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.Font;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartFrame {
	private BookList bookList;
	private DefaultCategoryDataset bookData;

	private org.jfree.chart.ChartFrame mFrame;

	private JFreeChart mChart;

	public ChartFrame(BookList p) {
		bookList = p;
		bookData = new DefaultCategoryDataset();
	}

	public void setVisible() {
		mChart = null;
		for(int i = 0; i<bookList.size(); ++i) {
			Book book = bookList.get(i);
			bookData.addValue(100-book.getQuantity(), book.getCardCode(), "");
		}
		mChart = ChartFactory.createBarChart3D("CARDS SOLD", "Card Code", "Quantity",
			bookData, PlotOrientation.VERTICAL, true, true, true);
		mChart.getCategoryPlot().getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		mFrame = null;
		mFrame = new org.jfree.chart.ChartFrame("Quantity of Sales Chart", mChart, true);
		mFrame.pack();
		mFrame.setDefaultCloseOperation(mFrame.HIDE_ON_CLOSE);
		mFrame.setVisible(true);
	}
}
