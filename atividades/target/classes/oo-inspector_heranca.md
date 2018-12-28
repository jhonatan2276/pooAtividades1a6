# Herança

## Definições
> referenciar origem: artigo, livro, revista
Nada mais é do que criar classes usando outras classes já existentes.
Criar uma classe e herdar as características de outra se estas tiverem uma relação (se forem parecidas).

## Exemplos
> referenciar origem: repositório, site, jre

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
          System.out.println( "Cão Comendo..." );
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
		System.out.println("Obrigado por Utilizar a Televisão!");
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
### Funcionário [1]
Atributos Publicos diretamente acessiveis por outras classes = 5
Quantidade de métodos = 2, estando eles divididos entre todas as classes e publicamente
acessíveis.
Quantidade de Atributos = 2
Quantidade de parametros de entrada = 0

### Animal [2]
Atributos Publicos diretamente acessiveis por outras classes = 0
Quantidade de métodos = 4, estando eles divididos entre todas as classes e publicamente
acessíveis.
Os métodos estão acessíveis corretamente, de forma publica, cumprindo sua “tarefa”.
Quantidade de Atributos = 0
Quantidade de parametros de entrada = 1, apenas o método construtor determina
parâmetros, visto que os outros métodos executam sua ação diretamente.
Restrição de acesso ao objeto = 0, não há restrição de acesso ao objeto.

### Pessoa [3]
Atributos Publicos diretamente acessiveis por outras classes = 0
Quantidade de métodos = 2, estando eles divididos entre todas as classes e publicamente
acessíveis.
Quantidade de Atributos = 4
Quantidade de parametros de entrada = 4

### Pessoa, Aluno, Professor, Funcionario [4]
Atributos Publicos diretamente acessiveis por outras classes = 9, divididos entre as classes, precedidos dos metodos "public"
Nesse caso os atributos estão setados como "public" o que é não é recomendavel, visto que assim eles ficam diretamente acessiveis por classes externas.
Quantidade de métodos = 4, estando eles divididos entre todas as classes e publicamente acessíveis.
Isso é bom, pois cada metodo está disponivel para as demais classes.
Quantidade de Atributos = 4, porém todos setados como "public"
Quantidade de parametros de entrada = 3, considerando os construtores
Restrição de acesso ao objeto = 0, não há restrição de acesso ao objeto, isto não é recomenda pois os atributos de cada classe estão acessiveis diretamente

### TV [5]
Atributos Publicos diretamente acessiveis por outras classes = 4
4 metodos encontra-se setados como "public"
Quantidade de métodos = 14 métodos devidamente encapsulados e distribuídos, considerando todas as classes.
Dessa forma os metodos estão acessiveis de maneira correta pelas classes.
Quantidade de Atributos = 8
Dentre todos os atributos 4 estão setados como "Private", o que é recomendado, porém outros 8 estão acessiveis de forma direta.
Quantidade de parametros de entrada = 10, divididos entre as classes
Restrição de acesso ao objeto = 4 atributos não são acessados diretamente, visto que estes são setados como parametro no metodo construtor.

## Inspeção

Dentre as classes analisadas, a classe 05 - TV mostra atender de melhor maneira as boas praticas de Encapsulamento, Polimorfismo e HERANÇA.
> 5 classes devem ser inspecionadas com a ferramenta
> referenciar origem
```
[1] https://www.caelum.com.br/apostila-java-orientacao-objetos/heranca-reescrita-e-polimorfismo/#7-1-repetindo-codigo
[2] http://www.guj.com.br/t/exemplos-praticos-de-polimorfismo/65598/2
[3] https://pt.stackoverflow.com/questions/45699/como-funciona-a-heran%C3%A7a-de-construtor-em-java
[4] https://www.devmedia.com.br/entendendo-e-aplicando-heranca-em-java/24544
[5]
```

