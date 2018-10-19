package com.cima

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import com.cima.Profesional
import grails.rest.RestfulController


class ProfesionalController extends RestfulController<Profesional> {
    static responseFormats = ["json","xml"]
    
    ProfesionalService profesionalService

    ProfesionalController(){
        super(Profesional)
    }

    
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond profesionalService.list(params), model:[profesionalCount: profesionalService.count()]
    }

    def show(Long id) {
        respond profesionalService.get(id)
    }

    
    def save(Profesional profesional) {
        if (profesional == null) {
            render status: NOT_FOUND
            return
        }

        try {
            profesionalService.save(profesional)
        } catch (ValidationException e) {
            respond profesional.errors, view:'create'
            return
        }

        respond profesional, [status: CREATED, view:"show"]
    }

    def update(Profesional profesional) {
        if (profesional == null) {
            render status: NOT_FOUND
            return
        }

        try {
            profesionalService.save(profesional)
        } catch (ValidationException e) {
            respond profesional.errors, view:'edit'
            return
        }

        respond profesional, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        profesionalService.delete(id)

        render status: NO_CONTENT
    }
}
