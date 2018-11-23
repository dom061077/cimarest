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
        def turnoInstanceSaved = turnoInstance.save(failOnError:false)     
        if (turnoInstanceSaved!=null)
            return turnoInstanceSaved
        else
            return turnoInstance
    }
    
    def update(Long idTurno,Turno turnoInstance ){
        def turnoInstanceToSave = Turno.get(idTurno)
        def turnoInstanceSaved
        turnoInstanceToSave.start = turnoInstance.start
        turnoInstanceToSave.end = turnoInstance.end
        turnoInstanceToSave.fechaStart = turnoInstance.fechaStart
        turnoInstanceToSave.fechaEnd = turnoInstance.fechaEnd
        turnoInstanceSaved = turnoInstanceToSave.save()
        if(turnoInstanceSaved != null)
            return turnoInstanceSaved
        else
            return turnoInstanceToSave
    }
    
}
