package nl.arnovanoort.wgmgh.vaadin.components;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import nl.arnovanoort.wgmgh.domain.Rekening;
import nl.arnovanoort.wgmgh.services.RekeningService;

import com.vaadin.data.util.POJOContainer;
import com.vaadin.ui.Select;

@Named
public class RekeningNummerSelect extends Select {

	//private RekeningService rekeningService;

	@Inject
	public RekeningNummerSelect(RekeningService rekeningService) {
		List<Rekening> rekeningen = rekeningService.getRekeningen("nobodyAtTheMoment");
		POJOContainer<Rekening> container = new POJOContainer<Rekening>(rekeningen, "rekeningHouder", "rekeningNummer");

		setCaption("Kies rekeningnummer");
		setContainerDataSource(container);
		setItemCaptionMode(Select.ITEM_CAPTION_MODE_PROPERTY);
		setItemCaptionPropertyId("rekeningNummer");

	}

}
