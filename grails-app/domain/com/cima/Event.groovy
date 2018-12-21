package com.cima

import com.cima.enums.EstadoTurno

class Event {
	Date fechaStart
	Date fechaEnd
	String start
	String end
	String titulo
	boolean allDay
	boolean atendido
	EstadoTurno estado=EstadoTurno.TURNO_PENDIENTE
    

    static constraints = {
    }
}
