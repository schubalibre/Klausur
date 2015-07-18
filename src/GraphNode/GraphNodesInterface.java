package GraphNode;

public interface GraphNodesInterface {
	public int addNode(String name) throws DuplicateNameException;
	public String getNode(int index) throws NodeNotFoundException;
	public int getNode(String name) throws NodeNotFoundException;
	public int numberOfNodes();
}
