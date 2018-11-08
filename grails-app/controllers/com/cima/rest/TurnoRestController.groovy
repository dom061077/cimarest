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
        Date fStart = sf.parse(request.JSON.start)
        Date fEnd = sf.parse(request.JSON.end)
        def turnoInstance = new Turno(fechaStart:fStart,fechaEnd:fEnd,start:request.JSON.start
                    ,end: request.JSON.end,titulo: request.JSON.title
                    ,estado: EstadoEvent.EVENT_PENDIENTE)
        turnoService.save(turnoInstance,request.JSON.idPaciente,request.JSON.idProfesional)
        [result:params]
    }
    
}
