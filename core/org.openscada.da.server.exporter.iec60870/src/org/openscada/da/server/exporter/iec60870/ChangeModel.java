/*******************************************************************************
 * Copyright (c) 2016 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.openscada.da.server.exporter.iec60870;

import org.openscada.protocol.iec60870.asdu.types.ASDUAddress;
import org.openscada.protocol.iec60870.asdu.types.CauseOfTransmission;
import org.openscada.protocol.iec60870.asdu.types.InformationObjectAddress;
import org.openscada.protocol.iec60870.asdu.types.Value;

public interface ChangeModel
{
    public void notifyChange ( CauseOfTransmission cause, ASDUAddress asduAddress, InformationObjectAddress informationObjectAddress, final Value<?> value );

    public void dispose ();
}
