package model.entity;
import java.util.Scanner;

public class Servico {

	private static int idServico;
	private String servicoNome, servicoDescricao;
	private double servicoPreco;

  public Servico(){}

  public Servico(String servicoNome, String servicoDescricao, double servicoPreco){
    setServicoNome(servicoNome);
    setServicoDescricao(servicoDescricao);
    setServicoPreco(servicoPreco);
  }

//get id:
public int getIdServico() {return idServico;}

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
  public double getServicoPreco(){
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

}








========================SEGUNDA OPCAO =======================================



package entity;

import exceptions.InformacaoInvalida;

public class Servico {
	private String nomeServico;
	private double precoServico;
	
	//======== CONSTRUTORES ===========
	
	public Servico(String nomeServico, double precoServico) throws InformacaoInvalida{
		setNomeServico(nomeServico);
		setPrecoServico(precoServico);
	}

	public String getNomeServico() {
		return this.nomeServico;
	}

	public void setNomeServico(String nomeServico) throws InformacaoInvalida{
		if(nomeServico != null && !nomeServico.isEmpty())
			this.nomeServico = nomeServico;
		else
			throw new InformacaoInvalida("O nome do serviço não pode ser vazio");
	}

	public double getPrecoServico() {
		return this.precoServico;
	}

	public void setPrecoServico(double precoServico) throws InformacaoInvalida{
		if(precoServico >= 0)
			this.precoServico = precoServico;
		else
			throw new InformacaoInvalida("O preço do serviço não pode ser negativo");
	}
}

