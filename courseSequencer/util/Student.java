package courseSequencer.util;

import java.util.ArrayList;

public class Student {
    String studentid;
    String state;
    ArrayList<String> completedcourse;
    ArrayList<String> courseingroup1;
    ArrayList<String> courseingroup2;
    ArrayList<String> courseingroup3;
    ArrayList<String> courseingroup4;
    ArrayList<String> courseingroup5;

    public Student(String studentidin, String statein){
        studentid = studentidin;
        state = statein;
        completedcourse = new ArrayList<>();
        courseingroup1 = new ArrayList<>();
        courseingroup2 = new ArrayList<>();
        courseingroup3 = new ArrayList<>();
        courseingroup4 = new ArrayList<>();
        courseingroup5 = new ArrayList<>();
    }

    public void addcourseinrespectivegr(String getgrpno, String course){
        if(getgrpno.equals("1")){
            courseingroup1.add(course);
        }else if(getgrpno.equals("2")){
            courseingroup2.add(course);
        }else if(getgrpno.equals("3")){
            courseingroup3.add(course);
        }else if(getgrpno.equals("4")){
            courseingroup4.add(course);
        }else if(getgrpno.equals("5")){
            courseingroup5.add(course);
        }

    }

    public int getgroupsize(String grpno){
        if(grpno.equals("1")){
            return courseingroup1.size();
        }else if(grpno.equals("2")){
            return courseingroup2.size();
        }else if(grpno.equals("3")){
            return courseingroup3.size();
        }else if(grpno.equals("4")){
            return courseingroup4.size();
        }else if(grpno.equals("5")){
            return courseingroup5.size();
        }else{
            return -1;
        }
    }
    
}
