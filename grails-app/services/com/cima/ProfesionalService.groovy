package com.cima

import grails.gorm.transactions.Transactional

@Transactional
class ProfesionalService {
    def list(){
        return Profesional.list()
    }

}
