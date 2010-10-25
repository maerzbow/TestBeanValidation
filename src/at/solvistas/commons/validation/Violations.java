package at.solvistas.commons.validation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Violations implements Serializable {
	private static final long serialVersionUID = 3935416271227783754L;

	private Map<String, Set<Violation>> violationMap = new HashMap<String, Set<Violation>>();

	void addViolation(String propertyName, String message, Object value) {
		Violation v = new Violation(propertyName, message, value);

		Set<Violation> violationsPerProperty = violationMap.get(propertyName);
		if (violationsPerProperty == null) {
			violationsPerProperty = new HashSet<Violation>();
			violationMap.put(propertyName, violationsPerProperty);
		}

		violationsPerProperty.add(v);
	}

	public Set<Violation> getViolations(String propertyName) {
		return violationMap.get(propertyName);
	}

	public boolean hasViolations(String propertyName) {
		return !getViolations(propertyName).isEmpty();
	}

	public boolean hasViolations() {
		return !violationMap.isEmpty();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Set<Violation>> entry : violationMap.entrySet()) {
			sb.append(entry.getKey()).append(":\n");
			for (Violation v : entry.getValue()) {
				sb.append(v.toString()).append("\n");
			}
		}
		return sb.toString();
	}

}
