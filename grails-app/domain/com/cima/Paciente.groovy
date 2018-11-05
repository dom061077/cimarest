package com.cima

import com.cima.enums.EstadoCivilEnum
import com.cima.enums.TipoDocumentoEnum
import com.cima.enums.IvaEnum
import com.cima.ObraSocial
import com.cima.Institucion


class Paciente {
    
	Long dni
	String apellido
	String nombre
        String apellidoNombre
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
        Institucion institucion

    static constraints = {
    }
}
