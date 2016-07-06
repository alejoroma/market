package views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import controller.Action;
import controller.Controller;

public class DialogReport extends JDialog implements Printable{

	private static final long serialVersionUID = 1L;
	private JPanel panelConten;
	private JPanel panelCentro;
	private ChartPanel PanelGrafica;
	private JFreeChart grafica;
	private JFreeChart graficaMes;
	private JPanel panelDay;
	private DefaultCategoryDataset Datos1;
	private int day1 ,day2, day3,day4, day5,day6,day7;
	private ArrayList<Integer> valueShoping;
	private XYSeries series;
	
	public DialogReport(Controller controller) {
		setTitle("Report");
		setIconImage(new ImageIcon(getClass().getResource("/imgs/icon.png")).getImage());
		this.setModal(true);
		setSize(800, 600);
		setLayout(new GridLayout(1, 1));

		panelConten = new JPanel();
		panelConten.setOpaque(false);
		panelConten.setLayout(new BorderLayout());
		JScrollPane jScrollPane = new JScrollPane(panelConten);
		add(jScrollPane);

		panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(2, 1, 10, 10));
		panelCentro.setOpaque(false);
		panelConten.add(panelCentro, BorderLayout.CENTER);

		JPanel panelTitle = new JPanel();
		panelTitle.setLayout(new GridLayout(2, 1));
		panelConten.add(panelTitle,BorderLayout.NORTH);

		JLabel jlTitle = new JLabel("Sales Report");
		jlTitle.setHorizontalAlignment(SwingConstants.CENTER);
		jlTitle.setBounds(250, 50, 200, 50);
		jlTitle.setFont(new Font("Arial", Font.ITALIC, 30));
		panelTitle.add(jlTitle);

		JLabel jLabelImag = new JLabel(new ImageIcon(getClass().getResource("/imgs/logo.png")));
		jLabelImag.setBounds(250, 100, 300, 300);
		panelTitle.add(jLabelImag);
		
		Datos1 = new DefaultCategoryDataset();
		addReportDay();
		panelDay = new JPanel();
		PanelGrafica = new ChartPanel(grafica);
		panelDay.add(PanelGrafica);
		panelCentro.add(panelDay);
	
		
		series = new XYSeries("Product");
		reportGraficaMes();
		JPanel panelGraficaMes = new JPanel();
		panelCentro.add(panelGraficaMes);
		ChartPanel reportMes = new ChartPanel(graficaMes);
		panelGraficaMes.add(reportMes);

		JPanel panelImprimir = new JPanel();
		panelConten.add(panelImprimir, BorderLayout.PAGE_END);
		JButton button =  new JButton(new ImageIcon(getClass().getResource("/imgs/impresora.png")));
		button.setToolTipText("Imprimir reporte");
		button.setOpaque(false);
		button.setBorder(null);
		button.setContentAreaFilled(false);
		button.addActionListener(controller);
		button.setActionCommand(Action.TO_PRINT.name());
		panelImprimir.add(button,BorderLayout.PAGE_END);
	}
	
	public void refrechDates(int day1,int day2,int day3,int day4,int day5,int day6,int day7){
		this.day1 = day1;
		this.day2 = day2;
		this.day3 = day3;
		this.day4 = day4;
		this.day5 = day5;
		this.day6 = day6;
		this.day7 = day7;
		addReportDay();
	}

	//numero de productos vendidos por dia 
	public void  addReportDay(){
		Datos1.addValue(day1, "Negocio 1", "Monday");
		Datos1.addValue(day2, "Negocio 1", "Tuesday");
		Datos1.addValue(day3, "Negocio 1", "Wenesday");
		Datos1.addValue(day4, "Negocio 1", "Thursday");
		Datos1.addValue(day5, "Negocio 1", "Fryday");
		Datos1.addValue(day6, "Negocio 1", "Saturday");
		Datos1.addValue(day7, "Negocio 1", "Sunday");
		grafica = ChartFactory.createBarChart("Daily Sales","Dayds", "Sale", Datos1,PlotOrientation.VERTICAL, true, true, false);
	}
	
	public void refrechDatesMohtn(ArrayList<Integer> valueShoping){
		this.valueShoping = valueShoping;
	}
	
	//reporte de vntas mensuales dinero diario
	public void reportGraficaMes(){
		series.add(1, 0);
		series.add(30, 0);
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		graficaMes = ChartFactory.createXYLineChart("Monthly Sales", "Quantity Of Product", "Sales",
				dataset, PlotOrientation.VERTICAL,true, false,false);
	}

	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		if (pageIndex>0) 
			return NO_SUCH_PAGE;
		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate( pageFormat.getImageableX()+30, pageFormat.getImageableY()+30);
		g2d.scale(0.5, 0.5);
		panelCentro.printAll(graphics);
		return PAGE_EXISTS;

	}

	public void imprimirFile(){
		try {
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintable(this);
			boolean aceptar_impresion = job.printDialog();
			if (aceptar_impresion) {
				job.printDialog();
				job.print();
			}
		} catch (PrinterException ex) {
			JOptionPane.showMessageDialog(null, "ERROR DE IMPRESION","ERROR\n",JOptionPane.ERROR_MESSAGE);
		}
	}
}