package com.cima

import com.cima.enums.EstadoConsultaEnum
import com.cima.enums.EstadoTurno
import grails.gorm.transactions.Transactional

@Transactional
class ConsultaService {
    static transactional = true
    
    def serviceMethod() {

    }
    
    def save(String contenido,String estado,Long cie10Id,Long turnoId){
        
        def turnoInstance = Turno.load(turnoId)
        log.info('turnoInstance: '+turnoInstance.profesional);
        def cie10Instance = Cie10.load(cie10Id)
        def profesionalInstance = turnoInstance.profesional
        def pacienteInstance = turnoInstance.paciente
        
        Consulta.withTransaction{status ->
            def consultaInstance = new Consulta(contenido:contenido
                ,cie10:cie10Instance,profesional:profesionalInstance
                ,estado:estado
                ,paciente:pacienteInstance,turno:turnoInstance)
            consultaInstance.turno.estado = EstadoTurno.TURNO_ATENDIDO    

            def consultaInstanceSaved = consultaInstance.save(failOnError:false)
            if(consultaInstanceSaved!=null)
                return consultaInstanceSaved
            else{
                status.setRollbackOnly()
                return consultaInstance
            }
        }
    }
}
