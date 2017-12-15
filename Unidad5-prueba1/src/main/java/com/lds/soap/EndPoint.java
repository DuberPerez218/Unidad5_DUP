package com.lds.soap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.rmi.RemoteException;

import com.lds.soap.GlobalWeatherStub.GetCitiesByCountry;
import com.lds.soap.GlobalWeatherStub.GetCitiesByCountryResponse;

import javax.ws.rs.PathParam;

@Path("/servlet")
public class EndPoint {
	
	@GET
	@Path("/ciudad/{idc}")
	@Produces("text/plain")
	public String servlet3(@PathParam("idc") String idciudad) throws RemoteException {
		
	    GlobalWeatherStub globalWeatherStub = new GlobalWeatherStub();
		
		GetCitiesByCountry getCitiesByCountry = new GetCitiesByCountry();
		getCitiesByCountry.setCountryName(idciudad);
		
		GetCitiesByCountryResponse getCitiesByCountryResponse = globalWeatherStub.getCitiesByCountry(getCitiesByCountry);
		return getCitiesByCountryResponse.getGetCitiesByCountryResult(); 
	
	}

}
