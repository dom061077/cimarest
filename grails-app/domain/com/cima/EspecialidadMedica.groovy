package com.cima

class EspecialidadMedica {

    String descripcion
    static constraints = {
		descripcion(nullable:false,blank:false)
    }
    
}
