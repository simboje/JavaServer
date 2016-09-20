/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simba
 */
public class ServerPanelTest
{
    String connString = "jdbc:mysql://localhost:3306/chatserver";
    public ServerPanelTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    Connection conn=null;
    @Before
    public void setUp()
    {
        try
        {
            conn = DriverManager.getConnection(connString,"root","");
            Statement stat = conn.createStatement();
            ResultSet rset = stat.executeQuery("select COUNT(*) from users");
            int i=0;
            while(rset.next())
            {
                i=rset.getInt(1);
            }
            assertNotEquals(0, i);
            
            ResultSet rsetx = stat.executeQuery("select COUNT(*) from messages");
            int ix=0;
            while(rsetx.next())
            {
                ix=rsetx.getInt(1);
            }
            assertNotEquals(0, ix);
        } 
        catch (SQLException ex)
        {
            fail("Connection to database failed. "+ex.toString());
        }
        catch (Exception e)
        {
            fail(e.toString());
        }
    }
    
    @After
    public void tearDown()
    {
        try
        {
            conn.close();
        } 
        catch (SQLException ex)
        {
            fail("Conn close failde.");
            Logger.getLogger(ServerPanelTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of main method, of class ServerPanel.
     */
    @Test
    public void testMain()
    {
        System.out.println("main");
        String[] args = null;
        ServerPanel.main(args);
        // TODO review the generated test code and remove the default call to fail.
        assertNotNull(conn);
    }
    
}
