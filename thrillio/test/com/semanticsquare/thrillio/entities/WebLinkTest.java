package com.semanticsquare.thrillio.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.semanticsquare.thrillio.managers.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		//Test1- Porn in url ---false
		Weblink webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		
		boolean isKidFriendlyEligible =  webLink.isKidFriendlyEligible();
		assertFalse("For porn in url must be false",isKidFriendlyEligible);
		
		//Test2- Porn in title -- false
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Porn Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible =  webLink.isKidFriendlyEligible();
		assertFalse("For porn in title must be false",isKidFriendlyEligible);
		
		
		//test3-- Adult in host --false
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Porn Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.adult.com");
		
		isKidFriendlyEligible =  webLink.isKidFriendlyEligible();
		assertFalse("For adult in host must be false",isKidFriendlyEligible);
		
		
		//Test4-- Adult in url, not in host --true
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-adult--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible =  webLink.isKidFriendlyEligible();
		assertTrue("For adult in url nt in host must be true",isKidFriendlyEligible);
		
		//test5-- Adult in title only --true
		webLink = BookmarkManager.getInstance().createWeblink(2000, "Adult Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com");
		
		isKidFriendlyEligible =  webLink.isKidFriendlyEligible();
		assertTrue("For adult in title must be true",isKidFriendlyEligible);
	
		
		
	}

}
