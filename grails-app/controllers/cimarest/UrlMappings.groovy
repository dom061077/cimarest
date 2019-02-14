package cimarest

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")
        
        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
        
        get "/api/generalLookup" (controller:"generalLookup",action:"index")
        get "/api/generalLookup/cie10" (controller:"generalLookup",action:"cie10Lookup")
        get "/api/generalLookup/especialidades" (controller:"generalLookup",action:"especialidadesLookup")
        get "/api/generalLookup/provincias" (controller:"generalLookup",action:"provinciaLookup")
        get "/api/generalLookup/profesional" (controller:"generalLookup",action:"profesionalLookup")
        get "/api/generalLookup/profesionales.json" (controller:"generalLookup",action:"profesionalList")
        get "/api/generalLookup/listestadosturnos.json" (controller:"generalLookup",action:"listEstadosTurnosList")
        get "/api/generalLookup/listEstadoConsulta.json" (controller:"generalLookup",action:"listEstadoConsulta")
        /*turnos-----------------*/
        post "/api/addturno" (controller:"turnoRest",action:"add")
        post "/api/updateturno" (controller:"turnoRest",action:"update")
        post "/api/updateturnoestado" (controller:"turnoRest",action:"updateEstado")
        delete "/api/deleteturno/$id" (controller:"turnoRest",action:"delete")
        
        get "/api/listturnos" (controller:"turnoRest",action:"list")
        
        
        
        /*-Pacientes------------------*/
        get "/api/paciente/search" (controller:"pacienteRest",action:"search")
    }
}
