package calenderApiConections;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.util.DateTime;

import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.*;

import java.io.IOException;
import java.util.List;

public class GetCalenderData extends GlobalInstances {

    public Calendar getCalendarService() throws IOException {
        Authorization authorization = new Authorization();
        Credential credential = authorization.authorize();

        return new Calendar.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public List<Event> getEventDetails() throws IOException {
        Calendar service = getCalendarService();

        DateTime now = new DateTime(System.currentTimeMillis());
//        Events events = service.events().list(" thoughtworks.com_mpl97cvn9ms82612kushkoeac4@group.calendar.google.com")
        Events events = service.events().list("thoughtworks.com_695d8lhg9akcmr1kam3u3iea3o@group.calendar.google.com")
                .setTimeMin(now)
                .setOrderBy("startTime")
                .setSingleEvents(true)
                .execute();

        List<Event> items = events.getItems();
        if (items.size() == 0) {
            System.out.println("No upcoming events found.");
        } else {
            System.out.println("Upcoming events");
            return items;
        }
        return null;
    }
}