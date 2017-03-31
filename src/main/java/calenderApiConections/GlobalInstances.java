package calenderApiConections;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;

import java.util.Arrays;
import java.util.List;

public class GlobalInstances {

    protected final String APPLICATION_NAME = "Google Calendar API Java";
    protected final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    protected final java.io.File DATA_STORE_DIR = new java.io.File(
            System.getProperty("user.home"), ".credentials/calendar-java-quickstart");
    protected FileDataStoreFactory DATA_STORE_FACTORY;
    protected HttpTransport HTTP_TRANSPORT;
    protected final List<String> SCOPES = Arrays.asList(CalendarScopes.CALENDAR_READONLY);

    GlobalInstances() {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
