/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaserver;

import java.io.PrintWriter;

/**
 *
 * @author Simba
 */
public class UserData
{
    String userName;

    public String getUserName()
    {
        return userName;
    }

    public PrintWriter getPw()
    {
        return pw;
    }
    PrintWriter pw;
    
    public UserData(String un,PrintWriter pwrite)
    {
        userName=un;
        pw=pwrite;
    }
}
