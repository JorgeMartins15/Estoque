package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import application.Main;
import db.DbException;
import gui.utils.Alerts;
import gui.utils.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.dao.FabricaDeDao;
import modelo.dao.MaquinasDao;
import modelo.entidades.Maquinas;

public class crudMaquinaViewController implements Initializable {

	MaquinasDao maquinasDao = FabricaDeDao.createMaquinasDao();

	@FXML
	private MenuItem menuItemMaquinas;

	@FXML
	private MenuItem menuItemComponentesEletronica;

	@FXML
	private MenuItem menuItemLista;
	
	@FXML
	private MenuItem menuItemDepartamento;
	
	@FXML
	private MenuItem menuItemRequisicoes;

	@FXML
	private Label lbInserirNome;

	@FXML
	private Button btMostrarTodos;

	@FXML
	private Button btMostrarId;

	@FXML
	private Button btUpdate;

	@FXML
	private Button btDeletar;

	@FXML
	private Button btInserirNovo;

	@FXML
	private Button btConfirmarNovo;

	@FXML
	private Button btLimparFiltros;

	@FXML
	private Button btBuscaNome;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtAlteraNome;

	@FXML
	private TextField txtInserirNovo;

	@FXML
	private TextField txtBuscaNome;

	@FXML
	private RadioButton rbInicia;

	@FXML
	private RadioButton rbCaracter;

	@FXML
	TableView<Maquinas> tabelaMaq;

	@FXML
	TableColumn<Maquinas, Integer> colIdMaq;

	@FXML
	TableColumn<Maquinas, Integer> colNomeMaq;

	List<Maquinas> list = new ArrayList<Maquinas>();

	ObservableList<Maquinas> obsList;

	@FXML
	public void onMenuItemComponentesAction(ActionEvent e) {

		Main.troca("/gui/crudComponentesView.fxml");
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
	public void onMenuItemRequisicoesAction(ActionEvent e) {

		Main.troca("/gui/requisicoesView.fxml");

	}

	@FXML
	public void onBTMostrarTodosAction(ActionEvent e) {
		list = maquinasDao.buscarTodos();
		obsList = FXCollections.observableArrayList(list);
		tabelaMaq.setItems(obsList);
	}

	@FXML
	public void onBTBuscaIdAction(ActionEvent e) {

		list.clear();
		Maquinas mq = new Maquinas();
		List<Maquinas> mq2 = maquinasDao.buscarTodos();

		if (txtId.getText() != "") {
			mq = maquinasDao.buscaPorId(Integer.parseInt(txtId.getText()));

			if (mq2.contains(mq)) {
				txtAlteraNome.setText(mq.getNome());
				list.add(mq);
				obsList = FXCollections.observableArrayList(list);
				tabelaMaq.setItems(obsList);
				list.clear();
			} else {
				Alerts.showAlert("Inválido", null, "ID NÃO EXISTENTE!!!", AlertType.ERROR);
				txtId.setText("");
			}

		} else {

			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.INFORMATION);
		}

	}

	@FXML
	public void onBTBuscaNomeAction(ActionEvent e) {

		list.clear();
		List<Maquinas> mq2 = maquinasDao.buscarTodos();

		if (txtBuscaNome.getText() != "") {

			if (rbInicia.isSelected()) {
				mq2 = maquinasDao.buscaPorNome(txtBuscaNome.getText() + "%");
			}

			else if (rbCaracter.isSelected()) {
				mq2 = maquinasDao.buscaPorNome("%" + txtBuscaNome.getText() + "%");
			}

			list.addAll(mq2);
			obsList = FXCollections.observableArrayList(list);
			tabelaMaq.setItems(obsList);
			list.clear();
		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.CONFIRMATION);
		}
	}

	@FXML
	public void onBTUpdateAction(ActionEvent e) {

		if ((txtAlteraNome.getText() != "") || (txtId.getText() != "")) {

			Maquinas mq = maquinasDao.buscaPorId(Integer.parseInt(txtId.getText()));

			Optional<ButtonType> resultado = Alerts.showConfirmation("Confirmação",
					"Deseja realmente fazer update do Id selecionado?");

			if (resultado.get() == ButtonType.OK) {

				if (txtAlteraNome.getText() != "") {
					if (mq != null) {
						mq.setNome(txtAlteraNome.getText().toUpperCase());
						maquinasDao.update(mq);

						list.clear();
						list = maquinasDao.buscarTodos();

						obsList = FXCollections.observableArrayList(list);
						tabelaMaq.setItems(obsList);
						list.clear();
						txtAlteraNome.setText("");
						txtId.setText("");
					} else {
						Alerts.showAlert("Inválido", null, "ID NÃO EXISTENTE!!!", AlertType.ERROR);
						txtId.setText("");
						txtAlteraNome.setText("");
					}
				} else {
					Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.CONFIRMATION);
				}
			}
		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.INFORMATION);
		}
	}

	@FXML
	public void onBTDeleteAction(ActionEvent e) {

		if (txtId.getText() != "") {

			Optional<ButtonType> resultado = Alerts.showConfirmation("Confirmação",
					"Deseja realmente deletar o Id selecionado?");

			if (resultado.get() == ButtonType.OK) {

				Maquinas mq = maquinasDao.buscaPorId(Integer.parseInt(txtId.getText()));
				if (mq != null) {
					maquinasDao.deletePorId(mq.getId());

					list = maquinasDao.buscarTodos();
					obsList = FXCollections.observableArrayList(list);
					tabelaMaq.setItems(obsList);
					txtId.setText("");
					txtAlteraNome.setText("");
				} else {
					Alerts.showAlert("Inválido", null, "ID não pode ser excluido, porque não existe!!!",
							AlertType.WARNING);
				}
			}

		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.WARNING);
		}

	}

	@FXML
	public void onBTConfirmarNovoAction(ActionEvent e) {
		Maquinas mq = new Maquinas(null, txtInserirNovo.getText().toUpperCase());

		if (txtInserirNovo.getText() != "") {

			Optional<ButtonType> resultado = Alerts.showConfirmation("Confirmação", "Deseja realmente incluir novo?");

			if (resultado.get() == ButtonType.OK) {

				try {
					maquinasDao.inserir(mq);
					list = maquinasDao.buscarTodos();
					obsList = FXCollections.observableArrayList(list);
					tabelaMaq.setItems(obsList);
					txtInserirNovo.setText("");
				} catch (DbException e1) {
					e1.getMessage();
					Alerts.showAlert("Inválido", null, "Nome já existente!!!", AlertType.INFORMATION);
				}

			}
		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.INFORMATION);
		}
	}

	@FXML
	public void onBTLimpaFiltrosAction(ActionEvent e) {

		txtId.setText("");
		txtAlteraNome.setText("");
		txtBuscaNome.setText("");
		List<Maquinas> mq2 = maquinasDao.buscarTodos();
		obsList = FXCollections.observableArrayList(mq2);
		tabelaMaq.setItems(obsList);

	}
	
	@FXML
	public void tblArquivosMouseCliked(MouseEvent event) {
		
		txtId.setText(tabelaMaq.getSelectionModel().getSelectedItem().getId().toString());
	    txtAlteraNome.setText(tabelaMaq.getSelectionModel().getSelectedItem().getNome());
	}

	@Override
	public void initialize(URL ur, ResourceBundle rb) {

		colIdMaq.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNomeMaq.setCellValueFactory(new PropertyValueFactory<>("nome"));

		colIdMaq.setResizable(true);

		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtAlteraNome, 40);
		Constraints.setTextFieldMaxLength(txtInserirNovo, 40);
		Constraints.setTextFieldMaxLength(txtId, 4);
		
		rbInicia.setSelected(true);

	}
}
