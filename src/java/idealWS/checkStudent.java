/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idealWS;

import idealModel.IdealId;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Molnet
 */
@Path("api")
public class checkStudent {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of IdealWS
     */
    public checkStudent() {
    }

    /**
     * Retrieves representation of an instance of idealWS.checkStudent
     * @return an instance of java.lang.String
     * http://localhost:8080/IdealWS/api/checkStudent/bjrber-7/qwerty/uiop
     */
    @GET
    @Path("checkStudent/{ideal}/{courseCode}/{semesterCode}")
    @Produces(MediaType.APPLICATION_JSON)
    public IdealId checkStudent(@PathParam("ideal") String ideal, 
                                @PathParam("courseCode") String courseCode, 
                                @PathParam("semesterCode") String semesterCode) {
        IdealId idId = new IdealId(ideal,"LTU10004");
        return idId;
    }

    /**
     * PUT method for updating or creating an instance of checkStudent
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
