package nl.arnovanoort.wgmgh.vaadin.jpa;

import javax.inject.Named;

import nl.arnovanoort.wgmgh.domain.BankMutatie;
import nl.arnovanoort.wgmgh.domain.Category;

import com.vaadin.addon.jpacontainer.provider.MutableLocalEntityProvider;

@Named
public class CategoryMutableLocalEntityProvider extends AbstractBatchableEntityProvider<Category> {

	public CategoryMutableLocalEntityProvider(){
		super(Category.class);
	}
}
