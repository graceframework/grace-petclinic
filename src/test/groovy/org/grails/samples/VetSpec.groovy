package org.graceframework.samples

import spock.lang.Specification

class VetSpec extends Specification implements DomainDataFactory {
	
	Vet vet = validVet()
	
	
	def 'a valid Vet has no errors'() {
		when:
		vet.validate()
		
		then:
		!vet.hasErrors()
		!vet.specialities
	}
}
