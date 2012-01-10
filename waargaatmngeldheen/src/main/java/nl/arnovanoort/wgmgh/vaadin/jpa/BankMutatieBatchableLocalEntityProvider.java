package nl.arnovanoort.wgmgh.vaadin.jpa;

import javax.inject.Named;

import nl.arnovanoort.wgmgh.domain.BankMutatie;

import com.vaadin.addon.jpacontainer.provider.MutableLocalEntityProvider;

@Named
public class BankMutatieBatchableLocalEntityProvider extends AbstractBatchableEntityProvider<BankMutatie> {

	public BankMutatieBatchableLocalEntityProvider(){
		super(BankMutatie.class);
	}
}
