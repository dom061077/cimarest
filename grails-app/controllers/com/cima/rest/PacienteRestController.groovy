package com.cima.rest


import grails.rest.*
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_USER")
class PacienteRestController {
    def pacienteService
    static responseFormats = ['json', 'xml']
	
    def index() { }
    
    def search(String filter){
        def pacientes = pacienteService.search(filter)
        pacientes.each{
            log.debug('nombre paciente: '+it.apellido+' '+it.nombre)
        } 
        //[result:pacientes] 
        def resultado = [:]
        resultado.success = true
        [result:resultado,pacientes:pacientes] 
    }
}
