import java.io.*;

public class Size {
	
	private String fileName;
	public Size(String fileName){
		this.fileName = fileName;
	}
	
	 public long getTxtFileSize() {
			// Récupère et retourne la taille du fichier texte 
		   	File file = new File(fileName+"/"+fileName+".txt");
		    long fileTxtSize = file.length();
		    System.out.println("La taille de "+fileName+".txt est : "+fileTxtSize+" octets \n");
		   	return fileTxtSize;
		   }

	 public long getCompFileSize() {
			// Récupère et retourne la taille du fichier compressé 
	    	File file = new File(fileName+"/"+fileName+"_comp.bin");
	        long fileCompSize = file.length();
	        System.out.println("La taille de "+fileName+"_comp.bin est : "+fileCompSize+" octets \n");
	    	return fileCompSize;
	    }

	 public void getMoy() {
		 // Calcule et affiche le taux de compression avec la formule donnée dans le sujet
	        double amount = 1 - (double) this.getCompFileSize() / this.getTxtFileSize();
	        System.out.println("Le taux est de : " + String.format("%.3f", amount)+"\n");
	 }
	 
	 public void getNb() throws IOException {
		 // Calcule et affiche le nombre moyen de bits.
		 
		 int lengthAlpha = (int)this.getTxtFileSize();
	     
	     BinaryFileReader bfr = new BinaryFileReader(fileName); 
	     String code = bfr.readBinaryFile();
	     int lengthCode = code.length();
	     
	     float average = (float)lengthCode/lengthAlpha;
	     System.out.println ("La moyenne est: "+ String.format("%.2f",average)+"\n");
	 }
		 			
}
