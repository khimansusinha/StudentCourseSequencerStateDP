package courseSequencer.util;

import java.io.IOException;
import java.util.ArrayList;

import courseSequencer.state.CourseSequencerStateI;
import courseSequencer.state.State;

public class Context implements CourseSequencerStateI{
    State state;
    private ArrayList<String> waitinglist;

    public Context(){
        state = new State();
        state.createallstate();
        waitinglist = new ArrayList<>();

    }

    @Override
    public void scheduler(FileProcessor resFp, ErrorLog errorFp, Results results) {
        Student student = new Student(StCourseGlobalData.studentid, "1");
        int selectedcount = 0;
        int semcount = 0;
        ArrayList<String> schedulelist = new ArrayList<>();
        while(StCourseGlobalData.preferencelist.size() != 0 || waitinglist.size() != 0){
            if(graduationdone(student)){
                break;
            }
            for(int i = 0; i < waitinglist.size(); i++){
                if(selectedcount == 3)
                    System.exit(0);

                if(prereqcheck(student, waitinglist.get(i), StCourseGlobalData.getgroupno(waitinglist.get(i)))){
                    schedulelist.add(waitinglist.get(i)) ;   
                    waitinglist.set(i, "remove");
                    selectedcount++;
                }  
            }
            for(int i = 0; i < waitinglist.size(); i++){
                if(waitinglist.get(i).equals("remove")){
                    waitinglist.remove(i);
                }
            }
            while(selectedcount < 3){
                String pref = StCourseGlobalData.getstudentpref();
                if(!pref.equals("")){
                    if(prereqcheck(student, pref, StCourseGlobalData.getgroupno(pref))){
                        schedulelist.add(pref);
                        selectedcount++;
                    }else{
                        //System.out.println("adding in waitlist::"+pref);
                        waitinglist.add(pref);
                    }      
                }else{
                    //System.out.println("finished global pref list");
                    break;
                }
            }
            for(int i = 0; i < schedulelist.size(); i++){
                if(graduationdone(student)){
                    //System.out.println("No of transcount =  "+state.getsttranscount());
                    break;
                }
                schedule(student, schedulelist.get(i));
            }
            schedulelist.clear();
            semcount++;
            selectedcount = 0;
            determinechangeGroup(state, student);
        }
        if(!graduationdone(student)){
            semcount = 0;
        }
        results.writeInFP(resFp, ""+student.studentid+":");
        results.printStdOut(""+student.studentid+":");
        for(int i = 0; i<student.completedcourse.size(); i++){
            results.writeInFP(resFp, " "+student.completedcourse.get(i));
            results.printStdOut(" "+student.completedcourse.get(i));
        }
        results.writeInFP(resFp, " -- ");
        results.printStdOut(" -- ");
        results.writeInFP(resFp, " "+semcount);
        results.printStdOut(" "+semcount);
        results.writeInFP(resFp, " "+state.getsttranscount());
        results.printStdOut(" "+state.getsttranscount());

        try {
            resFp.wf.close();
           
        } catch (IOException e) {
            System.err.println("Failed to close for output.txt file");
            e.printStackTrace();
            System.exit(0);
        } finally{
            try {
                errorFp.af.close();
            } catch (IOException e) {
                System.err.println("Failed to close for error file");
                e.printStackTrace();
                System.exit(0);
            }
        }  
    }

    @Override
    public void determinechangeGroup(State state, Student student) {
        state.determinenextstate(student);
       
    }

    public void schedule(Student student, String pref){
        student.completedcourse.add(pref);
        String getgrpno = StCourseGlobalData.getgroupno(pref);
        student.addcourseinrespectivegr(getgrpno, pref);
    }

    //method for prerequisite check
    public boolean prereqcheck(Student student, String courseN, String groupN){
        Course course = new Course(courseN, groupN);
        boolean flag = true;
        
        ArrayList<String> prereqL = new ArrayList<>(course.getpreqclist(groupN, courseN));
        if(prereqL.size() != 0){
            if(student.completedcourse.size() == 0){
                   return false;
                }
            for(int j = 0; j < prereqL.size(); j++){
                if(!student.completedcourse.contains(prereqL.get(j))){
                    flag = false;
                    break;
                }
            }
        }else{
            if(courseN.equals("A") || courseN.equals("E") || 
               courseN.equals("I") || courseN.equals("M") || 
               (courseN.compareTo("Q") >= 0 && courseN.compareTo("Z") <= 0)){
                flag = true; 
            }else{
                flag = false;
            }  
        }
        return flag;
    }

    public boolean graduationdone(Student student){
        if(student.courseingroup1.size() >= 2 && student.courseingroup2.size() >= 2 
            && student.courseingroup3.size() >= 2 && student.courseingroup4.size() >= 2
            && student.courseingroup5.size() >= 2 && student.completedcourse.size() >= 10){
                return true;
            }
        return false;
    }



   



   
    
}
