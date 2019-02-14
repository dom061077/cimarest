package com.cima.rest


import grails.rest.*
import com.cima.Consulta
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured("hasAnyRole('ROLE_USER','ROLE_PROFESIONAL')")
class ConsultaController {
	static responseFormats = ['json', 'xml']
	
    def index() { }
    
    def add(){
        log.info('Todos los paramétros: '+request.JSON)

    }
}
