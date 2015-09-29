package steuerBuerger;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SteuerBuerger2 implements SteuerBuergerInterface {
	
	private Map<Integer, Person> steuerBuergerMap = new HashMap<>();
	
	@Override
	public int addSteuerBuerger(Person buerger) throws DuplicateEntryException {
		int steuernummer = this.anzahlSteuerBuerger();
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
		
		int steuernummer = -1;
		
		for ( Entry<Integer, Person> person : steuerBuergerMap.entrySet()){
			  if(buerger.equals(person.getValue())){
				  steuernummer = person.getKey();
			  }
		}
		return steuernummer;
	}

	@Override
	public int anzahlSteuerBuerger() {
		return steuerBuergerMap.size();
	}

}
