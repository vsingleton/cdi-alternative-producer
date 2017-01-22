package info.alternative;

import org.jboss.weld.manager.BeanManagerImpl;
import org.jboss.weld.bean.builtin.BeanManagerProxy;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

public class AltDynamicProducerExtension implements Extension {
    public void beforeBean(@Observes BeforeBeanDiscovery beforeBeanDiscovery, BeanManager beanManager) {
        
        BeanManagerImpl beanManagerImpl = ((BeanManagerProxy)beanManager).delegate();
        beanManagerImpl.addBean(new AltDynamicShiftProducer());
        
//        beforeBeanDiscovery.addAnnotatedType(beanManager.createAnnotatedType(AltDynamicShiftProducer.class), null);
    }
    
//    public void afterBean(final @Observes AfterBeanDiscovery afterBeanDiscovery) {
//        afterBeanDiscovery.addBean(new AltDynamicShiftProducer());
//    }
}

