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

package com.liferay.portal.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Image;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.base.ImageServiceBaseImpl;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.permission.DLFileEntryPermission;

/**
 * @author Brian Wing Shun Chan
 * @author Julio Camarero
 * @author Sergio González
 */
public class ImageServiceImpl extends ImageServiceBaseImpl {

	public Image getImage(long imageId)
		throws PortalException, SystemException {

		DLFileEntry fileEntry = dlFileEntryFinder.fetchByAnyImageId(imageId);

		if (fileEntry != null) {
			DLFileEntryPermission.check(
				getPermissionChecker(), fileEntry, ActionKeys.VIEW);
		}

		return imageLocalService.getImage(imageId);
	}

}