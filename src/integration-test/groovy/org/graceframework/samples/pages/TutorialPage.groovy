package org.graceframework.samples.pages

import geb.Page

class TutorialPage extends PageWithFooter {

	static url = '/clinic/tutorial'
	
	static at = {
		title == 'The Grails PetClinic Application'
	}
}
