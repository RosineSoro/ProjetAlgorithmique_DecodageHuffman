import java.io.*;





public class BinaryFileReader {
    private String fileName;

    
    //constructeur
    public BinaryFileReader(String fileName){this.fileName = fileName;}
    
    //getters and setters
    public String getFileName() {return fileName;}
    public void setFileName(String fileName) {this.fileName = fileName;}
    
    
    
    public String readBinaryFile(){
        String binaryString = "";
        try {
        	
            FileInputStream binaryFile = new FileInputStream(new File(fileName+"/"+fileName+"_comp.bin"));
            
            //Convertit inputStream en BufferedInputStream pour une optimisation de la lecture du fichier
            BufferedInputStream binFileReader = new BufferedInputStream(binaryFile);
            
            //La variable bit est utilisée pour récuperer la valeur lue dans le fichier .
            int bit;
            
            //La variable i est utilisée pour garder une trace du nombre de bits lus.
            int i = 0;
            
            
            while ((bit = binFileReader.read()) != -1) {
            	
            	/*Tant que la valeur renvoyée par la lecture du fichier binaire n'est pas '-1', c'est-à-dire que la fin du fichier n'est pas atteinte
                 * l'entier retourné est converti en binaire */
            	
                String sbit = Integer.toBinaryString(bit);
                i+=1;
                
                /* Si i = 1, on ajoute sbit à binaryString
                 * sinon, on formate sbit de telle sorte qu'elle occupe toujours 8 bits, en remplaçant les espaces par des zéros
                 */
                
                if (i == 1){
                    binaryString += sbit;
                }
                else{
                    String sbit_replace = String.format("%8s", sbit).replace(" ", "0");
                    binaryString += sbit_replace;
                }

            }

            binFileReader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return binaryString;
    }
}


