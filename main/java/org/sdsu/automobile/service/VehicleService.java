package org.sdsu.automobile.service;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

import org.sdsu.automobile.dao.VehicleDAO;
import org.sdsu.automobile.model.Vehicle;
 
@Path("/vehicles")
public class VehicleService {
 
    // URI:
    // /contextPath/servletPath/vehicles
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Vehicle> getVehicles(@QueryParam("make") String make) {
        List<Vehicle> list = VehicleDAO.getVehicles();
        List<Vehicle> result = new LinkedList<Vehicle>();
 
        if (StringUtils.isEmpty(make)) {
        	return list;
        }
        
        for (Vehicle vehicle : list) {
        	if (vehicle.getMake().equals(make)) {
        		result.add(vehicle);
        	}
        }
        
        return result;
    }
 
    // URI:
    // /contextPath/servletPath/id
    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Vehicle getVehicle(@PathParam("id") Integer id) {
        return VehicleDAO.getVehicle(id);
    }
 
    // URI:
    // /contextPath/servletPath/vehicles
    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addVehicle(Vehicle vehicle) {
    	if (StringUtils.isEmpty(vehicle.getMake()) || StringUtils.isEmpty(vehicle.getModel())
    			|| (vehicle.getYear() < 1950 || vehicle.getYear() > 2050)) {
    		return Response.serverError().build();
    	}
        //return VehicleDAO.addVehicle(vehicle);
    	return Response.ok(VehicleDAO.addVehicle(vehicle), MediaType.APPLICATION_XML).build();
    }
 
    // URI:
    // /contextPath/servletPath/vehicles
    @PUT
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateVehicle(Vehicle vehicle) {
        //return VehicleDAO.updateVehicle(vehicle);
    	if (StringUtils.isEmpty(vehicle.getMake()) || StringUtils.isEmpty(vehicle.getModel())
    			|| (vehicle.getYear() < 1950 || vehicle.getYear() > 2050)) {
    		return Response.serverError().build();
    	}
        //return VehicleDAO.addVehicle(vehicle);
    	return Response.ok(VehicleDAO.updateVehicle(vehicle), MediaType.APPLICATION_XML).build();
    }
 
    @DELETE
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public void deleteVehicle(@PathParam("id") Integer id) {
    	VehicleDAO.deleteVehicle(id);
    }
 
}