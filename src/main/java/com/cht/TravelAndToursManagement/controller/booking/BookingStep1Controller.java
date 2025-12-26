package com.cht.TravelAndToursManagement.controller.booking;

import com.cht.TravelAndToursManagement.model.Client;
import com.cht.TravelAndToursManagement.navigation.NavigationService;
import com.cht.TravelAndToursManagement.repository.ClientRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookingStep1Controller implements Initializable {

    @FXML
    public TextField searchField;

    @FXML
    private ListView<Client> clientListView;

    @FXML
    private VBox searchContainer;

    @FXML
    private Button closeButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button nextButton;

    @FXML
    private VBox existingClientCard;

    @FXML
    private VBox newCustomerCard;

    private String selectedClientType = null;
    private Client selectedClient = null;
    private final NavigationService navigationService;
    private final ClientRepository clientRepository;

    public BookingStep1Controller(NavigationService navigationService, ClientRepository clientRepository) {
        this.navigationService = navigationService;
        this.clientRepository = clientRepository;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (searchContainer != null) {
            searchContainer.setVisible(false);
            searchContainer.setManaged(false);
        }
        if (clientListView != null) {
            clientListView.setVisible(false);
            clientListView.setManaged(false);
            clientListView.setOnMouseClicked(event -> selectClientFromList());
            clientListView.setPlaceholder(new Label("No customer found"));
            clientListView.setCellFactory(listView -> new ListCell<>() {
                private final Label avatar = new Label("●");
                private final Label name = new Label();
                private final Label email = new Label();
                private final Label phone = new Label();
                private final VBox textBox = new VBox(name, email, phone);
                private final HBox wrapper = new HBox(avatar, textBox);
                {
                    wrapper.setSpacing(12);
                    wrapper.setStyle("-fx-padding: 12; -fx-background-radius: 8;");
                    avatar.setStyle("-fx-background-color: #00b26b; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 8 10; -fx-background-radius: 50%;");
                    name.setStyle("-fx-font-weight: bold; -fx-text-fill: #1b4332;");
                    email.setStyle("-fx-text-fill: #4f5d75;");
                    phone.setStyle("-fx-text-fill: #4f5d75;");
                    textBox.setSpacing(4);
                }

                @Override
                protected void updateItem(Client item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setGraphic(null);
                        setStyle("");
                    } else {
                        avatar.setText(item.getName() != null && !item.getName().isEmpty() ? item.getName().substring(0, 1).toUpperCase() : "●");
                        name.setText(item.getName());
                        email.setText(item.getEmail());
                        phone.setText(item.getContactNumber());
                        setGraphic(wrapper);
                        boolean selected = getIndex() == getListView().getSelectionModel().getSelectedIndex();
                        setStyle(selected ? "-fx-background-color: #e9f7ef; -fx-border-color: #00b26b; -fx-border-radius: 8;" : "");
                    }
                }
            });
        }

        searchField.setVisible(false);
        searchField.setManaged(false);
        searchField.textProperty().addListener((obs, oldText, newText) -> getClientName());

        setupCardHoverEffects();
        setupCardClickedHandlers();

        // Start with no selection; user must click a card to reveal search
        updateNextButtonState();
    }

    private void setupCardClickedHandlers() {
        existingClientCard.setOnMouseClicked(this::selectExistingCustomer);
        newCustomerCard.setOnMouseClicked(this::selectNewCustomer);
    }

    private void setupCardHoverEffects() {
        // Existing Customer Card Hover
        existingClientCard.setOnMouseEntered(event -> {
            if (selectedClientType == null || !selectedClientType.equals("existing")) {
                existingClientCard.setStyle(
                        "-fx-border-color: #0066CC; " +
                                "-fx-border-radius: 8; " +
                                "-fx-border-width: 2; " +
                                "-fx-padding: 24; " +
                                "-fx-background-color: #F0F7FF; " +
                                "-fx-background-radius:  8; " +
                                "-fx-cursor: hand; " +
                                "-fx-effect: dropshadow(gaussian, rgba(0, 102, 204, 0.2), 8, 0, 0, 4);"
                );
            }
        });

        existingClientCard.setOnMouseExited(event -> {
            if (selectedClientType == null || !selectedClientType.equals("existing")) {
                existingClientCard.setStyle(
                        "-fx-border-color: #E0E0E0; " +
                                "-fx-border-radius: 8; " +
                                "-fx-border-width: 1; " +
                                "-fx-padding: 24; " +
                                "-fx-background-color:  white; " +
                                "-fx-background-radius: 8; " +
                                "-fx-cursor: hand;"
                );
            }
        });

        // New Customer Card Hover
        newCustomerCard.setOnMouseEntered(event -> {
            if (selectedClientType == null || !selectedClientType.equals("new")) {
                newCustomerCard.setStyle(
                        "-fx-border-color:  #0066CC; " +
                                "-fx-border-radius: 8; " +
                                "-fx-border-width:  2; " +
                                "-fx-padding: 24; " +
                                "-fx-background-color: #F0F7FF; " +
                                "-fx-background-radius: 8; " +
                                "-fx-cursor: hand; " +
                                "-fx-effect:  dropshadow(gaussian, rgba(0, 102, 204, 0.2), 8, 0, 0, 4);"
                );
            }
        });

        newCustomerCard.setOnMouseExited(event -> {
            if (selectedClientType == null || ! selectedClientType.equals("new")) {
                newCustomerCard.setStyle(
                        "-fx-border-color: #E0E0E0; " +
                                "-fx-border-radius: 8; " +
                                "-fx-border-width: 1; " +
                                "-fx-padding: 24; " +
                                "-fx-background-color: white; " +
                                "-fx-background-radius: 8; " +
                                "-fx-cursor:  hand;"
                );
            }
        });
    }

    @FXML
    private void selectExistingCustomer(MouseEvent event) {
        selectedClientType = "existing";
        selectedClient = null;
        updateCardSelection();
    }

    @FXML
    private void selectNewCustomer(MouseEvent event) {
        selectedClientType = "new";
        selectedClient = null;
        updateCardSelection();
    }

    private void updateCardSelection() {
        if ("existing".equals(selectedClientType)) {
            if (searchContainer != null) {
                searchContainer.setVisible(true);
                searchContainer.setManaged(true);
            }
            searchField.setVisible(true);
            searchField.setManaged(true);
            searchField.requestFocus();

            if (clientListView != null) {
                clientListView.setVisible(true);
                clientListView.setManaged(true);
            }

            existingClientCard.setStyle(
                    "-fx-border-color: #009a61; -fx-border-radius: 8; -fx-border-width:  2; " +
                            "-fx-padding: 24; -fx-background-color: #e9f7ef; -fx-background-radius: 8; -fx-cursor: hand;"
            );
            newCustomerCard.setStyle(
                    "-fx-border-color: #E0E0E0; -fx-border-radius:  8; -fx-border-width: 1; " +
                            "-fx-padding: 24; -fx-background-color: white; -fx-background-radius: 8; -fx-cursor: hand;"
            );

            getClientName();
        } else if ("new".equals(selectedClientType)) {
            searchField.clear();
            searchField.setVisible(false);
            searchField.setManaged(false);
            if (searchContainer != null) {
                searchContainer.setVisible(false);
                searchContainer.setManaged(false);
            }
            if (clientListView != null) {
                clientListView.getItems().clear();
                clientListView.setVisible(false);
                clientListView.setManaged(false);
            }

            newCustomerCard.setStyle(
                    "-fx-border-color: #009a61; -fx-border-radius: 8; -fx-border-width: 2; " +
                            "-fx-padding: 24; -fx-background-color:  #e9f7ef; -fx-background-radius: 8; -fx-cursor: hand;"
            );
            existingClientCard.setStyle(
                    "-fx-border-color: #E0E0E0; -fx-border-radius: 8; -fx-border-width:  1; " +
                            "-fx-padding: 24; -fx-background-color: white; -fx-background-radius:  8; -fx-cursor:  hand;"
            );
        }
        updateNextButtonState();
    }

    private void getClientName() {
        if (!"existing".equals(selectedClientType)) {
            return;
        }

        String keyword = searchField.getText() == null ? "" : searchField.getText().trim();
        if (keyword.isEmpty()) {
            if (clientListView != null) {
                clientListView.getItems().clear();
            }
            selectedClient = null;
            updateNextButtonState();
            return;
        }

        List<Client> clients = clientRepository.findByNameOrEmail(keyword);
        ObservableList<Client> clientItems = FXCollections.observableArrayList(clients);
        if (clientListView != null) {
            clientListView.setItems(clientItems);
        }

        selectedClient = clients.size() == 1 ? clients.get(0) : null;
        updateNextButtonState();
    }

    private void selectClientFromList() {
        if (clientListView == null || clientListView.getSelectionModel().getSelectedIndex() < 0) {
            selectedClient = null;
            updateNextButtonState();
            return;
        }

        selectedClient = clientListView.getSelectionModel().getSelectedItem();
        updateNextButtonState();
    }

    private void updateNextButtonState() {
        boolean enable = selectedClientType != null && (!"existing".equals(selectedClientType) || selectedClient != null);
        nextButton.setDisable(!enable);
        nextButton.setStyle(enable
                ? "-fx-padding: 10 16; -fx-font-family: 'Inter'; -fx-font-size: 14; -fx-font-weight:  500; -fx-text-fill: white; -fx-background-color: #009a61; -fx-border-radius: 6; -fx-cursor: hand;"
                : "-fx-padding: 10 16; -fx-font-family: 'Inter'; -fx-font-size:  14; -fx-font-weight: 500; -fx-text-fill: #999999; -fx-background-color: #CCCCCC; -fx-border-radius: 6; -fx-cursor: default;"
        );
    }

    @FXML
    private void handleClose() {
        closeStage();
    }

    @FXML
    private void handleCancel() {
        closeStage();
    }

    @FXML
    private void handleNextStep() {
        if (selectedClientType == null) return;
        if ("existing".equals(selectedClientType) && selectedClient == null) return;
        System.out.println("Proceeding with: " + selectedClientType + " customer" + (selectedClient != null ? " -> " + selectedClient.getName() : ""));
//         navigationService.navigateTo(Route. BOOKING_STEP2);
        closeStage();
    }

    private void closeStage() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public String getSelectedClientType() {
        return selectedClientType;
    }

    public Client getSelectedClient() {
        return selectedClient;
    }
}
