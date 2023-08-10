import java.util.Scanner;
import java.util.Date;

public class Orcamento {

  private static int idServico;
  private Cliente clienteOrcamento;
  private Automovel automovelOrcamento;
  private Pecas pecasOrcamento;
  private Servico servicoOrcamento;
  private double totalOrcamento;
  private Date dataOrcamento = new Date();

  public Orcamento(){}
  public Orcamento(Cliente clienteOrcamento, Automovel automovelOrcamento, Pecas pecasOrcamento, Servico servicoOrcamento){
      this.idServico++;
      setClienteOrcamento(clienteOrcamento);
      setAutomovelOrcamento(automovelOrcamento);
      setPecasOrcamento(pecasOrcamento);
      setServicoOrcamento(servicoOrcamento);
      this.dataOrcamento = dataOrcamento;
      /*setTotalOrcamento(totalOrcamento);*/
  }


/*==>GET/SET clienteOrcamento<==*/
  public Cliente getClienteOrcamento(){
    return clienteOrcamento;
  }
  public void setClienteOrcamento(Cliente clienteOrcamento){
    this.clienteOrcamento = clienteOrcamento;
    System.out.println("Cliente atribuido.");
  }
/*<========================>*/

/*==>GET/SET automovelCliente<==*/
  public Automovel getAutomovelOrcamento(){
    return automovelOrcamento;
  }
  public void setAutomovelOrcamento(Automovel automovelOrcamento){
    this.automovelOrcamento = automovelOrcamento;
    System.out.println("Automovel atribuido.");
  }
/*<========================>*/

/*==>GET/SET pecasOrcamento<==*/
  public Pecas getPecasOrcamento(){
    return pecasOrcamento;
  }
  public void setPecasOrcamento(Pecas pecasOrcamento){
    this.pecasOrcamento = pecasOrcamento;
    System.out.println("Pecas atribuidos.");
  }
/*<========================>*/

/*==>GET/SET<==*/
  public Servico getServicoOrcamento(){
    return servicoOrcamento;
  }
  public void setServicoOrcamento(Servico servicoOrcamento){
    this.servicoOrcamento = servicoOrcamento;
    System.out.println("Servicos atribuidos.");
  }
/*<========================>*/

/*==>METODO ALTERAR CLIENTE<==*/
  public void alteraOrcamento(){
    System.out.println("Editando Orcamento");
  }
/*<========================>*/

/*METODO EXCLUIR CLIENTE(ESQUECER)*/
  public void excluiOrcamento(){
    System.out.println("Confirma exclusao do orcamento? ");
  }
/*<========================>*/
/*METOODO CONSULTA*/
  public void consultaOrcamento(){
    System.out.println("Teste: "+idServico);
  }

/*TESTE*/
  public static void main (String args[]){
    Pecas pec = new Pecas(1,"Teste","Teste",25.00,5,1);
    Servico ser = new Servico("ABC", "DEF", 45.00);
    Endereco end = new Endereco("rua B", "bairro C", "cep19381", 32);
		Cliente dono = new Cliente("Matheus", end, "09876543217");
		Automovel auto = new Automovel("placa1", "Vermelho", "modelo1", 2020, 0, dono);
    Orcamento orc = new Orcamento(dono, auto, pec, ser);
    orc.consultaOrcamento();
    Orcamento orc2 = new Orcamento(dono, auto, pec, ser);
    orc2.consultaOrcamento();
    Orcamento orc3 = new Orcamento(dono, auto, pec, ser);
    orc3.consultaOrcamento();

  }

}
