package org.graceframework.samples

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OwnerController {

    OwnerService ownerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ownerService.list(params), model:[ownerCount: ownerService.count()]
    }

    def show(Long id) {
        respond ownerService.get(id)
    }

    def create() {
        respond new Owner(params)
    }

    def save(Owner owner) {
        if (owner == null) {
            notFound()
            return
        }

        try {
            ownerService.save(owner)
        } catch (ValidationException e) {
            respond owner.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'owner.label', default: 'Owner'), owner.id])
                redirect owner
            }
            '*' { respond owner, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond ownerService.get(id)
    }

    def update(Owner owner) {
        if (owner == null) {
            notFound()
            return
        }

        try {
            ownerService.save(owner)
        } catch (ValidationException e) {
            respond owner.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'owner.label', default: 'Owner'), owner.id])
                redirect owner
            }
            '*'{ respond owner, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        ownerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'owner.label', default: 'Owner'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'owner.label', default: 'Owner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
