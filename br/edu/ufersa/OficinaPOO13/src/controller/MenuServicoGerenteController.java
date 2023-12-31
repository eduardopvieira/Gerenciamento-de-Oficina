package controller;

import java.util.List;

import Exceptions.InfoNaoCompativelException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.BO.ServicoBO;
import model.VO.Servico;
import view.Telas;

public class MenuServicoGerenteController {

    @FXML
    private Button botaoAutomovel;

    @FXML
    private ImageView botaoBuscar;

    @FXML
    private Button botaoCadastrarServico;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoDeletar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private ChoiceBox<?> choiceboxBusca;  

    @FXML
    private TextField textfieldBuscar;
    
    @FXML private TableView<Servico> tabelaServicos = new TableView<Servico>();
    @FXML private TableColumn <Servico, Integer>tableColumnIDServico = new TableColumn<Servico, Integer>("servico_id");
    @FXML private TableColumn <Servico, String>tableColumnNomeServico = new TableColumn<Servico, String>("servico_nome");
    @FXML private TableColumn <Servico, String>tableColumnDescricaoServico = new TableColumn<Servico, String>("servico_desc");
    @FXML private TableColumn <Servico, Double>tableColumnValorServico = new TableColumn<Servico, Double>("servico_preco");

 public void initialize() {
    	
    	tableColumnIDServico.setCellValueFactory(new PropertyValueFactory<Servico, Integer>("ServicoId"));
    	tableColumnNomeServico.setCellValueFactory(new PropertyValueFactory<Servico, String>("servicoNome"));
    	tableColumnDescricaoServico.setCellValueFactory(new PropertyValueFactory<Servico, String>("servicoDescricao"));
    	tableColumnValorServico.setCellValueFactory(new PropertyValueFactory<Servico, Double>("servicoPreco"));
		
        
    	tabelaServicos.getColumns().add(tableColumnIDServico);
    	tabelaServicos.getColumns().add(tableColumnNomeServico);
    	tabelaServicos.getColumns().add(tableColumnDescricaoServico);
    	tabelaServicos.getColumns().add(tableColumnValorServico);
       
        
        try
        {
            ServicoBO servBO = new ServicoBO();
        	List<Servico> listaServicos = servBO.listar();

            while(!listaServicos.isEmpty())
            {
            	tabelaServicos.getItems().add(listaServicos.get(0));
            	listaServicos.remove(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }	
	}

    @FXML
    void deletar(ActionEvent event) {
    	{
            ServicoBO servBO = new ServicoBO();

            try
            {
            	servBO.deletar(tabelaServicos.getSelectionModel().getSelectedItem());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            tabelaServicos.getItems().removeAll(tabelaServicos.getSelectionModel().getSelectedItem());
            stableTable();
        }
    }

    @FXML
    void editar(ActionEvent event) {
    	try {
            Servico pc = tabelaServicos.getSelectionModel().getSelectedItem();            
            Telas.telaEditarServico(pc);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void irParaMenuAuto(ActionEvent event) throws Exception{
    	Telas.telaMenuAutos();
    }

 

    @FXML
    void realizarBusca(MouseEvent event) throws InfoNaoCompativelException {
    	Servico serv = new Servico();
        if (textfieldBuscar.getText() != null && !textfieldBuscar.getText().isEmpty())
        {
        	serv.setServicoNome(textfieldBuscar.getText());

        	ServicoBO pcBO = new ServicoBO();
            List<Servico> pcFab = null;
            try
            {
                pcFab = pcBO.buscarPorNome(serv);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
                if (!pcFab.isEmpty())
                {
                    updateTable(pcFab);
                }
        }
        else
        {
            stableTable();
        }
    }


    @FXML
    void irParaMenuClientes(ActionEvent event) throws Exception {
    	Telas.telaMenuClientes();

    }

    @FXML
    void irParaMenuOrcamentos(ActionEvent event) throws Exception {
    	Telas.telaMenuOrcamentos();
    }

    @FXML
    void irParaMenuPecas(ActionEvent event) throws Exception {
    	Telas.telaMenuPecas();
    }

    @FXML
    void irParaTelaCadastrarServico(ActionEvent event) throws Exception {
    	Telas.telaCadastrarServicoGerente();
    }

    @FXML
    void irParaTelaLogin(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }
    
    public void stableTable()
    {
    	tabelaServicos.getItems().clear();
    	ServicoBO pcBO = new ServicoBO();
        try
        {
            List<Servico> pcList = pcBO.listar();

            while(!pcList.isEmpty())
            {
            	tabelaServicos.getItems().add(pcList.get(0));
            	pcList.remove(0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void updateTable(List<Servico> list)
    {
        tabelaServicos.getItems().clear();
        while(!list.isEmpty())
        {
        	tabelaServicos.getItems().add(list.get(0));
            list.remove(0);
        }
    }
}
