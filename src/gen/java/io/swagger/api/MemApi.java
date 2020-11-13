package io.swagger.api;


import io.swagger.api.MemApiService;
import io.swagger.api.factories.MemApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/mem")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-11-13T17:04:40.635Z[GMT]")public class MemApi  {
   private final MemApiService delegate;

   public MemApi(@Context ServletConfig servletContext) {
      MemApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("MemApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (MemApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = MemApiServiceFactory.getMemApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    
    @Produces({ "text/plain" })
    @Operation(summary = "Stores a number in the memory", description = "Stores a number in the memory", tags={ "Basic" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful response", content = @Content(schema = @Schema(implementation = Boolean.class))),
        
        @ApiResponse(responseCode = "404", description = "Not found response", content = @Content(schema = @Schema(implementation = String.class))) })
    public Response storeData(@Parameter(in = ParameterIn.QUERY, description = "Value to store",required=true) @QueryParam("value") Integer value
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.storeData(value,securityContext);
    }
}
