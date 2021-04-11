
package uni.Controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import uni.Backend.Dao.Implementation.JsonVehicleDaoImpl;
import uni.Backend.pojo.Vehicle;
import uni.Data.models.ListTableModel;
import uni.ViewPanels.IntFrmVehicle;


public class IntFrmVehicleController {
    private IntFrmVehicle intFrmVehicle;
    private JsonVehicleDaoImpl jsonVehicleDaoImpl;
    private ListTableModel tblViewVehicleModel;
    private List<Vehicle> vehicles;
    private final String[] HEADERS = new String[]{"StockNumber","Year","Make","Model",
    "Style","Vin","Exterior color","Interior color","Miles","price","Transmission",
    "Engine","Image","Status"};
    private TableRowSorter<ListTableModel> tblRowSorter;
    
    public IntFrmVehicleController(IntFrmVehicle intFrmVehicle) {
        this.intFrmVehicle = intFrmVehicle;
        initComponent();
    }
    
    private void initComponent(){
        try {
            jsonVehicleDaoImpl = new JsonVehicleDaoImpl();
            loadTable();  
            
            intFrmVehicle.getTxtFind().addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e){
                    TxtFindKeyTyped(e);
                }
            });
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IntFrmVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IntFrmVehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void TxtFindKeyTyped(KeyEvent e){
        RowFilter<ListTableModel, Object> rf = null;        
        rf = RowFilter.regexFilter(intFrmVehicle.getTxtFind().getText(), 0,1,2,3,4,5,6,7,8,9);
        tblRowSorter.setRowFilter(rf);
    }
    
    private void loadTable() throws IOException{
        vehicles = jsonVehicleDaoImpl.getAll().stream().collect(Collectors.toList());
        tblViewVehicleModel = new ListTableModel(vehicles, HEADERS);
        tblRowSorter = new TableRowSorter<>(tblViewVehicleModel);
        
        intFrmVehicle.getTblViewVehicle().setModel(tblViewVehicleModel);
        intFrmVehicle.getTblViewVehicle().setRowSorter(tblRowSorter);
    }
    

}
