package com.cima

class ObraSocial {
	String descripcion
	String razonSocial
	String domicilio
	String codigoPostal
	String telefono
	String contacto
	String cuit
	Boolean habilitada= new Boolean(true)
	Institucion institucion
	
	//static hasMany = [pacientes:Paciente]

    static constraints = {
		telefono(blank:true,nullable:true,matches:'[0-9]{3}-[0-9]{7}')
		cuit(matches:'[0-9]{2}-[0-9]{8}-[0-9]')
		descripcion(nullable:false,blank:false)
		razonSocial(nullable:false,blank:false)
    }
}
