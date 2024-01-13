package org.graceframework.samples.pages

class AddPetPage extends PageWithFooter {

  static url = '/pet/add'

  static at = {
    title == 'Add Pet'
  }
  
  static content = {
    name { $('#pet_name') }
    id { $('#pet_owner_id') }
    addPet { $('input', type: 'submit') }
    errors(required: false) { $('.errors') }
  }
}
