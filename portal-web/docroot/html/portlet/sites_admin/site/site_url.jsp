<%--
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
--%>

<%@ include file="/html/portlet/sites_admin/init.jsp" %>

<%
Group liveGroup = (Group)request.getAttribute("site.liveGroup");
Long liveGroupId = (Long)request.getAttribute("site.liveGroupId");
Group stagingGroup = (Group)request.getAttribute("site.stagingGroup");
Long stagingGroupId = (Long)request.getAttribute("site.stagingGroupId");

LayoutSet publicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(liveGroupId, false);
LayoutSet privateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(liveGroupId, true);

String publicVirtualHost = ParamUtil.getString(request, "publicVirtualHost", BeanParamUtil.getString(publicLayoutSet, request, "virtualHostname"));
String privateVirtualHost = ParamUtil.getString(request, "privateVirtualHost", BeanParamUtil.getString(privateLayoutSet, request, "virtualHostname"));
%>

<c:choose>
	<c:when test="<%= windowState.equals(LiferayWindowState.POP_UP) %>">
		<div class="portlet-msg-alert">
			<liferay-ui:message key="this-operation-can-only-be-performed-from-the-control-panel" />
		</div>
	</c:when>
	<c:otherwise>
		<liferay-ui:error-marker key="errorSection" value="siteUrl" />

		<aui:model-context bean="<%= liveGroup %>" model="<%= Group.class %>" />

		<liferay-ui:error exception="<%= GroupFriendlyURLException.class %>">

			<%
			GroupFriendlyURLException gfurle = (GroupFriendlyURLException)errorException;
			%>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.ADJACENT_SLASHES %>">
				<liferay-ui:message key="please-enter-a-friendly-url-that-does-not-have-adjacent-slashes" />
			</c:if>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DOES_NOT_START_WITH_SLASH %>">
				<liferay-ui:message key="please-enter-a-friendly-url-that-begins-with-a-slash" />
			</c:if>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.DUPLICATE %>">
				<liferay-ui:message key="please-enter-a-unique-friendly-url" />
			</c:if>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.ENDS_WITH_SLASH %>">
				<liferay-ui:message key="please-enter-a-friendly-url-that-does-not-end-with-a-slash" />
			</c:if>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.INVALID_CHARACTERS %>">
				<liferay-ui:message key="please-enter-a-friendly-url-with-valid-characters" />
			</c:if>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.KEYWORD_CONFLICT %>">
				<%= LanguageUtil.format(pageContext, "please-enter-a-friendly-url-that-does-not-conflict-with-the-keyword-x", gfurle.getKeywordConflict()) %>
			</c:if>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.POSSIBLE_DUPLICATE %>">
				<liferay-ui:message key="the-friendly-url-may-conflict-with-another-page" />
			</c:if>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.TOO_DEEP %>">
				<liferay-ui:message key="the-friendly-url-has-too-many-slashes" />
			</c:if>

			<c:if test="<%= gfurle.getType() == GroupFriendlyURLException.TOO_SHORT %>">
				<liferay-ui:message key="please-enter-a-friendly-url-that-is-at-least-two-characters-long" />
			</c:if>
		</liferay-ui:error>

		<liferay-ui:error exception="<%= LayoutSetVirtualHostException.class %>">
			<liferay-ui:message key="please-enter-a-unique-virtual-host" />

			<liferay-ui:message key="virtual-hosts-must-be-valid-domain-names" />
		</liferay-ui:error>

		<aui:fieldset label="friendly-url">
			<liferay-ui:message key="enter-the-friendly-url-that-will-be-used-by-both-public-and-private-pages" />

			<liferay-ui:message arguments="<%= new Object[] {publicVirtualHost + themeDisplay.getPathFriendlyURLPublic(), themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPrivateGroup()} %>" key="the-friendly-url-is-appended-to-x-for-public-pages-and-x-for-private-pages" />

			<aui:input label="" name="friendlyURL" />
		</aui:fieldset>

		<aui:fieldset label="virtual-hosts">
			<liferay-ui:message key="enter-the-public-and-private-virtual-host-that-will-map-to-the-public-and-private-friendly-url" />

			<liferay-ui:message arguments="<%= new Object[] {HttpUtil.getProtocol(request), themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic()} %>" key="for-example,-if-the-public-virtual-host-is-www.helloworld.com-and-the-friendly-url-is-/helloworld" />

			<aui:input label="public-pages" name="publicVirtualHost" type="text" value="<%= publicVirtualHost %>" />

			<aui:input label="private-pages" name="privateVirtualHost" type="text" value="<%= privateVirtualHost %>">
				<aui:validator errorMessage="please-enter-a-unique-virtual-host" name="custom">
					function(val, fieldNode, ruleValue) {
						return (val != A.one('#<portlet:namespace />publicVirtualHost').val());
					}
				</aui:validator>
			</aui:input>
		</aui:fieldset>

		<aui:script use="aui-base">
			var friendlyURL = A.one('#<portlet:namespace />friendlyURL');

			friendlyURL.on(
				['blur', 'change', 'focus'],
				function(event) {
					var value = A.Lang.trim(friendlyURL.val());

					if (value == '/') {
						value = '';
					}
					else {
						value = value.replace(
							/^[^\/]|\/$/g,
							function(match, index) {
								var str = '';

								if (index == 0) {
									str = '/' + match
								}

								return str;
							}
						);
					}

					friendlyURL.val(value);
				}
			);
		</aui:script>

		<c:if test="<%= liveGroup.hasStagingGroup() %>">
			<aui:fieldset label="staging-friendly-url">
				<aui:input bean="<%= stagingGroup %>" label="" model="<%= Group.class %>" field="friendlyURL" fieldParam="stagingFriendlyURL" name="stagingFriendlyURL" />
			</aui:fieldset>

			<aui:fieldset label="staging-virtual-hosts">

				<%
				LayoutSet stagingPublicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(stagingGroupId, false);

				String stagingPublicVirtualHost = ParamUtil.getString(request, "stagingPublicVirtualHost", stagingPublicLayoutSet.getVirtualHostname());
				%>

				<aui:input label="public-pages" name="stagingPublicVirtualHost" type="text" value="<%= stagingPublicVirtualHost %>" />

				<%
				LayoutSet stagingPrivateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(stagingGroupId, true);

				String stagingPrivateVirtualHost = ParamUtil.getString(request, "stagingPrivateVirtualHost", stagingPrivateLayoutSet.getVirtualHostname());
				%>

				<aui:input label="private-pages" name="stagingPrivateVirtualHost" type="text" value="<%= stagingPrivateVirtualHost %>">
					<aui:validator errorMessage="please-enter-a-unique-virtual-host" name="custom">
						function(val, fieldNode, ruleValue) {
							return (val != A.one('#<portlet:namespace />stagingPublicVirtualHost').val());
						}
					</aui:validator>
				</aui:input>
			</aui:fieldset>
		</c:if>
	</c:otherwise>
</c:choose>