
package uni.Backend.Dao;

import java.io.IOException;
import java.util.Collection;
import uni.Backend.pojo.Vehicle;


public interface VehicleDao extends Dao<Vehicle>{
    Vehicle findById(int id) throws IOException;
    Collection<Vehicle> findByStatus(String status) throws IOException;
}
