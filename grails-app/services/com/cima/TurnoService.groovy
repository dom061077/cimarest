package com.cima

import grails.gorm.transactions.Transactional
import com.cima.Paciente
import com.cima.Profesional
import com.cima.enums.EstadoTurno


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
    
    def updateEstado(Long turnoId,EstadoTurno estado){
        def turnoInstance  = Turno.get(turnoId)
        if (turnoInstance == null )
            return false
        else{    
            turnoInstance.estado = estado
            if (!turnoInstance.save(flush:true))
                return false
        }
        return true
    }
    
}
