
package org.hkfree.topoagent.postuninstall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Zruseni naplanovane ulohy
 * 
 * @author Filip Valenta
 */
public class TopoAgentPostUninstall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String createScheduledTask = "SCHTASKS /Delete /TN \"TopoAgent\" /F";
        execCommand(createScheduledTask, "");
        
    }
    
    private static void execCommand(String command, String notice) {
        try {
            Process p = Runtime.getRuntime().exec(command);
            String line;

            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (line.trim().equals("")) {
                    continue;
                }
                System.out.println(line.trim());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
