package com.cima.rest


import grails.rest.*
import grails.converters.*
import com.cima.Turno
import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_USER")
class TurnoRestController {
	static responseFormats = ['json', 'xml']
	
    def index() { }
    
    def add(){
        log.info('Parametros XXXX: '+request.JSON.fechaStart+', titulo: '+request.JSON.titulo)
        
        [result:params]
    }
    
}
