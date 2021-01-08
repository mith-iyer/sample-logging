package com.oal.innovationweek.samplelogging.controller;

import com.oal.innovationweek.samplelogging.model.Attendee;
import com.oal.innovationweek.samplelogging.model.WorkshopSession;
import com.oal.innovationweek.samplelogging.service.ErrorHandlerService;
import com.oal.innovationweek.samplelogging.service.WorkshopSessionService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("/api/v1/sessions")
@Transactional
public class WorkshopSessionController {

    private final WorkshopSessionService workshopSessionService;
    private final ErrorHandlerService errorHandlerService;
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(WorkshopSessionController.class);


    public WorkshopSessionController(WorkshopSessionService workshopSessionService, ErrorHandlerService errorHandlerService) {
        this.workshopSessionService = workshopSessionService;
        this.errorHandlerService = errorHandlerService;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response list() {
        return javax.ws.rs.core.Response
                .status(200)
                .entity(workshopSessionService.getAllWorkshopSessions())
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response get(@PathParam("id") Long id) {
        if (null == workshopSessionService.getWorkshopSessionById(id)) {
            log.error("Workshop Session with inputted id " + id + " not found");
            return Response
                    .status(404)
                    .entity(errorHandlerService.createErrorObject("Not found", "Workshop Session with id " + id + " not found"))
                    .build();
        } else {
            return Response
                    .status(200)
                    .entity(workshopSessionService.getWorkshopSessionById(id))
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response create(@RequestBody WorkshopSession session) {
        return Response
                .status(201)
                .entity(workshopSessionService.createWorkshopSession(session))
                .build();
    }

    @PATCH
    @Path("/signup/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response updateWorkshopSession(@PathParam("id") Long workshopSessionId,
                                          @RequestBody Attendee attendee) {

        try {
            return null == workshopSessionService.updateWorkshopSession(workshopSessionId, attendee) ?
                    Response
                            .status(404)
                            .entity(errorHandlerService.createErrorObject("Not found", "Workshop Session with id " + workshopSessionId + " not found"))
                            .build() :
                    Response
                            .status(201)
                            .entity(workshopSessionService.updateWorkshopSession(workshopSessionId, attendee))
                            .build();
        } catch (InternalServerErrorException e) {
            log.error(e.getMessage());
            return Response
                    .status(500)
                    .entity(errorHandlerService.createErrorObject("Something went wrong", e.getMessage()))
                    .build();
        }
    }
}