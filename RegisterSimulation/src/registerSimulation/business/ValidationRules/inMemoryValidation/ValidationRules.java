package registerSimulation.business.ValidationRules.inMemoryValidation;

import java.util.ArrayList;
import java.util.List;

import registerSimulation.core.utilities.results.ErrorResult;
import registerSimulation.core.utilities.results.Result;
import registerSimulation.core.utilities.results.SuccessResult;

public class ValidationRules {
	// kontrol edilen metotlarýn duru
	 public static List<Result> resultList = new ArrayList<Result>();
	 public static Result[] run(Result... results) {
		
		 for(Result result : results) {
    		 if(!result.isSuccess()) {
    			 resultList.add(result);
    			
    		 }
    			
    			
    	 }
		 return resultList.toArray(new Result[resultList.size()]);
		
     }
}
