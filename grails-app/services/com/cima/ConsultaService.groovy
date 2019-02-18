package com.cima

import com.cima.enums.EstadoConsultaEnum
import grails.gorm.transactions.Transactional

@Transactional
class ConsultaService {
    static transactional = true
    
    def serviceMethod() {

    }
    
    def save(String contenido,Long cie10Id,Long profesionalId,Long pacienteId
        ,EstadoConsultaEnum estado,Long turnoId){
        
        def cie10Instance = Cie10.load(cie10Id)
        def profesionalInstance = Profesional.load(profesionalId)
        def pacienteInstance = Paciente.load(pacienteId)
        def turnoInstance = Turno.load(turnoId)
        def consultaInstance = new Consulta(contenido:contenido
            ,cie10:cie10Instance,profesional:profesionalInstance
            ,paciente:pacienteInstance,turno:turnoInstance)
        
        
        def consultaInstanceSaved = consultaInstance.save(failOnError:false)
        if(consultaInstanceSaved!=null)
            return consultainstanceSaved
        else
            return consultaInstance
    }
}
