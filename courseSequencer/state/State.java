package courseSequencer.state;

import courseSequencer.util.Student;

public class State{
    State1 state1;
    State2 state2;
    State3 state3;
    State4 state4;
    State5 state5;
    State state;
    int  sttranscount;
    //String groupN;


    public State(){
        sttranscount = 0;
    }
    public void createallstate(){
        state1 = new State1("1");
        state2 = new State2("2");
        state3 = new State3("3");
        state4 = new State4("4");
        state5 = new State5("5");
        state = state1;
    }

    public void determinenextstate(Student student){
        String currgroupN = (state).getgroupN();
        //System.out.println("determine current state::"+currgroupN);
        int currentstatesize = student.getgroupsize(currgroupN);
        int nxtstategrpN = Integer.parseInt(currgroupN);

        for(int i = 1; i <= 5; i++){
            if(student.getgroupsize(String.valueOf(i)) > currentstatesize){
               nxtstategrpN = i;
            }
        }
        if(currgroupN.equals(String.valueOf(nxtstategrpN))){
            //System.out.println("determine next state 11::"+nxtstategrpN);
            return;
        }

        if(nxtstategrpN == 1){
            state = state1;
            sttranscount++;
        }else if(nxtstategrpN == 2){
            state = state2;
            sttranscount++;
        }else if(nxtstategrpN == 3){
            state = state3;
            sttranscount++;
        }else if(nxtstategrpN == 4){
            state = state4;
            sttranscount++;
        }else if(nxtstategrpN == 5){
            state = state5;
            sttranscount++;
        }
       // System.out.println("determine next state ::"+nxtstategrpN);
    }
    public int getsttranscount(){
        return sttranscount;
    }
   
    public String getgroupN(){
        return "";
    }    
}
