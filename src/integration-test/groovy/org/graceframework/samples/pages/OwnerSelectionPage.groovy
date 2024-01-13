package org.graceframework.samples.pages

import geb.Page

class OwnerSelectionPage extends Page {

	static url = '/owner/find'
	
	static at = {
		title == 'Select Owner'
	}
}
