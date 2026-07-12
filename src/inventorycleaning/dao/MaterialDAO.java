package inventorycleaning.dao;
import inventorycleaning.model.Material;
import java.util.List;

public class MaterialDAO {
    public List<Material> getAll() {
        // TODO: implement SELECT * FROM materials
        return null;
    }

    public Material getById(int id) {
        // TODO: implement SELECT * FROM materials WHERE id = ?
        return null;
    }

    public boolean insert(Material m) {
        // TODO: implement INSERT INTO materials (...)
        return false;
    }

    public boolean update(Material m) {
        // TODO: implement UPDATE materials SET ... WHERE id = ?
        return false;
    }

    public boolean delete(int id) {
        // TODO: implement DELETE FROM materials WHERE id = ?
        return false;
    }

    public List<Material> search(String keyword) {
        // TODO: implement SELECT * FROM materials WHERE name LIKE ?
        return null;
    }

    public List<Material> getLowStock() {
        // TODO: implement SELECT * FROM materials WHERE quantity <= reorder_level
        return null;
    }
}
