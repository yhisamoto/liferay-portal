/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.portal.service.http.LayoutSetBranchServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.portal.service.http.LayoutSetBranchServiceSoap
 * @generated
 */
public class LayoutSetBranchSoap implements Serializable {
	public static LayoutSetBranchSoap toSoapModel(LayoutSetBranch model) {
		LayoutSetBranchSoap soapModel = new LayoutSetBranchSoap();

		soapModel.setLayoutSetBranchId(model.getLayoutSetBranchId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPrivateLayout(model.getPrivateLayout());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setMaster(model.getMaster());

		return soapModel;
	}

	public static LayoutSetBranchSoap[] toSoapModels(LayoutSetBranch[] models) {
		LayoutSetBranchSoap[] soapModels = new LayoutSetBranchSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LayoutSetBranchSoap[][] toSoapModels(
		LayoutSetBranch[][] models) {
		LayoutSetBranchSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LayoutSetBranchSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LayoutSetBranchSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LayoutSetBranchSoap[] toSoapModels(
		List<LayoutSetBranch> models) {
		List<LayoutSetBranchSoap> soapModels = new ArrayList<LayoutSetBranchSoap>(models.size());

		for (LayoutSetBranch model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LayoutSetBranchSoap[soapModels.size()]);
	}

	public LayoutSetBranchSoap() {
	}

	public long getPrimaryKey() {
		return _layoutSetBranchId;
	}

	public void setPrimaryKey(long pk) {
		setLayoutSetBranchId(pk);
	}

	public long getLayoutSetBranchId() {
		return _layoutSetBranchId;
	}

	public void setLayoutSetBranchId(long layoutSetBranchId) {
		_layoutSetBranchId = layoutSetBranchId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getPrivateLayout() {
		return _privateLayout;
	}

	public boolean isPrivateLayout() {
		return _privateLayout;
	}

	public void setPrivateLayout(boolean privateLayout) {
		_privateLayout = privateLayout;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public boolean getMaster() {
		return _master;
	}

	public boolean isMaster() {
		return _master;
	}

	public void setMaster(boolean master) {
		_master = master;
	}

	private long _layoutSetBranchId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _privateLayout;
	private String _name;
	private String _description;
	private boolean _master;
}