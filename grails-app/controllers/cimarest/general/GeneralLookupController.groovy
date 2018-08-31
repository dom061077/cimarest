package cimarest.general


import grails.rest.*
import grails.converters.*
import com.cima.Cie10

class GeneralLookupController {
	static responseFormats = ['json', 'xml']
        
    def index() { 
    
    }
    
    def cie10Lookup(){
        List list = Cie10.list()
        [list:list]
    }
}
