package steuerBuerger;

import java.util.HashMap;
import java.util.Map;

public class SteuerBuerger implements SteuerBuergerInterface {
	
	Map<Integer, Person> steuerBuergerMap = new HashMap<>();
	
	@Override
	public int addSteuerBuerger(Person buerger) throws DuplicateEntryException {
		int steuernummer = buerger.getSteuernummer();
		if(steuerBuergerMap.containsKey(steuernummer)) throw new DuplicateEntryException();
		steuerBuergerMap.put(steuernummer, buerger);
		return steuernummer;
	}

	@Override
	public Person getSteuerBuerger(int steuernummer) throws NotFoundException {
		if(!steuerBuergerMap.containsKey(steuernummer)) throw new NotFoundException();
		return steuerBuergerMap.get(steuernummer);
	}

	@Override
	public int getSteuernummer(Person buerger) throws NotFoundException {
		if(!steuerBuergerMap.containsValue(buerger)) throw new NotFoundException();
		return buerger.getSteuernummer();
	}

	@Override
	public int anzahlSteuerBuerger() {
		return steuerBuergerMap.size();
	}

}
