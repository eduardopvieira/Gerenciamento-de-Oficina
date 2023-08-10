public class Pecas {

	private int idItem; 
	private String descricaoItem;
	private String fabricante;
	private double precoItem;
	private double estoqueItem;
	private int unidadeMedidaItem;
	
	
	public Pecas(){}
	
	public Pecas(int idItem, String descricaoItem, String fabricante, double precoItem, double estoqueItem, int unidadeMedidaItem){
		setIdItem(idItem);
		setDescricaoItem(descricaoItem);
		setFabricante(fabricante);
		setPrecoItem(precoItem);
		setEstoqueItem(estoqueItem);
		setUnidadeMedidaItem(unidadeMedidaItem);
	}
	
	
	//GETS AND SETS:
	
	public int getIdItem() {
			return idItem;
	}


	public void setIdItem(int idItem) {
		if (idItem >= 0) {
			this.idItem = idItem;
		}
	}
	//-------------------------------------
	
	public String getDescricaoItem() {
		return descricaoItem;
	}
	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	//-------------------------------------
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	//--------------------------------------
	public double getPrecoItem() {
		return precoItem;
	}
	public void setPrecoItem(double precoItem) {
		if (precoItem >= 0) {
			this.precoItem = precoItem;
		}
	}
	
	//---------------------------------------
	public double getEstoqueItem() {
		return estoqueItem;
	}
	public void setEstoqueItem(double estoqueItem) {
		if (estoqueItem >= 0) {
		this.estoqueItem = estoqueItem;}
	}
	//----------------------------------------
	public int getUnidadeMedidaItem() {
		return unidadeMedidaItem;
	}
	public void setUnidadeMedidaItem(int unidadeMedidaItem) {
		if (unidadeMedidaItem >= 0) { 
		this.unidadeMedidaItem = unidadeMedidaItem;}
	}
	//=======================================METODOS==================================================
	public void orcaItem(int idItem) {
		this.idItem = idItem;
	}
	public void modificaUnd(int unidadeMedidaItem) {
		setUnidadeMedidaItem(unidadeMedidaItem);
	}
	public void alteraPreco(double precoItem) {
		setPrecoItem(precoItem);
	}
	public void alteraDescricao(String descricaoItem) {
		setDescricaoItem(descricaoItem);
	}
	public void buscar (String descricaoItem) {
		System.out.println(descricaoItem);
	}
	public void buscarFabricante (String fabricante) {
		System.out.println(fabricante);
	}
	
	
	//----------------------------------------MAIN---------------------------------------------------
	public static void main (String args[]) {
		Pecas p = new Pecas(1, "peça daora", "fabricante daora", 2, 3, 4);
		System.out.println(p.getFabricante());		
	}	
}
