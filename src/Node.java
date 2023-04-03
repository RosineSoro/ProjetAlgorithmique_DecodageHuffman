import java.util.Objects;
public class Node implements Comparable {
	
	//déclaration des variables
	private String label;
	private int  occurrence;
	private Node leftChild;
	private Node rightChild;
	private String branch;
	

	//constructeur1
	public Node(String label,int occurrence, Node leftChild, Node rightChild)
	{
		this.label = label;
		this.occurrence = occurrence;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.branch= "";
	}
    
	//constructeur2
	public Node(String label,int occurrence)
	{
		this.label = label;
		this.occurrence = occurrence;
	}
	
		

	//getters and setters
	public String getLabel() {return label;}
    public void setLabel(String label) {this.label = label;}
    
	public int getOccurrence() {return occurrence;}
	public void setOccurrence(int occurrence) {this.occurrence = occurrence;}

	public Node getLeftChild() {return leftChild;}
	public void setLeftChild(Node leftChild) {this.leftChild = leftChild;}

	public Node getRightChild() {return rightChild;}
	public void setRightChild(Node rightChild) {this.rightChild = rightChild;}

	public String getBranch() {return branch;}
	public void setBranch(String direction) {this.branch= direction;}

   
		
	
	@Override
	public String toString() {
		return "(" + label + "," + occurrence + ")";
	}

	@Override
	public int compareTo(Object o) {
		if (this.occurrence > ((Node)o).getOccurrence())
			return 1;
		if (this.occurrence == ((Node)o).getOccurrence() && this.label.compareTo(((Node)o).getLabel()) > 0 )
			return 1;
		return -1;
	}
	
	@Override
	public boolean equals(Object obj) {
    	if (obj == this) {
        return true;
    	}
    	if (!(obj instanceof Node)) {
        return false;
    	}
    	Node other = (Node) obj;
    	return Objects.equals(label, other.label) && occurrence == other.occurrence;
	}

}
	
	
