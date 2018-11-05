package com.cima

import grails.gorm.transactions.Transactional

@Transactional
class PacienteService {
    //String filterArray = [];
    def search(String filter) {
        
        def pacientes = Paciente.createCriteria().list([max:10]){
                ilike('apellidoNombre','%'+filter+'%')
        }
        return pacientes
    }
}
