package com.cima

import grails.rest.*

@Resource(uri='/provincias',formats=['json', 'xml'])
class Provincia {
	String nombre
	
    static constraints = {
    }
	static hasMany = [localidades:Localidad]
}
