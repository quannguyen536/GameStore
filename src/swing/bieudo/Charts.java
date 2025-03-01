package swing.bieudo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import swing.chart.blankchart.BlankPlotCharts;
import swing.chart.blankchart.BlankPlotChatRenders;
import swing.chart.blankchart.SeriesSizes;

public class Charts extends JPanel {

	   private List<ModelLegends> legends = new ArrayList<>();
	    private List<ModelCharts> model = new ArrayList<>();
	    private final int seriesSize = 40;
	    private final int seriesSpace = 6;
	    private final Animator animator;
	    private float animate;

	    public Charts() {
	        initComponents();
	        TimingTarget target = new TimingTargetAdapter() {
	            @Override
	            public void timingEvent(float fraction) {
	                animate = fraction;
	                repaint();
	            }
	        };
	        animator = new Animator(800, target);
	        animator.setResolution(0);
	        animator.setAcceleration(0.5f);
	        animator.setDeceleration(0.5f);
	        blankPlotCharts.setBlankPlotChatRender(new BlankPlotChatRenders() {
				
	            @Override
	            public String getLabelText(int index) {
	                return model.get(index).getLabel();
	            }

	            @Override
	            public void renderSeries(BlankPlotCharts chart, Graphics2D g2, SeriesSizes size, int index) {
	                double totalSeriesWidth = (seriesSize * legends.size()) + (seriesSpace * (legends.size() - 1));
	                double x = (size.getWidth() - totalSeriesWidth) / 2;
	                for (int i = 0; i < legends.size(); i++) {
	                    ModelLegends legend = legends.get(i);
	                    g2.setColor(legend.getColor());
	                    double seriesValues = chart.getSeriesValuesOf(model.get(index).getValues()[i], size.getHeight()) * animate;
	                    g2.fillRect((int) (size.getX() + x), (int) (size.getY() + size.getHeight() - seriesValues), seriesSize, (int) seriesValues);
	                    x += seriesSpace + seriesSize;
	                }
	            }
	        });
	    	setBackground(new Color(219, 239, 255));
	    }

	    public void addLegend(String name, Color color) {
	        ModelLegends data = new ModelLegends(name, color);
	        legends.add(data);
	        panelLegend.add(new LegendItems(data));
	        panelLegend.repaint();
	        panelLegend.revalidate();
	    }

	    public void addData(ModelCharts data) {
	        model.add(data);
	        blankPlotCharts.setLabelCount(model.size());
	        double max = data.getMaxValues();
	        if (max > blankPlotCharts.getMaxValues()) {
	            blankPlotCharts.setMaxValues(max);
	        }
	    }

	    public void clear() {
	        animate = 0;
	        blankPlotCharts.setLabelCount(0);
	        model.clear();
	        repaint();
	    }

	    public void start() {
	        if (!animator.isRunning()) {
	            animator.start();
	        }
	    }

	    @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	    private void initComponents() {

	        blankPlotCharts = new BlankPlotCharts();
	        panelLegend = new javax.swing.JPanel();

	        setBackground(new java.awt.Color(255, 255, 255));

	        panelLegend.setOpaque(false);
	        panelLegend.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(panelLegend, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
	                    .addComponent(blankPlotCharts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(blankPlotCharts, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
	                .addGap(0, 0, 0)
	                .addComponent(panelLegend, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	        );
	    }
	    private BlankPlotCharts blankPlotCharts;
	    private JPanel panelLegend;
}
