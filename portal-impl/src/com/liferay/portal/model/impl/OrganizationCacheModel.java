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

package com.liferay.portal.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.Organization;

/**
 * The cache model class for representing Organization in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Organization
 * @generated
 */
public class OrganizationCacheModel implements CacheModel<Organization> {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{organizationId=");
		sb.append(organizationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", parentOrganizationId=");
		sb.append(parentOrganizationId);
		sb.append(", leftOrganizationId=");
		sb.append(leftOrganizationId);
		sb.append(", rightOrganizationId=");
		sb.append(rightOrganizationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", recursable=");
		sb.append(recursable);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", statusId=");
		sb.append(statusId);
		sb.append(", comments=");
		sb.append(comments);
		sb.append("}");

		return sb.toString();
	}

	public Organization toEntityModel() {
		OrganizationImpl organizationImpl = new OrganizationImpl();

		organizationImpl.setOrganizationId(organizationId);
		organizationImpl.setCompanyId(companyId);
		organizationImpl.setParentOrganizationId(parentOrganizationId);
		organizationImpl.setLeftOrganizationId(leftOrganizationId);
		organizationImpl.setRightOrganizationId(rightOrganizationId);

		if (name == null) {
			organizationImpl.setName(StringPool.BLANK);
		}
		else {
			organizationImpl.setName(name);
		}

		if (type == null) {
			organizationImpl.setType(StringPool.BLANK);
		}
		else {
			organizationImpl.setType(type);
		}

		organizationImpl.setRecursable(recursable);
		organizationImpl.setRegionId(regionId);
		organizationImpl.setCountryId(countryId);
		organizationImpl.setStatusId(statusId);

		if (comments == null) {
			organizationImpl.setComments(StringPool.BLANK);
		}
		else {
			organizationImpl.setComments(comments);
		}

		organizationImpl.resetOriginalValues();

		return organizationImpl;
	}

	public long organizationId;
	public long companyId;
	public long parentOrganizationId;
	public long leftOrganizationId;
	public long rightOrganizationId;
	public String name;
	public String type;
	public boolean recursable;
	public long regionId;
	public long countryId;
	public int statusId;
	public String comments;
}