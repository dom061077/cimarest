package com.cima

import com.cima.enums.EstadoEvent

class Event {
	Date fechaStart
	Date fechaEnd
	Integer start
	Integer end
	String titulo
	boolean allDay
	boolean atendido
	EstadoEvent estado=EstadoEvent.EVENT_PENDIENTE
    

    static constraints = {
    }
}
