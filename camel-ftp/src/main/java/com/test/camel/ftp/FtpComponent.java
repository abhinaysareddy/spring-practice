package com.test.camel.ftp;

import org.apache.camel.builder.RouteBuilder;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class FtpComponent extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        URI fromFtpUrl = new URIBuilder()
                .setScheme("ftp")
                .setHost("localhost")

                .setPath("/ftp/read")
                .addParameter("username", "")
                .addParameter("password", "")
                .addParameter("passiveMode", "false")
                .addParameter("antInclude", "*.txt")
                .addParameter("initialDelay", "10s")
                .addParameter("delay", "50")
                .addParameter("idempotent","true")

                .build();
        URI errorURL = new URIBuilder()
                .setScheme("ftp")
                .setHost("localhost")

                .setPath("/ftp/error")
                .addParameter("username", "")
                .addParameter("password", "")
                .addParameter("passiveMode", "false")
                .addParameter("antInclude", "*.txt")
                .addParameter("initialDelay", "10s")
                .addParameter("delay", "50")

                .build();
        URI successURL = new URIBuilder()
                .setScheme("ftp")
                .setHost("localhost")

                .setPath("/ftp/success")
                .addParameter("username", "")
                .addParameter("password", "")
                .addParameter("passiveMode", "false")
                .addParameter("antInclude", "*.txt")
                .addParameter("initialDelay", "10s")
                .addParameter("delay", "50")

                .build();
        from(fromFtpUrl.toString())

                .streamCaching()
                .setHeader("fileName").simple("${file:name}")

                .bean(SFTPService.class, "downloadAndProcessFile")

               // .choice().when(new TestPredicate()).to(errorURL.toString())
                .choice().when(header("error").contains("false")).bean(SFTPService.class,"saveData").to(successURL.toString())
                .otherwise().to(errorURL.toString()).end()
                .log("Processing file ${file:name} complete.");



    }
}
