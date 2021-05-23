package mx.com.gm.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.data.PersonaDao;
import mx.com.gm.domain.Persona;


@Stateless
@Path("/personas")
public class PersonaServiceRS {
    
    @Inject
    private PersonaDao personaDao;
    
    @GET
    @Produces(value=MediaType.APPLICATION_JSON)
    /**
     * Metodo que encargado del servicio de encontrar una lista de personas
     * 
     * @return personas
     */
    public List<Persona> listarPersonas(){
        List<Persona> personas =  personaDao.encontrarTodasPersonas();
        System.out.println("personas encontradas:" + personas);
        return personas;
    }
    //Obtener la persona
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}") //hace referencia al path: /personas/{id}, ej. /personas/1
    /**
     * Metodo encargado del servicio de encontrar una persona en la bbdd
     * 
     *@param id
     *      Id de la clase persona 
     *@return persona
     */
    public Persona encontrarPersona(@PathParam("id") int id){
        Persona persona = personaDao.encontrarPersona(new Persona(id));
        System.out.println("persona encontrada:" + persona);
        return persona;
    }
    
    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    /**
     * Metodos encargado del servicio que agrega una persona en bbdd
     * 
     * @param persona
     *      Bean del tipo persona
     * 
     * @return persona
     */
    public Persona agregarPersona(Persona persona){
        personaDao.insertarPersona(persona);
        System.out.println("persona agregada:" + persona);
        return persona;
    }
    
    @PUT
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    /**
     * Metodo encargado del servicio de modificar una persona en la bbdd
     * 
     * @param id
     *      ID de la clase persona 
     * @param personaModificada
     *      Objeto de tipo persona que se va a modificar
     * @return response
     */
    public Response modificarPersona(@PathParam("id") int id, Persona personaModificada){
        Persona persona = personaDao.encontrarPersona( new Persona(id));
        if(persona != null){
            personaDao.actualizarPersona(personaModificada);
            System.out.println("persona modificada:" + personaModificada);
            return Response.ok().entity(personaModificada).build();
        }
        else{
            return Response.status(Status.NOT_FOUND).build();
        }
    }
    
    @DELETE
    @Produces(value = MediaType.APPLICATION_JSON)
    @Path("{id}")
    /**
     * Metodo encargado del servicio que elimina una persona en la bbdd
     * 
     * @param id 
     *      Id de la clase persona
     * @return response
     */
    public Response eliminarPersona(@PathParam("id") int id){
        personaDao.eliminarPersona(new Persona(id));
        System.out.println("persona eliminada con el id:" + id);
        return Response.ok().build();
    }
    
}

