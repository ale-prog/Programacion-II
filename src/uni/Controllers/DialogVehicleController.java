
package uni.Controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import uni.Backend.Dao.Implementation.JsonVehicleDaoImpl;
import uni.Backend.pojo.Vehicle;
import uni.Backend.pojo.VehicleSubModel;
import uni.ViewPanels.DialogVehicle;


public class DialogVehicleController {

    private DialogVehicle dialogVehicle;
    private Gson gson;
    private List<VehicleSubModel> vehicleSubModels;
    private DefaultComboBoxModel cmbModelMake;
    private DefaultComboBoxModel cmbModelModel;
    private DefaultComboBoxModel cmbModelYear;
    private DefaultComboBoxModel cmbModelEColor;
    private DefaultComboBoxModel cmbModelIColor;
    private DefaultComboBoxModel cmbModelStatus;
    private String status[] = new String[]{"Active","Not available","Mantainance"};
    private JFileChooser fileChooser;
    private JsonVehicleDaoImpl jvdao;
    
    
    public DialogVehicleController(DialogVehicle DialogVehicle) throws FileNotFoundException {
        this.dialogVehicle = dialogVehicle;
        initComponent();
    }

    private void initComponent() throws FileNotFoundException {
        gson = new Gson();
        jvdao = new JsonVehicleDaoImpl();
        JsonReader jreader = new JsonReader(new BufferedReader(
                new InputStreamReader(getClass().getResourceAsStream("/resources/vehicleData.json"))
        ));
        
        Type listType = new TypeToken<ArrayList<VehicleSubModel>>(){}.getType();
        vehicleSubModels = gson.fromJson(jreader, listType);
        
        List<String> makes = vehicleSubModels.stream()
                .map(v -> v.getMake())
                .collect(Collectors.toList());
        List<String> models = vehicleSubModels.stream()
                .map(v -> v.getModel()).collect(Collectors.toList());
        List<String> years = vehicleSubModels.stream()
                .map(v -> v.getYear()).collect(Collectors.toList());
        List<String> colors = vehicleSubModels.stream()
                .map(v -> v.getColor()).collect(Collectors.toList());
        
        cmbModelMake = new DefaultComboBoxModel<>(makes.toArray());
        cmbModelModel = new DefaultComboBoxModel(models.toArray());
        cmbModelYear = new DefaultComboBoxModel(years.toArray());
        cmbModelEColor = new DefaultComboBoxModel(colors.toArray());
        cmbModelIColor = new DefaultComboBoxModel(colors.toArray());
        cmbModelStatus = new DefaultComboBoxModel(status);
        
        dialogVehicle.getCmbMake().setModel(cmbModelMake);
        dialogVehicle.getCmbModel().setModel(cmbModelModel);
        dialogVehicle.getCmbYear().setModel(cmbModelYear);
        dialogVehicle.getCmbEcolor().setModel(cmbModelEColor);
        dialogVehicle.getCmbIcolor().setModel(cmbModelIColor);
        dialogVehicle.getCmbStatus().setModel(cmbModelStatus);
        
        dialogVehicle.getTxtStock().requestFocus();
        
        dialogVehicle.getBtnBrowse().addActionListener((e)->{
            btnBrowseActionListener(e);
        });
        
        dialogVehicle.getBtnSave().addActionListener((e)->{
            try {
                btnSaveActionListener(e);
            } catch (IOException ex) {
                Logger.getLogger(DialogVehicleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }

    private void btnSaveActionListener(ActionEvent e) throws IOException{
        int stock, year;
        String make, model, style, vin, eColor, iColor, miles, engine, image, status;
        float price;
        Vehicle.Transmission transmission = Vehicle.Transmission.AUTOMATIC;
        
        if(dialogVehicle.getTxtStock().getText().isEmpty()){
            return;
        }
        stock = Integer.parseInt(dialogVehicle.getTxtStock().getText());
        year = Integer.parseInt(dialogVehicle.getCmbYear().getSelectedItem().toString());
        make = dialogVehicle.getCmbMake().getSelectedItem().toString();
        model = dialogVehicle.getCmbModel().getSelectedItem().toString();
        style = dialogVehicle.getTxtStyle().getText();
        vin = dialogVehicle.getTxtVin().getText();
        eColor = dialogVehicle.getCmbEcolor().getSelectedItem().toString();
        iColor = dialogVehicle.getCmbIcolor().getSelectedItem().toString();
        miles = dialogVehicle.getSpnMiles().getModel().getValue().toString();
        price = Float.parseFloat(dialogVehicle.getSpnPrice().getModel().getValue().toString());
        engine = dialogVehicle.getTxtEngine().getText();
        image = dialogVehicle.getTxtImage().getText();
        status = dialogVehicle.getCmbStatus().getSelectedItem().toString();
        transmission = dialogVehicle.getRbAutomatic().isSelected() ?
                transmission : Vehicle.Transmission.MANUAL;
                
        Vehicle v = new Vehicle(stock, year, make, model, 
                style, vin, eColor, iColor, miles, price, transmission, engine, image, status);
        
        jvdao.create(v);
        JOptionPane.showMessageDialog(null, "Vehicle saved successfully.",
                "Information message", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void btnBrowseActionListener(ActionEvent e){
        fileChooser = new JFileChooser();
        
        int option = fileChooser.showOpenDialog(null);
        if(option == JFileChooser.CANCEL_OPTION){
            return;
        }
        
        File file = fileChooser.getSelectedFile();
        if(!file.exists()){
            JOptionPane.showMessageDialog(null, "Image does not exists", 
                    "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        dialogVehicle.getTxtImage().setText(file.getPath());        
    }
}
