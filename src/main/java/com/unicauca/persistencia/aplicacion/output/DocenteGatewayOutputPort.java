package com.unicauca.persistencia.aplicacion.output;

import com.unicauca.persistencia.dominio.modelos.Docente;

public interface DocenteGatewayOutputPort {

    boolean existeDocentePorCorreo(String correo);

    Docente guardarDocente(Docente docente);

}
