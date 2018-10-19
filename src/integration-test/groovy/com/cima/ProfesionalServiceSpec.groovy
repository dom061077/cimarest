package com.cima

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ProfesionalServiceSpec extends Specification {

    ProfesionalService profesionalService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Profesional(...).save(flush: true, failOnError: true)
        //new Profesional(...).save(flush: true, failOnError: true)
        //Profesional profesional = new Profesional(...).save(flush: true, failOnError: true)
        //new Profesional(...).save(flush: true, failOnError: true)
        //new Profesional(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //profesional.id
    }

    void "test get"() {
        setupData()

        expect:
        profesionalService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Profesional> profesionalList = profesionalService.list(max: 2, offset: 2)

        then:
        profesionalList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        profesionalService.count() == 5
    }

    void "test delete"() {
        Long profesionalId = setupData()

        expect:
        profesionalService.count() == 5

        when:
        profesionalService.delete(profesionalId)
        sessionFactory.currentSession.flush()

        then:
        profesionalService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Profesional profesional = new Profesional()
        profesionalService.save(profesional)

        then:
        profesional.id != null
    }
}
