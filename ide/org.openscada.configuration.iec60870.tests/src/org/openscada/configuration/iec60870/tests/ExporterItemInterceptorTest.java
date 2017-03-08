/**
 * Copyright (c) 2014 IBH SYSTEMS GmbH.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBH SYSTEMS GmbH - initial API and implementation and/or initial documentation
 * 
 */
package org.openscada.configuration.iec60870.tests;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.openscada.configuration.iec60870.ExporterItemInterceptor;
import org.openscada.configuration.iec60870.IEC60870Factory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Exporter Item Interceptor</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExporterItemInterceptorTest extends TestCase
{

    /**
     * The fixture for this Exporter Item Interceptor test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExporterItemInterceptor fixture = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static void main ( String[] args )
    {
        TestRunner.run ( ExporterItemInterceptorTest.class );
    }

    /**
     * Constructs a new Exporter Item Interceptor test case with the given name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ExporterItemInterceptorTest ( String name )
    {
        super ( name );
    }

    /**
     * Sets the fixture for this Exporter Item Interceptor test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected void setFixture ( ExporterItemInterceptor fixture )
    {
        this.fixture = fixture;
    }

    /**
     * Returns the fixture for this Exporter Item Interceptor test case.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ExporterItemInterceptor getFixture ()
    {
        return fixture;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
    @Override
    protected void setUp () throws Exception
    {
        setFixture ( IEC60870Factory.eINSTANCE.createExporterItemInterceptor () );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see junit.framework.TestCase#tearDown()
     * @generated
     */
    @Override
    protected void tearDown () throws Exception
    {
        setFixture ( null );
    }

} //ExporterItemInterceptorTest
