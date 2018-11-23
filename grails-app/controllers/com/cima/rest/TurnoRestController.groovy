package com.cima.rest


import grails.rest.*
import grails.converters.*
import com.cima.Turno
import grails.plugin.springsecurity.annotation.Secured
import java.text.SimpleDateFormat
import com.cima.enums.EstadoEvent

@Secured("ROLE_USER")
class TurnoRestController {
        def turnoService
	static responseFormats = ['json', 'xml']
	
    def index() { }
    
    def add(){
        log.info('Todos los prametros: '+request.JSON)
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        Date hoy = new Date();
        Date fStart = sf.parse(request.JSON.start)
        Date fEnd = sf.parse(request.JSON.end)
        log.debug('VALOR DE fStart: '+request.JSON.start+' fEnd: '+request.JSON.end)
        def turnoInstance = new Turno(fechaStart:fStart,fechaEnd:fEnd,start:request.JSON.start.trim()
            ,end: request.JSON.end.trim(),titulo: request.JSON.title
                    ,estado: EstadoEvent.EVENT_PENDIENTE)
                
              
       turnoInstance = turnoService.save(turnoInstance,request.JSON.pacienteId,request.JSON.profesionalId)
       if (turnoInstance.hasErrors() || !turnoInstance.validate()){
            turnoInstance.errors.each{
                log.debug('ERROR!!!: '+it)
            }
            render (view:"/errors/_errors",model:[errors:turnoInstance.errors])
            return
       }

        log.debug("Id Objecto devuelto: "+turnoInstance?.id)
        [turno:turnoInstance]
    }
    
    def update(){
        log.info('Modificando datos del turno: '+request.JSON)
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm")
        Date hoy = new Date();
        Date fStart = sf.parse(request.JSON.start)
        Date fEnd = sf.parse(request.JSON.end)
        def turnoInstance = new Turno(fechaStart:fStart,fechaEnd:fEnd,start:request.JSON.start.trim()
            ,end: request.JSON.end.trim())
        //update(Long idTurno,Turno turnoInstance,Long idPaciente,Long idProfesional ){
        turnoInstance  = turnoService.update(request.JSON.id,turnoInstance)        
        if (turnoInstance.hasErrors() || !turnoInstance.validate()){
            turnoInstance.errors.each{
                log.debug('Error!!!: '+it)
            }
            render(view:"/errors/_errors",model:[errors:turnoInstance.errors])
            return
        }
        [turno:turnoInstance]
    }
    
    
    def list(){
        log.info("Metodo list")
        def turnos = Turno.createCriteria().list(){
            profesional{
                if(params.profesionalId)
                eq("id",new Long(params.profesionalId))
            }
        }
        [turnos:turnos]
    }

    
    
}
