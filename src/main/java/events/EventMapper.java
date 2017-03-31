package events;

import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.model.Event;

public class EventMapper {
    DateTime startDate, endDate;
    String email, message;

    public EventMapper(Event event) {
        startDate = event.getStart().getDateTime();
        endDate = event.getEnd().getDateTime();
        email = event.getCreator().getEmail();
        message = event.getSummary();
    }
}
