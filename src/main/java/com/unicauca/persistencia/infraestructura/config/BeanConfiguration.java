package com.unicauca.persistencia.infraestructura.config;

import com.unicauca.persistencia.aplicacion.output.DocenteGatewayOutputPort;
import com.unicauca.persistencia.aplicacion.output.EspacioFisicoGatewayOutputPort;
import com.unicauca.persistencia.aplicacion.output.FormateadorRespuestaOutputPort;
import com.unicauca.persistencia.aplicacion.output.FranjaHorariaGatewayOutputPort;
import com.unicauca.persistencia.dominio.casosdeuso.DocenteUseCaseAdapter;
import com.unicauca.persistencia.dominio.casosdeuso.EspacioFisicoUseCaseAdapter;
import com.unicauca.persistencia.dominio.casosdeuso.FranjaHorariaUseCaseAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public DocenteUseCaseAdapter docenteUseCaseAdapter(final DocenteGatewayOutputPort docenteGatewayOutputPort, final FormateadorRespuestaOutputPort formateadorRespuestaOutputPort) {
        return new DocenteUseCaseAdapter(docenteGatewayOutputPort, formateadorRespuestaOutputPort);
    }

    @Bean
    public EspacioFisicoUseCaseAdapter espacioFisicoUseCaseAdapter(final EspacioFisicoGatewayOutputPort espacioFisicoGatewayOutputPort) {
        return new EspacioFisicoUseCaseAdapter(espacioFisicoGatewayOutputPort);
    }

    @Bean
    public FranjaHorariaUseCaseAdapter franjaHorariaUseCaseAdapter(final FranjaHorariaGatewayOutputPort franjaHorariaGatewayOutputPort, final FormateadorRespuestaOutputPort formateadorRespuestaOutputPort) {
        return new FranjaHorariaUseCaseAdapter(franjaHorariaGatewayOutputPort, formateadorRespuestaOutputPort);
    }
}
