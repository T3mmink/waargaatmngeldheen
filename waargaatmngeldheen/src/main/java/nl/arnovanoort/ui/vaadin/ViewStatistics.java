package nl.arnovanoort.ui.vaadin;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.services.BankMutatieService;
import nl.arnovanoort.wgmgh.services.CategoryService;
import nl.arnovanoort.wgmgh.services.RekeningService;
import nl.arnovanoort.wgmgh.vaadin.components.BankOverzichtChartGenerator;

import com.invient.vaadin.charts.InvientCharts;
import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.POJOContainer;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.PopupDateField;
import com.vaadin.ui.VerticalLayout;

@Named
public class ViewStatistics extends CustomComponent {
	
	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private VerticalLayout verticalLayout_1;

	@AutoGenerated
	private VerticalLayout content;

	@AutoGenerated
	private VerticalLayout categoryDetailContainer;

	@AutoGenerated
	private HorizontalLayout spacer2;

	@AutoGenerated
	private HorizontalLayout invientChartsContainer;

	@AutoGenerated
	private HorizontalLayout spacer1;

	@AutoGenerated
	private Button generateStatistics;

	@AutoGenerated
	private GridLayout gridLayout_1;

	@AutoGenerated
	private ListSelect rekeningNummerSelect;

	@AutoGenerated
	private Label rekeningnummer;

	@AutoGenerated
	private PopupDateField datumTot;

	@AutoGenerated
	private Label datumTotLabel;

	@AutoGenerated
	private PopupDateField datumVan;

	@AutoGenerated
	private Label datumVanLabel;

	@AutoGenerated
	private Label label_1;

	@AutoGenerated
	private AbsoluteLayout menu;

	@AutoGenerated
	private Label menuItemUpload;

	@AutoGenerated
	private Label menuItemStatistieken;

	@AutoGenerated
	private AbsoluteLayout header2;

	@AutoGenerated
	private VerticalLayout titleholder;

	@AutoGenerated
	private Label subtitle;

	@AutoGenerated
	private Label title;

	@AutoGenerated
	private Embedded embedded_1;

	@AutoGenerated
	private HorizontalLayout filler;

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	



	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */



	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@Inject
	private RekeningService rekeningService;
	
	@Inject
	CategoryService categoryService;

	@Inject
	BankMutatieService bankMutatieService;
	
	@Inject
	BankOverzichtChartGenerator bankOverzichtChartGenerator;
	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */


	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */

	
	public CustomComponent create(){
		buildMainLayout();
		setCompositionRoot(mainLayout);

		List<Rekening> rekeningen = rekeningService.getRekeningen("nobodyAtTheMoment");
		POJOContainer<Rekening> container = new POJOContainer<Rekening>(rekeningen, "rekeningHouder", "rekeningNummer");

		setCaption("Kies rekeningnummer");
		rekeningNummerSelect.setContainerDataSource(container);
		
		generateStatistics.addListener( new Button.ClickListener() {
			
			public void buttonClick(ClickEvent event) {
//				List<BankMutatieSummaryForCategory> overzicht = bankMutatieService.getOverzichtPerCategory((Rekening)rekeningNummerSelect.getValue(), (Date)datumVan.getValue(), (Date)datumTot.getValue());
//				BeanItemContainer<BankMutatieSummaryForCategory> overzichtInBeanItemContainer = new BeanItemContainer<BankMutatieSummaryForCategory>(BankMutatieSummaryForCategory.class, overzicht);
//				statisticsTable.setContainerDataSource(overzichtInBeanItemContainer);
//				statisticsTable.setVisibleColumns(new Object[]{"category", "amount" });
				
				invientChartsContainer.removeAllComponents();
				InvientCharts chart = bankOverzichtChartGenerator.generateChart((Rekening)rekeningNummerSelect.getValue(), (Date)datumVan.getValue(), (Date)datumTot.getValue());
				invientChartsContainer.addComponent(chart);
				
				// create overview expenses per category
				List<Category> categories = categoryService.getCategories((Rekening)rekeningNummerSelect.getValue(),(Date)datumVan.getValue(), (Date)datumTot.getValue());
				for(Category category: categories){
					addCategoryOverview(category);
				}
			}

		});


		return this;
	}

	private void addCategoryOverview(Category category) {
		
		List<BankMutatie> mutaties = category.getBankMutaties();

		// CategoryDetailGrid
		GridLayout categoryDetailGrid = new GridLayout();
		categoryDetailGrid.setImmediate(false);
		categoryDetailGrid.setWidth("-1px");
		categoryDetailGrid.setHeight("-1px");
		categoryDetailGrid.setMargin(false);
		categoryDetailGrid.setColumns(3);
		categoryDetailGrid.setRows(mutaties.size() + 3);
		
		Label categoryLabel = new Label();
		categoryLabel.setStyleName("mutatiesHeader");
		categoryLabel.setImmediate(false);
		categoryLabel.setWidth("-1px");
		categoryLabel.setHeight("-1px");
		categoryLabel.setValue(category.getName());
		categoryDetailGrid.addComponent(categoryLabel, 0, 0);
		
		// start writing the first mutatie on row 3 of grid
		int mutatieCounter = 2;
		for(BankMutatie mutatie:mutaties){
			// datumVanLabel
			Label descriptionLabel = new Label();
			descriptionLabel.setStyleName("mutaties");
			descriptionLabel.setImmediate(false);
			descriptionLabel.setWidth("500");
			descriptionLabel.setHeight("-1px");
			descriptionLabel.setValue(mutatie.getOmschrijving());
			categoryDetailGrid.addComponent(descriptionLabel, 0, mutatieCounter);

			Label transactionAmountLabel = new Label();
			transactionAmountLabel.setStyleName("text");
			transactionAmountLabel.setImmediate(false);
			transactionAmountLabel.setWidth("100");
			transactionAmountLabel.setHeight("-1px");
			transactionAmountLabel.setValue(mutatie.getTransactieBedrag());
			categoryDetailGrid.addComponent(transactionAmountLabel, 1, mutatieCounter);
			
			mutatieCounter++;
		}
		categoryDetailContainer.addComponent(categoryDetailGrid);
		categoryDetailContainer.setComponentAlignment(categoryDetailGrid,new Alignment(48));

	}
 

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setStyleName("background");
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// verticalLayout_1
		verticalLayout_1 = buildVerticalLayout_1();
		mainLayout.addComponent(verticalLayout_1);
		mainLayout.setComponentAlignment(verticalLayout_1, new Alignment(20));
		
		return mainLayout;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_1() {
		// common part: create layout
		verticalLayout_1 = new VerticalLayout();
		verticalLayout_1.setStyleName("background");
		verticalLayout_1.setImmediate(false);
		verticalLayout_1.setWidth("800px");
		verticalLayout_1.setHeight("-1px");
		verticalLayout_1.setMargin(false);
		
		// filler
		filler = new HorizontalLayout();
		filler.setImmediate(false);
		filler.setWidth("760px");
		filler.setHeight("75px");
		filler.setMargin(true);
		filler.setSpacing(true);
		verticalLayout_1.addComponent(filler);
		verticalLayout_1.setComponentAlignment(filler, new Alignment(20));
		
		// header2
		header2 = buildHeader2();
		verticalLayout_1.addComponent(header2);
		verticalLayout_1.setComponentAlignment(header2, new Alignment(20));
		
		// menu
		menu = buildMenu();
		verticalLayout_1.addComponent(menu);
		verticalLayout_1.setComponentAlignment(menu, new Alignment(33));
		
		// content
		content = buildContent();
		verticalLayout_1.addComponent(content);
		verticalLayout_1.setComponentAlignment(content, new Alignment(20));
		
		return verticalLayout_1;
	}

	@AutoGenerated
	private AbsoluteLayout buildHeader2() {
		// common part: create layout
		header2 = new AbsoluteLayout();
		header2.setStyleName("header");
		header2.setImmediate(false);
		header2.setWidth("760px");
		header2.setHeight("150px");
		header2.setMargin(false);
		
		// embedded_1
		embedded_1 = new Embedded();
		embedded_1.setImmediate(false);
		embedded_1.setWidth("70px");
		embedded_1.setHeight("70px");
		embedded_1.setSource(new ThemeResource("img/evilmoney.jpg"));
		embedded_1.setType(1);
		embedded_1.setMimeType("image/png");
		header2.addComponent(embedded_1, "top:40.0px;left:45.0px;");
		
		// titleholder
		titleholder = buildTitleholder();
		header2.addComponent(titleholder,
				"top:59.0px;right:125.0px;left:128.0px;");
		
		return header2;
	}

	@AutoGenerated
	private VerticalLayout buildTitleholder() {
		// common part: create layout
		titleholder = new VerticalLayout();
		titleholder.setImmediate(false);
		titleholder.setWidth("100.0%");
		titleholder.setHeight("-1px");
		titleholder.setMargin(false);
		
		// title
		title = new Label();
		title.setStyleName("title");
		title.setImmediate(false);
		title.setWidth("84.28%");
		title.setHeight("30px");
		title.setValue("Waar gaat m'n geld heen");
		titleholder.addComponent(title);
		
		// subtitle
		subtitle = new Label();
		subtitle.setStyleName("subtitle");
		subtitle.setImmediate(false);
		subtitle.setWidth("-1px");
		subtitle.setHeight("-1px");
		subtitle.setValue("Geen idee");
		titleholder.addComponent(subtitle);
		
		return titleholder;
	}

	@AutoGenerated
	private AbsoluteLayout buildMenu() {
		// common part: create layout
		menu = new AbsoluteLayout();
		menu.setStyleName("menu");
		menu.setImmediate(false);
		menu.setWidth("800px");
		menu.setHeight("50px");
		menu.setMargin(false);
		
		// menuItemStatistieken
		menuItemStatistieken = new Label();
		menuItemStatistieken.setStyleName("menu-item");
		menuItemStatistieken.setImmediate(false);
		menuItemStatistieken.setWidth("-1px");
		menuItemStatistieken.setHeight("-1px");
		menuItemStatistieken.setValue("Statistieken");
		menu.addComponent(menuItemStatistieken, "top:18.0px;left:35.0px;");
		
		// menuItemUpload
		menuItemUpload = new Label();
		menuItemUpload.setStyleName("menu-item");
		menuItemUpload.setImmediate(false);
		menuItemUpload.setWidth("-1px");
		menuItemUpload.setHeight("-1px");
		menuItemUpload.setValue("Upload");
		menu.addComponent(menuItemUpload, "top:18.0px;right:567.0px;");
		
		return menu;
	}

	@AutoGenerated
	private VerticalLayout buildContent() {
		// common part: create layout
		content = new VerticalLayout();
		content.setStyleName("content");
		content.setImmediate(false);
		content.setWidth("760px");
		content.setHeight("-1px");
		content.setMargin(true);
		
		// label_1
		label_1 = new Label();
		label_1.setStyleName("header");
		label_1.setImmediate(false);
		label_1.setWidth("-1px");
		label_1.setHeight("-1px");
		label_1.setValue("Geef onder over welke periode en voor welk rekeningnummer je je uitgaven wil bekijken");
		content.addComponent(label_1);
		
		// gridLayout_1
		gridLayout_1 = buildGridLayout_1();
		content.addComponent(gridLayout_1);
		
		// generateStatistics
		generateStatistics = new Button();
		generateStatistics.setCaption("Genereer");
		generateStatistics.setImmediate(true);
		generateStatistics.setWidth("-1px");
		generateStatistics.setHeight("-1px");
		content.addComponent(generateStatistics);
		
		// spacer1
		spacer1 = new HorizontalLayout();
		spacer1.setImmediate(false);
		spacer1.setWidth("-1px");
		spacer1.setHeight("30px");
		spacer1.setMargin(false);
		content.addComponent(spacer1);
		
		// invientChartsContainer
		invientChartsContainer = new HorizontalLayout();
		invientChartsContainer.setImmediate(false);
		invientChartsContainer.setWidth("-1px");
		invientChartsContainer.setHeight("-1px");
		invientChartsContainer.setMargin(false);
		content.addComponent(invientChartsContainer);
		content.setComponentAlignment(invientChartsContainer, new Alignment(48));
		
		// spacer2
		spacer2 = new HorizontalLayout();
		spacer2.setImmediate(false);
		spacer2.setWidth("-1px");
		spacer2.setHeight("30px");
		spacer2.setMargin(false);
		content.addComponent(spacer2);
		
		// categoryDetailContainer
//		categoryDetailContainer = new VerticalLayout();
//		categoryDetailContainer.setImmediate(false);
//		categoryDetailContainer.setWidth("-1px");
//		categoryDetailContainer.setHeight("-1px");
//		categoryDetailContainer.setMargin(false);
//		content.addComponent(categoryDetailContainer);
//		content.setComponentAlignment(categoryDetailContainer,
//				new Alignment(20));
		
		return content;
	}

	@AutoGenerated
	private GridLayout buildGridLayout_1() {
		// common part: create layout
		gridLayout_1 = new GridLayout();
		gridLayout_1.setImmediate(false);
		gridLayout_1.setWidth("-1px");
		gridLayout_1.setHeight("-1px");
		gridLayout_1.setMargin(true);
		gridLayout_1.setSpacing(true);
		gridLayout_1.setColumns(2);
		gridLayout_1.setRows(5);
		
		// datumVanLabel
		datumVanLabel = new Label();
		datumVanLabel.setStyleName("text");
		datumVanLabel.setImmediate(false);
		datumVanLabel.setWidth("-1px");
		datumVanLabel.setHeight("-1px");
		datumVanLabel.setValue("Datum van");
		gridLayout_1.addComponent(datumVanLabel, 0, 0);
		
		// datumVan
		datumVan = new PopupDateField();
		datumVan.setImmediate(false);
		datumVan.setWidth("-1px");
		datumVan.setHeight("-1px");
		datumVan.setInvalidAllowed(false);
		datumVan.setResolution(4);
		gridLayout_1.addComponent(datumVan, 1, 0);
		
		// datumTotLabel
		datumTotLabel = new Label();
		datumTotLabel.setStyleName("text");
		datumTotLabel.setImmediate(false);
		datumTotLabel.setWidth("-1px");
		datumTotLabel.setHeight("-1px");
		datumTotLabel.setValue("Datum tot");
		gridLayout_1.addComponent(datumTotLabel, 0, 1);
		
		// datumTot
		datumTot = new PopupDateField();
		datumTot.setImmediate(false);
		datumTot.setWidth("-1px");
		datumTot.setHeight("-1px");
		datumTot.setInvalidAllowed(false);
		datumTot.setResolution(4);
		gridLayout_1.addComponent(datumTot, 1, 1);
		
		// rekeningnummer
		rekeningnummer = new Label();
		rekeningnummer.setImmediate(false);
		rekeningnummer.setWidth("-1px");
		rekeningnummer.setHeight("-1px");
		rekeningnummer.setValue("Rekeningnummer");
		gridLayout_1.addComponent(rekeningnummer, 0, 3);
		
		// rekeningNummerSelect
		rekeningNummerSelect = new ListSelect();
		rekeningNummerSelect.setImmediate(false);
		rekeningNummerSelect.setWidth("-1px");
		rekeningNummerSelect.setHeight("52px");
		gridLayout_1.addComponent(rekeningNummerSelect, 1, 3);
		
		return gridLayout_1;
	}


}