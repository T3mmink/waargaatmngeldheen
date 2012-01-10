package nl.arnovanoort.ui.vaadin;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.vaadintest6.MyVaadinApplication;
import nl.arnovanoort.wgmgh.beans.BankMutatieSummaryForCategory;
import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.services.BankMutatieService;
import nl.arnovanoort.wgmgh.vaadin.components.RekeningNummerSelect;

import com.vaadin.addon.jpacontainer.EntityProvider;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.fieldfactory.FieldFactory;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.POJOContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button;
import com.vaadin.ui.Select;
import com.vaadin.ui.TableFieldFactory;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.TwinColSelect;

@Named
public class SearchView extends Panel implements Button.ClickListener  {
	
	DateField startDatum = new DateField();
	DateField eindDatum = new DateField();
	Button calculate = new Button("Bereken",this);

	@Inject
	RekeningNummerSelect rekeningNummerSelect;

	@Inject
	BankMutatieService bankMutatieService;
	
	Table overzichtTable = new Table();

	public SearchView create() {
        // remove all components. Needed when create is called 2x. Otherwise addComponent will add table again.
		removeAllComponents();
        setCaption("Search contacts2");
        setSizeFull();
        
        addComponent(startDatum);
        addComponent(eindDatum);
        addComponent(rekeningNummerSelect);
        addComponent(calculate);
        addComponent(overzichtTable);
        
        
		return this;
    }

	public void buttonClick(ClickEvent event) {
		List<BankMutatieSummaryForCategory> overzicht = bankMutatieService.getOverzichtPerCategory((Rekening)rekeningNummerSelect.getValue(), (Date)startDatum.getValue(), (Date)eindDatum.getValue());
		BeanItemContainer<BankMutatieSummaryForCategory> overzichtInBeanItemContainer = new BeanItemContainer<BankMutatieSummaryForCategory>(BankMutatieSummaryForCategory.class, overzicht);
		overzichtTable.setContainerDataSource(overzichtInBeanItemContainer);
		overzichtTable.setVisibleColumns(new Object[]{"category", "amount" });

	}

}