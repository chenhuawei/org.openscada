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
package org.openscada.protocol.iec60870.client.data;

import java.util.concurrent.Executor;

import org.openscada.protocol.iec60870.asdu.message.DoublePointInformationSequence;
import org.openscada.protocol.iec60870.asdu.message.DoublePointInformationSingle;
import org.openscada.protocol.iec60870.asdu.message.DoublePointInformationTimeSingle;
import org.openscada.protocol.iec60870.asdu.message.MeasuredValueNormalizedSequence;
import org.openscada.protocol.iec60870.asdu.message.MeasuredValueNormalizedSingle;
import org.openscada.protocol.iec60870.asdu.message.MeasuredValueNormalizedTimeSingle;
import org.openscada.protocol.iec60870.asdu.message.MeasuredValueScaledSequence;
import org.openscada.protocol.iec60870.asdu.message.MeasuredValueScaledSingle;
import org.openscada.protocol.iec60870.asdu.message.MeasuredValueScaledTimeSingle;
import org.openscada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointSequence;
import org.openscada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointSingle;
import org.openscada.protocol.iec60870.asdu.message.MeasuredValueShortFloatingPointTimeSingle;
import org.openscada.protocol.iec60870.asdu.message.SinglePointInformationSequence;
import org.openscada.protocol.iec60870.asdu.message.SinglePointInformationSingle;
import org.openscada.protocol.iec60870.asdu.message.SinglePointInformationTimeSingle;
import org.openscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.openscada.protocol.iec60870.asdu.types.DoublePoint;
import org.openscada.protocol.iec60870.asdu.types.InformationEntry;
import org.openscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.openscada.protocol.iec60870.asdu.types.QualifierOfInterrogation;
import org.openscada.protocol.iec60870.asdu.types.Value;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

public class DataProcessor implements DataHandler
{
    private final AttributeKey<Runnable> startTimersKey = AttributeKey.valueOf ( "startTimers" );

    private final DataListener listener;

    private final Executor executor;

    private boolean delayStart;

    private Runnable requestStartDataRunner;

    private Runnable interrogationRunner;

    public DataProcessor ( final Executor executor, final DataListener listener )
    {
        this.executor = executor;
        this.listener = listener;
        this.delayStart = false;
    }

    public DataProcessor ( Executor executor, DataListener dataListener, boolean delayStart )
    {
        this.executor = executor;
        this.listener = dataListener;
        this.delayStart = delayStart;
    }

    @Override
    public void activated ( final DataModuleContext dataModuleContext, final ChannelHandlerContext ctx )
    {
        // wrap both in closures, so we don't have to store it in a local field
        this.requestStartDataRunner = new Runnable () {
            @Override
            public void run ()
            {
                final Runnable startTimers = ctx.attr ( startTimersKey ).getAndRemove ();
                if ( startTimers != null )
                {
                    startTimers.run ();
                }
                dataModuleContext.requestStartData ();
            }
        };
        this.interrogationRunner = new Runnable () {
            @Override
            public void run ()
            {
                dataModuleContext.startInterrogation ( ASDUAddress.BROADCAST, QualifierOfInterrogation.GLOBAL );
            }
        };
        if ( !delayStart )
        {
            try
            {
                this.requestStartDataRunner.run ();
            }
            finally
            {
                this.requestStartDataRunner = null;
            }
        }
    }

    @Override
    public void started ()
    {
        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                DataProcessor.this.listener.started ();
            };
        } );
        if ( this.interrogationRunner != null )
        {
            try
            {
                this.interrogationRunner.run ();
            }
            finally
            {
                this.interrogationRunner = null;
            }
        }
    }

    @Override
    public void disconnected ()
    {
        this.requestStartDataRunner = null;
        this.interrogationRunner = null;

        this.executor.execute ( new Runnable () {
            @Override
            public void run ()
            {
                DataProcessor.this.listener.disconnected ();
            };
        } );
    }

    protected void fireEntry ( final ASDUAddress asduAddress, final InformationObjectAddress address, final Value<?> value )
    {
        this.executor.execute ( new Runnable () {

            @Override
            public void run ()
            {
                DataProcessor.this.listener.update ( asduAddress, address, value );
            }
        } );
    }

    @Override
    public void process ( final SinglePointInformationTimeSingle msg )
    {
        for ( final InformationEntry<Boolean> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final SinglePointInformationSingle msg )
    {
        for ( final InformationEntry<Boolean> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final SinglePointInformationSequence msg )
    {
        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<Boolean> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }

    @Override
    public void process ( final DoublePointInformationTimeSingle msg )
    {
        for ( final InformationEntry<DoublePoint> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final DoublePointInformationSingle msg )
    {
        for ( final InformationEntry<DoublePoint> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final DoublePointInformationSequence msg )
    {
        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<DoublePoint> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }

    @Override
    public void process ( final MeasuredValueShortFloatingPointTimeSingle msg )
    {
        for ( final InformationEntry<Float> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueShortFloatingPointSingle msg )
    {
        for ( final InformationEntry<Float> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueShortFloatingPointSequence msg )
    {
        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<Float> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }

    @Override
    public void process ( final MeasuredValueScaledTimeSingle msg )
    {
        for ( final InformationEntry<Short> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueScaledSingle msg )
    {
        for ( final InformationEntry<Short> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueScaledSequence msg )
    {
        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<Short> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }

    @Override
    public void process ( final MeasuredValueNormalizedTimeSingle msg )
    {
        for ( final InformationEntry<Double> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueNormalizedSingle msg )
    {
        for ( final InformationEntry<Double> entry : msg.getEntries () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), entry.getAddress (), entry.getValue () );
        }
    }

    @Override
    public void process ( final MeasuredValueNormalizedSequence msg )
    {
        int i = msg.getStartAddress ().getAddress ();

        for ( final Value<Double> value : msg.getValues () )
        {
            fireEntry ( msg.getHeader ().getAsduAddress (), InformationObjectAddress.valueOf ( i ), value );
            i++;
        }
    }

    @Override
    public void requestStartData ()
    {
        if ( this.requestStartDataRunner != null )
        {
            try
            {
                this.requestStartDataRunner.run ();
            }
            finally
            {
                this.requestStartDataRunner = null;
            }
        }
    }
}
