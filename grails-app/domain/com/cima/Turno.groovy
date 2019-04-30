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
		start (unique:'paciente')
		end (unique:'paciente')
		paciente(nullable:true,blank:true)
		profesional(nullable:false,blank:false)
                  
                fechaStart validator: { val, obj ->
                    Date hoy = new Date()
                    if (obj.id  == null && val.compareTo(hoy)<0) 
                        return ['com.cima.turno.fechaStart.previousfechastart.error']
                    if(obj.id != null && obj.getPersistentValue('fechaStart').compareTo(hoy)<0
                            && obj.getPersistentValue('fechaStart').compareTo(val)!=0)    
                        return ['com.cima.turno.fechaStart.turnovencido.error']
                    if(obj.id != null && val.compareTo(hoy)<0 
                            && obj.getPersistentValue('fechaStart').compareTo(val)!=0)
                        return ['com.cima.turno.fechaStart.vencerturno.error']
                } 
                
                fechaEnd validator: { val, obj ->
                    Date hoy = new Date()
                    if (obj.id != null && obj.getPersistentValue('fechaStart').compareTo(hoy)<0
                            && val.compareTo(obj.getPersistentValue('fechaEnd'))!=0)
                        return ['com.cima.turno.fechaEnd.turnovencido.error']
                    
                }
                estado validator:{ val,obj ->
                    Date hoy = new Date()
                    if (obj.id == null && val != EstadoTurno.TURNO_PENDIENTE)
                        return['com.cima.turno.fechaStart.estadonopendiente.error']
                    if (obj.id != null && val == EstadoTurno.TURNO_ATENDIDO 
                        && obj.getPersistentValue('estado')!= EstadoTurno.TURNO_PENDIENTE 
                        
                        )    {
                        return['com.cima.turno.estado.turnoatendido.nopendiente.error']
                    }
                    if (obj.id != null && obj.getPersistentValue('estado')==EstadoTurno.TURNO_ATENDIDO
                        && val!=obj.getPersistentValue('estado'))
                        return('com.cima.turno.estado.turnoatendido.updateestado.error')
                   
                    if (obj.id != null && obj.getPersistentValue('estado')!=val && obj.fechaStart.compareTo(hoy)<0)    
                        return ['com.cima.turno.estado.turnovencido.updateestado.error']
                    
                }
                titulo (nullable:true,blank:true)
		
    }
	
    static mapping = {
    //tiempoAtencion formula:"TIMESTAMPDIFF(MINUTE,fecha_start,fecha_end)"
        tiempoAtencion formula:"fecha_start-fecha_end"
    }        
}
