package courseSequencer.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileProcessor {
	public File fp;
    public BufferedReader bf;
    public BufferedWriter wf, af;
    public String modeFp;
    BufferedWriter errFpObj;
    public FileProcessor(String fname,String mode){
        fp = new File(fname);
        modeFp = mode;
        try {
            if(mode == "r"){
               bf = new BufferedReader(new FileReader(fp));
            }else if(mode == "w"){
                try {
                    wf = new BufferedWriter(new FileWriter(fp,false));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else if(mode == "a"){
                 try {
                    af = new BufferedWriter(new FileWriter(fp,true));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else{
                System.out.println("Invalid File Open Mode has given in input");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void fanoutCourseObj(ErrorLog errorFp){
        String str;
         try {
            while((str = bf.readLine()) != null){
                String studentid = "";
                String course = "";
                StringTokenizer strTok = new StringTokenizer(str,": ");
                Boolean flag = false;
               
                
                while(strTok.hasMoreTokens()){
                    if(flag == false){
                       studentid = strTok.nextToken();
                       StCourseGlobalData.studentid = studentid;
                       flag = true;
                    }else{
                        course =strTok.nextToken();
                        StCourseGlobalData.addCoursepref(course);
                    }
                }
              
            }
            //System.out.println("Student id::"+StCourseGlobalData.studentid+"  "+StCourseGlobalData.preferencelist+"::FileProcessor.java");
            bf.close(); 
        } catch (IOException e) {
            errorFp.writeError("Failed to parse input file");
            System.err.println("Failed to parse input file");
            e.printStackTrace();
            System.exit(0);
        }

    }
    
            
    
 }
