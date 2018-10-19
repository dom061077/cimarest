package com.cima

import grails.rest.*

@Resource(uri='/provincias',formats=['json', 'xml'])
class Cie10 {
    String descripcion
    String cie10

    static constraints = {
    }
}
