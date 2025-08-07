package com.selenium.dataprovider;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/main/resources/envconfig.properties"})
public interface PropReader extends Config {

    @DefaultValue("staging")
    String environment();
    @Key("${environment}.username")
    String username();
    @Key("${environment}.password")
    String password();
    @Key("${environment}.url")
    String url();
}