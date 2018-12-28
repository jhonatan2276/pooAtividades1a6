# Encapsulamento

## Definições
> referenciar origem: artigo, livro, revista


Na 5 fase da faculdade tivemos uma matéria sobre orientação a objeto;
Encapsulamento é uma forma de restringir o acesso ao comportamento interno de um objeto.
Facilita na manutenção e não propaga mudanças
Mostra somente o que o objeto sabe fazer, sem descrever como é feito.


## Exemplos
> referenciar origem: repositÃ³rio, site, jre

```
[1]=============================================================================
 class Carro {
   String cor;
   String modelo;
   double velocidadeAtual;
   double velocidadeMaxima;
 
   //liga o carro
   void liga() {
     System.out.println("O carro está ligado");
   }
 
   //acelera uma certa quantidade
   void acelera(double quantidade) {
     double velocidadeNova = this.velocidadeAtual + quantidade; 
     this.velocidadeAtual = velocidadeNova;
   }
 
   //devolve a marcha do carro
   int pegaMarcha() {
     if (this.velocidadeAtual < 0) {
       return -1;
     }
     if (this.velocidadeAtual >= 0 && this.velocidadeAtual < 40) {
       return 1;
     }
     if (this.velocidadeAtual >= 40 && this.velocidadeAtual < 80) {
       return 2;
     }
     return 3;
   }
 }
 ```
 ```
[2]=============================================================================
public class Conta {
    String numero, agencia, dataAbertura;
    int banco;

    public void inicializaConta(String numero, String agencia, int banco, String dataAbertura) {
        this.numero = numero;
        this.agencia = agencia;
        this.dataAbertura = dataAbertura;
        this.banco = banco;
    }

    public void imprimiDados() {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("NUMERO : "+numero+"\t AGENCIA : "+agencia+"\t BANCO : "+banco+"\t DATA DE ABERTURA : "+dataAbertura);
        System.out.println("---------------------------------------------------------------------------------------------");
    }
}
```
```
[3]=============================================================================
class Pedido {
  private String comprador;
  private double valorTotal;
 
  public String getComprador() { 
    return comprador; 
  }
  public double getValorTotal() { 
    return valorTotal; 
  }
 
  public void adiciona(Item item) {
    if(item.getValor() < 1000)
        this.valorTotal += item.getValor();
    else 
        this.valorTotal += item.getValor() * 0.95;
  }
}
// utilizando a classe juntamento com o "item"(a classe item não foi adicionada pois é só um exemplo)
Pedido p = new Pedido();
Item item = new Item("Super Geladeira", 1500.0);
p.adiciona(item);
```
```
[4]=============================================================================
class ContaEncapsulada {

  private double saldo;
  private double limite;
  private Cliente titular;

  public double getLimite() {
    return this.limite;
  }

  public void setLimite(double limite) {
    this.limite = limite;
  }

  public Cliente getTitular() {
    return this.titular;
  }

  public void setTitular(Cliente titular) {
    this.titular = titular;
  }
}
```
```
[5]=============================================================================
public class TV { 
    private int canal; 
    private int volume; 
    private boolean ligada; 
    private int tamanho; 
    public TV(){ 
        this.tamanho = 42; 
        this.ligada = true; 
    } 
    public void setCanal(int novoCanal){
        // Testar se a TV está ligada
        canal = novoCanal;
    }
    public int getCanal(){
        // Testar se a TV está ligada
        return canal;
    }
    public void setVolume(int novoVolume){
        // Testar se a TV está ligada
        volume = novoVolume;
    }
    public int getVolume(){
        // Testar se a TV está ligada
        return volume ;
    }
    public static void main (String args []){ 
        TV minhaTV = new TV(); 
        minhaTV.setCanal(7); 
        minhaTV.setVolume(22); 
    } 
}
```
## Ferramenta
> checklist ou tabela

### Carro [1]

Atributos Publicos diretamente acessiveis por outras classes = 4
Quantidade de métodos = 3 assim como os parametros os métodos também estão acessiveis para outras classes, 
isso é bom, pois um metodo deve ser acessivel de forma critica, para que tenha o retorno de sua criação;
Quantidade de Atributos = 4
Quantidade de parametros de entrada = 0, o método está acessando o parametro de forma direta
Restrição de acesso ao objeto = 0, não há restrição de acesso ao objeto

### Conta [2]

Atributos Publicos diretamente acessiveis por outras classes = 4
Quantidade de métodos = 2
Quantidade de Atributos = 4
Quantidade de parametros de entrada = 4
Restrição de acesso ao objeto = 0, isso é ruim pois fica acessivel no escopo da classe

### Pedido [3]

Atributos Publicos diretamente acessiveis por outras classes = 0
Quantidade de métodos = 1
Quantidade de Atributos = 2
Quantidade de parametros de entrada = 1
Restrição de acesso ao objeto = 0, isso é ruim pois fica acessivel no escopo da classe

### ContaEncapsulada [4]

Vejamos que o atributo saldo é totalmente privado, pois ele será chamado atraves de um metodo deposita() e saca().

Atributos Publicos diretamente acessiveis por outras classes = 0
Quantidade de métodos = 1
Quantidade de Atributos = 2
Quantidade de parametros de entrada = 1
Restrição de acesso ao objeto = 0, isso é ruim pois fica acessivel no escopo da classe

### TV [5]

Vejamos que o atributo saldo é totalmente privado, pois ele será chamado atraves de um metodo deposita() e saca().

Atributos Publicos diretamente acessiveis por outras classes = 4
Quantidade de métodos = 1
Quantidade de Atributos = 4
Quantidade de parametros de entrada = 2
Restrição de acesso ao objeto = 0, isso é ruim pois fica acessivel no escopo da classe

## Inspeção

Diante de todas as classes analisadas, chegamos que a classe [4] foi a melhor encapsulada, pois nem todos
os atributos tem os getters e setters, o atributo saldo foi protegido para não ser utilizando de forma 
externa da classe.
A Classe carro [1] não tem encapsulamento algum, pois não foi definido o tipo de acesso, dando assim a oportunidade
de ser alterado no momento que for instanciada a classe.

> 5 classes devem ser inspecionadas com a ferramenta
> referenciar origem
```
[1] - https://www.caelum.com.br/apostila-java-orientacao-objetos/orientacao-a-objetos-basica/#4-10-para-saber-mais-uma-fabrica-de-carros
[2] - Classe criada em sala de aula na 5ª fase (2010)
[3] - http://blog.caelum.com.br/revisitando-a-orientacao-a-objetos-encapsulamento-no-java/
[4] - https://www.caelum.com.br/apostila-java-orientacao-objetos/modificadores-de-acesso-e-atributos-de-classe/#6-3-getters-e-setters
[5] - http://www.guj.com.br/t/como-encapsular-uma-classe/94607
```

