package com.cima.enums

public enum EstadoTurno {
	TURNO_ATENDIDO("Atendido"),
	TURNO_AUSENTE("Ausente"),
	TURNO_ANULADO("Anulado"),
	TURNO_PENDIENTE("Pendiente"),
	TURNO_ENSALA("En Sala") 
	
	String name
	
	public EstadoTurno(String name){
		this.name=name
	}
	
	static list (def excluded=null){
		def listint = listinterno()
		listint.remove(excluded)
		return listint
	}
	
	private static listinterno(){
		[TURNO_ATENDIDO,TURNO_AUSENTE,TURNO_ANULADO,TURNO_PENDIENTE,TURNO_ENSALA]
	}
	
	
}
