import java.io.*;
import java.awt.*;
import org.jfree.chart.*;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.*;

public class PieChart {
    public static void main(String[] args) {
        String title = "老师情况统计";
        DefaultPieDataset piedata = new DefaultPieDataset();
        piedata.setValue("高级职称", 25.5);
        piedata.setValue("中级职称", 44.1);
        piedata.setValue("初级职称及其他", 33.4);
        JFreeChart chart = ChartFactory.createPieChart(title, piedata, true, true, true);
        chart.setTitle(new TextTitle(title, new Font("宋体", Font.ITALIC, 25)));
        chart.addSubtitle(new TextTitle("最后更新日期:2005年8月5日", new Font("宋体", Font.ITALIC, 20)));
        chart.setBackgroundPaint(Color.white);
        try {
            ChartUtilities.saveChartAsJPEG(new File("C:\\PieChart.jpg"), chart, 600, 600);
        } catch (IOException exz) {
            System.out.print("Can't Creat image File");
        }
    }
}
