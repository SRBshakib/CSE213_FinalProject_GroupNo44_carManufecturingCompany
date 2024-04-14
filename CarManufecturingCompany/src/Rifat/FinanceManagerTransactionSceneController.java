/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Rifat;

import Dip.AppendableObjectOutputStream;
import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FinanceManagerTransactionSceneController implements Initializable {

    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField amountTextField;
    @FXML
    private TableView<Transaction> transactionTableView;
    @FXML
    private TableColumn<Transaction, LocalDate> dateColumnTable;
    @FXML
    private TableColumn<Transaction, Double> amountColumnTable;

    private final ObservableList<Transaction> transactionList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateColumnTable.setCellValueFactory(new PropertyValueFactory<>("date"));
        amountColumnTable.setCellValueFactory(new PropertyValueFactory<>("amount"));
        transactionTableView.setItems(transactionList);
    }

    private void backButtonOnMouseClick(ActionEvent event) throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Rifat/FinanceManagerDashboardScene.fxml"));
        Scene scene1 = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
    }

    @FXML
private void loadButtonOnMouseClick(ActionEvent event) {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TransactionInfo.bin"))) {
        transactionList.clear();
        while (true) {
            try {
                Transaction transaction = (Transaction) ois.readObject();
                transactionList.add(transaction);
            } catch (EOFException e) {
                break; // End of file reached
            }
        }
    } catch (IOException | ClassNotFoundException ex) {
        Logger.getLogger(FinanceManagerTransactionSceneController.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    @FXML
    private void saveButtonOnMouseClick(ActionEvent event) {
        LocalDate date = datePicker.getValue();
        double amount = Double.parseDouble(amountTextField.getText());
        Transaction transaction = new Transaction(date, amount);
        transactionList.add(transaction);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TransactionInfo.bin", true))) {
            oos.writeObject(transaction);
        } catch (IOException ex) {
            Logger.getLogger(FinanceManagerTransactionSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }

        clearFields();
    }

    private void clearFields() {
        datePicker.setValue(null);
        amountTextField.clear();
    }
}


