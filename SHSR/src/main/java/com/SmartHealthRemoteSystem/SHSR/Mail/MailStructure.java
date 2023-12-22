package com.SmartHealthRemoteSystem.SHSR.Mail;

public class MailStructure {
    private String to;
    private String password;
    
    public MailStructure(String to, String password) {
        this.to = to;
        this.password = password;
    }
    public String getTo(){
        return to;
    }
    public void setTo(String to){
        this.to = to;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
