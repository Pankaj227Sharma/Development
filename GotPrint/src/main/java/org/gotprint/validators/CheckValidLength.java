package org.gotprint.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("org.gotprint.validators.CheckValidLength")
public class CheckValidLength implements Validator{

	@Override
	public void validate(FacesContext facesContext,UIComponent component, Object value) throws ValidatorException {
		String text = value.toString();
		System.out.println("Validator Called " + text.length());
		if(text.length()<5 || text.length()>100){
			FacesMessage msg =
		            new FacesMessage("notes validation failed","Notes should only be of 100 characters");
		         msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		         throw new ValidatorException(msg);
		}
		
	}
	
	

}
