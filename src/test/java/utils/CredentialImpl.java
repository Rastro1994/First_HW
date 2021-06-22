package utils;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/creds.properties"
})
public interface CredentialImpl extends Config {

    @Config.Key("login")
    String getLogin();

    @Config.Key("password")
    String getPassword();

}
