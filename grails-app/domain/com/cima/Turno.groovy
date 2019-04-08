package com.cima

import com.cima.enums.EstadoTurno

class Turno {
	Date fechaStart
	Date fechaEnd
	String start
	String end
	String titulo
	boolean allDay
	boolean atendido
	EstadoTurno estado//=EstadoTurno.TURNO_PENDIENTE
	Paciente paciente
	Profesional profesional    

    static constraints = {
    	//start (unique:'profesional')
		start (unique:'paciente')
    	//end (unique:'profesional')
		end (unique:'paciente')
		paciente(nullable:true,blank:true)
		profesional(nullable:false,blank:false)
		//user(nullable:true,blank:true)
                
                fechaStart validator: { val, obj ->
                    Date hoy = new Date()
                    if (obj.id  == null && val.compareTo(hoy)<0) 
                        return ['com.cima.turno.fechaStart.previousfechastart.error']
                    //if (obj.getPersistentValue('estado') == EstadoTurno.TURNO_PENDIENTE && obj.id != null
                    //    && obj.getPersistentValue('fechaStart').compareTo(obj.fechaStart)==0)    
                    //    return ['com.cima.turno.fechaStart.estadonopendiente.error']
                    if(obj.id != null && obj.estado  != EstadoTurno.TURNO_PENDIENTE
                            && val!= obj.fechaStart)    
                        return ['com.cima.turno.fechaStart.estadonopendiente.error']
                }
                estado validator:{ val,obj ->
                    Date hoy = new Date()
                    if (obj.id == null && val != EstadoTurno.TURNO_PENDIENTE)
                        return['com.cima.turno.fechaStart.estadonopendiente.error']
                    if (obj.id != null && val != EstadoTurno.TURNO_PENDIENTE)    
                        return['com.cima.turno.estado.turnoatendido.error']
                    
                }
                titulo (nullable:true,blank:true)
		
    }
	
    static mapping = {
    //tiempoAtencion formula:"TIMESTAMPDIFF(MINUTE,fecha_start,fecha_end)"
        tiempoAtencion formula:"fecha_start-fecha_end"
    }        
}
