package org.example.gofpatterns.chainofresponsibility;

import org.example.gofpatterns.chainofresponsibility.provider.AbstractProvider;

import java.security.AuthProvider;

public abstract class AuthenticationProcessor {
    public AuthenticationProcessor nextProcessor;

    public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
    public abstract boolean isAuthorized(AbstractProvider abstProvider);
}
