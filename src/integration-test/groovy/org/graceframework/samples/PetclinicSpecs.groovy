package org.graceframework.samples

import geb.spock.GebReportingSpec

import org.graceframework.samples.pages.WelcomePage


import grails.testing.mixin.integration.Integration
import spock.lang.*

@Integration
abstract class PetclinicSpecs extends GebReportingSpec {
	
	def 'can go Home'() {
		when:
		home.click()
		
		then:
		at WelcomePage
	}
}
