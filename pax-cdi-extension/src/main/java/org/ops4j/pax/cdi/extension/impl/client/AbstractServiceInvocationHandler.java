package org.ops4j.pax.cdi.extension.impl.client;

import java.lang.reflect.InvocationHandler;

import javax.enterprise.inject.spi.InjectionPoint;

import org.ops4j.pax.cdi.extension.impl.util.InjectionPointOsgiUtils;
import org.osgi.framework.BundleContext;

/**
 * Common base class for static and dynamic service invocation handlers.
 *
 * @author Harald Wellmann
 *
 */
public abstract class AbstractServiceInvocationHandler implements InvocationHandler {

    protected InjectionPoint ip;
    protected BundleContext bundleContext;

    /**
     * Constructs an invocation handler for the given injection point.
     *
     * @param ip
     *            OSGi service injection point
     */
    protected AbstractServiceInvocationHandler(InjectionPoint ip) {
        this.ip = ip;
        this.bundleContext = InjectionPointOsgiUtils.getBundleContext(ip);
    }

    /**
     * Releases any resources held by this invocation handler.
     */
    public abstract void release();

}
