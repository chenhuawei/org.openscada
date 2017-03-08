/**
 */
package org.openscada.configuration.snmp.provider;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.provider.EcoreEditPlugin;
import org.eclipse.scada.configuration.globalization.provider.GlobalizeEditPlugin;

import org.eclipse.scada.configuration.infrastructure.provider.InfrastructureEditPlugin;

import org.eclipse.scada.configuration.script.provider.ScriptEditPlugin;
import org.eclipse.scada.configuration.security.provider.SecurityEditPlugin;

import org.eclipse.scada.configuration.world.provider.WorldEditPlugin;

import org.eclipse.scada.da.exec.configuration.provider.ExecEditPlugin;

/**
 * This is the central singleton for the Snmp edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class SnmpEditPlugin extends EMFPlugin
{
    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final SnmpEditPlugin INSTANCE = new SnmpEditPlugin();

    /**
     * Keep track of the singleton.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static Implementation plugin;

    /**
     * Create the instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SnmpEditPlugin()
    {
        super
          (new ResourceLocator [] 
           {
             ExecEditPlugin.INSTANCE,
             GlobalizeEditPlugin.INSTANCE,
             InfrastructureEditPlugin.INSTANCE,
             SecurityEditPlugin.INSTANCE,
             org.openscada.da.snmp.configuration.provider.SnmpEditPlugin.INSTANCE,
             WorldEditPlugin.INSTANCE,
             EcoreEditPlugin.INSTANCE,
             ScriptEditPlugin.INSTANCE,
           });
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    @Override
    public ResourceLocator getPluginResourceLocator()
    {
        return plugin;
    }

    /**
     * Returns the singleton instance of the Eclipse plugin.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the singleton instance.
     * @generated
     */
    public static Implementation getPlugin()
    {
        return plugin;
    }

    /**
     * The actual implementation of the Eclipse <b>Plugin</b>.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static class Implementation extends EclipsePlugin
    {
        /**
         * Creates an instance.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Implementation()
        {
            super();

            // Remember the static instance.
            //
            plugin = this;
        }
    }

}
