package com.cima

import com.cima.enums.EstadoConsultaEnum

class Consulta {

	Date fechaConsulta = new java.sql.Date((new java.util.Date()).getTime())
	Date fechaAlta = new java.sql.Date((new java.util.Date()).getTime())
	String contenido
	Cie10 cie10
	Profesional profesional
	Paciente paciente
	EstadoConsultaEnum estado
	Turno turno

	//examen fisico	
	String pulso
	String fc
	String ta
	String fr
	String taxilar
	String trectal
	String pesoh
	String pesoa
	String impresion
	String habito
	String actitud
	String ubicacion
	String marcha
	String psiqui
	String facie
	Institucion institucion
    
    
    static constraints = {
    }
}
