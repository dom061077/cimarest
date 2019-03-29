package com.cima.rest


import grails.rest.*
import com.cima.Consulta
import grails.converters.*
import grails.plugin.springsecurity.annotation.Secured

@Secured("hasAnyRole('ROLE_USER','ROLE_PROFESIONAL')")
class ConsultaController {
    def consultaService
    static responseFormats = ['json', 'xml']
        
    def index() { }
    
    def add(){
        log.info('Todos los paramétros: '+request.JSON)
        // save(String contenido,Long cie10Id,Long turnoId){
        //[contenido:sadfsdf, estado:ESTADO_PUBLICO, cie10Id:5, turnoId:56]
        log.info("TurnoId: "+request.turnoId)
        def consultaInstance = consultaService.save(request.JSON.contenido,request.JSON.estado,request.JSON.cie10Id
                ,new Long(request.JSON.turnoId))
       if (consultaInstance.hasErrors() || !consultaInstance.validate()){
            consultaInstance.errors.each{
                log.debug('ERROR!!!: '+it)
            }
            render (view:"/errors/_errors",model:[errors:consultaInstance.errors])
            return
       }            
        [consulta:consultaInstance]    
    }
}