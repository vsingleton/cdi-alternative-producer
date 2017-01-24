package info.alternative;

import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

public class AltDynamicProducerExtension implements Extension {

    public void afterBean(final @Observes AfterBeanDiscovery afterBeanDiscovery) {
        afterBeanDiscovery.addBean(new AltDynamicShiftProducer());
    }

}

