package swing.chart.blankchart;

import java.awt.Graphics2D;

public abstract class BlankPlotChatRenders {


    public abstract String getLabelText(int index);

    public abstract void renderSeries(BlankPlotCharts chart, Graphics2D g2, SeriesSizes size, int index);
}
