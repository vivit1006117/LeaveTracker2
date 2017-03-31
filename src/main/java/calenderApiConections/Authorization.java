package calenderApiConections;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Authorization extends GlobalInstances {

    private InputStream in = GetCalenderData.class.getResourceAsStream("/client_secret.json");
    public Credential authorize() throws IOException {
        GoogleAuthorizationCodeFlow flow = getGoogleAuthorizationCodeFlow();

        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
//        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }

    private GoogleAuthorizationCodeFlow getGoogleAuthorizationCodeFlow() throws IOException {
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        return new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("online")
                .build();
    }

}
