package com.rmendel.lineManager.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rmendel.lineManager.application.LineCache;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/lineService")
@Api(value = "question")
public final class LineService {
	
	 @GET
	 @Path("/line/{lineNumber}")
	 @ApiOperation(value = "Returns the line at position [lineNumber] from the service data file",
	 	response = String.class)	 
	 @ApiImplicitParams(
		{@ApiImplicitParam(name = "lineNumber", value = "Line id", required = true, dataType = "int", paramType = "path")})
	 @Produces(MediaType.APPLICATION_JSON)
	 public String getLine(@PathParam("lineNumber") int lineNumber) {
		 String toReturn = "";
		 
		 try {
			 toReturn = LineCache.getInstance().getLine(lineNumber);
			 
		 } catch(Exception e) {
			 // TODO: Return appropriate HTTP error
		 }

		 return toReturn;
	 }
}
