package courseSequencer.state;

public class State1 extends State {
    String groupN;

    public State1(String groupno){
        groupN = groupno;
    }
    public String getgroupN(){
        return groupN;
    }    
}
