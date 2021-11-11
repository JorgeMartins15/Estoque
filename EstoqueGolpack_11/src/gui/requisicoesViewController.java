package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IllegalFormatException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import application.Main;
import gui.utils.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.dao.RequisicaoDao;
import modelo.dao.FabricaDeDao;
import modelo.entidades.Requisicao;

public class requisicoesViewController implements Initializable {

	@FXML
	private MenuItem menuItemMaquinas;

	@FXML
	private MenuItem menuItemRequisicaoEletronica;

	@FXML
	private MenuItem menuItemLista;

	@FXML
	private MenuItem menuItemDepartamento;

	@FXML
	private Button btDecrementaUmReq;

	@FXML
	private Button btIncrementaUmReq;

	@FXML
	private Button btDecrementaAllReq;

	@FXML
	private Button btIncrementaAllReq;

	@FXML
	private TextField txtNumeroReq;

	@FXML
	private TableView<Requisicao> tabelaRequisicao;

	@FXML
	private TableColumn<Requisicao, Integer> colItem;

	@FXML
	private TableColumn<Requisicao, String> colNome;

	@FXML
	private TableColumn<Requisicao, String> colCodigo;

	@FXML
	private TableColumn<Requisicao, String> colQuantidade;

	@FXML
	private TableColumn<Requisicao, String> colDestino;

	@FXML
	private TableColumn<Requisicao, Integer> colDataEmissao;

	@FXML
	private TableColumn<Requisicao, Integer> colDataEntrega;

	RequisicaoDao requisicaoDaoDao = FabricaDeDao.createRequisicaoDao();
	ObservableList<Requisicao> obsList;

	Set<Integer> set = new TreeSet<Integer>();
	List<Integer> auxList1 = new ArrayList<Integer>(set);
	Integer auxI;
	Integer auxIndex;

	@FXML
	public void onMenuItemMaquinasAction(ActionEvent e) {

		Main.troca("/gui/crudMaquinaView.fxml");
	}

	@FXML
	public void onMenuItemListaAction(ActionEvent e) {

		Main.troca("/gui/ListaPorMaquinaView.fxml");
	}

	@FXML
	public void onMenuItemComponentesEletronicaAction(ActionEvent e) {

		Main.troca("/gui/crudComponentesEletronicaView.fxml");

	}

	@FXML
	public void onMenuItemDepartamentoAction(ActionEvent e) {

		Main.troca("/gui/crudDepartamentoView.fxml");

	}

	@FXML
	public void onTextBuscaReqReqAction(ActionEvent e) {

		if (auxI > 0) {
			auxI = auxI - 1;
		} else {
			auxI = 0;
		}

		if (auxI < set.size() - 1) {
			auxI = auxI + 1;
		} else {
			auxI = 3;
		}

			boolean confirma = false;
			List<Integer> auxList = new ArrayList<Integer>(set);
			Requisicao requisicao = new Requisicao();
			requisicao.setNumero(Integer.parseInt(txtNumeroReq.getText()));
			
			List<Requisicao> listAll = requisicaoDaoDao.buscarTodos();
			
			List<Requisicao> numReq = requisicaoDaoDao.buscaPorNumero(requisicao);
			
			for(Requisicao r : listAll) {
				if (numReq.contains(r)) {
					obsList = FXCollections.observableArrayList(numReq);
					confirma = true;
					System.out.println("true");
				}
			}
		
			if(confirma == true) {
				tabelaRequisicao.setItems(obsList);
				confirma = false;
			}else if (confirma == false) {
				txtNumeroReq.setText(auxList.get(set.size() - 1).toString());
				auxI = set.size() - 1;
				requisicao.setNumero(Integer.parseInt(txtNumeroReq.getText()));
				numReq = requisicaoDaoDao.buscaPorNumero(requisicao);
				obsList = FXCollections.observableArrayList(numReq);
				tabelaRequisicao.setItems(obsList);
				Alerts.showAlert("Alerta", null, "Requisição não Existe!", Alert.AlertType.INFORMATION);
			}
			

	}

	@FXML
	public void onBTDecrementaUmReqAction(ActionEvent e) {

		if (auxI > 0) {
			auxI = auxI - 1;
		} else {
			auxI = 0;
		}

		List<Integer> auxList = new ArrayList<Integer>(set);

		txtNumeroReq.setText(auxList.get(auxI).toString());

		Requisicao requisicao = new Requisicao();
		requisicao.setNumero(Integer.parseInt(txtNumeroReq.getText()));

		List<Requisicao> numReq = requisicaoDaoDao.buscaPorNumero(requisicao);

		obsList = FXCollections.observableArrayList(numReq);
		tabelaRequisicao.setItems(obsList);

		System.out.println(auxI);

	}

	@FXML
	public void onBTIncrementaUmReqAction(ActionEvent e) {

		if (auxI < set.size() - 1) {
			auxI = auxI + 1;
		} else {
			auxI = 3;
		}

		List<Integer> auxList = new ArrayList<Integer>(set);

		txtNumeroReq.setText(auxList.get(auxI).toString());

		Requisicao requisicao = new Requisicao();
		requisicao.setNumero(Integer.parseInt(txtNumeroReq.getText()));

		List<Requisicao> numReq = requisicaoDaoDao.buscaPorNumero(requisicao);

		obsList = FXCollections.observableArrayList(numReq);
		tabelaRequisicao.setItems(obsList);
		System.out.println(auxI);

	}

	@FXML
	public void onBTDecrementaAllReqAction(ActionEvent e) {

		List<Integer> auxList = new ArrayList<Integer>(set);
		Requisicao requisicao = new Requisicao();
		requisicao.setNumero(auxList.get(0));

		txtNumeroReq.setText(auxList.get(0).toString());
		List<Requisicao> numReq = requisicaoDaoDao.buscaPorNumero(requisicao);

		obsList = FXCollections.observableArrayList(numReq);
		tabelaRequisicao.setItems(obsList);
		auxI = 0;
		System.out.println(auxI);
	}

	@FXML
	public void onBTIncrementaAllReqAction(ActionEvent e) {
		List<Integer> auxList = new ArrayList<Integer>(set);
		Requisicao requisicao = new Requisicao();
		Integer stg = auxList.size() - 1;
		requisicao.setNumero(auxList.get(stg));

		txtNumeroReq.setText(auxList.get(stg).toString());
		List<Requisicao> numReq = requisicaoDaoDao.buscaPorNumero(requisicao);

		obsList = FXCollections.observableArrayList(numReq);
		tabelaRequisicao.setItems(obsList);
		auxI = auxList.size() - 1;

		System.out.println(auxI);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		colItem.setCellValueFactory(new PropertyValueFactory<>("item"));
		colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		colDestino.setCellValueFactory(new PropertyValueFactory<>("destino"));
		colDataEmissao.setCellValueFactory(new PropertyValueFactory<>("dataEmissao"));
		colDataEntrega.setCellValueFactory(new PropertyValueFactory<>("dataEntrega"));

		List<Requisicao> req = requisicaoDaoDao.buscarTodos();

		auxI = auxList1.size();

		for (Requisicao r : req) {
			Integer i = 0;
			if (i < r.getNumero()) {
				i = r.getNumero();
				set.add(i);
				txtNumeroReq.setText(i.toString());
			}

		}
		Requisicao requisicao = new Requisicao();
		requisicao.setNumero(Integer.parseInt(txtNumeroReq.getText()));
		List<Requisicao> numReq = requisicaoDaoDao.buscaPorNumero(requisicao);

		obsList = FXCollections.observableArrayList(numReq);
		tabelaRequisicao.setItems(obsList);

		System.out.println(set.size());
	}

}
