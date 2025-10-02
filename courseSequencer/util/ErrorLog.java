package courseSequencer.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorLog {
    public File fp;
    public BufferedWriter af;
   
    public ErrorLog(String fname,String mode){
        fp = new File(fname);
            if(mode == "a"){
                try {
                    if(!fp.exists() || (fp.length() == 0)){
                        af = new BufferedWriter(new FileWriter(fp,false));
                        writeError("Error Message::\n");
                        af.close();
                    }
                    af = new BufferedWriter(new FileWriter(fp,true));
                } catch (IOException e) {
                    System.err.println("Failed to write in errorLog.txt file");
                    e.printStackTrace();
                    System.exit(0);
                }
            }else{
                System.out.println("Invalid File Open Mode has given in input");
            }
    }
    public void writeError(String msg){
        try {
            af.write(msg);
            af.flush();
        } catch (IOException e) {
            System.err.println("Failed to write in errorLog.txt file");
            e.printStackTrace();
            System.exit(0);
        }
     }
    
}
