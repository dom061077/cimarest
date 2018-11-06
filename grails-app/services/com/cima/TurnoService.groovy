package com.cima

import grails.gorm.transactions.Transactional
import com.cima.Paciente
import com.cima.Profesional


@Transactional
class TurnoService {
    static transactional = true

    def save(Turno turnoInstance,Long idPaciente, Long idProfesional) {
        def pacienteInstance = Paciente.load(idPaciente)
        def profesionalInstance = Profesional.load(idProfesional)
        turnoInstance.paciente = pacienteInstance
        turnoInstance.profesional = profesionalInstance
        turnoInstance.save(failOnError:true)     
    }
}
