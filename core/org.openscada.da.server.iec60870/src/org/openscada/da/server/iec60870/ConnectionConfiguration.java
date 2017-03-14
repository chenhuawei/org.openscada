/*******************************************************************************
 * Copyright (c) 2014 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.openscada.da.server.iec60870;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openscada.protocol.iec60870.ProtocolOptions;
import org.openscada.protocol.iec60870.client.data.DataModuleOptions;

public class ConnectionConfiguration
{
    private final String host;

    private final int port;

    private final ProtocolOptions protocolOptions;

    private final DataModuleOptions dataModuleOptions;

    private final Map<String, CommandMessage> itemTypes;

    public ConnectionConfiguration ( final String host, final int port, final ProtocolOptions protocolOptions, final DataModuleOptions dataModuleOptions, final Map<String, CommandMessage> itemTypes )
    {
        this.host = host;
        this.port = port;
        this.protocolOptions = protocolOptions;
        this.dataModuleOptions = dataModuleOptions;
        this.itemTypes = new HashMap<> ( itemTypes );
    }

    public String getHost ()
    {
        return this.host;
    }

    public int getPort ()
    {
        return this.port;
    }

    public ProtocolOptions getProtocolOptions ()
    {
        return this.protocolOptions;
    }

    @Override
    public String toString ()
    {
        return String.format ( "[%s:%s]", this.host, this.port );
    }

    public DataModuleOptions getDataModuleOptions ()
    {
        return this.dataModuleOptions;
    }

    public Map<String, CommandMessage> getItemTypes ()
    {
        return Collections.unmodifiableMap ( itemTypes );
    }
}
