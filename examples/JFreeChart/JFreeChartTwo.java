import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFreeChartTwo {
    public static void main(String[] args) {
        String dataName[] = new String[] { "0-30岁", "30-50岁", "50-70岁", "70岁以上" };
        int dataValueCount[] = { 4, 5, 4, 6 };

        DefaultCategoryDataset categoryDataset = newDefaultCategoryDataset();
        for (int i = 0; i < dataName.length; i++)
            categoryDataset.addValue(dataValueCount[i], dataName[i], dataName[i]);

        String titleString = "用户年龄阶段分布统计图";
        JFreeChart chart = ChartFactory.createBarChart(titleString, "用户年龄阶段", "数量", categoryDataset,
                PlotOrientation.VERTICAL, true, true, false);
        ChartUtilities.writeChartAsJPEG(response.getOutputStream(), chart, 500, 300);
    }
}
