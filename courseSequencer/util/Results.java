package courseSequencer.util;

import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    @Override
    public void writeInFP(FileProcessor fp, String msg) {
        try {
            if(fp.modeFp == "w"){
                fp.wf.write(msg);
            }
            fp.wf.flush();
        } catch (IOException e) {
            System.err.println("Failed to write in output.txt file");
            e.printStackTrace();
            System.exit(0);
        }
        
    }

    @Override
    public void printStdOut(String msg) {
        System.out.print(msg);
    }
	
}
