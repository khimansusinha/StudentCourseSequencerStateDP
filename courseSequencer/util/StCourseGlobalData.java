package courseSequencer.util;

import java.util.ArrayList;

public class StCourseGlobalData {
    static String studentid;
    static ArrayList<String> preferencelist = new ArrayList<>();
    
    public static String getstudentpref(){
        if(preferencelist.size() == 0)
           return "";

        String pref = preferencelist.get(0);
        preferencelist.remove(0);

        return pref;
    }
    public static void addCoursepref(String course){
        preferencelist.add(course);

    }
     public static String getgroupno(String course){
        if(course.compareTo("A") >= 0 && course.compareTo("D") <= 0){
            return "1";
        }else  if(course.compareTo("E") >= 0 && course.compareTo("H") <= 0){
            return "2";
        }else  if(course.compareTo("I") >= 0 && course.compareTo("L") <= 0){
            return "3";
        }else  if(course.compareTo("M") >= 0 && course.compareTo("P") <= 0){
            return "4";
        }else  if(course.compareTo("Q") >= 0 && course.compareTo("Z") <= 0){
            return "5";
        }else{
            return "";
        }
     }
    


}
