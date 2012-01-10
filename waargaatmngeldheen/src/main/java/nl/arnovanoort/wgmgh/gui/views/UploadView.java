package nl.arnovanoort.wgmgh.gui.views;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Category;
import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.services.RekeningService;
import nl.arnovanoort.wgmgh.upload.UploadReciever;
import nl.arnovanoort.wgmgh.vaadin.components.RekeningNummerSelect;

import com.vaadin.addon.jpacontainer.EntityProvider;
import com.vaadin.addon.jpacontainer.JPAContainer;
import com.vaadin.addon.jpacontainer.fieldfactory.FieldFactory;
import com.vaadin.data.util.POJOContainer;
import com.vaadin.data.util.filter.IsNull;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Select;
import com.vaadin.ui.Table;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Button.ClickEvent;

@Named
public class UploadView extends Panel implements Button.ClickListener{

	private static final long serialVersionUID = 1328064205605134834L;

	// krijg dit niet geinjecteerd, mist default constructor..... uitzoeken
	// aha, spring vind het niet altijd leuk wanneer je tegen class aan  programmeert... MutatieMutableEntityProvider => EntityProvider
	@Inject
	EntityProvider<BankMutatie> bankMutatieBatchableLocalEntityProvider;

	@Inject
	EntityProvider<Category> categoryMutableLocalEntityProvider;

	@Inject
	private UploadReciever uploadReciever;;

	@Inject
	RekeningNummerSelect rekeningNummerSelect;
	

	JPAContainer<BankMutatie> bankMutatieContainer ;
	JPAContainer<Category> categoryContainer ;
	
	public UploadView create(){
		removeAllComponents();
        setCaption("Upload");
        setSizeFull();
        
        addComponent(rekeningNummerSelect);
        addComponent(createUpload());
		addComponent(createMutatiesTable());

		Button button = new Button("Opslaan");
		addComponent(button);
		
		return this;
	}
	
	private Upload createUpload(){
		uploadReciever.setRekeningNummerSelect(rekeningNummerSelect);
		Upload upload = new Upload("Bank bestand", uploadReciever);
		upload.addListener((Upload.SucceededListener) uploadReciever);
		upload.addListener((Upload.FailedListener) uploadReciever);
		return upload;
	}





	private Table createMutatiesTable() {
		Table mutatiesTable;

		bankMutatieContainer = new JPAContainer(BankMutatie.class);
        bankMutatieContainer.setEntityProvider(bankMutatieBatchableLocalEntityProvider);
        bankMutatieContainer.setWriteThrough(true);
//		bankMutatieContainer.setReadOnly(false);
//		bankMutatieContainer.setAutoCommit(true);

//        EntityContainer<BankMutatie> container = new JPAContainer<BankMutatie>(BankMutatie.class);
//        	container.setEntityProvider(mutatieMutableEntityProvider);
		mutatiesTable = new Table("mutatie", bankMutatieContainer);
//		mutatiesTable.setImmediate(false);
		mutatiesTable.setWriteThrough(false);
		mutatiesTable.setEditable(true); // anders kan geen select maar tekst en kan ik category niet aanpassen.
		mutatiesTable.setSelectable(false);
//		mutatiesTable.setReadThrough(false);
		mutatiesTable.setVisibleColumns(new Object[]{"transactieBedrag", "omschrijving", "transactieDatum", "category"});
		
		FieldFactory jpaContainerFieldFactory = new FieldFactory();
		jpaContainerFieldFactory.setSingleSelectType(Category.class, Select.class);
		mutatiesTable.setTableFieldFactory(jpaContainerFieldFactory);//FieldFactory(jpaContainerFieldFactory );
		
		bankMutatieContainer.addContainerFilter(new IsNull("category"));
		
		return mutatiesTable;
	}
	
	public void buttonClick(ClickEvent event) {
		bankMutatieContainer.commit();
		
	}

	public RekeningNummerSelect getRekeningNummerSelect() {
		return rekeningNummerSelect;
	}

	public void setRekeningNummerSelect(RekeningNummerSelect rekeningNummerSelect) {
		this.rekeningNummerSelect = rekeningNummerSelect;
	}

}
