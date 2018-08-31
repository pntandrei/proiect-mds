/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarie;

import java.sql.Date;

/**
 *
 * @author DOMNUL STEFAN
 */
public class inchiriere {
     private int ID;
    private String Nume_s;
    private String Nume_c;
    private Date Data;
    public inchiriere(int id, String numes, String numec, Date data){
        this.ID = id;
        this.Nume_s = numes;
        this.Nume_c = numec;
        this.Data = data;
    }
    
    public int getID() {
            return ID;
        }

        public String getNUMES() {
            return Nume_s;
        }

        public String getNUMEC() {
            return Nume_c;
        }

        public Date getDATA() {
            return Data;
        }

}
