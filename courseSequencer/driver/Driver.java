package courseSequencer.driver;

import courseSequencer.util.Context;
import courseSequencer.util.ErrorLog;
import courseSequencer.util.FileProcessor;
import courseSequencer.util.Results;

/**
 * @author placeholder
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

		

	     if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}")
		  || args[2].equals("${arg2}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
			System.exit(0);
		}
		String argStr0 = args[0];
		String argStr1 = args[1];
		String argStr2 = args[2];

		//Error message inside error file
		ErrorLog errorFp = new ErrorLog(argStr2, "a");
		
		//course preference info file
		FileProcessor fpr1 = new FileProcessor(argStr0, "r");
		fpr1.fanoutCourseObj(errorFp);

        //result for course registration info file
		FileProcessor resFp = new FileProcessor(argStr1, "w");
		
		Results results = new Results();
		Context ctx = new Context();
		ctx.scheduler(resFp, errorFp, results);
		
	}
}
