package utils;

import org.aeonbits.owner.ConfigFactory;

public class Credentionlmpl {

    public static CredentialManager getCredConfig() {
        return ConfigFactory.create(CredentialManager.class, System.getProperties());
    }
}
