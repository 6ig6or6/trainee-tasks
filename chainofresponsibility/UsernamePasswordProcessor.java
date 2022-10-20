package org.example.gofpatterns.chainofresponsibility;

import org.example.gofpatterns.chainofresponsibility.provider.AbstractProvider;
import org.example.gofpatterns.chainofresponsibility.provider.UsernamePasswordProvider;

import java.security.AuthProvider;

public class UsernamePasswordProcessor extends AuthenticationProcessor {
    public UsernamePasswordProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AbstractProvider authProvider) {
        if (authProvider instanceof UsernamePasswordProvider) {
            return true;
        } else if (nextProcessor != null) {
            return nextProcessor.isAuthorized(authProvider);
        }
        return false;
    }
}
