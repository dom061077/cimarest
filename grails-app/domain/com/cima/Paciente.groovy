package com.cima

class Paciente {
    
	Long dni
	String apellido
	String nombre
	String domicilio
	String codigoPostal
	String telefono
	Date fechaNacimiento
	String cuit
	String ocupacion
	String medicoEnviante
	String email
	Boolean sexo
	Long numeroAfiliado
	Localidad localidad
        
	EstadoCivilEnum estadoCivil
	TipoDocumentoEnum tipoDocumento
	IvaEnum estadoIva
	ObraSocial obraSocial    

    static constraints = {
    }
}
