package at.solvistas.commons.validation;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.engine.ResourceBundleMessageInterpolator;

public class Validator {
	private javax.validation.Validator beanValidationValidator;

	public Validator() {
		this(Locale.getDefault());
	}

	public Validator(Locale locale) {
		Configuration<?> configuration = Validation.byDefaultProvider()
				.configure();
		ValidatorFactory factory = configuration.messageInterpolator(
				new ResourceBundleMessageInterpolator(ResourceBundle.getBundle(
						"ValidationMessages", Locale.GERMAN)))
				.buildValidatorFactory();
		beanValidationValidator = factory.getValidator();
	}

	public Violations validate(Object o) {
		Violations result = new Violations();
		Set<ConstraintViolation<Object>> violations = beanValidationValidator
				.validate(o);
		for (ConstraintViolation<Object> violation : violations) {
			result.addViolation(violation.getPropertyPath().toString(),
					violation.getMessage(), violation.getInvalidValue());
		}
		return result;
	}
}
