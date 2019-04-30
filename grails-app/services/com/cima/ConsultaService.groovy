package com.cima

import com.cima.enums.EstadoConsultaEnum
import com.cima.enums.EstadoTurno
import grails.gorm.transactions.Transactional
import grails.validation.ValidationException


class ConsultaService {
    
    
    def serviceMethod() {

    }
    
    @Transactional
    def save(String contenido,String estado,Long cie10Id,Long turnoId){
        
            def cie10Instance = Cie10.load(cie10Id)
        
            def turnoInstance = Turno.get(turnoId)
            log.info('turnoInstance: '+turnoInstance.profesional);
            def pacienteInstance = turnoInstance.paciente
            def profesionalInstance = turnoInstance.profesional
            
            
            def consultaInstance = new Consulta(contenido:contenido
                ,cie10:cie10Instance,profesional:profesionalInstance
                ,estado:estado
                ,paciente:pacienteInstance,turno:turnoInstance)
            consultaInstance.turno.estado = EstadoTurno.TURNO_ATENDIDO    
            

            if(consultaInstance.validate()){
                def consultaInstanceSaved = consultaInstance.save(failOnError:true)
                if(consultaInstanceSaved!=null){
                    return consultaInstanceSaved
                }else{
                    

                    return consultaInstance
                }
            }
            
            return consultaInstance
        
            
            
            
    }
}
