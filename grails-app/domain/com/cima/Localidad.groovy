package com.cima

class Localidad {
    String nombre
    Integer codigoPostal
    static constraints = {
    }
	
    static belongsTo = [provincia:Provincia]
}
