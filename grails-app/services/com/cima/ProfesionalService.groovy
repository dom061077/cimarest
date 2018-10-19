package com.cima

import grails.gorm.services.Service

@Service(Profesional)
interface ProfesionalService {

    Profesional get(Serializable id)

    List<Profesional> list(Map args)

    Long count()

    void delete(Serializable id)

    Profesional save(Profesional profesional)

}