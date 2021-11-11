package gui;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import application.Main;
import gui.utils.Alerts;
import gui.utils.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import modelo.dao.ComponentesDao;
import modelo.dao.DepartamentoDao;
import modelo.dao.FabricaDeDao;
import modelo.dao.ListaMaquinasDao;
import modelo.dao.MaquinasDao;
import modelo.entidades.Componentes;
import modelo.entidades.Departamento;
import modelo.entidades.ListaComponenteMaquina;
import modelo.entidades.Maquinas;

public class ListaPorMaquinaViewController implements Initializable {

	@FXML
	private MenuItem menuItemMaquinas;

	@FXML
	private MenuItem menuItemComponentes;
	
	@FXML
	private MenuItem menuItemComponentesEletronica;
	
	@FXML
	private MenuItem menuItemDepartamento;

	@FXML
	private ComboBox<String> cbMaquinas;

	@FXML
	private Button btListaMaquina;

	@FXML
	private Button btListaFull;

	@FXML
	private Button btListainserir;

	@FXML
	private Button btListaDeletar;

	@FXML
	private Button btListaComponentes;

	@FXML
	private Button btAdicionaALista;

	@FXML
	private Button btBuscaMaq;

	@FXML
	private Button btLimpaLista;

	@FXML
	private Button btExibir;

	@FXML
	private Button btBuscaComp;

	@FXML
	private Button btExportar;
	
	@FXML
	private Button btBuscaMaqNome;
	
	@FXML
	private Button btBuscaMaqFull;
	
	@FXML
	private Button btConcluiLista;
	
	@FXML
	private Button btPorDepartamento;

	@FXML
	private TextField txtQtdGS300;

	@FXML
	private TextField txtQtdEP35;

	@FXML
	private TextField txtinsereIdMq;

	@FXML
	private TextField txtinsereIdCp;

	@FXML
	private TextField txtinserirQtd;

	@FXML
	private TextField txtBuscaNome;

	@FXML
	private TextField txtQtdeMaq;

	@FXML
	private TextField txtBuscaNomeComponente;
	
	@FXML
	private TextField txtBuscaNomeMaquina;
	
	@FXML
	private Label lbAviso;
	
	@FXML
	private ComboBox<String> cbBuscaPorDepartamento;

	@FXML
	private TableView<ListaComponenteMaquina> tableListaMaquina;

	@FXML
	private TableColumn<ListaComponenteMaquina, Integer> columnMaquina;

	@FXML
	private TableColumn<ListaComponenteMaquina, Integer> columnComponente;

	@FXML
	private TableColumn<ListaComponenteMaquina, String> columnCodigo;

	@FXML
	private TableColumn<ListaComponenteMaquina, Integer> columnQuantidadePorMaquina;

	@FXML
	private TableColumn<ListaComponenteMaquina, Integer> columnQuantidadeEstoque;

	@FXML
	private TableColumn<ListaComponenteMaquina, String> columnTeste;

	@FXML
	TableView<Maquinas> tabelaMaq;

	@FXML
	TableColumn<Maquinas, Integer> colIdMaq;

	@FXML
	TableColumn<Maquinas, Integer> colNomeMaq;

	@FXML
	private TableView<Componentes> tabelaComponentes;

	@FXML
	private TableColumn<Componentes, Integer> colIdComp;

	@FXML
	private TableColumn<Componentes, String> colNomeComp;

	@FXML
	private TableColumn<Componentes, String> colCodigoComp;

	@FXML
	private TableColumn<Componentes, String> colFornecedor1Comp;

	@FXML
	private TableColumn<Componentes, String> colFornecedor2Comp;

	@FXML
	private TableColumn<Componentes, Integer> colQuantidadeComp;

	@FXML
	private TableColumn<Componentes, Integer> colPontoPedidoComp;

	@FXML
	private RadioButton rbInicia;

	@FXML
	private RadioButton rbCaracter;

	@FXML
	private ListView<Componentes> lvListaComponenteMaquina;

	@FXML
	private ListView<ListaComponenteMaquina> lvListaPedido;

	List<ListaComponenteMaquina> list = new ArrayList<ListaComponenteMaquina>();

	List<ListaComponenteMaquina> listAdd = new ArrayList<ListaComponenteMaquina>();

	List<ListaComponenteMaquina> listaMesclada = new ArrayList<ListaComponenteMaquina>();

	ObservableList<ListaComponenteMaquina> obsList;

	List<Componentes> list2 = new ArrayList<Componentes>();

	ObservableList<Componentes> obsList2;

	List<Maquinas> list3 = new ArrayList<Maquinas>();

	ObservableList<Maquinas> obsList3;

	String auxRemoveCb;

	ListaMaquinasDao listaMaquinasDao = FabricaDeDao.createListaMaquinasDao();
	ComponentesDao componentesDao = FabricaDeDao.createComponentesDao();
	MaquinasDao maquinasDao = FabricaDeDao.createMaquinasDao();

	@FXML
	public void onMenuItemMaquinasAction(ActionEvent e) {

		Main.troca("/gui/crudMaquinaView.fxml");

	}

	@FXML
	public void onMenuItemComponentesAction(ActionEvent e) {

		Main.troca("/gui/crudComponentesView.fxml");

	}
	
	@FXML
	public void onMenuItemComponentesEletronicaAction(ActionEvent e) {

		Main.troca("/gui/crudComponentesEletronicaView.fxml");

	}
	
	@FXML
	public void onMenuItemDepartamentoAction(ActionEvent e) {

		Main.troca("/gui/crudDepartamentoView.fxml");

	}
	
	
	public void dataChange() {
	
		txtQtdeMaq.textProperty().addListener((observable, oldValue, newValue) -> {
		    //System.out.println("textfield changed from " + oldValue + " to " + newValue);
		    if (cbMaquinas.getValue() != null) {
		    	onBTBuscaMaqAction(null);
		    	lbAviso.setVisible(false);
		    }else {
				txtQtdeMaq.setText("0");
				lbAviso.setVisible(true);
			}
		    
		});
		
	}

	@FXML
	public void tblArquivosMouseCliked(MouseEvent event) {
	    txtinsereIdCp.setText(tabelaComponentes.getSelectionModel().getSelectedItem().getId().toString());
	}
	
	@FXML
	public void tblArquivosMouseClikedMaq(MouseEvent event) {
	    txtinsereIdMq.setText(tabelaMaq.getSelectionModel().getSelectedItem().getId().toString());
	}
	
	@FXML
	public void onBTListaInserirAction(ActionEvent e) {
		ComponentesDao componentesDao = FabricaDeDao.createComponentesDao();
		MaquinasDao maquinasDao = FabricaDeDao.createMaquinasDao();
		Componentes cp = new Componentes();
		Maquinas mq = new Maquinas();
		ListaComponenteMaquina lc = new ListaComponenteMaquina();
		if ((txtinsereIdMq.getText() != "") && (txtinsereIdCp.getText() != "") && (txtinserirQtd.getText() != "")) {
			mq = maquinasDao.buscaPorId(Integer.parseInt(txtinsereIdMq.getText()));
			cp = componentesDao.buscaPorId(Integer.parseInt(txtinsereIdCp.getText()));
			lc.setQuanbtidade_Por_Maquina(Integer.parseInt(txtinserirQtd.getText()));
			listaMaquinasDao.inserir(mq, cp, lc);

			List<ListaComponenteMaquina> cmp = listaMaquinasDao.buscarTodos();
			obsList = FXCollections.observableArrayList(cmp);
			tableListaMaquina.setItems(obsList);

			txtinsereIdMq.setText("");
			txtinsereIdCp.setText("");
			txtinserirQtd.setText("");

			list2.clear();
			obsList2 = FXCollections.observableArrayList(list2);

		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.INFORMATION);
		}

	}

	@FXML
	public void onBTDeletarAction(ActionEvent e) {
		if ((txtinsereIdMq.getText() != "") && (txtinsereIdCp.getText() != "")) {
			listaMaquinasDao.deletePorId(Integer.parseInt(txtinsereIdMq.getText()),
					Integer.parseInt(txtinsereIdCp.getText()));

			List<ListaComponenteMaquina> cmp = listaMaquinasDao.buscarTodos();
			obsList = FXCollections.observableArrayList(cmp);
			tableListaMaquina.setItems(obsList);

			list2.clear();
			obsList2 = FXCollections.observableArrayList(list2);

		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.INFORMATION);
		}

	}

	@FXML
	public void onBTListaComponentesAction(ActionEvent e) {
		list2 = componentesDao.buscarTodos();
		
		
		
		obsList2 = FXCollections.observableArrayList(list2);
		tabelaComponentes.setItems(obsList2);
	}
	
	@FXML
	public void onBTListaMaquinasAction(ActionEvent e) {
		list3.clear();
		list3 = maquinasDao.buscarTodos();
		obsList3 = FXCollections.observableArrayList(list3);
		tabelaMaq.setItems(obsList3);
	}

	@FXML
	public void onBTBuscaMaqAction(ActionEvent e) {
		
		if (cbMaquinas.getValue() != null) {
		list3 = maquinasDao.buscaPorNome(cbMaquinas.getValue());
		Maquinas mq = new Maquinas();
		if (txtQtdeMaq.getText() == "") {
			txtQtdeMaq.setText("0");
		}

		mq.setQtdeMaquinas(Integer.parseInt(txtQtdeMaq.getText()));

		for (Maquinas m : list3) {
			mq.setId(m.getId());
		}

		txtinsereIdMq.setText(mq.getId().toString());

		List<ListaComponenteMaquina> cmp = listaMaquinasDao.buscarPorMaquina(mq);


		for (ListaComponenteMaquina c : cmp) {
			DepartamentoDao departamentoDao = FabricaDeDao.createDepartamentoDao();
			Departamento dp = new Departamento();
			dp = departamentoDao.buscaPorId(Integer.parseInt(c.getTeste()));
			 
			c.setTeste(dp.getNome());
			
			c.setQuanbtidade_Por_Maquina(c.multiplica(Integer.parseInt(txtQtdeMaq.getText())));
			auxRemoveCb = c.getTipoMaquina();
		}
		listAdd.clear();
		listAdd.addAll(cmp);

		obsList3 = FXCollections.observableArrayList(list3);
		tabelaMaq.setItems(obsList3);
		obsList = FXCollections.observableArrayList(cmp);
		tableListaMaquina.setItems(obsList);
		}else {
			Alerts.showAlert("Inválido", null, "Insira um Equipamento e digite a quantidade!", AlertType.CONFIRMATION);
			txtQtdeMaq.setText("0");
		}
	}

	@FXML
	public void onBTExibirAction(ActionEvent e) {
		
		listaMesclada.clear();

		txtinsereIdMq.setText("");
		Map<String, Integer> mp = new HashMap<String, Integer>();

		for (ListaComponenteMaquina c : list) {

			String nome = c.getComponente_Id();
			Integer count = c.getQuanbtidade_Por_Maquina();

			if (mp.containsKey(nome)) {
				int soma = mp.get(nome);
				mp.put(nome, count + soma);
			} else {
				mp.put(nome, count);
			}

		}

		for (String key : mp.keySet()) {
			String chave = key;
			Integer valor = mp.get(key);
			String codigo = "";
			Integer estoque = 0;
			String departamento = "";

			for (ListaComponenteMaquina k : list) {
				if (k.getComponente_Id() == key) {
					codigo = k.getCodigo();
					estoque = k.getQuanbtidade_Em_Estoque();
					departamento = k.getTeste();
				}
			}

			if (valor != 0) {

				listaMesclada.add(new ListaComponenteMaquina(null, chave, codigo, valor, estoque, departamento));
			}

			btExportar.setDisable(false);
			obsList = FXCollections.observableArrayList(listaMesclada);
			tableListaMaquina.setItems(obsList);

		}
	}
	
	@FXML
	public void onBTExibirPorDepartamentoAction(ActionEvent e) {

			List<ListaComponenteMaquina> lc = new ArrayList<ListaComponenteMaquina>();
			
			for (ListaComponenteMaquina l: listaMesclada) {
				if (l.getTeste().contains(cbBuscaPorDepartamento.getValue())) {
					lc.add(l);
				}
			}

			btExportar.setDisable(false);
			obsList = FXCollections.observableArrayList(lc);
			tableListaMaquina.setItems(obsList);

		}
	

	@FXML
	public void onBTAddListaAction(ActionEvent e) {

		List<Maquinas> mqEmpty = new ArrayList<Maquinas>();
		List<ListaComponenteMaquina> cmpEmpty = new ArrayList<ListaComponenteMaquina>();

		list.addAll(listAdd);
		listAdd.clear();

		obsList3 = FXCollections.observableArrayList(mqEmpty);
		tabelaMaq.setItems(obsList3);
		obsList = FXCollections.observableArrayList(cmpEmpty);
		tableListaMaquina.setItems(obsList);
		txtQtdeMaq.setText("0");

		cbMaquinas.getItems().remove(auxRemoveCb);

		obsList = FXCollections.observableArrayList(list);
		tableListaMaquina.setItems(obsList);
	}

	public void onBTListaFullAction(ActionEvent e) {
		
		List<ListaComponenteMaquina> cmp = listaMaquinasDao.buscarTodos();
		txtinsereIdMq.setText("");
		
		for (ListaComponenteMaquina c : cmp) {
			DepartamentoDao departamentoDao = FabricaDeDao.createDepartamentoDao();
			Departamento dp = new Departamento();
			dp = departamentoDao.buscaPorId(Integer.parseInt(c.getTeste()));
			 
			c.setTeste(dp.getNome());
			}

	

		obsList = FXCollections.observableArrayList(cmp);
		tableListaMaquina.setItems(obsList);
	}

	public void onBTLimpaListaAction(ActionEvent e) {

		list.clear();
		obsList = FXCollections.observableArrayList(list);
		tableListaMaquina.setItems(obsList);

		cbMaquinas.getItems().clear();

		List<Maquinas> lista = new ArrayList<Maquinas>();
		MaquinasDao maquinasDao = FabricaDeDao.createMaquinasDao();
		lista = maquinasDao.buscarTodos();

		for (Maquinas m : lista) {
			cbMaquinas.getItems().add(m.getNome());
		}
		
		btExportar.setDisable(true);
		btExibir.setDisable(true);
		btListaFull.setDisable(true);
		
		btAdicionaALista.setDisable(false);
		btConcluiLista.setDisable(false);
		btBuscaMaq.setDisable(false);
		
		txtQtdeMaq.setDisable(false);
		
		cbMaquinas.setDisable(false);

	}

	@FXML
	public void onBTBuscaNomeComponenteAction(ActionEvent e) {

		list2.clear();
		List<Componentes> cp2 = componentesDao.buscarTodos();

		if (txtBuscaNomeComponente.getText() != "") {

			if (rbInicia.isSelected()) {
				cp2 = componentesDao.buscaPorNome(txtBuscaNomeComponente.getText() + "%");
			}

			else if (rbCaracter.isSelected()) {
				cp2 = componentesDao.buscaPorNome("%" + txtBuscaNomeComponente.getText() + "%");
			}

			txtBuscaNomeComponente.setText("");
			list2.addAll(cp2);
			obsList2 = FXCollections.observableArrayList(list2);
			tabelaComponentes.setItems(obsList2);
			list2.clear();
		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.CONFIRMATION);
		}
		
		
	}
	
	@FXML
	public void onBTBuscaNomeMaquinaAction(ActionEvent e) {

		list3.clear();
		List<Maquinas> mq3 = maquinasDao.buscarTodos();

		if (txtBuscaNomeMaquina.getText() != "") {

			if (rbInicia.isSelected()) {
				mq3 = maquinasDao.buscaPorNome(txtBuscaNomeMaquina.getText() + "%");
			}

			else if (rbCaracter.isSelected()) {
				mq3 = maquinasDao.buscaPorNome("%" + txtBuscaNomeMaquina.getText() + "%");
			}

			txtBuscaNomeMaquina.setText("");
			list3.addAll(mq3);
			obsList3 = FXCollections.observableArrayList(list3);
			tabelaMaq.setItems(obsList3);
			list2.clear();
		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.CONFIRMATION);
		}
	}

	@FXML
	public void onBTExportarAction(ActionEvent e) {
		
		String path = "C:\\Users\\jorge.luiz\\Desktop\\out.csv";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (ListaComponenteMaquina l : listaMesclada) {
				String st = l.toString();
				bw.write(st);
				bw.newLine();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	@FXML
	public void onBTConcluiListaAction(ActionEvent e) {
		
		btExibir.setDisable(false);
		btListaFull.setDisable(false);
		btExportar.setDisable(false);
		
		btAdicionaALista.setDisable(true);
		btConcluiLista.setDisable(true);
		btBuscaMaq.setDisable(true);
		txtQtdeMaq.setDisable(true);
		
		cbMaquinas.setDisable(true);
		
		listaMesclada.clear();

		txtinsereIdMq.setText("");
		Map<String, Integer> mp = new HashMap<String, Integer>();

		for (ListaComponenteMaquina c : list) {

			String nome = c.getComponente_Id();
			Integer count = c.getQuanbtidade_Por_Maquina();

			if (mp.containsKey(nome)) {
				int soma = mp.get(nome);
				mp.put(nome, count + soma);
			} else {
				mp.put(nome, count);
			}

		}

		for (String key : mp.keySet()) {
			String chave = key;
			Integer valor = mp.get(key);
			String codigo = "";
			Integer estoque = 0;
			String departamento = "";

			for (ListaComponenteMaquina k : list) {
				if (k.getComponente_Id() == key) {
					codigo = k.getCodigo();
					estoque = k.getQuanbtidade_Em_Estoque();
					departamento = k.getTeste();
				}
			}

			if (valor != 0) {

				listaMesclada.add(new ListaComponenteMaquina(null, chave, codigo, valor, estoque, departamento));
			}
			
			btExportar.setDisable(false);
			obsList = FXCollections.observableArrayList(listaMesclada);
			tableListaMaquina.setItems(obsList);
			cbBuscaPorDepartamento.setDisable(false);
			btPorDepartamento.setDisable(false);
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		columnMaquina.setCellValueFactory(new PropertyValueFactory<>("tipoMaquina"));
		columnComponente.setCellValueFactory(new PropertyValueFactory<>("componente_Id"));
		columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		columnQuantidadePorMaquina.setCellValueFactory(new PropertyValueFactory<>("quanbtidade_Por_Maquina"));
		columnQuantidadeEstoque.setCellValueFactory(new PropertyValueFactory<>("quanbtidade_Em_Estoque"));
		columnTeste.setCellValueFactory(new PropertyValueFactory<>("teste"));

		colIdMaq.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNomeMaq.setCellValueFactory(new PropertyValueFactory<>("nome"));

		colIdComp.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNomeComp.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colCodigoComp.setCellValueFactory(new PropertyValueFactory<>("codigo"));

		Constraints.setTextFieldInteger(txtinserirQtd);
		Constraints.setTextFieldInteger(txtinsereIdCp);
		Constraints.setTextFieldInteger(txtinsereIdMq);

		txtQtdeMaq.setText("0");

		columnTeste.setCellFactory(TextFieldTableCell.forTableColumn());

		List<Maquinas> lista = new ArrayList<Maquinas>();
		MaquinasDao maquinasDao = FabricaDeDao.createMaquinasDao();
		lista = maquinasDao.buscarTodos();

		for (Maquinas m : lista) {
			cbMaquinas.getItems().add(m.getNome());
		}

		rbInicia.setSelected(true);
		
		btExportar.setDisable(true);
		btExibir.setDisable(true);
		btListaFull.setDisable(true);
		
		List<Departamento> li = new ArrayList<Departamento>();
		DepartamentoDao departamentoDao = FabricaDeDao.createDepartamentoDao();
		li = departamentoDao.buscarTodos();

		for (Departamento d : li) {
			cbBuscaPorDepartamento.getItems().add(d.getNome());
		}
		
		cbBuscaPorDepartamento.setValue("ELÉTRICA");
		cbBuscaPorDepartamento.setDisable(true);
		btPorDepartamento.setDisable(true);
		lbAviso.setVisible(false);
	}

}
