import java.util.Date;
import java.util.Locale;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import at.solvistas.commons.validation.Violations;

/** nochn GIT Tests **/
public class TestBean {

	@NotNull
	private String notNull;
	@Length(min = 3, max = 5)
	private String email = "dsslsds.at";
	@Future
	private Date jetzt = new Date();

	public static void main(String[] args) {
		TestBean t = new TestBean();

		at.solvistas.commons.validation.Validator validator = new at.solvistas.commons.validation.Validator(
				Locale.GERMAN);

		Violations result = validator.validate(t);
		System.out.println(result.toString());

	}
}
