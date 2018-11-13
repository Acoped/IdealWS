/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idealWS;


import idealModel.EnrollCode;
import idealModel.IdealId;
import idealModel.ReplyWrapper;
import javax.json.JsonArray;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    public ReplyWrapper checkStudent(@PathParam("ideal") String ideal, 
                                @PathParam("courseCode") String courseCode, 
                                @PathParam("semesterCode") String semesterCode) {

        // Client call to ParaplyetWS to get EnrollCode.
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/ParaplyetWS/api/getEnrollCode/"
                + courseCode
                + "/"
                + semesterCode);
        EnrollCode ec = target.request(MediaType.APPLICATION_JSON).get(EnrollCode.class);
        
        // TODO Refactor to a Boolean.
        // Checks if ideal and enrollCode exists in same row returns id if so, else 999.
        IdealId idId = new IdealId(ideal,ec.getEnrollCode());
        
        // Wrapper class packing ideal and enrollCode in a class to return from this API.
        ReplyWrapper rw = new ReplyWrapper();
        rw.setEnrollCode(ec.getEnrollCode());
        if (idId.getId() != 999)  { 
            rw.setIdeal(ideal);
        }
        else {
            rw.setEnrollCode("Student not Registred");
            rw.setIdeal(ideal);
        } 
        
        return rw;
    }


}