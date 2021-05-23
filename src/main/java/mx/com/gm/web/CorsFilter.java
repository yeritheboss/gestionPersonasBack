/*
 * TCross origin resource sharing 
    clase que se utiliza para compartir informacion entre cliente/servidor , hay que meterlo para poder permitir peticiones 
esto tambien se hace para conectarnos con el servicio de angular 
 */
package mx.com.gm.web;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
/**
 *
 * @author gerangelberroteran
 */
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
     
        
        MultivaluedMap<String, Object>headers =responseContext.getHeaders();
        headers.add("Acces-Control-Allow-Origin", "*"); //para que todas las peticiones puedan entrar en nuestro webservice
        headers.add("Access-Control-Allow-Credentials", "true");//para permitir uso de credenciales , usuario , password para entrar
        headers.add("Access-Control-Allow-Headers","Origin,X-Requested-With, Content-Type, Accept, Authorization");//cabeceros a soportar 
        headers.add("Access-Control-Allow-Method","GET,POST,PUT,DELETE,OPTIONS,HEAD"); //para indicarle los metodo a permitir
    }
    
    
    
    
}
