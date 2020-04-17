package com.bidding.server;


import com.bidding.server.domain.AppUser;
import com.bidding.shared.dto.UserDto;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.oauth2.Oauth2;
import com.google.appengine.api.utils.SystemProperty;
import com.gwtplatform.dispatch.shared.ActionException;

import java.io.IOException;


public class ServerUtils {

    private static final int CONNECT_TIMEOUT = 3 * 60000; // 3 minutes

    private static final int READ_TIMEOUT = 3 * 60000; // 3 minutes

    public static final String APPLICATION_NAME = "BiddingCRM";

    public static final String OAUTH2_CALLBACK_PATH = "/oauth2callback";

    public static final String SIGN_IN_WITH_GOOGLE_PATH = "/withGoogle";

    public static final String RUN_TASK_PATH = "/run";

    public static final String RUN_TASK_NAME_PREFIX = "run_";

    public static final String RUN_TASK_NAME_TEMPLATE = RUN_TASK_NAME_PREFIX + "%s";

    public static final String RUN_PART_TASK_PATH = "/run_part";

    public static final String RUN_PART_TASK_NAME_TEMPLATE = RUN_TASK_NAME_PREFIX + "_part_%s_%s";

    /**
     * Build and return an Oauth2 service object based on given request
     * parameters.
     *
     * @param credential
     *            User credentials.
     * @return Drive service object that is ready to make requests, or null if
     *         there was a problem.
     */
    public static Oauth2 getOauth2Service(Credential credential) {
        return new Oauth2.Builder(CredentialManager.TRANSPORT, CredentialManager.JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME).build();
    }

    private static HttpRequestInitializer setHttpTimeout(final HttpRequestInitializer requestInitializer) {
        return new HttpRequestInitializer() {
            @Override
            public void initialize(HttpRequest httpRequest) throws IOException {
                requestInitializer.initialize(httpRequest);
                httpRequest.setConnectTimeout(CONNECT_TIMEOUT);
                httpRequest.setReadTimeout(READ_TIMEOUT);
            }
        };
    }

    public static boolean isProduction() {
        return SystemProperty.environment.value() == SystemProperty.Environment.Value.Production;
    }

    public static UserDto createUserDto(boolean isLoggedIn, AppUser appUser) throws ActionException {
        UserDto userDto = new UserDto();

        if (appUser != null) {
            userDto.setAttributes(isLoggedIn, appUser.getId(), appUser.getLogin(), appUser.isAdmin(),
                    appUser.getPictureURL(), appUser.getDoCreated().toString(), appUser.getDoModified().toString() , appUser.getGoogleId() , appUser.getEmail());
        }
        return userDto;
    }
}
