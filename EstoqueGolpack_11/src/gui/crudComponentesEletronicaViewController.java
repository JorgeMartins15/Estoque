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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelo.dao.ComponentesEletronicaDao;
import modelo.dao.FabricaDeDao;
import modelo.entidades.Componentes;
import modelo.entidades.ComponentesEletronica;
import modelo.entidades.Maquinas;

public class crudComponentesEletronicaViewController implements Initializable {

	@FXML
	private MenuItem menuItemMaquinas;

	@FXML
	private MenuItem menuItemComponentes;

	@FXML
	private MenuItem menuItemLista;
	
	@FXML
	private MenuItem menuItemDepartamento;

	@FXML
	private Button btTelaMaquinas;

	@FXML
	private Button btBuscaId;

	@FXML
	private Button btDeletar;

	@FXML
	private Button btUpdate;

	@FXML
	private Button btCompBuscaTodos;

	@FXML
	private Button btInserirNovo;

	@FXML
	private Button btConfirmaNovo;

	@FXML
	private Button btLimpaFiltros;

	@FXML
	private Button btBuscaNome;

	@FXML
	private Label lbUpNome;

	@FXML
	private Label lbUpCodigo;

	@FXML
	private Label lbUpFornecedor1;

	@FXML
	private Label lbUpFornecedor2;

	@FXML
	private Label lbUpQuantidadeAtual;

	@FXML
	private Label lbUpPontoPedido;

	@FXML
	private Label lbNewNome;

	@FXML
	private Label lbNewCodigo;

	@FXML
	private Label lbNewFornecedor1;

	@FXML
	private Label lbNewFornecedor2;

	@FXML
	private Label lbNewQuantidadeAtual;

	@FXML
	private Label lbNewPontoPedido;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtAlteraNome;

	@FXML
	private TextField txtAlteraCodigoGrupo;

	@FXML
	private TextField txtAlteraCodigoSubGrupo;

	@FXML
	private TextField txtAlteraCodigoSubSub;

	@FXML
	private TextField txtAlteraFornecedor1;

	@FXML
	private TextField txtAlteraFornecedor2;

	@FXML
	private TextField txtAlteraQuantidadeAtual;

	@FXML
	private TextField txtAlteraPontoDePedido;

	@FXML
	private TextField txtInserirNome;

	@FXML
	private TextField txtInserirCodigoGrupo;

	@FXML
	private TextField txtInserirCodigoSubGrupo;

	@FXML
	private TextField txtInserirCodigoSubSub;

	@FXML
	private TextField txtInserirFornecedor1;

	@FXML
	private TextField txtInserirFornecedor2;

	@FXML
	private TextField txtInserirQuantidadeAtual;

	@FXML
	private TextField txtInserirPontoDePedido;

	@FXML
	private TextField txtBuscaNome;

	@FXML
	private RadioButton rbInicia;

	@FXML
	private RadioButton rbCaracter;

	@FXML
	private TableView<ComponentesEletronica> tabelaComponentesEletronica;

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
	private TableColumn<Componentes, Integer> colMaquinaIdComp;

	ComponentesEletronicaDao componentesEletronicaDao = FabricaDeDao.createComponentesEletronicaDao();

	List<ComponentesEletronica> list = new ArrayList<ComponentesEletronica>();

	ObservableList<ComponentesEletronica> obsList;

	@FXML
	public void onMenuItemMaquinasAction(ActionEvent e) {

		Main.troca("/gui/crudMaquinaView.fxml");
	}
	
	@FXML
	public void onMenuItemComponentesAction(ActionEvent e) {

		Main.troca("/gui/crudComponentesView.fxml");

	}

	@FXML
	public void onMenuItemListaAction(ActionEvent e) {

		Main.troca("/gui/ListaPorMaquinaView.fxml");
	}
	
	@FXML
	public void onMenuItemDepartamentoAction(ActionEvent e) {

		Main.troca("/gui/crudDepartamentoView.fxml");

	}

	@FXML
	public void onBTCompBuscaTodosAction(ActionEvent e) {
		list = componentesEletronicaDao.buscarTodos();
		obsList = FXCollections.observableArrayList(list);
		tabelaComponentesEletronica.setItems(obsList);

	}

	@FXML
	public void onBTBuscaIdAction(ActionEvent e) {

		list.clear();
		ComponentesEletronica cp = new ComponentesEletronica();
		List<ComponentesEletronica> cp2 = componentesEletronicaDao.buscarTodos();

		if (txtId.getText() != "") {
			cp = componentesEletronicaDao.buscaPorId(Integer.parseInt(txtId.getText()));

			if (cp2.contains(cp)) {
				txtAlteraNome.setText(cp.getNome());
				txtAlteraCodigoGrupo.setText(cp.getCodigo().substring(0, 3));
				txtAlteraCodigoSubGrupo.setText(cp.getCodigo().substring(4, 7));
				txtAlteraCodigoSubSub.setText(cp.getCodigo().substring(8, 12));
				txtAlteraFornecedor1.setText(cp.getFornecedor1());
				txtAlteraFornecedor2.setText(cp.getFornecedor2());
				txtAlteraQuantidadeAtual.setText(cp.getQuantidadeAtual().toString());
				txtAlteraPontoDePedido.setText(cp.getPontoDePedido().toString());
				list.add(cp);
				obsList = FXCollections.observableArrayList(list);
				tabelaComponentesEletronica.setItems(obsList);
				list.clear();
			} else {
				Alerts.showAlert("Inválido", null, "ID NÃO EXISTENTE!!!", AlertType.INFORMATION);
				txtId.setText("");
			}

		} else {

			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.INFORMATION);
		}

	}

	@FXML
	public void onBTUpdateAction(ActionEvent e) {

		boolean upOk = false;

		if (txtId.getText() != "") {
			ComponentesEletronica cp = componentesEletronicaDao.buscaPorId(Integer.parseInt(txtId.getText()));

			if ((txtAlteraNome.getText() != "") && (txtAlteraCodigoGrupo.getText() != "")
					&& (txtAlteraCodigoSubGrupo.getText() != "") && (txtAlteraCodigoSubSub.getText() != "")
					&& (txtAlteraFornecedor1.getText() != "") && (txtAlteraQuantidadeAtual.getText() != "")
					&& (txtAlteraPontoDePedido.getText() != "")) {

				Optional<ButtonType> resultado = Alerts.showConfirmation("Confirmação",
						"Deseja realmente fazer update do Id selecionado?");

				if (resultado.get() == ButtonType.OK) {
					if (cp != null) {

						String grupo = txtAlteraCodigoGrupo.getText();
						String subGrupo = txtAlteraCodigoSubGrupo.getText();
						String subSub = txtAlteraCodigoSubSub.getText();

						cp.setNome(txtAlteraNome.getText().toUpperCase());
						cp.setCodigo(grupoChar3(grupo) + "." + grupoChar3(subGrupo) + "." + grupoChar4(subSub));
						cp.setFornecedor1(txtAlteraFornecedor1.getText().toUpperCase());
						cp.setFornecedor2(txtAlteraFornecedor2.getText().toUpperCase());
						cp.setQuantidadeAtual(Integer.parseInt(txtAlteraQuantidadeAtual.getText().toUpperCase()));
						cp.setPontoDePedido(Integer.parseInt(txtAlteraPontoDePedido.getText().toUpperCase()));

						try {
							componentesEletronicaDao.update(cp);
							upOk = true;
						} catch (DbException e1) {
							Alerts.showAlert("Inválido", null, "Nome ou Código já existe no data Base!!!",
									AlertType.INFORMATION);
							upOk = false;
						}

						if (upOk == true) {
							list.clear();
							list = componentesEletronicaDao.buscarTodos();

							obsList = FXCollections.observableArrayList(list);
							tabelaComponentesEletronica.setItems(obsList);
							list.clear();
							txtAlteraNome.setText("");
							txtAlteraCodigoGrupo.setText("");
							txtAlteraCodigoSubGrupo.setText("");
							txtAlteraCodigoSubSub.setText("");
							txtAlteraFornecedor1.setText("");
							txtAlteraFornecedor2.setText("");
							txtAlteraPontoDePedido.setText("");
							txtAlteraQuantidadeAtual.setText("");
							txtId.setText("");
						}
					} else {
						Alerts.showAlert("Inválido", null, "ID não existe!!!", AlertType.INFORMATION);
						txtAlteraNome.setText("");
						txtAlteraCodigoGrupo.setText("");
						txtAlteraCodigoSubGrupo.setText("");
						txtAlteraCodigoSubSub.setText("");
						txtAlteraFornecedor1.setText("");
						txtAlteraFornecedor2.setText("");
						txtAlteraPontoDePedido.setText("");
						txtAlteraQuantidadeAtual.setText("");
						txtId.setText("");
					}
				}
			} else {
				Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.INFORMATION);
			}
		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.ERROR);
		}
	}

	@FXML
	public void onBTDeleteAction(ActionEvent e) {

		if (txtId.getText() != "") {

			Optional<ButtonType> resultado = Alerts.showConfirmation("Confirmação",
					"Deseja realmente deletar o Id selecionado?");

			if (resultado.get() == ButtonType.OK) {

				ComponentesEletronica cp = componentesEletronicaDao.buscaPorId(Integer.parseInt(txtId.getText()));
				if (cp != null) {
					componentesEletronicaDao.deletePorId(cp.getId());
					list = componentesEletronicaDao.buscarTodos();
					obsList = FXCollections.observableArrayList(list);
					tabelaComponentesEletronica.setItems(obsList);
					txtId.setText("");
					txtAlteraNome.setText("");
					txtAlteraCodigoGrupo.setText("");
					txtAlteraCodigoSubGrupo.setText("");
					txtAlteraCodigoSubSub.setText("");
					txtAlteraFornecedor1.setText("");
					txtAlteraFornecedor2.setText("");
					txtAlteraQuantidadeAtual.setText("");
					txtAlteraPontoDePedido.setText("");
				} else {
					Alerts.showAlert("Inválido", null, "Não pode ser excluido, ID não existe!!!",
							AlertType.INFORMATION);
					txtId.setText("");
				}
			}
		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.INFORMATION);
		}

	}

	@FXML
	public void onBTConfirmarNovoAction(ActionEvent e) {
		Maquinas mq = new Maquinas(1, null);
		ComponentesEletronica cp = new ComponentesEletronica();

		if ((txtInserirNome.getText() != "") && (txtInserirCodigoGrupo.getText() != "")
				&& (txtInserirCodigoSubGrupo.getText() != "") && (txtInserirCodigoSubSub.getText() != "")
				&& (txtInserirFornecedor1.getText() != "") && (txtInserirQuantidadeAtual.getText() != "")
				&& (txtInserirPontoDePedido.getText() != "")) {

			String grupo = txtInserirCodigoGrupo.getText();
			String subGrupo = txtInserirCodigoSubGrupo.getText();
			String subSub = txtInserirCodigoSubSub.getText();

			cp.setNome(txtInserirNome.getText().toUpperCase());
			cp.setCodigo(grupoChar3(grupo) + "." + grupoChar3(subGrupo) + "." + grupoChar4(subSub));
			cp.setFornecedor1(txtInserirFornecedor1.getText().toUpperCase());
			cp.setFornecedor2(txtInserirFornecedor2.getText().toUpperCase());
			cp.setQuantidadeAtual(Integer.parseInt(txtInserirQuantidadeAtual.getText()));
			cp.setPontoDePedido(Integer.parseInt(txtInserirPontoDePedido.getText()));
			cp.setMaquinas(mq);

			Optional<ButtonType> resultado = Alerts.showConfirmation("Confirmação", "Deseja realmente incluir novo?");

			if (resultado.get() == ButtonType.OK) {

				try {
					componentesEletronicaDao.inserir(cp);
					list = componentesEletronicaDao.buscarTodos();
					obsList = FXCollections.observableArrayList(list);
					tabelaComponentesEletronica.setItems(obsList);

				} catch (DbException e1) {
					e1.getMessage();
					Alerts.showAlert("Inválido", null, "Nome ou Código já existente!!!", AlertType.INFORMATION);
				}

			}

			txtInserirNome.setText("");
			txtInserirCodigoGrupo.setText("");
			txtInserirCodigoSubGrupo.setText("");
			txtInserirCodigoSubSub.setText("");
			txtInserirFornecedor1.setText("");
			txtInserirFornecedor2.setText("");
			txtInserirPontoDePedido.setText("");
			txtInserirQuantidadeAtual.setText("");

		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.INFORMATION);
		}

	}

	@FXML
	public void onBTLimpaFiltrosAction(ActionEvent e) {

		txtId.setText("");
		txtBuscaNome.setText("");
		txtAlteraCodigoGrupo.setText("");
		txtAlteraCodigoSubGrupo.setText("");
		txtAlteraCodigoSubSub.setText("");
		txtAlteraFornecedor1.setText("");
		txtAlteraFornecedor2.setText("");
		txtAlteraNome.setText("");
		txtAlteraPontoDePedido.setText("");
		txtAlteraQuantidadeAtual.setText("");
		list = componentesEletronicaDao.buscarTodos();
		obsList = FXCollections.observableArrayList(list);
		tabelaComponentesEletronica.setItems(obsList);

	}

	@FXML
	public void onBTBuscaNomeAction(ActionEvent e) {

		list.clear();

		List<ComponentesEletronica> cp2 = componentesEletronicaDao.buscarTodos();

		if (txtBuscaNome.getText() != "") {

			if (rbInicia.isSelected()) {
				cp2 = componentesEletronicaDao.buscaPorNome(txtBuscaNome.getText() + "%");
			}

			else if (rbCaracter.isSelected()) {
				cp2 = componentesEletronicaDao.buscaPorNome("%" + txtBuscaNome.getText() + "%");
			}

			list.addAll(cp2);
			obsList = FXCollections.observableArrayList(list);
			tabelaComponentesEletronica.setItems(obsList);
			list.clear();
		} else {
			Alerts.showAlert("Inválido", null, "Campo não pode ser vazio!", AlertType.CONFIRMATION);
		}
	}

	public String grupoChar3(String nome) {

		if (nome.length() == 2) {
			nome = "0" + nome;
		} else if (nome.length() == 1) {
			nome = "00" + nome;
		}

		return nome;
	}

	public String grupoChar4(String nome) {

		if (nome.length() == 3) {
			nome = "0" + nome;
		} else if (nome.length() == 2) {
			nome = "00" + nome;
		} else if (nome.length() == 1) {
			nome = "000" + nome;
		}

		return nome;
	}

	@FXML
	public void tblArquivosMouseCliked(MouseEvent event) {

		txtId.setText(tabelaComponentesEletronica.getSelectionModel().getSelectedItem().getId().toString());
		txtAlteraNome.setText(tabelaComponentesEletronica.getSelectionModel().getSelectedItem().getNome());
		txtAlteraCodigoGrupo
				.setText(tabelaComponentesEletronica.getSelectionModel().getSelectedItem().getCodigo().substring(0, 3));
		txtAlteraCodigoSubGrupo
				.setText(tabelaComponentesEletronica.getSelectionModel().getSelectedItem().getCodigo().substring(4, 7));
		txtAlteraCodigoSubSub
				.setText(tabelaComponentesEletronica.getSelectionModel().getSelectedItem().getCodigo().substring(8, 12));
		txtAlteraFornecedor1.setText(tabelaComponentesEletronica.getSelectionModel().getSelectedItem().getFornecedor1());
		txtAlteraFornecedor2.setText(tabelaComponentesEletronica.getSelectionModel().getSelectedItem().getFornecedor2());
		txtAlteraQuantidadeAtual
				.setText(tabelaComponentesEletronica.getSelectionModel().getSelectedItem().getQuantidadeAtual().toString());
		txtAlteraPontoDePedido
				.setText(tabelaComponentesEletronica.getSelectionModel().getSelectedItem().getPontoDePedido().toString());
	}

	@Override
	public void initialize(URL ur, ResourceBundle rb) {

		colIdComp.setCellValueFactory(new PropertyValueFactory<>("id"));
		colNomeComp.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colCodigoComp.setCellValueFactory(new PropertyValueFactory<>("codigo"));
		colFornecedor1Comp.setCellValueFactory(new PropertyValueFactory<>("fornecedor1"));
		colFornecedor2Comp.setCellValueFactory(new PropertyValueFactory<>("fornecedor2"));
		colQuantidadeComp.setCellValueFactory(new PropertyValueFactory<>("quantidadeAtual"));
		colPontoPedidoComp.setCellValueFactory(new PropertyValueFactory<>("pontoDePedido"));
		colMaquinaIdComp.setCellValueFactory(new PropertyValueFactory<>("maquinas"));

		Constraints.setTextFieldInteger(txtAlteraPontoDePedido);
		Constraints.setTextFieldInteger(txtAlteraQuantidadeAtual);
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldInteger(txtInserirPontoDePedido);
		Constraints.setTextFieldInteger(txtInserirQuantidadeAtual);
		Constraints.setTextFieldInteger(txtInserirCodigoGrupo);
		Constraints.setTextFieldInteger(txtInserirCodigoSubGrupo);
		Constraints.setTextFieldInteger(txtInserirCodigoSubSub);
		Constraints.setTextFieldInteger(txtAlteraCodigoGrupo);
		Constraints.setTextFieldInteger(txtAlteraCodigoSubGrupo);
		Constraints.setTextFieldInteger(txtAlteraCodigoSubSub);

		Constraints.setTextFieldMaxLength(txtAlteraCodigoGrupo, 3);
		Constraints.setTextFieldMaxLength(txtAlteraCodigoSubGrupo, 3);
		Constraints.setTextFieldMaxLength(txtAlteraCodigoSubSub, 4);
		Constraints.setTextFieldMaxLength(txtAlteraFornecedor1, 20);
		Constraints.setTextFieldMaxLength(txtAlteraFornecedor2, 20);
		Constraints.setTextFieldMaxLength(txtAlteraNome, 40);
		Constraints.setTextFieldMaxLength(txtAlteraPontoDePedido, 4);
		Constraints.setTextFieldMaxLength(txtAlteraQuantidadeAtual, 4);
		Constraints.setTextFieldMaxLength(txtId, 4);
		Constraints.setTextFieldMaxLength(txtInserirCodigoGrupo, 3);
		Constraints.setTextFieldMaxLength(txtInserirCodigoSubGrupo, 3);
		Constraints.setTextFieldMaxLength(txtInserirCodigoSubSub, 4);
		Constraints.setTextFieldMaxLength(txtInserirFornecedor1, 20);
		Constraints.setTextFieldMaxLength(txtInserirFornecedor2, 20);
		Constraints.setTextFieldMaxLength(txtInserirNome, 40);
		Constraints.setTextFieldMaxLength(txtInserirPontoDePedido, 4);
		Constraints.setTextFieldMaxLength(txtInserirQuantidadeAtual, 4);

		colNomeComp.setPrefWidth(300);

		rbInicia.setSelected(true);
	}
}
