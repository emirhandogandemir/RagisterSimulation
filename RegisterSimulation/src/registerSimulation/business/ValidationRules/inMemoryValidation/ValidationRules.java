package registerSimulation.business.ValidationRules.inMemoryValidation;

import java.util.ArrayList;
import java.util.List;

import registerSimulation.core.utilities.results.ErrorResult;
import registerSimulation.core.utilities.results.Result;
import registerSimulation.core.utilities.results.SuccessResult;

public class ValidationRules {
	 public static Result [] run(Result... results) {
		 List<Result> resultList = new ArrayList<Result>();
		 for(Result result : results) {
    		 if(!result.isSuccess()) {
    			 resultList.add(result);
    		 }
    			 //return new ErrorResult();
    			
    	 }
		 return resultList.toArray(new Result[resultList.size()]);
     }
}
