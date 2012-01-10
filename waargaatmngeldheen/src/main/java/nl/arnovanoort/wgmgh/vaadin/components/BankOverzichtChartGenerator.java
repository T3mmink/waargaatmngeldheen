package nl.arnovanoort.wgmgh.vaadin.components;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.dto.CategoryTotalAmountAndPercentage;
import nl.arnovanoort.wgmgh.services.CategoryService;
import nl.arnovanoort.wgmgh.vaadin.charts.InvientChartColorPicker;

import com.invient.vaadin.charts.Color;
import com.invient.vaadin.charts.Color.RGB;
import com.invient.vaadin.charts.InvientCharts;
import com.invient.vaadin.charts.InvientCharts.DecimalPoint;
import com.invient.vaadin.charts.InvientCharts.Series;
import com.invient.vaadin.charts.InvientCharts.SeriesType;
import com.invient.vaadin.charts.InvientCharts.XYSeries;
import com.invient.vaadin.charts.InvientChartsConfig;
import com.invient.vaadin.charts.InvientChartsConfig.GeneralChartConfig.Margin;
import com.invient.vaadin.charts.InvientChartsConfig.PieConfig;
import com.invient.vaadin.charts.InvientChartsConfig.PieDataLabel;
import com.invient.vaadin.charts.InvientChartsConfig.PointConfig;
import com.vaadin.ui.Component;


@Named("bankOverzichtChartGenerator")
public class BankOverzichtChartGenerator {

	@Inject
	CategoryService categoryService;
	
	@Inject
	InvientChartColorPicker chartColorPicker;
	
	public InvientCharts generateChart(Rekening rekening, Date datumVan, Date datumTot) {
		// generate data
		List<CategoryTotalAmountAndPercentage> totalAmountAndPercentage = categoryService.getCategoriesWithValuesAndPercentage(rekening, datumVan, datumTot);
		
		// create config and chart
		InvientChartsConfig chartConfig = createChartsConfig(rekening, datumVan, datumTot);
		InvientCharts chart = new InvientCharts(chartConfig);

		// create pie using vaste lasten data
		createVasteLastenChart(chart);

		// create pie using category data
		createExpensesPerCategoryChart(chart, totalAmountAndPercentage);

		return chart;
	}

	private void createExpensesPerCategoryChart(InvientCharts chart, List<CategoryTotalAmountAndPercentage> totalAmountAndPercentage) {
		LinkedHashSet<DecimalPoint> points;
		PieConfig pieCfg = new PieConfig();
		pieCfg.setInnerSize(150);
		pieCfg.setDataLabel(new PieDataLabel());
		pieCfg.setColor(new RGB(0, 0, 0));
		pieCfg.getDataLabel().setConnectorColor(new RGB(0, 0, 0));

		XYSeries series = new XYSeries("Uitgaven per categorie", SeriesType.PIE, pieCfg);
		points = new LinkedHashSet<DecimalPoint>();
		for(CategoryTotalAmountAndPercentage amountAndPercentage: totalAmountAndPercentage){
			points.add(getPointWithColor(series, amountAndPercentage.getCategory().getName(),amountAndPercentage.getPercentage(), chartColorPicker.nextColor()));
		}
		series.setSeriesPoints(points);

		chart.addSeries(series);
	}

	private void createVasteLastenChart(InvientCharts chart) {
		PieConfig pieCfg = new PieConfig();
		pieCfg.setInnerSize(65);
		pieCfg.setDataLabel(new PieDataLabel(false));

		XYSeries series = new XYSeries("Vaste lasten", SeriesType.PIE, pieCfg);
		LinkedHashSet<DecimalPoint> points = new LinkedHashSet<DecimalPoint>();
		points.add(getPointWithColor(series, "Firefox", new BigDecimal(44.2), new RGB(69, 114,167)));
		points.add(getPointWithColor(series, "IE", new BigDecimal(46.6), new RGB(170, 70, 67)));
		points.add(getPointWithColor(series, "Chrome", new BigDecimal(3.1), new RGB(137, 165,78)));
		points.add(getPointWithColor(series, "Safari", new BigDecimal(2.7), new RGB(128, 105,155)));
		points.add(getPointWithColor(series, "Opera", new BigDecimal(2.3), new RGB(128, 105,155)));
		points.add(getPointWithColor(series, "Mozilla", new BigDecimal(0.4), new RGB(219, 132,61)));
		series.setSeriesPoints(points);

		chart.addSeries(series);
	}

	private InvientChartsConfig createChartsConfig(Rekening rekening,
			Date datumVan, Date datumTot) {
		InvientChartsConfig chartConfig = new InvientChartsConfig();
		chartConfig.getGeneralChartConfig().setType(SeriesType.PIE);

		chartConfig.getGeneralChartConfig().setMargin(new Margin());
		chartConfig.getGeneralChartConfig().getMargin().setTop(50);
		chartConfig.getGeneralChartConfig().getMargin().setRight(0);
		chartConfig.getGeneralChartConfig().getMargin().setBottom(0);
		chartConfig.getGeneralChartConfig().getMargin().setLeft(0);
		//chartConfig.getGeneralChartConfig().setHeight(50);
		//chartConfig.getGeneralChartConfig().setWidth(50);
		chartConfig.getTitle().setText("Overzicht uitgaven rekeningnummer " + rekening.getRekeningNummer());
		chartConfig.getSubtitle().setText("Periode van " + datumVan + " tot " + datumTot);

		chartConfig.getTooltip().setFormatterJsFunc(
				"function() {"
						+ " return '<b>'+ this.series.name +'</b><br/>'+ "
						+ "     this.point.name +': '+ this.y +' %'; " + "}");
		return chartConfig;
	}

	private DecimalPoint getPointWithColor(Series series, String name,
			BigDecimal y, Color color) {
		DecimalPoint point = new DecimalPoint(series, name, y.doubleValue());
		point.setConfig(new PointConfig(color));
		return point;
	}

}
