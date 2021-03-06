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

package com.liferay.portlet.social.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the social activity setting remote service. This utility wraps {@link com.liferay.portlet.social.service.impl.SocialActivitySettingServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivitySettingService
 * @see com.liferay.portlet.social.service.base.SocialActivitySettingServiceBaseImpl
 * @see com.liferay.portlet.social.service.impl.SocialActivitySettingServiceImpl
 * @generated
 */
public class SocialActivitySettingServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.portlet.social.service.impl.SocialActivitySettingServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static SocialActivitySettingService getService() {
		if (_service == null) {
			_service = (SocialActivitySettingService)PortalBeanLocatorUtil.locate(SocialActivitySettingService.class.getName());

			ReferenceRegistry.registerReference(SocialActivitySettingServiceUtil.class,
				"_service");
			MethodCache.remove(SocialActivitySettingService.class);
		}

		return _service;
	}

	public void setService(SocialActivitySettingService service) {
		MethodCache.remove(SocialActivitySettingService.class);

		_service = service;

		ReferenceRegistry.registerReference(SocialActivitySettingServiceUtil.class,
			"_service");
		MethodCache.remove(SocialActivitySettingService.class);
	}

	private static SocialActivitySettingService _service;
}