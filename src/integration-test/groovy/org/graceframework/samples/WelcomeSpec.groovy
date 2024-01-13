package org.graceframework.samples

import org.graceframework.samples.pages.DisplayVetsPage
import org.graceframework.samples.pages.FindOwnersPage
import org.graceframework.samples.pages.TutorialPage
import org.graceframework.samples.pages.WelcomePage

class WelcomeSpec extends PetclinicSpecs {
	
	def setup() {
		to WelcomePage
	}
	
	def 'can find an Owner'() {
		expect:
		at WelcomePage
		findOwner.click()
		at FindOwnersPage
	}
	
	def 'can display all Veterinarians'() {
		expect:
		at WelcomePage
		displayAllVets.click()
		at DisplayVetsPage
	}

	def 'can display a Tutorial'() {
		expect:
		at WelcomePage
		tutorial.click()
		at TutorialPage
	}
}
