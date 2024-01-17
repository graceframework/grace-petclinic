package org.graceframework.samples

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PetServiceSpec extends Specification {

    PetService petService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pet(...).save(flush: true, failOnError: true)
        //new Pet(...).save(flush: true, failOnError: true)
        //Pet pet = new Pet(...).save(flush: true, failOnError: true)
        //new Pet(...).save(flush: true, failOnError: true)
        //new Pet(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pet.id
    }

    void "test get"() {
        setupData()

        expect:
        petService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pet> petList = petService.list(max: 2, offset: 2)

        then:
        petList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        petService.count() == 5
    }

    void "test delete"() {
        Long petId = setupData()

        expect:
        petService.count() == 5

        when:
        petService.delete(petId)
        sessionFactory.currentSession.flush()

        then:
        petService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pet pet = new Pet()
        petService.save(pet)

        then:
        pet.id != null
    }
}
