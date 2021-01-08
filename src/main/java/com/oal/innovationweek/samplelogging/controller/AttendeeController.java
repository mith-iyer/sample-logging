package com.oal.innovationweek.samplelogging.controller;

import com.oal.innovationweek.samplelogging.model.Attendee;
import com.oal.innovationweek.samplelogging.service.AttendeeService;
import com.oal.innovationweek.samplelogging.service.ErrorHandlerService;
import org.apache.commons.lang3.StringUtils;
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
@Path("api/v1/attendees")
public class AttendeeController {
    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(AttendeeController.class);

    private final AttendeeService attendeeService;
    private final ErrorHandlerService errorHandlerService;

    public AttendeeController(AttendeeService attendeeService, ErrorHandlerService errorHandlerService) {
        this.attendeeService = attendeeService;
        this.errorHandlerService = errorHandlerService;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response list() {
        log.debug("Requesting full list of attendees");
        return Response
                .status(200)
                .entity(attendeeService.getAllAttendees())
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response get(@PathParam("id") Long id) {
        if (null == attendeeService.getAttendeeById(id)) {
            log.error("Attendee not found with id: " + id);
            return Response
                    .status(404)
                    .entity(errorHandlerService.createErrorObject("Not found", "Attendee with id " + id + " not found"))
                    .build();
        } else {
            return Response
                    .status(200)
                    .entity(attendeeService.getAttendeeById(id))
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    public Response create(@RequestBody final Attendee attendee) {
        if (StringUtils.isBlank(attendee.getFirstName()) || StringUtils.isBlank(attendee.getLastName())) {
            return Response.status(400).entity(errorHandlerService.createErrorObject("Bad input", "Please provide all mandatory values")).build();
        }

        return Response
                .status(201)
                .entity(attendeeService.createAttendee(attendee))
                .build();
    }
}
