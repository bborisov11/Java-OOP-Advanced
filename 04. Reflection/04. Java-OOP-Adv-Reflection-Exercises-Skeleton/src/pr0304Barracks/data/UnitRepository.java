package pr0304Barracks.data;

import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.Unit;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class UnitRepository implements Repository {

	public static final String UNITS_PATH = "pr0304Barracks.models.units.";
	private Map<String, Integer> amountOfUnits;

	public UnitRepository() {
		this.amountOfUnits = new TreeMap<>();
	}

	public void addUnit(Unit unit) {
		String unitType = unit.getClass().getSimpleName();
		if (!this.amountOfUnits.containsKey(unitType)) {
			this.amountOfUnits.put(unitType, 0);
		}

		int newAmount = this.amountOfUnits.get(unitType) + 1;
		this.amountOfUnits.put(unitType, newAmount);
	}

	public String getStatistics() {
		StringBuilder statBuilder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
			String formatedEntry =
					String.format("%s -> %d%n", entry.getKey(), entry.getValue());
			statBuilder.append(formatedEntry);
		}
		statBuilder.setLength(
				statBuilder.length() - System.lineSeparator().length());

		return statBuilder.toString();
	}

	public void removeUnit(String unitType){ //throws ExecutionControl.NotImplementedException {

		if(!this.amountOfUnits.containsKey(unitType) || this.amountOfUnits.get(unitType) <= 0) {
			throw new NoSuchElementException("No such units in repository.");
		}
			int currentCount = this.amountOfUnits.get(unitType) - 1;
			this.amountOfUnits.put(unitType, currentCount);
	}
}
