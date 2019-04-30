package com.cima.rest


import grails.rest.*
import grails.converters.*
import com.cima.Turno
import grails.plugin.springsecurity.annotation.Secured
import java.text.SimpleDateFormat
import com.cima.enums.EstadoTurno

@Secured("hasAnyRole('ROLE_USER','ROLE_PROFESIONAL')")
class TurnoRestController {
        def turnoService
	static responseFormats = ['json', 'xml']
        //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
	
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
                    ,estado: EstadoTurno.TURNO_PENDIENTE)
                
     
       turnoInstance = turnoService.save(turnoInstance,request.JSON.pacienteId,request.JSON.profesionalId)
       if (turnoInstance.hasErrors()/* || !turnoInstance.validate()*/){
            turnoInstance.errors.each{
                log.debug('ERROR!!!: '+it)
            }
            render (view:"/errors/_errors",model:[errors:turnoInstance.errors])
            return
       }

        log.debug("Id Objecto devuelto: "+turnoInstance?.id)
        [turno:turnoInstance]
    }
    
    def updateEstado(){
        log.info('Modificando estado del turno: '+request.JSON)
        def turnoInstance = turnoService.updateEstado(Long.valueOf(request.JSON.id)
            ,EstadoTurno.valueOf(request.JSON.estado))
        if (turnoInstance.hasErrors()){
            turnoInstance.errors.each{
                log.debug('ERROR!!!: '+it)
            }            
            render(view:"/errors/_errors",model:[errors:turnoInstance.errors])
            return
        }
            
        [turno:turnoInstance]
    }
    
    def delete(){
        log.info('Eliminando turno: '+params)
        boolean result = turnoService.delete(Long.parseLong(params.id));
        if(result)
            render(view:"updateEstado"
                    ,model:[success:true]
                )
        else        
            render(view:"updateEstado"
                    ,model:[success:false,message:'No se puede eliminar un turno no pendiente']
                )
        
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

        
        /*if (!(turnoInstance.fechaStart.compareTo(hoy)>0)){
            render(view:"/generalresponse/response"
                ,model:[success:false,messages:["El turno no debe comenzar antes de la fecha y hora actual "]])
            return
        } */
            
        
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
        def turnos = Turno.createCriteria().list(){
            profesional{
                if(params.profesionalId)
                eq("id",new Long(params.profesionalId))
            }
        }
        [turnos:turnos]
    }


    
}
