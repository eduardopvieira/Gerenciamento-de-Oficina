public class Automovel{
	private String placa;
	private String cor;
	private String modelo;
	private int ano;
	private int quilometragem;
	private Cliente dono;
	
	public Automovel() {}
	public Automovel(String placa, String cor, String modelo, int ano, int quilometragem, Cliente dono)
	{
		setPlaca(placa);
		setCor(cor);
		setModelo(modelo);
		setAno(ano);
		setQuilometragem(quilometragem);
		setDono(dono);
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa)
	{
		if (placa != null && !placa.isEmpty() && placa.length() == 7)
			this.placa = placa;
		else 
			System.out.println("Entrada invalida");
	}
	public String getCor() 
	{
		return cor;
	}
	public void setCor(String cor)
	{
		if (cor != null && !cor.isEmpty())
			this.cor = cor;
		else 
			System.out.println("Entrada invalida");
	}
	public String getModelo()
	{
		return modelo;
	}
	public void setModelo(String modelo)
	{
		if (modelo != null && !modelo.isEmpty())
			this.modelo = modelo;
		else 
			System.out.println("Entrada invalida");
	}
	public int getAno()
	{
		return ano;
	}
	public void setAno(int ano)
	{
		if(ano > 0)
			this.ano = ano;
		else 
			System.out.println("Entrada invalida");
	}
	public int getQuilometragem()
	{
		return quilometragem;
	}
	public void setQuilometragem(int quilometragem)
	{
		if(!(quilometragem < 0))
			this.quilometragem = quilometragem;
		else 
			System.out.println("Entrada inválida!");
	}
	public Cliente getDono()
	{
		return dono;
	}
	public void setDono(Cliente dono)
	{
		if (dono != null) {
			this.dono = dono;
		}
		else
			System.out.println("Dono invalido!");
	}
	public void cadastrarAuto(Automovel automovel)
	{
		System.out.println("Automovel cadastrado!");
	}
	public void excluirAutomovel(String placa)
	{
		System.out.println("Automovel excluido!");
	}
	public void editarAutomovel(String placa)
	{
		System.out.println("Automovel editado com sucesso!");
	}
	public void buscarp(String placa)
	{
		System.out.println("Placa do automovel encontrada");
	}
	public void buscarm(String modelo)
	{
		System.out.println("Modelo do automovel encontrado");
	}
	public static void main(String args[])
	{
		Endereco end = new Endereco("rua B", "bairro C", "cep19381", 32);
		Cliente dono1 = new Cliente("Matheus", end, "09876543217");
		Automovel auto = new Automovel();
		Automovel auto2 = new Automovel("placa1", "Vermelho", "modelo1", 2020, 0, dono1);
		System.out.println(auto2.getAno());
		auto2.buscarp("placa1");
	}
}
