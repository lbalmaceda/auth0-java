package com.auth0;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

import java.io.IOException;

public class MockServer {

    private final MockWebServer server;

    public MockServer() throws Exception {
        server = new MockWebServer();
        server.start();
    }

    public void stop() throws IOException {
        server.shutdown();
    }

    public String getBaseUrl() {
        return server.url("/").toString();
    }

    public RecordedRequest takeRequest() throws InterruptedException {
        return server.takeRequest();
    }

    public void userInfoResponse() {
        MockResponse response = new MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json")
                .setBody("{\n" +
                        "  \"email_verified\": false,\n" +
                        "  \"email\": \"test.account@userinfo.com\",\n" +
                        "  \"clientID\": \"q2hnj2iu...\",\n" +
                        "  \"updated_at\": \"2016-12-05T15:15:40.545Z\",\n" +
                        "  \"name\": \"test.account@userinfo.com\",\n" +
                        "  \"picture\": \"https://s.gravatar.com/avatar/dummy.png\",\n" +
                        "  \"user_id\": \"auth0|58454...\",\n" +
                        "  \"nickname\": \"test.account\",\n" +
                        "  \"identities\": [\n" +
                        "    {\n" +
                        "      \"user_id\": \"58454...\",\n" +
                        "      \"provider\": \"auth0\",\n" +
                        "      \"connection\": \"Username-Password-Authentication\",\n" +
                        "      \"isSocial\": false\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"created_at\": \"2016-12-05T11:16:59.640Z\",\n" +
                        "  \"sub\": \"auth0|58454...\"\n" +
                        "}");
        server.enqueue(response);
    }

    public void resetPasswordResponse() {
        MockResponse response = new MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json")
                .setBody("We've just sent you an email to reset your password.");
        server.enqueue(response);
    }

    public void signUpResponse() {
        MockResponse response = new MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json")
                .setBody("{\n" +
                        "  \"_id\": \"58457fe6b27...\",\n" +
                        "  \"email_verified\": false,\n" +
                        "  \"email\": \"test.account@signup.com\"\n" +
                        "}");
        server.enqueue(response);
    }

    public void loginResponse() {
        MockResponse response = new MockResponse()
                .setResponseCode(200)
                .addHeader("Content-Type", "application/json")
                .setBody("{\n" +
                        "  \"access_token\":\"eyJz93a...k4laUWw\",\n" +
                        "  \"refresh_token\":\"GEbRxBN...edjnXbL\",\n" +
                        "  \"id_token\":\"eyJ0XAi...4faeEoQ\",\n" +
                        "  \"token_type\":\"Bearer\",\n" +
                        "  \"expires_in\":86400\n" +
                        "}");
        server.enqueue(response);
    }
}