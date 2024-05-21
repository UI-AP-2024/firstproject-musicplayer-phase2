package org.example.musicap.GUIs;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.example.musicap.Controllers.ListenerController;
import org.example.musicap.Controllers.NormalListenerController;
import org.example.musicap.Controllers.PremiumListenerController;
import org.example.musicap.Models.Data.Database;
import org.example.musicap.Models.Genre;
import org.example.musicap.Models.PremiumPlan;
import org.example.musicap.Models.User.Listener;
import org.example.musicap.Models.User.NormalListener;

public class PremiumViewController implements ShowAlert {

    @FXML
    private Label plan1Name;
    @FXML
    private Label plan2Name;
    @FXML
    private Label plan3Name;
    @FXML
    private Label plan1Text;
    @FXML
    private Label plan2Text;
    @FXML
    private Label plan3Text;
    private Database database;
    private Listener listenerModel;
    private ListenerController listenerController;
    public void initialize()
    {
        LayoutViewController.pagesStack.add("premium-view.fxml");
        database = Database.getInstance();
        listenerModel = (Listener) database.getLogedInUser();
        if(listenerModel instanceof NormalListener) listenerController = new NormalListenerController();
        else listenerController = new PremiumListenerController();
        plan1Name.setText(PremiumPlan.values()[0].name());
        plan2Name.setText(PremiumPlan.values()[1].name());
        plan3Name.setText(PremiumPlan.values()[2].name());
        plan1Text.setText(String.valueOf(PremiumPlan.values()[0].getPrice()) + "$/" + String.valueOf(PremiumPlan.values()[0].getDays()));
        plan2Text.setText(String.valueOf(PremiumPlan.values()[1].getPrice()) + "$/" + String.valueOf(PremiumPlan.values()[1].getDays()));
        plan3Text.setText(String.valueOf(PremiumPlan.values()[2].getPrice()) + "$/" + String.valueOf(PremiumPlan.values()[2].getDays()));
    }
    @FXML
    private void getPlan1(MouseEvent event) {
        try {
            showAlert(listenerController.purchasePremium(PremiumPlan.values()[0]), "Premium access", "Purchase");
            listenerModel = (Listener) database.getLogedInUser();
            if (listenerModel instanceof NormalListener) listenerController = new NormalListenerController();
            else listenerController = new PremiumListenerController();
        }
        catch (Exception e)
        {
            showAlert(e.getMessage(), "Premium access", "Purchase");
        }
    }

    @FXML
    private void getPlan2(MouseEvent event) {
        try {
            showAlert(listenerController.purchasePremium(PremiumPlan.values()[1]), "Premium access", "Purchase");
            listenerModel = (Listener) database.getLogedInUser();
            if (listenerModel instanceof NormalListener) listenerController = new NormalListenerController();
            else listenerController = new PremiumListenerController();
        }
        catch (Exception e)
        {
            showAlert(e.getMessage(), "Premium access", "Purchase");
        }
    }

    @FXML
    private void getPlan3(MouseEvent event) {
        try {
            showAlert(listenerController.purchasePremium(PremiumPlan.values()[2]), "Premium access", "Purchase");
            listenerModel = (Listener) database.getLogedInUser();
            if (listenerModel instanceof NormalListener) listenerController = new NormalListenerController();
            else listenerController = new PremiumListenerController();
        }
        catch (Exception e)
        {
            showAlert(e.getMessage(), "Premium access", "Purchase");
        }
    }
}
