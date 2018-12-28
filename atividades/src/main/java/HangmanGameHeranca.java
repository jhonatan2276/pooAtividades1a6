import java.util.Scanner;

public class HangmanGameHeranca extends Game{
    private String pass; 
    private boolean canPlay;
    private int wrongs;
    private int limit;
    private boolean gotcha;
    
    public static void main(String[] args) {
	   	HangmanGameHeranca forca = new HangmanGameHeranca();
	   	
	   	forca.setaVariaveis();
	   	forca.iniciar("Ghost");    
	    forca.jogar();
    };
    
    public void setaVariaveis() {
    	canPlay = true;
        wrongs = 0;
        limit = 6;
        gotcha = false;
    };
    
    public char[] constroiPlaceHolder(){
        char[] placeholder = new char[pass.length()];
            for (int i = 0; i < pass.length(); i++)
                    placeholder[i] = '*';
        return placeholder;
    };
    
    public void mostraResultado(boolean resultado) {
    	System.out.println("Você ".concat(resultado ? " Venceu" : " Perdeu"));
    };
    
    public void jogar(){
        char[] constPlaceH = constroiPlaceHolder();
       
        Scanner scanner = new Scanner(System.in);
        do {
        	System.out.printf("Tentativas: %d/%d", wrongs, limit);
            String attempt = scanner.nextLine();
            boolean hit = false;
                        
            gotcha = true;
            String placeholderAsString = "";
            for (int i = 0; i < pass.length(); i++) {
            	if (pass.charAt(i) == attempt.charAt(0)) {
                    constPlaceH[i] = attempt.charAt(0);
                    hit = true;
            	}
                gotcha = gotcha & (pass.charAt(i) == constPlaceH[i]);
                placeholderAsString += constPlaceH[i];
            }
                if (!hit)
                        wrongs++;
                canPlay = wrongs < limit && !gotcha;
                System.out.println(placeholderAsString);
        } while (canPlay);
        scanner.close();
        mostraResultado(gotcha);
    };
    
    //Esta parte subscreve atráves da anotação @Override
    //Herda o padrão da classe Game
    @Override
    void iniciar(String pass) {
        this.pass = pass;
    };
}
