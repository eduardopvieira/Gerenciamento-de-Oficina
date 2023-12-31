package controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.BO.AutomovelBO;
import model.VO.Automovel;
import model.VO.UsuarioAutenticado;
import view.Telas;
import view.util.Alerts;

public class MenuAutoController {

    @FXML
    private TextField botaoBuscar;

    @FXML
    private Button botaoCadastrarCliente;

    @FXML
    private Button botaoClientes;

    @FXML
    private Button botaoDeletar;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoOrcamentos;

    @FXML
    private ImageView botaoParaBuscar;

    @FXML
    private Button botaoPecas;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoServicos;

    
    @FXML private TableView<Automovel> tableviewAuto = new TableView<Automovel>();
    @FXML private TableColumn <Automovel, String>tableColumnCPFDono = new TableColumn<Automovel, String>("dono");
    @FXML private TableColumn <Automovel, Integer>tableColumnAno= new TableColumn<Automovel, Integer>("ano");
    @FXML private TableColumn <Automovel, String>tableColumnCor = new TableColumn<Automovel, String>("cor");
    @FXML private TableColumn <Automovel, String>tableColumnMarca = new TableColumn<Automovel, String>("marca");
    @FXML private TableColumn <Automovel, String>tableColumnModelo = new TableColumn<Automovel, String>("modelo");
    @FXML private TableColumn <Automovel, String>tableColumnPlaca = new TableColumn<Automovel, String>("placa");
    @FXML private TableColumn <Automovel, Integer>tableColumnKm = new TableColumn<Automovel, Integer>("quilometragem");

    public void initialize() {
		
    	AutomovelBO autoBO = new AutomovelBO();
    	
		tableColumnCPFDono.setCellValueFactory(new PropertyValueFactory<Automovel, String>("CPFDono"));
		tableColumnAno.setCellValueFactory(new PropertyValueFactory<Automovel, Integer>("ano"));
		tableColumnCor.setCellValueFactory(new PropertyValueFactory<Automovel, String>("cor"));
		tableColumnMarca.setCellValueFactory(new PropertyValueFactory<Automovel, String>("marca"));
		tableColumnModelo.setCellValueFactory(new PropertyValueFactory<Automovel, String>("modelo"));
		tableColumnPlaca.setCellValueFactory(new PropertyValueFactory<Automovel, String>("placa"));
		tableColumnKm.setCellValueFactory(new PropertyValueFactory<Automovel, Integer>("km"));
        
        
        tableviewAuto.getColumns().add(tableColumnCPFDono);
        tableviewAuto.getColumns().add(tableColumnAno);
        tableviewAuto.getColumns().add(tableColumnCor);
        tableviewAuto.getColumns().add(tableColumnMarca);
        tableviewAuto.getColumns().add(tableColumnModelo);
        tableviewAuto.getColumns().add(tableColumnPlaca);
        tableviewAuto.getColumns().add(tableColumnKm);

        
        try
        {
            List<Automovel> listaAuto = autoBO.listar();

            while(!listaAuto.isEmpty())
            {
                tableviewAuto.getItems().add(listaAuto.get(0));
                listaAuto.remove(0);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }	
	}
    
    
    @FXML
    void abrirCadastroAuto(ActionEvent event)throws Exception {
    	Telas.telaCadastroAuto();
    }

    @FXML
    void deletar(ActionEvent event) {
    	
            AutomovelBO autoBO = new AutomovelBO();

            try
            {
            	autoBO.deletar(tableviewAuto.getSelectionModel().getSelectedItem());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            tableviewAuto.getItems().removeAll(tableviewAuto.getSelectionModel().getSelectedItem());
            stableTable();
        
    }

    @FXML
    void editar(ActionEvent event) throws Exception {
    	try {
            Automovel pc = tableviewAuto.getSelectionModel().getSelectedItem();
            System.out.println(pc.getAno());
            System.out.println(pc.getCor());
            System.out.println(pc.getCPFDono());
            System.out.println(pc.getKm());
            System.out.println(pc.getMarca());
            System.out.println(pc.getModelo());
            System.out.println(pc.getPlaca());
            
            Telas.telaEditarAuto(pc);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    void irTelaMenuClientes(ActionEvent event)throws Exception {
    	Telas.telaMenuClientes();
    }

    @FXML
    void realizarBusca(MouseEvent event)throws Exception {
    	Automovel pc = new Automovel();
        if (botaoBuscar.getText() != null && !botaoBuscar.getText().isEmpty())
        {
        	pc.setModelo(botaoBuscar.getText());

            AutomovelBO pcBO = new AutomovelBO();
            List<Automovel> resultAuto = null;

            try
            {
            	resultAuto = pcBO.buscarPorPlacaOuDono(pc);
             
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
                if (!resultAuto.isEmpty())
                {
                    updateTable(resultAuto);
                } else {
                	Alerts.showAlert("Erro", "Não encontrado", "Nenhum resultado para a sua busca.", AlertType.ERROR);
                }
        }
        else
        {
            stableTable();
        }
    }

    @FXML
    void trocarParaMenuOrcamentos(ActionEvent event)throws Exception {
    	Telas.telaMenuOrcamentos();
    }

    @FXML
    void trocarParaMenuPecas(ActionEvent event)throws Exception {
    	Telas.telaMenuPecas();
    }

    @FXML
    void trocarParaMenuServicos(ActionEvent event)throws Exception {
    	if ("gerente".equals(UsuarioAutenticado.getFuncao())) {
    		Telas.telaMenuServicoGerente();
    	} else if ("funcionario".equals(UsuarioAutenticado.getFuncao())) {
    		Telas.telaMenuServicoFuncionario();
    		}
    }

    @FXML
    void trocarParaTelaLogin(ActionEvent event) throws Exception {
    	Telas.telaLogin();
    }
    
    public void stableTable()
    {
    	tableviewAuto.getItems().clear();
    	AutomovelBO autoBO = new AutomovelBO();
        try
        {
            List<Automovel> pcList = autoBO.listar();

            while(!pcList.isEmpty())
            {
            	tableviewAuto.getItems().add(pcList.get(0));
            	pcList.remove(0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    
    public void updateTable(List<Automovel> list)
    {
        tableviewAuto.getItems().clear();
        while(!list.isEmpty())
        {
        	tableviewAuto.getItems().add(list.get(0));
            list.remove(0);
        }
    }

}
