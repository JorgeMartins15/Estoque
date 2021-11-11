package application;

import java.io.IOException;

import gui.ListaPorMaquinaViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stage;

	private static Scene crudMaquinaScene;
	private static Scene crudComponentesScene;
	private static Scene crudComponentesEletronicaScene;
	private static Scene listaScene;
	private static Scene crudDepartamento;
	private static Scene requisicoes;

	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;

			FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/gui/crudMaquinaView.fxml"));
			ScrollPane view1 = loader1.load();

			view1.setFitToHeight(true);
			view1.setFitToWidth(true);
			view1.setPrefSize(1360, 750);

			crudMaquinaScene = new Scene(view1);

			loader1 = new FXMLLoader(getClass().getResource("/gui/crudComponentesView.fxml"));
			ScrollPane view2 = loader1.load();

			view2.setFitToHeight(true);
			view2.setFitToWidth(true);
			view2.setPrefSize(1360, 850);

			crudComponentesScene = new Scene(view2);

			loader1 = new FXMLLoader(getClass().getResource("/gui/ListaPorMaquinaView.fxml"));
			ScrollPane view3 = loader1.load();

			view3.setFitToHeight(true);
			view3.setFitToWidth(true);
			view3.setPrefSize(1360, 750);

			listaScene = new Scene(view3);

			loader1 = new FXMLLoader(getClass().getResource("/gui/crudComponentesEletronicaView.fxml"));
			ScrollPane view4 = loader1.load();

			view4.setFitToHeight(true);
			view4.setFitToWidth(true);
			view4.setPrefSize(1360, 750);

			crudComponentesEletronicaScene = new Scene(view4);

			loader1 = new FXMLLoader(getClass().getResource("/gui/crudDepartamentoView.fxml"));
			ScrollPane view5 = loader1.load();

			view5.setFitToHeight(true);
			view5.setFitToWidth(true);
			view5.setPrefSize(1360, 750);

			crudDepartamento = new Scene(view5);
			
			loader1 = new FXMLLoader(getClass().getResource("/gui/requisicoesView.fxml"));
			ScrollPane view6 = loader1.load();

			view6.setFitToHeight(true);
			view6.setFitToWidth(true);
			view6.setPrefSize(1360, 750);

			requisicoes = new Scene(view6);

			primaryStage.setScene(crudMaquinaScene);
			primaryStage.setTitle("Estoque Elétrica Golpack");
			primaryStage.resizableProperty().setValue(false);
			primaryStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void troca(String trc) {
		switch (trc) {
		case "/gui/crudMaquinaView.fxml":
			stage.setScene(crudMaquinaScene);
			break;

		case "/gui/crudComponentesView.fxml":
			stage.setScene(crudComponentesScene);
			break;

		case "/gui/ListaPorMaquinaView.fxml":
			stage.setScene(listaScene);
			break;

		case "/gui/crudComponentesEletronicaView.fxml":
			stage.setScene(crudComponentesEletronicaScene);
			break;

		case "/gui/crudDepartamentoView.fxml":
			stage.setScene(crudDepartamento);
			break;
			
		case "/gui/requisicoesView.fxml":
			stage.setScene(requisicoes);
			break;

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
