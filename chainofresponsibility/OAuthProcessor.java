package org.example.gofpatterns.chainofresponsibility;

import org.example.gofpatterns.chainofresponsibility.provider.AbstractProvider;
import org.example.gofpatterns.chainofresponsibility.provider.OAuthTokenProvider;

import java.security.AuthProvider;

public class OAuthProcessor extends AuthenticationProcessor {
    public OAuthProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AbstractProvider authProvider) {
        if (authProvider instanceof OAuthTokenProvider) {
           return true;
        }
        else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProvider);
        }
        return false;
    }
}
