package de.rexlmanu.vplanapi.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class SecureWebsite extends Authenticator{

    private URL url;
    private String username;
    private String password;

    public SecureWebsite(URL url) {
        this.url = url;
    }

    public SecureWebsite setAutication(String username, String password){
        this.username = username;
        this.password = password;
        return  this;
    }

    public String getContent(){
        StringBuilder content = new StringBuilder();
        try {
            Authenticator.setDefault(this);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = in.readLine()) != null) content.append(line);
            in.close();
        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());

        }
        return content.toString();
    }


    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password.toCharArray());
    }
}
