package courseSequencer.state;

public class State2 extends State{
    String groupN;

    public State2(String groupno){
        groupN = groupno;
    }
    public String getgroupN(){
        return groupN;
    }    
}
