package guiBodenbelaege;

import business.TeppichhandelModel;
import javafx.stage.Stage;
import ownUtil.Observer;

public class BodenbelaegeControl implements Observer {
	private BodenbelaegeView bodenbelaegeView;
	private TeppichhandelModel teppicheModel;

	public BodenbelaegeControl(Stage primaryStage){
 		this.teppicheModel = TeppichhandelModel.getInstance(); 		
		this.bodenbelaegeView 
		 	= new BodenbelaegeView(this, primaryStage,
			teppicheModel);
		this.teppicheModel.addObserver(this);
	}

	@Override
	public void update() {
		bodenbelaegeView.zeigeTeppicheAn();
	}
}
