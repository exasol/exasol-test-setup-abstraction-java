package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class CiUserApp {
    public static void main(final String[] args) {
        App app = new App();

        new CiUserStack(app, "CiUserStack");

        app.synth();
    }
}
