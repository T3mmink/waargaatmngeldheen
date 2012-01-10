package nl.arnovanoort.wgmgh.vaadin.jpa;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vaadin.addon.jpacontainer.provider.BatchableLocalEntityProvider;
import com.vaadin.addon.jpacontainer.provider.MutableLocalEntityProvider;

public abstract class AbstractBatchableEntityProvider<T>  extends 	MutableLocalEntityProvider<T> {

	@Inject
    protected AbstractBatchableEntityProvider(Class<T> entityClass) {
		super( entityClass);
	}
	
	@PersistenceContext
    private EntityManager em;


    @PostConstruct
    public void init() {
        setEntityManager(em);
        setEntitiesDetached(false);
		setTransactionsHandledByProvider(false);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateEntityProperty(Object entityId,
            String propertyName, Object propertyValue)
            throws IllegalArgumentException {
        super.updateEntityProperty(entityId, propertyName,
            propertyValue);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T updateEntity(final T entity) {
        return super.updateEntity(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T addEntity(final T entity) {
        return super.addEntity(entity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeEntity(Object entityId) {
        super.removeEntity(entityId);
    }
}