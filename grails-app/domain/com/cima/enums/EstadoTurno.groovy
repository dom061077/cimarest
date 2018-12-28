package com.cima.enums

public enum EstadoTurno {
	TURNO_ATENDIDO("Atendido","DarkGreen"),//
	TURNO_AUSENTE("Ausente","Red"),//
	TURNO_ANULADO("Anulado","SlateGray"),//
	TURNO_PENDIENTE("Pendiente",""),
	TURNO_ENSALA("En Sala","Purple")//
	
	//String name
        public final List<String> values
	
	public EstadoTurno(String ...values ){
		this.values = Arrays.asList(values)
	}
        
        public List<String> getValues(){
            return values
        }
	
	static list (def excluded=null){
		def listint = listinterno()
		listint.remove(excluded)
		return listint
	}
	
	private static listinterno(){
		[TURNO_ATENDIDO,TURNO_AUSENTE,TURNO_ANULADO,TURNO_PENDIENTE,TURNO_ENSALA]
	}
        
        public String getColor(){
            if (name == TURNO_ATENDIDO)
                return 'DarkGreen';
            if (name == TURNO_AUSENTE)    
                return  'Red' 
            if (name == TURNO_ANULADO)    
                return 'SlateGray'
            if (name == TURNO_PENDIENTE)    
                return ''
            if (name == TURNO_ENSALA)    
                return 'NavajoWhite'
            return 'NADA'
        }
	
	
}
