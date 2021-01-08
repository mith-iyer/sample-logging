package com.oal.innovationweek.samplelogging.controller;

import com.oal.innovationweek.samplelogging.model.Speaker;
import com.oal.innovationweek.samplelogging.service.ErrorHandlerService;
import com.oal.innovationweek.samplelogging.service.SpeakerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Component
@Path("/api/v1/speakers")
public class SpeakerController {
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(SpeakerController.class);

    private final SpeakerService speakerService;
    private final ErrorHandlerService errorHandlerService;

    @Autowired
    public SpeakerController(SpeakerService speakerService, ErrorHandlerService errorHandlerService) {
        this.speakerService = speakerService;
        this.errorHandlerService = errorHandlerService;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response list() {
        log.info("Requesting full list of speakers");
        return Response
                .status(200)
                .entity(speakerService.getAllSpeakers())
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response get(@PathParam("id") Long id) {
        if (null == speakerService.getSpeakerById(id)) {
            log.error("Speaker not found with id: " + id);
            return Response
                    .status(404)
                    .entity(errorHandlerService.createErrorObject("Not found", "Speaker with id " + id + " not found"))
                    .build();
        } else {
            return Response
                    .status(200)
                    .entity(speakerService.getSpeakerById(id))
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response create(@RequestBody final Speaker speaker) {
        if (StringUtils.isBlank(speaker.getFirstName()) || StringUtils.isBlank(speaker.getLastName())) {
            return Response.status(400).entity(errorHandlerService.createErrorObject("Bad input", "Please provide all mandatory values")).build();
        }

        return Response
                .status(201)
                .entity(speakerService.createSpeaker(speaker))
                .build();
    }
}
