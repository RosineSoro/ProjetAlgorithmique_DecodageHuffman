import java.io.*;
import java.util.ArrayList;

public class Alphabet {
	
	//déclaration des attributs
	
	private String fileName;
    private ArrayList<Node> alphabet = new ArrayList<>();

    //constructeur 
    public Alphabet(String fileName) {
        this.fileName = fileName;
    }
    
    //getters and setters
    
    public String getFileName() {return fileName;}
	public void setFileName(String fileName) {this.fileName = fileName;}
    
	
	public ArrayList<Node> readFile() {
    	/*méthode qui lit le fichier contenant l'alphabet et qui stocke dans un ArrayList le caractère et son occurence
         * Elle retourne une liste de noeuds des caractères de l'aphabet
         * */
		
        try {
        	
        	//création d'un objet de type BufferedReader pour lire le fichier
          
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName+"/"+fileName+"_freq.txt"), "UTF-8"));
            
            /*lecture de la première ligne du fichier, qui contient la taille de l'alphabet. 
            *Cette taille est convertie en un entier et stockée dans la variable alphabetSize
            */
            
            String  ligne = reader.readLine();
            int alphabetSize = Integer.parseInt(ligne);
            
            // Lecture de chaque ligne suivante qui contient un caractère de l'alphabet et sa fréquence
            
            for (int i = 0; i < alphabetSize; i++) {
                ligne = reader.readLine();
                
               // Récupération du caractère et de sa fréquence

                String caractere = "" + ligne.charAt(0);
                int frequence = Integer.parseInt(ligne.substring(2));
                Node node = new Node (caractere, frequence);
                
                //insertion du caractère et de sa fréquence à alphabet
                alphabet.add(node);
            }
            
            //fermeture du fichier
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alphabet;
    }
 
}




