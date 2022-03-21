/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tube;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;
import javax.servlet.http.HttpSession;
import login.SessionUtils;

/**
 *
 * @author Arek
 */
@Named("andreBean")
@SessionScoped
public class AndreBean implements Serializable {

    private String value;

    public void runSubmit() {
        System.out.println("Submit executed");
    }

    public String getValue() {
        System.out.println("getValue");
        return value;
    }

    public void setValue(String value) {
        System.out.println("setValue: " + value);
        this.value = value;
    }

    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }

}
