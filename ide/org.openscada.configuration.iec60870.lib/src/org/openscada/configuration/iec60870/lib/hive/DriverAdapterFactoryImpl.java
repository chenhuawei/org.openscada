/*******************************************************************************
 * Copyright (c) 2014, 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.openscada.configuration.iec60870.lib.hive;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.scada.configuration.infrastructure.lib.DriverHandler;
import org.openscada.configuration.iec60870.IEC60870Driver;

public class DriverAdapterFactoryImpl implements IAdapterFactory
{
    @Override
    public <T> T getAdapter ( final Object adaptableObject, final Class<T> adapterType )
    {
        if ( !DriverHandler.class.equals ( adapterType ) )
        {
            return null;
        }

        if ( adaptableObject instanceof IEC60870Driver )
        {
            return adapterType.cast ( new DriverHandlerImpl () );
        }
        return null;
    }

    @Override
    public Class<?>[] getAdapterList ()
    {
        return new Class<?>[] { DriverHandler.class };
    }

}
