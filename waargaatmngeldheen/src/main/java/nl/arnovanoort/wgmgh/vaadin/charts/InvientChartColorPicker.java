package nl.arnovanoort.wgmgh.vaadin.charts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.invient.vaadin.charts.Color;
import com.invient.vaadin.charts.Color.RGB;

@Named("chartColorPicker")
public class InvientChartColorPicker {

	int counter = 0;
	List<RGB> colors = new ArrayList<RGB>();
	
	InvientChartColorPicker(){
		colors.add(new RGB(69, 114,167));
		colors.add(new RGB(170, 70, 67));
		colors.add(new RGB(137, 165,78));
		colors.add(new RGB(128, 105,155));
		colors.add(new RGB(128, 105,155));
		colors.add(new RGB(219, 132,61));
	}

	public Color nextColor() {
		if(counter == colors.size()){
			counter = 0;
		}
		return colors.get(counter++);
	}

	
}
