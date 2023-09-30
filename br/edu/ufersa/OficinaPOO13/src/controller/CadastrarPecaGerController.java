package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.VO.Pecas;

public class CadastrarPecaGerController {
	@FXML
    private TextField descricaoPeca;
	@FXML
	private TextField fabricantePeca;
	@FXML
	private TextField precoPeca;
	@FXML
	private TextField estoquePeca;
	@FXML
	private Button botaoConcluir;
	@FXML
	private Button botaoCancelar;
	
	public void concluir(ActionEvent event) throws Exception{
		Pecas pecaVO = new Pecas();
		pecaVO.setDescricaoItem(descricaoPeca.getText());
		pecaVO.setFabricante(fabricantePeca.getText());
		pecaVO.setPrecoItem(Double.parseDouble(precoPeca.getText()));
		pecaVO.setEstoqueItem(Integer.parseInt(estoquePeca.getText()));
		System.out.println("Peça: Descrição: " + pecaVO.getDescricaoItem() + " Fabricante: " + pecaVO.getFabricante() + " Preco: " + pecaVO.getPrecoItem() + " Estoque: " + pecaVO.getEstoqueItem());
		
	}
	public void cancelar(ActionEvent event) throws Exception{
		
	}
}