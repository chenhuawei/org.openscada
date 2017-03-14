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
package org.openscada.protocol.iec60870.asdu.message;

import io.netty.buffer.ByteBuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openscada.protocol.iec60870.ProtocolOptions;
import org.openscada.protocol.iec60870.asdu.ASDUHeader;
import org.openscada.protocol.iec60870.asdu.types.ASDU;
import org.openscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.openscada.protocol.iec60870.asdu.types.InformationStructure;
import org.openscada.protocol.iec60870.asdu.types.TypeHelper;
import org.openscada.protocol.iec60870.asdu.types.Value;

@ASDU ( id = 9, name = "M_ME_NA_1", informationStructure = InformationStructure.SEQUENCE )
public class MeasuredValueNormalizedSequence extends AbstractMessage
{
    private final InformationObjectAddress startAddress;

    private final List<Value<Double>> values;

    private MeasuredValueNormalizedSequence ( final ASDUHeader header, final InformationObjectAddress startAddress, final List<Value<Double>> values )
    {
        super ( header );
        this.startAddress = startAddress;
        this.values = values;
    }

    public List<Value<Double>> getValues ()
    {
        return this.values;
    }

    public InformationObjectAddress getStartAddress ()
    {
        return this.startAddress;
    }

    public static MeasuredValueNormalizedSequence parse ( final ProtocolOptions options, final byte length, final ASDUHeader header, final ByteBuf data )
    {
        final InformationObjectAddress startAddress = InformationObjectAddress.parse ( options, data );

        final List<Value<Double>> values = new ArrayList<> ( length );
        for ( int i = 0; i < length; i++ )
        {
            values.add ( TypeHelper.parseNormalizedValue ( options, data, false ) );
        }

        return new MeasuredValueNormalizedSequence ( header, startAddress, values );
    }

    @Override
    public void encode ( final ProtocolOptions options, final ByteBuf out )
    {
        EncodeHelper.encodeHeader ( this, options, this.values.size (), this.header, out );

        this.startAddress.encode ( options, out );

        for ( final Value<Double> value : this.values )
        {
            TypeHelper.encodeNormalizedValue ( options, out, value, false );
        }
    }

    public static MeasuredValueNormalizedSequence create ( final InformationObjectAddress startAddress, final ASDUHeader header, final Value<Double> value )
    {
        return createInternal ( startAddress, header, Collections.singletonList ( value ) );
    }

    public static MeasuredValueNormalizedSequence create ( final InformationObjectAddress startAddress, final ASDUHeader header, final List<Value<Double>> values )
    {
        if ( values.size () > MAX_INFORMATION_ENTRIES )
        {
            throw new IllegalArgumentException ( String.format ( "A maximum of %s values can be transmitted", MAX_INFORMATION_ENTRIES ) );
        }
        return createInternal ( startAddress, header, new ArrayList<> ( values ) );
    }

    private static MeasuredValueNormalizedSequence createInternal ( final InformationObjectAddress startAddress, final ASDUHeader header, final List<Value<Double>> values )
    {
        return new MeasuredValueNormalizedSequence ( header, startAddress, values );
    }

}
