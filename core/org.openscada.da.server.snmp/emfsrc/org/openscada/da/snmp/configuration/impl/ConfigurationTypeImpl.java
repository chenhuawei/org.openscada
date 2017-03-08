/**
 * This file is part of the openSCADA project
 * 
 * Copyright (C) 2013 Jens Reimann (ctron@dentrassi.de)
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openscada.da.snmp.configuration.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.openscada.da.snmp.configuration.ConfigurationPackage;
import org.openscada.da.snmp.configuration.ConfigurationType;
import org.openscada.da.snmp.configuration.ConnectionType;
import org.openscada.da.snmp.configuration.MibsType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openscada.da.snmp.configuration.impl.ConfigurationTypeImpl#getMibs <em>Mibs</em>}</li>
 *   <li>{@link org.openscada.da.snmp.configuration.impl.ConfigurationTypeImpl#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationTypeImpl extends MinimalEObjectImpl.Container
		implements ConfigurationType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "This file is part of the openSCADA project\n\nCopyright (C) 2013 Jens Reimann (ctron@dentrassi.de)\n\nopenSCADA is free software: you can redistribute it and/or modify\nit under the terms of the GNU Lesser General Public License version 3\nonly, as published by the Free Software Foundation.\n\nopenSCADA is distributed in the hope that it will be useful,\nbut WITHOUT ANY WARRANTY; without even the implied warranty of\nMERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\nGNU Lesser General Public License version 3 for more details\n(a copy is included in the LICENSE file that accompanied this code).\n\nYou should have received a copy of the GNU Lesser General Public License\nversion 3 along with openSCADA. If not, see\n<http://opensource.org/licenses/lgpl-3.0.html> for a copy of the LGPLv3 License."; //$NON-NLS-1$

	/**
	 * The cached value of the '{@link #getMibs() <em>Mibs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMibs()
	 * @generated
	 * @ordered
	 */
	protected MibsType mibs;

	/**
	 * The cached value of the '{@link #getConnection() <em>Connection</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnection()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectionType> connection;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ConfigurationPackage.Literals.CONFIGURATION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MibsType getMibs() {
		return mibs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMibs(MibsType newMibs,
			NotificationChain msgs) {
		MibsType oldMibs = mibs;
		mibs = newMibs;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET,
					ConfigurationPackage.CONFIGURATION_TYPE__MIBS, oldMibs,
					newMibs);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMibs(MibsType newMibs) {
		if (newMibs != mibs) {
			NotificationChain msgs = null;
			if (mibs != null)
				msgs = ((InternalEObject) mibs)
						.eInverseRemove(
								this,
								EOPPOSITE_FEATURE_BASE
										- ConfigurationPackage.CONFIGURATION_TYPE__MIBS,
								null, msgs);
			if (newMibs != null)
				msgs = ((InternalEObject) newMibs)
						.eInverseAdd(
								this,
								EOPPOSITE_FEATURE_BASE
										- ConfigurationPackage.CONFIGURATION_TYPE__MIBS,
								null, msgs);
			msgs = basicSetMibs(newMibs, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ConfigurationPackage.CONFIGURATION_TYPE__MIBS, newMibs,
					newMibs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectionType> getConnection() {
		if (connection == null) {
			connection = new EObjectContainmentEList<ConnectionType>(
					ConnectionType.class, this,
					ConfigurationPackage.CONFIGURATION_TYPE__CONNECTION);
		}
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ConfigurationPackage.CONFIGURATION_TYPE__MIBS:
			return basicSetMibs(null, msgs);
		case ConfigurationPackage.CONFIGURATION_TYPE__CONNECTION:
			return ((InternalEList<?>) getConnection()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case ConfigurationPackage.CONFIGURATION_TYPE__MIBS:
			return getMibs();
		case ConfigurationPackage.CONFIGURATION_TYPE__CONNECTION:
			return getConnection();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case ConfigurationPackage.CONFIGURATION_TYPE__MIBS:
			setMibs((MibsType) newValue);
			return;
		case ConfigurationPackage.CONFIGURATION_TYPE__CONNECTION:
			getConnection().clear();
			getConnection().addAll(
					(Collection<? extends ConnectionType>) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case ConfigurationPackage.CONFIGURATION_TYPE__MIBS:
			setMibs((MibsType) null);
			return;
		case ConfigurationPackage.CONFIGURATION_TYPE__CONNECTION:
			getConnection().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case ConfigurationPackage.CONFIGURATION_TYPE__MIBS:
			return mibs != null;
		case ConfigurationPackage.CONFIGURATION_TYPE__CONNECTION:
			return connection != null && !connection.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ConfigurationTypeImpl
