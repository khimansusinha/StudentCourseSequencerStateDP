package courseSequencer.state;

import courseSequencer.util.ErrorLog;
import courseSequencer.util.FileProcessor;
import courseSequencer.util.Results;
import courseSequencer.util.Student;

public interface CourseSequencerStateI {
    public void scheduler(FileProcessor resFp, ErrorLog errorFp, Results results);
    public void determinechangeGroup(State state, Student student);   
}