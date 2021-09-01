package com.test.camel.ftp;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.remote.RemoteFile;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.stereotype.Service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

@Service
public class SFTPService {
    public void downloadAndProcessFile(Exchange exchange)
    {
       FTPFile ftpFile=(FTPFile) exchange.getIn().getBody(RemoteFile.class).getFile();
        exchange.getAllProperties().put("sample","sasas");
        InputStream is=exchange.getIn().getBody(InputStream.class);
        System.out.println();
        exchange.getIn().setHeader("error","false");
        FTPPojo ftpPojo=new FTPPojo();
        ftpPojo.setCheck(true);
       // return ftpPojo;
       // System.out.println("File: " + headers.get("fileName") + " | Content: " + fileContent + "|");
    }

    public void saveData(Exchange exchange){
        exchange.getAllProperties().get("sample");
        System.out.println("Save Data");
    }
}
