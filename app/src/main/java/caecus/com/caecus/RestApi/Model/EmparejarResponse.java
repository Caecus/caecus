package caecus.com.caecus.RestApi.Model;

/**
 * Created by USUARIO on 30/08/2016.
 */
public class EmparejarResponse {
    boolean success;
    public EmparejarResponse(){

    }

    public EmparejarResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
