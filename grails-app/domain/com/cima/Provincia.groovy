package com.cima

class Provincia {
	String nombre
	
    static constraints = {
    }
	static hasMany = [localidades:Localidad]
}
