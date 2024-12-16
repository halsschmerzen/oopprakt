package guiBodenbelaege;

import business.TeppichhandelModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class BodenbelaegeView {

	private BodenbelaegeControl bodenbelaegeControl;
	private TeppichhandelModel teppicheModel;
	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeTeppiche = new Label("Anzeige Teppiche");
	private TextArea txtAnzeigeTeppiche = new TextArea();
	private Button btnAnzeigeTeppiche = new Button("Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public BodenbelaegeView(BodenbelaegeControl bodenbelaegeControl, Stage primaryStage, TeppichhandelModel teppicheModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Bodenbelägen");
		primaryStage.show();
		this.bodenbelaegeControl = bodenbelaegeControl;
		this.teppicheModel = teppicheModel;
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeTeppiche.setLayoutX(310);
		lblAnzeigeTeppiche.setLayoutY(40);
		lblAnzeigeTeppiche.setFont(font);
		lblAnzeigeTeppiche.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeTeppiche);
		// Textbereich	
		txtAnzeigeTeppiche.setEditable(false);
		txtAnzeigeTeppiche.setLayoutX(310);
		txtAnzeigeTeppiche.setLayoutY(90);
		txtAnzeigeTeppiche.setPrefWidth(220);
		txtAnzeigeTeppiche.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeTeppiche);
		// Button
		btnAnzeigeTeppiche.setLayoutX(310);
		btnAnzeigeTeppiche.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeTeppiche);
	}

	private void initListener() {
		btnAnzeigeTeppiche.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeTeppicheAn();
			}
		});
	}
	
	
	public void zeigeTeppicheAn() {
		
		if (teppicheModel.getTh() != null) {
			txtAnzeigeTeppiche.clear();
			for(int i = 0; i < teppicheModel.getTeppiche().size(); i++) {
			
				
				System.out.println(" DIESER TEPPICH YO " + teppicheModel.getTeppiche().get(i).gibTeppichZurueck(' '));
				
				txtAnzeigeTeppiche.appendText(teppicheModel.getTeppiche().get(i).gibTeppichZurueck(' ')); 
				
			}
			
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Teppich aufgenommen!");
		}
	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

}
