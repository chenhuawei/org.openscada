/**
 */
package org.openscada.configuration.snmp.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.scada.configuration.infrastructure.Device;

import org.eclipse.scada.configuration.world.Application;
import org.eclipse.scada.configuration.world.CommonDriver;
import org.eclipse.scada.configuration.world.Documentable;
import org.eclipse.scada.configuration.world.Driver;
import org.eclipse.scada.configuration.world.NamedDocumentable;

import org.openscada.configuration.snmp.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.openscada.configuration.snmp.SnmpPackage
 * @generated
 */
public class SnmpAdapterFactory extends AdapterFactoryImpl
{
    /**
     * The cached model package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected static SnmpPackage modelPackage;

    /**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SnmpAdapterFactory()
    {
        if (modelPackage == null)
        {
            modelPackage = SnmpPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object)
    {
        if (object == modelPackage)
        {
            return true;
        }
        if (object instanceof EObject)
        {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SnmpSwitch<Adapter> modelSwitch =
        new SnmpSwitch<Adapter>()
        {
            @Override
            public Adapter caseSnmpDriver(SnmpDriver object)
            {
                return createSnmpDriverAdapter();
            }
            @Override
            public Adapter caseSnmpDevice(SnmpDevice object)
            {
                return createSnmpDeviceAdapter();
            }
            @Override
            public Adapter caseMibsType(MibsType object)
            {
                return createMibsTypeAdapter();
            }
            @Override
            public Adapter caseStaticMibName(StaticMibName object)
            {
                return createStaticMibNameAdapter();
            }
            @Override
            public Adapter caseMibDir(MibDir object)
            {
                return createMibDirAdapter();
            }
            @Override
            public Adapter caseRecursiveMibDir(RecursiveMibDir object)
            {
                return createRecursiveMibDirAdapter();
            }
            @Override
            public Adapter caseDocumentable(Documentable object)
            {
                return createDocumentableAdapter();
            }
            @Override
            public Adapter caseNamedDocumentable(NamedDocumentable object)
            {
                return createNamedDocumentableAdapter();
            }
            @Override
            public Adapter caseApplication(Application object)
            {
                return createApplicationAdapter();
            }
            @Override
            public Adapter caseDriver(Driver object)
            {
                return createDriverAdapter();
            }
            @Override
            public Adapter caseCommonDriver(CommonDriver object)
            {
                return createCommonDriverAdapter();
            }
            @Override
            public Adapter caseDevice(Device object)
            {
                return createDeviceAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object)
            {
                return createEObjectAdapter();
            }
        };

    /**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target)
    {
        return modelSwitch.doSwitch((EObject)target);
    }


    /**
     * Creates a new adapter for an object of class '{@link org.openscada.configuration.snmp.SnmpDriver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.configuration.snmp.SnmpDriver
     * @generated
     */
    public Adapter createSnmpDriverAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.configuration.snmp.SnmpDevice <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.configuration.snmp.SnmpDevice
     * @generated
     */
    public Adapter createSnmpDeviceAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.configuration.snmp.MibsType <em>Mibs Type</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.configuration.snmp.MibsType
     * @generated
     */
    public Adapter createMibsTypeAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.configuration.snmp.StaticMibName <em>Static Mib Name</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.configuration.snmp.StaticMibName
     * @generated
     */
    public Adapter createStaticMibNameAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.configuration.snmp.MibDir <em>Mib Dir</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.configuration.snmp.MibDir
     * @generated
     */
    public Adapter createMibDirAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.openscada.configuration.snmp.RecursiveMibDir <em>Recursive Mib Dir</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.openscada.configuration.snmp.RecursiveMibDir
     * @generated
     */
    public Adapter createRecursiveMibDirAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Documentable <em>Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Documentable
     * @generated
     */
    public Adapter createDocumentableAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.NamedDocumentable <em>Named Documentable</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.NamedDocumentable
     * @generated
     */
    public Adapter createNamedDocumentableAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Application <em>Application</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Application
     * @generated
     */
    public Adapter createApplicationAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.Driver <em>Driver</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.Driver
     * @generated
     */
    public Adapter createDriverAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.world.CommonDriver <em>Common Driver</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.world.CommonDriver
     * @generated
     */
    public Adapter createCommonDriverAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link org.eclipse.scada.configuration.infrastructure.Device <em>Device</em>}'.
     * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @see org.eclipse.scada.configuration.infrastructure.Device
     * @generated
     */
    public Adapter createDeviceAdapter()
    {
        return null;
    }

    /**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter()
    {
        return null;
    }

} //SnmpAdapterFactory
