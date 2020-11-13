package io.swagger.api;


import io.swagger.api.CalculateApiService;
import io.swagger.api.factories.CalculateApiServiceFactory;

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


@Path("/calculate")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-11-13T17:04:40.635Z[GMT]")public class CalculateApi  {
   private final CalculateApiService delegate;

   public CalculateApi(@Context ServletConfig servletContext) {
      CalculateApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("CalculateApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (CalculateApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = CalculateApiServiceFactory.getCalculateApi();
      }

      this.delegate = delegate;
   }

    @GET
    
    
    @Produces({ "text/plain" })
    @Operation(summary = "Executes an opeation with two operands and an operator", description = "Executes an opeation with two operands and an operator", tags={ "Basic" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successful response", content = @Content(schema = @Schema(implementation = String.class))),
        
        @ApiResponse(responseCode = "404", description = "Not found response", content = @Content(schema = @Schema(implementation = String.class))) })
    public Response calculateoperation(@Parameter(in = ParameterIn.QUERY, description = "First operand",required=true) @QueryParam("operand1") Integer operand1
,@Parameter(in = ParameterIn.QUERY, description = "Operator to execute",required=true) @QueryParam("operator") String operator
,@Parameter(in = ParameterIn.QUERY, description = "Second Operand",required=true) @QueryParam("operand2") Integer operand2
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.calculateoperation(operand1,operator,operand2,securityContext);
    }
}
