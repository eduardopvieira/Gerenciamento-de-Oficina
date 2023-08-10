public class Gerente{
	private String nome;
	private Endereco endereco;
	private String cpf;
	private String senha;
	

	public Gerente(){}
	public Gerente(String nome, Endereco endereco, String cpf, String senha) // falta o atributo endereco
	{
		setNome(nome);
		setEndereco(endereco);
		setCpf(cpf);
		setSenha(senha);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		
		if (nome != null && !nome.isEmpty()) {
			this.nome = nome;
		}
		else
			System.out.println("Nome invalido!");
	}
	public Endereco getEndereco()
	{
		return endereco;
	}
	public void setEndereco(Endereco endereco)
	{
		   this.endereco = endereco;
		   System.out.println("Endereco atribuido.\n");
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if (cpf != null && !cpf.isEmpty() && cpf.length() == 11) {
			this.cpf = cpf;
		}
		else 
			System.out.println("cpf invalido!");
		
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if (senha != null && !senha.isEmpty() && senha.length() >= 8) {
			this.senha = senha;
		}
		else
			System.out.println("Senha inválida");
	}
	public void cadastrarGerente(Gerente gerente)
	{
		System.out.println("Gerente cadastrado com sucesso!");
	}
	public void excluirGerente(String cpf)
	{
		System.out.println("Gerente excluido com sucesso!");
	}
	public void editarFuncionario(String cpf)
	{
		System.out.println("Funcionario editado com sucesso!");
	}
	public void login(String cpf, String senha)
	{
		System.out.println("Bem vindo!");
	}
	public static void main(String args[])
	{
		Endereco e = new Endereco("rua A", "bairro B", "cep123200", 71);
		Gerente g1 = new Gerente();
		Gerente g2 = new Gerente("José", e,  "12345678910", "alegriaaa");
		System.out.println(g2.getSenha());
		g2.editarFuncionario("11121314156");
	}
}
