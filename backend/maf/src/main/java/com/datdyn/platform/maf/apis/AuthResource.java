package com.datdyn.platform.maf.apis;

import com.datdyn.platform.maf.dtos.Auth.User;
import io.quarkus.logging.Log;
import io.quarkus.oidc.OidcSession;
import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Authenticated
public class AuthResource {

    @Inject
    SecurityIdentity keycloakSecurityContext;

    @GET
    public Response authUser(@QueryParam("redirect") String redirectUrl) {
        return Response.status(302).location(URI.create(redirectUrl)).entity(new User(keycloakSecurityContext)).build();
    }

}