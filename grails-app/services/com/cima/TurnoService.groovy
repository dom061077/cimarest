package com.cima

import grails.gorm.transactions.Transactional

@Transactional
class TurnoService {
    static transactional = true

    def save(Turno turnoInstance) {
        turno.save(failOnError:true)     
    }
}
