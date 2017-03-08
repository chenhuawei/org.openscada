/*******************************************************************************
 * Copyright (c) 2014, 2015 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.openscada.protocol.iec60870.client.data.testing;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openscada.protocol.iec60870.ProtocolOptions;
import org.openscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.openscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.openscada.protocol.iec60870.asdu.types.Value;
import org.openscada.protocol.iec60870.client.AutoConnectClient;
import org.openscada.protocol.iec60870.client.AutoConnectClient.ModulesFactory;
import org.openscada.protocol.iec60870.client.AutoConnectClient.State;
import org.openscada.protocol.iec60870.client.ClientModule;
import org.openscada.protocol.iec60870.client.data.DataHandler;
import org.openscada.protocol.iec60870.client.data.DataListener;
import org.openscada.protocol.iec60870.client.data.DataModule;
import org.openscada.protocol.iec60870.client.data.DataModuleOptions;
import org.openscada.protocol.iec60870.client.data.DataProcessor;

public class Application
{
    public static void main ( final String[] args ) throws Exception
    {
        final short port = 2404;

        final ProtocolOptions.Builder options = new ProtocolOptions.Builder ();

        final ExecutorService dataExecutor = Executors.newSingleThreadExecutor ();
        final DataHandler handler = new DataProcessor ( dataExecutor, new DataListener () {

            @Override
            public void started ()
            {
                System.out.println ( "DATA: Started" );
            }

            @Override
            public void update ( final ASDUAddress commonAddress, final InformationObjectAddress objectAddress, final Value<?> value )
            {
                System.out.format ( "DATA: %s-%s: %s%n", commonAddress, objectAddress, value );
            }

            @Override
            public void disconnected ()
            {
                System.out.println ( "DATA: Disconnected" );
            }
        } );
        final DataModule dataModule = new DataModule ( handler, new DataModuleOptions.Builder ().build () );

        final ModulesFactory modulesFactory = new ModulesFactory () {

            @Override
            public List<ClientModule> createModules ()
            {
                return Collections.singletonList ( (ClientModule)dataModule );
            }
        };

        final AutoConnectClient.StateListener listener = new AutoConnectClient.StateListener () {

            @Override
            public void stateChanged ( final State state, final Throwable e )
            {
                System.out.format ( "State: %s%n", state );
                if ( e != null )
                {
                    e.printStackTrace ();
                }
            }
        };

        try ( final AutoConnectClient client = new AutoConnectClient ( args[0], port, options.build (), modulesFactory, listener ) )
        {
            while ( true )
            {
                Thread.sleep ( 1_000 );
            }
        }
        finally
        {
            System.out.println ( "Exiting..." );
            System.out.flush ();
        }
    }
}
