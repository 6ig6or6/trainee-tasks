package org.example.gofpatterns.chainofresponsibility;

import org.example.gofpatterns.chainofresponsibility.provider.OAuthTokenProvider;
import org.example.gofpatterns.chainofresponsibility.provider.UnsecuredProvider;
import org.example.gofpatterns.chainofresponsibility.provider.UsernamePasswordProvider;

public class Main {
    public static void main(String[] args) {
        AuthenticationProcessor authProcessorChain = getChainOfAuthProcessor();
        System.out.println(authProcessorChain.isAuthorized(new OAuthTokenProvider()));
        System.out.println(authProcessorChain.isAuthorized(new UsernamePasswordProvider()));
        System.out.println(authProcessorChain.isAuthorized(new UnsecuredProvider()));

    }
    private static AuthenticationProcessor getChainOfAuthProcessor() {
        AuthenticationProcessor oAuthProcessor = new OAuthProcessor(null);
        return new UsernamePasswordProcessor(oAuthProcessor);
    }
}
