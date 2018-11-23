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
        domicilio(nullable:true,blank:true)
        codigoPostal(nullable:true,blank:true)
        telefono(nullable:true,blank:true)
        fechaNacimiento(nullable:true,blank:true)
        cuit(nullable:true,blank:true)
        ocupacion(nullable:true,blank:true)
        medicoEnviante(nullable:true,blank:true)
        email(nullable:true,blank:true)
        sexo(nullable:true,blank:true)
        numeroAfiliado(nullable:true,blank:true)
        localidad(nullable:true,blank:true)
        estadoCivil(nullable:true,blank:true)
        tipoDocumento(nullable:true,blank:true)
        estadoIva(nullable:true,blank:true)
        obraSocial(nullable:true,blank:true)
        institucion(nullable:true,blank:true)
    }
}
