import java.util.Scanner;

public class Servico {

	private static int idServico;
	private String servicoNome, servicoDescricao;
	private double servicoPreco;

  public Servico(){}

  public Servico(String servicoNome, String servicoDescricao, double servicoPreco){
    this.idServico++;
    setServicoNome(servicoNome);
    setServicoDescricao(servicoDescricao);
    setServicoPreco(servicoPreco);
  }

/*==>GET/SET (id)<==
NÃO SE APLICA
<========================>*/
/*==>GET/SET (servicoNome)<==*/
  public String getServicoNome(){
    return servicoNome;
  }
  public void setServicoNome(String servicoNome){
    if (servicoNome != null && servicoNome != ""){ /*Verifica se foi passado algo para o servicoNome*/
      this.servicoNome = servicoNome;
    } else {
      System.out.println("\nNome não pode estar vazio. Digite o nome novamente: ");
      Scanner scan = new Scanner(System.in);
      String ss = scan.nextLine();
      if (ss != null && ss != ""){
        this.servicoNome = ss;
      }
    }
    System.out.println("Nome do servico: "+ servicoNome);
  }
/*<========================>*/

/*==>GET/SET (servicoDescricao)<==*/
  public String getServicoDescricao(){
    return servicoDescricao;
  }
  public void setServicoDescricao(String servicoDescricao){
    if (servicoDescricao != null && servicoDescricao != ""){ /*Verifica se foi passado algo para o servicoDescricao*/
      this.servicoDescricao = servicoDescricao;
    } else {
      System.out.println("\nDescricao não deve estar vazia. Digite o nome novamente: ");
      Scanner scan = new Scanner(System.in);
      String ds = scan.nextLine();
      if (ds != null && ds != ""){
        this.servicoDescricao = ds;
      }
    }
    System.out.println("Descricao do Servico: "+ servicoDescricao);
  }
/*<========================>*/

/*==>GET/SET (servico)<==*/
  public double getSercoPreco(){
    return servicoPreco;
  }

  public void setServicoPreco(double servicoPreco){
    if (servicoPreco >= 0){
      this.servicoPreco = servicoPreco;
    } else {
      System.out.println("\nPreco não deve ser negativo. Digite novamente o preco: ");
      Scanner scan = new Scanner(System.in);
      double sps = scan.nextDouble();
      if (sps >= 0){
        this.servicoPreco = sps;
      }
    }
    System.out.println("Preco do Servico: "+ servicoPreco);
  }
/*<========================>*/

/*==>METODO ALTERAR Servico<==*/
  public void alteraServico(){
    System.out.println("Editando Servico");
  }
/*<========================>*/

/*METODO EXCLUIR Servico*/
  public void excluiServico(){
    System.out.println("Confirma esquecimento do Servico? ");
  }
/*<========================>*/

/*==>METODO PARA MOSTRAR SERVICO<==*/
void mostraServico (){
  System.out.println("\nNome: "+ servicoNome+"\nPreco: "+ servicoPreco+"\nCod: "+idServico+"\n");
}
/*<========================>*/

/*==>TESTE DE SERVICO<==*/
public static void main (String args[]){
  Servico s1 = new Servico("Troca de Oleo", "Troca de Oleo", 60.00);
  s1.mostraServico();
  Servico s2 = new Servico("Alinhamento","Alinhamento das 4 rodas",49.9);
  s2.mostraServico();
}
/*<========================>*/

}
