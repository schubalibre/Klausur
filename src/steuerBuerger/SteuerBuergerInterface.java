package steuerBuerger;

public interface SteuerBuergerInterface {
	public int addSteuerBuerger(Person buerger) throws DuplicateEntryException;
	public Person getSteuerBuerger(int steuernummer) throws NotFoundException;
	public int getSteuernummer(Person buerger) throws NotFoundException;
	public int anzahlSteuerBuerger();
}
