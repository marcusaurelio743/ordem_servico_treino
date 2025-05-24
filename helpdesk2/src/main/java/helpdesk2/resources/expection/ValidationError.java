package helpdesk2.resources.expection;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();

	public ValidationError() {
		super();
	}

	public ValidationError(Long timestemp, Integer status, String error, String message, String path) {
		super(timestemp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void AddError(String FieldName, String message) {
		FieldMessage fieldMessage= new FieldMessage(FieldName, message);
		
		this.errors.add(fieldMessage);
	}
	
	
	
	

}
