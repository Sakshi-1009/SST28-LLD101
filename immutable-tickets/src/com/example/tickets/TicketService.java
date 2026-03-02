package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer that creates tickets.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - creates partially valid objects
 * - mutates after creation (bad for auditability)
 * - validation is scattered & incomplete
 *
 * TODO (student):
 * - After introducing immutable IncidentTicket + Builder, refactor this to stop
 * mutating.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // scattered validation (incomplete on purpose)

        // BAD: mutating after creation

        List<String> tags = new ArrayList<>();
        tags.add("NEW");

        return IncidentTicket.builder()
                .id(id)
                .reporterEmail(reporterEmail)
                .title(title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .tags(tags)
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket t) {
        // BAD: mutating ticket after it has been "created"
        List<String> updatedTags = new ArrayList<>(t.getTags());
        updatedTags.add("ESCALATED"); // list leak

        return t.toBuilder()
                .priority("CRITICAL")
                .tags(updatedTags)
                .build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        // scattered validation

        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}