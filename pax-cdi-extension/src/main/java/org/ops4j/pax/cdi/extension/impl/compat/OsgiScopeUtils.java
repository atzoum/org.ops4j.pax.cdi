/*
 * Copyright 2014 Harald Wellmann.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.cdi.extension.impl.compat;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Utilities for dealing with prototype scope in OSGi 6.0 or higher.
 *
 * @author Harald Wellmann
 *
 */
public class OsgiScopeUtils {

    private OsgiScopeUtils() {
        // Hidden utility class constructor
    }

    /**
     * Creates a {@link ServiceObjectsWrapper} for the given bundle context and service reference.
     *
     * @param bc
     *            bundle context
     * @param serviceReference
     *            service reference
     * @return wrapper object, with type depending on the OSGi framework version
     */
    @SuppressWarnings("unchecked")
    public static <S> ServiceObjectsWrapper<S> createServiceObjectsWrapper(BundleContext bc, ServiceReference<S> serviceReference) {
        Osgi5ServiceObjectsWrapper wrapper = new Osgi5ServiceObjectsWrapper();
        wrapper.init(bc, serviceReference);
        return wrapper;
    }


}
