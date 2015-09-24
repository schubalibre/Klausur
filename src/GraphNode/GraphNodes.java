package GraphNode;

import java.util.ArrayList;
import java.util.HashMap;


public class GraphNodes implements GraphNodesInterface{
	HashMap<String, Integer> indices = new HashMap<String, Integer>();
	ArrayList<String> nodes = new ArrayList<>();

	@Override
	public int addNode(String name) throws DuplicateNameException {
		if(nodes.contains(name)) throw new DuplicateNameException();
		nodes.add(name);
		indices.put(name, nodes.size()-1);
		return nodes.size()-1;
	}

	@Override
	public String getNode(int index) throws NodeNotFoundException {
		String node = nodes.get(index);
		if(node == null) throw new NodeNotFoundException();
		return node;
	}

	@Override
	public int getNode(String name) throws NodeNotFoundException {
		if(nodes.contains(name)) throw new NodeNotFoundException();
		return nodes.indexOf(name);
	}

	@Override
	public int numberOfNodes() {
		return nodes.size()-1;
	}
}
