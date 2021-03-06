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

package com.liferay.portalweb.portal.dbupgrade.sampledatalatest.wiki.usecase;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewWikiFrontPageChildPageTag2Test extends BaseTestCase {
	public void testViewWikiFrontPageChildPageTag2() throws Exception {
		selenium.open("/web/wiki-use-case-community/");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Wiki Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Wiki Test Page",
			RuntimeVariables.replace("Wiki Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//div[@class='child-pages']/ul/li/a"));
		selenium.clickAt("//div[@class='child-pages']/ul/li/a",
			RuntimeVariables.replace("Wiki FrontPage ChildPage Title"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("wiki tag 2"),
			selenium.getText("xPath=(//a[@class='tag'])[2]"));
		selenium.clickAt("xPath=(//a[@class='tag'])[2]",
			RuntimeVariables.replace("wiki tag 2"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Pages with tag wiki tag 2."),
			selenium.getText("//h1[@class='header-title']/span"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("Approved"),
			selenium.getText("//td[2]/a"));
		assertTrue(selenium.isPartialText("//td[3]/a", "1.2"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[4]/a"));
		assertTrue(selenium.isElementPresent("//td[5]/a"));
		selenium.type("//input[@id='_36_keywords']",
			RuntimeVariables.replace("\"wiki tag 2\""));
		selenium.click(RuntimeVariables.replace("//input[@value='Search']"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Main"),
			selenium.getText("//td[2]/a"));
		assertEquals(RuntimeVariables.replace("Wiki FrontPage ChildPage Title"),
			selenium.getText("//td[3]/a"));
		assertEquals(RuntimeVariables.replace("Showing 1 - 1."),
			selenium.getText("//div[@class='search-results']"));
	}
}