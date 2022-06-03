/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group.pkg6.phase.pkg3;

import java.time.LocalDate;

/**
 *
 * @author Ahmed Desouki
 */
public interface Subject {
    void addObserver(int customerid,String username );
    void removeObserver(int custid);
   
    void notifyy();
}
