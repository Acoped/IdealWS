/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idealModel;

import idealWS.checkStudent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Molnet
 */
public class IdealId {
    private int id;
    
    private IdealId(){}
    
    public IdealId(String ideal, String enrollCode)    {
        DbConnection db = new DbConnection();
        setId(999);
          
        try {
            ResultSet rs = db.runSql("SELECT Id FROM ideal.studentenrolled WHERE Ideal = '"
                    + ideal
                    + "' AND EnrollCode = '"
                    + enrollCode
                    + "';");
            while (rs.next()) {
                setId(rs.getInt("Id"));
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(checkStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
