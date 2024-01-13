package org.graceframework.samples

class ClinicController {

	def index() {}

	def tutorial() {}

	def vets() {
		[vets: Vet.list()]
	}
}
