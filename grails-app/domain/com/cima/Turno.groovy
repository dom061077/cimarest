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
                /*fechaStart validator: { val, obj ->
                    if(obj == null){
                        Date hoy = new Date()
                        if (!(val.compareTo(hoy)>0)) 
                            return ['com.cima.Turno.fechaStart.lessthantoday.error']
                    }    
                }*/
                titulo (nullable:true,blank:true)
		
    }
	
    static mapping = {
    //tiempoAtencion formula:"TIMESTAMPDIFF(MINUTE,fecha_start,fecha_end)"
        tiempoAtencion formula:"fecha_start-fecha_end"
    }        
}
