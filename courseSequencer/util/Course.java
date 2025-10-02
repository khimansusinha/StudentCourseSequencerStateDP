package courseSequencer.util;

import java.util.ArrayList;

public class Course {
    String name;
    String group;
    ArrayList<String> prereq;

    public Course(String namein, String groupin){
        name = namein;
        group = groupin;
        prereq = new ArrayList<>();    
    }
    public ArrayList<String> getpreqclist(String group, String cname){
        ArrayList<String> retlist = new ArrayList<>();
        //System.out.println("group name::"+group+" ::cname ="+cname);
         if(group.equals("1")){
            if(cname.equals("B")){
                prereq.add("A");
            }else if(cname.equals("C")){
                prereq.add("A");
                prereq.add("B");
            }else if(cname.equals("D")){
                prereq.add("A");
                prereq.add("B");
                prereq.add("C");
            }
        }else if(group.equals("2")){
            if(cname.equals("F")){
                prereq.add("E");
            }else if(cname.equals("G")){
                prereq.add("E");
                prereq.add("F");
            }else if(cname.equals("H")){
                prereq.add("E");
                prereq.add("F");
                prereq.add("G");
            }
        }else if(group.equals("3")){
            if(cname.equals("J")){
                prereq.add("I");
            }else if(cname.equals("K")){
                prereq.add("I");
                prereq.add("J");
            }else if(cname.equals("L")){
                prereq.add("I");
                prereq.add("J");
                prereq.add("K");
            }
        }else if(group.equals("4")){
            if(cname.equals("N")){
                prereq.add("M");
            }else if(cname.equals("O")){
                prereq.add("M");
                prereq.add("N");
            }else if(cname.equals("P")){
                prereq.add("M");
                prereq.add("N");
                prereq.add("O");
            }
        }
        retlist.addAll(prereq);
        prereq.clear();
        return retlist;
    }
}


    

