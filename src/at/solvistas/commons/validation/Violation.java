package at.solvistas.commons.validation;

import java.io.Serializable;

public class Violation implements Serializable {
	private static final long serialVersionUID = -1190998474722614089L;

	private String propertyName;
	private String message;
	private Object value;

	public Violation(String propertyName, String message, Object value) {
		super();
		this.propertyName = propertyName;
		this.message = message;
		this.value = value;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public String getMessage() {
		return message;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Violation [message=");
		builder.append(message);
		builder.append(", propertyName=");
		builder.append(propertyName);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
}
