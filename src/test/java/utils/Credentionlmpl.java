package utils;

import org.aeonbits.owner.ConfigFactory;

public class Credentionlmpl {

    public static CredentialImpl getCredConfig() {
        return ConfigFactory.create(CredentialImpl.class, System.getProperties());
    }
}

