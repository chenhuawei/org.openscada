/*******************************************************************************
 * Copyright (c) 2013 IBH SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation
 *******************************************************************************/
package org.openscada.configuration.opc;

import org.eclipse.scada.configuration.world.lib.NodeElementProcessor;
import org.eclipse.scada.configuration.world.lib.NodeElementProcessorFactory;
import org.eclipse.scada.configuration.world.ApplicationNode;
import org.eclipse.scada.configuration.world.World;

public class NodeElementProcessorFactoryImpl implements NodeElementProcessorFactory
{

    @Override
    public NodeElementProcessor createProcessor ( final Object element, final World world, final ApplicationNode applicationNode )
    {
        if ( element instanceof OpcDriver )
        {
            return new OpcDriverProcessor ( (OpcDriver)element );
        }
        return null;
    }

}
