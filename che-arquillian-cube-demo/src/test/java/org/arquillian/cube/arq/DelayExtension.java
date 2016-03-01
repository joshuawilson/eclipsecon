package org.arquillian.cube.arq;

import org.arquillian.cube.spi.event.lifecycle.AfterStart;
import org.jboss.arquillian.core.api.annotation.Observes;
import org.jboss.arquillian.core.spi.LoadableExtension;

public class DelayExtension implements LoadableExtension {

    @Override
    public void register(ExtensionBuilder builder) {
        builder.observer(DelayAfterStart.class);
    }

    public static class DelayAfterStart {
        
        public void delay(@Observes AfterStart cube) throws Exception {
            Thread.sleep(6000);
        }
        
    }
}
