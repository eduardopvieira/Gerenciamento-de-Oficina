package model.VO;

import Exceptions.*;

public class Funcionario extends Pessoa {
    
    private String senha;
    private boolean isGerente;
    
    public Funcionario(){}
    public Funcionario (String cpf, String nome, String endereco, String senha) throws InfoNaoCompativelException {
        super(nome, endereco, cpf);
        setSenha(senha);
    }
    public Funcionario (String cpf, String senha) throws InfoNaoCompativelException {
        super.setCPF(cpf);
        setSenha(senha);
        setIsGerente(false);
    }

    public void setIsGerente(boolean isGerente) {
    	this.isGerente = isGerente;
    }
    
    public boolean getIsGerente() {
    	return this.isGerente;
    }
    
    public void setSenha(String senha) throws InfoNaoCompativelException {
        if (senha.length() >= 6 && senha != null && senha.isEmpty() == false) {
            this.senha = senha;
        } else {throw new InfoNaoCompativelException ("Senha inválida. Coloque mais caracteres.");}
    }

    public String getSenha() {return senha;}

    public void logar (String cpf, String senha) {
        if (super.getCPF() == cpf && getSenha() == senha) {
            System.out.println("Logou com sucesso.");
        } else {
            System.out.println("Login ou senha incorretos.");
        }
    }
}
