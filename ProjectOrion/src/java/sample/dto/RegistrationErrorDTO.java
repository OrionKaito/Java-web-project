/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;

import java.io.Serializable;

/**
 *
 * @author Orion
 */
public class RegistrationErrorDTO implements Serializable{
    private String usernameErr;
    private String passwordErr;
    private String phoneErr;
    private String emailErr;

    public String getPhoneErr() {
        return phoneErr;
    }

    public void setPhoneErr(String phoneErr) {
        this.phoneErr = phoneErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }

    
    
    public String getUsernameErr() {
        return usernameErr;
    }

    public void setUsernameErr(String usernameErr) {
        this.usernameErr = usernameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public RegistrationErrorDTO() {
    }

    public RegistrationErrorDTO(String usernameErr, String passwordErr) {
        this.usernameErr = usernameErr;
        this.passwordErr = passwordErr;
    }

    public RegistrationErrorDTO(String usernameErr, String passwordErr, String phoneErr, String emailErr) {
        this.usernameErr = usernameErr;
        this.passwordErr = passwordErr;
        this.phoneErr = phoneErr;
        this.emailErr = emailErr;
    }
    
    
}
