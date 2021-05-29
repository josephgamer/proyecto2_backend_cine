package cr.ac.una.db.dao.crud;

public abstract class AbstractCRUD {

    public abstract String getListAllCmd();

    public abstract String getAddCmd();

    public abstract String getRetrieveCmd();

    public abstract String getUpdateCmd();

    public abstract String getDeleteCmd();

    ///Nuevo
    public String getLast() {
        return GET_CMD;
    }

    public String getLastHorario() {
        return GET_CMDH;
    }
    
    protected static final String ADD_CMDP = "INSERT INTO eif209_2021_01.area_tematica " 
            + "(descripcion_area) " + "VALUES (?); ";
        
    protected static final String GET_CMD = "select max(id_area) as id_area from area_tematica;";
    
    
    protected static final String GET_CMDH = "select max(seq) as seq from horario;";
}
