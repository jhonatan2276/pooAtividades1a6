import java.util.Scanner;

public class HangmanGameEncapsulamento {
    
    private String pass;
    
    public static void main(String[] args) {
   	HangmanGameEncapsulamento forca = new HangmanGameEncapsulamento();
        forca.jogar("Ghost");
    }
    
    public void jogar(String pass){
    	this.pass = pass;
    	
        char[] constPlaceHolder = constroiPlaceHolder();
        boolean canPlay = true;
        int wrongs = 0;
        int limit = 6;
        boolean gotcha = false;
        Scanner scanner = new Scanner(System.in);
        do {
        	System.out.printf("Your attempt: %d/%d", wrongs, limit);
            String attempt = scanner.nextLine();
            boolean hit = false;
            gotcha = true;
            String placeholderAsString = "";
            for (int i = 0; i < pass.length(); i++) {
            	if (pass.charAt(i) == attempt.charAt(0)) {
                    constPlaceHolder[i] = attempt.charAt(0);
                    hit = true;
                }
                gotcha = gotcha & (pass.charAt(i) == constPlaceHolder[i]);
                placeholderAsString += constPlaceHolder[i];
            }
            if (!hit)
            	wrongs++;
            canPlay = wrongs < limit && !gotcha;
            System.out.println(placeholderAsString);
        } while (canPlay);
        scanner.close();
        
        mostraResultado(gotcha);
    }
    
    public void mostraResultado(boolean gotcha) {
    	System.out.println("Você ".concat(gotcha ? " ganhou" : " perdeu"));
    }
    
    public char[] constroiPlaceHolder(){
        this.pass = "Ghost";
        char[] placeholder = new char[pass.length()];
            for (int i = 0; i < pass.length(); i++)
                    placeholder[i] = '*';
        return placeholder;
    }
}
