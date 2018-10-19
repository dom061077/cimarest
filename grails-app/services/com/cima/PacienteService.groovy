package com.cima

import grails.gorm.transactions.Transactional

@Transactional
class PacienteService {

    def search(String filter) {
        def pacientes = Paciente.createCriteria().list(){
            or{
                ilike('apellido','%'+filter+'%')
                ilike('nombre','%'+filter+'%')
            }
        }
        return pacientes
    }
}
