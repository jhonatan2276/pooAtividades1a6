# Heran�a

## Defini��es
> referenciar origem: artigo, livro, revista
Nada mais � do que criar classes usando outras classes j� existentes.
Criar uma classe e herdar as caracter�sticas de outra se estas tiverem uma rela��o (se forem parecidas).

## Exemplos
> referenciar origem: reposit�rio, site, jre

```
[1]=============================================================================
class Funcionario {
  protected String nome;
  protected String cpf;
  protected double salario;
}
```
```
class Gerente {
  String nome;
  String cpf;
  double salario;
  int senha;
  int numeroDeFuncionariosGerenciados;
    
  public boolean autentica(int senha) {
    if (this.senha == senha) {
      System.out.println("Acesso Permitido!");
      return true;
    } else {
      System.out.println("Acesso Negado!");
      return false;
    }
  }
}
```
```
class Gerente extends Funcionario {
  int senha;
  int numeroDeFuncionariosGerenciados;
  
  public boolean autentica(int senha) {
    if (this.senha == senha) {
      System.out.println("Acesso Permitido!");
      return true;
    } else {
      System.out.println("Acesso Negado!");
      return false;
    }
  }
}
```
[2]=============================================================================
//Arquivo 01
public class Animal {
     public void comer() {
          System.out.println( "Animal Comendo..." );
     }
}
//Arquivo 02
public class Cao  extends Animal {
     public void comer() {
          System.out.println( "C�o Comendo..." );
     }
}
//Arquivo 03
public class Tigre extends Animal {
     public void comer() {
          System.out.println( "Tirgre Comendo..." );
     }
}
//Arquivo 04
publci class Test {
  public void fazerAnimalComer( Animal animal ) {
       animal.comer();
  }
  public static void main( String[] args ) {
       Test t = new Test();
        t.fazerAnimalComer( new Animal() );
        t.fazerAnimalComer( new Cao() );
        t.fazerAnimalComer( new Trigre() );
   }
}
```
[3]=============================================================================
public class Pessoa {
    protected String nome;
    protected Date nascimento;

    public Pessoa(String nome, Date nascimento){
        this.nome = nome;
        this.nascimento = nascimento;
    }
}
public class Cliente extends Pessoa{
    protected String endereco;
    protected int codigo;

    public Cliente(int codigo String nome, String endereco, Date nascimento) {
        super(nome, nascimento);
        this.endereco = endereco;
        this.codigo = codigo;
    }
}
```
[4]=============================================================================
Classe 01
public class Pessoa {
	public String nome;
	public String cpf;
	public Date data_nascimento;
	
	public Pessoa(String _nome, String _cpf, Date _data) {
		this.nome = _nome;
		this.cpf = _cpf;
		this.data_nascimento = _data;
	}
}
Classe 02
public class Aluno extends Pessoa {
	public Aluno(String _nome, String _cpf, Date _data) {
		super(_nome, _cpf, _data);
	}
	public String matricula;
}
Classe 03
public class Professor extends Pessoa {
	public Professor(String _nome, String _cpf, Date _data) {
		super(_nome, _cpf, _data);
	}
	public double salario;
	public String disciplina;
}
Classe 04
public class Funcionario extends Pessoa {
	public Funcionario(String _nome, String _cpf, Date _data) {
		super(_nome, _cpf, _data);
	}
	public double salario;
	public Date data_admissao;
	public String cargo;
}
```
[5]=============================================================================
Classe 01
public class TV {
	private int tamanho;
	private int canal;
	private int volume;
	private boolean ligada;
	public TV(int tamanho) {
		this.tamanho = tamanho;
		this.canal = 0;
		this.volume = 0;
		this.ligada = false;
	}
}

public interface ControleRemoto {
	void mudarCanal(int canal);
	void aumentarVolume (int taxa);
	void diminuirVolume (int taxa);
	boolean ligar();
	boolean desligar();
}

Classe 02
public class ModeloTV001 extends TV implements ControleRemoto {
	public final String MODELO = "TV001";
	public ModeloTV001(int tamanho) {
		super(tamanho);
	}
	
	public void desligar() {
		super.setLigada(false);
	}

	public void ligar() {
		super.setLigada(true);
	}

	public void aumentarVolume(int taxa) { }
	public void diminuirVolume(int taxa) { }
	public void mudarCanal(int canal) { }
}

Classe 03
public class ModeloX extends TV implements ControleRemoto {
	public final String MODELO = "TV-X";

	public ModeloSDX(int tamanho) {
		super(tamanho);
	}

	public void desligar() {
		System.out.println("Obrigado por Utilizar a Televis�o!");
		super.setLigada(false);
	}

	public void ligar() {
		super.setLigada(true);
	}

	public void aumentarVolume(int taxa) { }
	public void diminuirVolume(int taxa) { }
	public void mudarCanal(int canal) { }
}
## Ferramenta
> checklist ou tabela
### Funcion�rio [1]
Atributos Publicos diretamente acessiveis por outras classes = 5
Quantidade de m�todos = 2, estando eles divididos entre todas as classes e publicamente
acess�veis.
Quantidade de Atributos = 2
Quantidade de parametros de entrada = 0

### Animal [2]
Atributos Publicos diretamente acessiveis por outras classes = 0
Quantidade de m�todos = 4, estando eles divididos entre todas as classes e publicamente
acess�veis.
Os m�todos est�o acess�veis corretamente, de forma publica, cumprindo sua �tarefa�.
Quantidade de Atributos = 0
Quantidade de parametros de entrada = 1, apenas o m�todo construtor determina
par�metros, visto que os outros m�todos executam sua a��o diretamente.
Restri��o de acesso ao objeto = 0, n�o h� restri��o de acesso ao objeto.

### Pessoa [3]
Atributos Publicos diretamente acessiveis por outras classes = 0
Quantidade de m�todos = 2, estando eles divididos entre todas as classes e publicamente
acess�veis.
Quantidade de Atributos = 4
Quantidade de parametros de entrada = 4

### Pessoa, Aluno, Professor, Funcionario [4]
Atributos Publicos diretamente acessiveis por outras classes = 9, divididos entre as classes, precedidos dos metodos "public"
Nesse caso os atributos est�o setados como "public" o que � n�o � recomendavel, visto que assim eles ficam diretamente acessiveis por classes externas.
Quantidade de m�todos = 4, estando eles divididos entre todas as classes e publicamente acess�veis.
Isso � bom, pois cada metodo est� disponivel para as demais classes.
Quantidade de Atributos = 4, por�m todos setados como "public"
Quantidade de parametros de entrada = 3, considerando os construtores
Restri��o de acesso ao objeto = 0, n�o h� restri��o de acesso ao objeto, isto n�o � recomenda pois os atributos de cada classe est�o acessiveis diretamente

### TV [5]
Atributos Publicos diretamente acessiveis por outras classes = 4
4 metodos encontra-se setados como "public"
Quantidade de m�todos = 14 m�todos devidamente encapsulados e distribu�dos, considerando todas as classes.
Dessa forma os metodos est�o acessiveis de maneira correta pelas classes.
Quantidade de Atributos = 8
Dentre todos os atributos 4 est�o setados como "Private", o que � recomendado, por�m outros 8 est�o acessiveis de forma direta.
Quantidade de parametros de entrada = 10, divididos entre as classes
Restri��o de acesso ao objeto = 4 atributos n�o s�o acessados diretamente, visto que estes s�o setados como parametro no metodo construtor.

## Inspe��o

Dentre as classes analisadas, a classe 05 - TV mostra atender de melhor maneira as boas praticas de Encapsulamento, Polimorfismo e HERAN�A.
> 5 classes devem ser inspecionadas com a ferramenta
> referenciar origem
```
[1] https://www.caelum.com.br/apostila-java-orientacao-objetos/heranca-reescrita-e-polimorfismo/#7-1-repetindo-codigo
[2] http://www.guj.com.br/t/exemplos-praticos-de-polimorfismo/65598/2
[3] https://pt.stackoverflow.com/questions/45699/como-funciona-a-heran%C3%A7a-de-construtor-em-java
[4] https://www.devmedia.com.br/entendendo-e-aplicando-heranca-em-java/24544
[5]
```

