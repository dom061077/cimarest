package com.cima.rest


import grails.rest.*
import grails.converters.*

class ProfesionalController {
    def profesionalService
	static responseFormats = ['json', 'xml']
	
    def index() { 
        [profesionalList:profesionalService.list()]
    }
    
}
