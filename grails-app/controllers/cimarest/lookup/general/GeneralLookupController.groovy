package cimarest.general


import grails.rest.*
import grails.converters.*
import com.cima.Cie10
import com.cima.EspecialidadMedica
import com.cima.Profesional
import com.cima.Provincia
import com.cima.Localidad
import com.cima.ObraSocial
import com.cima.enums.EstadoTurno
import com.cima.enums.EstadoConsultaEnum
import grails.plugin.springsecurity.annotation.Secured


@Secured("hasAnyRole('ROLE_USER','ROLE_PROFESIONAL')")
class GeneralLookupController {
	static responseFormats = ['json', 'xml']
        
    def index() { 
    
    }
    
    def cie10Lookup(){
        log.info("Parametros: "+params)
        log.info("Parametros max: "+params.max)
        log.info("Parametros offset: "+params.offset)
        
        def offset = (params.offset?params.offset:0)
        def max = (params.max?params.max:10)
        def c = Cie10.createCriteria()
       
        List list = c.list(offset:offset,max:max){
            if(params.filter)
                ilike("descripcion","%"+params.filter+"%")
        }
        
        
        [list:list]
    }
    
    def especialidadLookup(){
        log.info("Parámetros: "+params)
        def offset = (params.offset?params.offset:0)
        def max = (params.max?params.max:10)
        def c = EspecialidadMedica.createCriteria()
       
        List list = c.list(offset:offset,max:max){
            if(params.filtro)
                ilike("descripcion","%"+params.filtro+"%")
        }
        [list:list]
    }
    
    def localidadLookup(){
        log.info("Parámetros: "+params)
        def offset = (params.offset?params.offset:0)
        def max = (params.max?params.max:10)
        def c = EspecialidadMedica.createCriteria()
       
        List list = c.list(offset:offset,max:max){
            if(params.filtro)
                ilike("descripcion","%"+params.filtro+"%")
        }
        [list:list]
        
    }
    
    def provinciaLookup(){
        log.info("Parámetros: "+params)
        def offset = (params.offset?params.offset:0)
        def max = (params.max?params.max:10)
        def c = Provincia.createCriteria()
       
        List list = c.list(offset:offset,max:max){
            if(params.filtro)
                ilike("nombre","%"+params.filtro+"%")
        }
        [list:list]        
    }
    
    def profesionalLookup(){
        log.info("Parametros: "+params)
        def offset = (params.offset?params.offset:0)
        def max = (params.max?params.max:10)
        def c = Profesional.createCriteria()
       
        List list = c.list(offset:offset,max:max){
            if(params.filtro)
                ilike("nombre","%"+params.filtro+"%")
        }
        [list:list]
    }
    
    def profesionalList(){
        def c = Profesional.createCriteria()
        def list = c.list(){
            
            order("nombre","asc")     
        }
        [profesionales:list]
    }
    
    def obraSocialLookup(){
        log.info("Parametros: "+params)
        def offset = (params.offset?params.offset:0)
        def max = (params.max?params.max:10)
        def c = ObraSocial.createCriteria()
       
        List list = c.list(offset:offset,max:max){
            if(params.filtro)
                 ilike("descripcion","%"+params.filtro+"%")
            
        }
        [list:list]
    }
    
    def listEstadosTurnosList(){
        def estados = EstadoTurno.list(EstadoTurno.TURNO_ATENDIDO)
        [estados:estados]
    }    
    
    def listEstadoConsulta(){
        def estados = EstadoConsultaEnum.list()
        [estados:estados]
    }
    
}
