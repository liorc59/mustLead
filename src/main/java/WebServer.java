import controllers.RequestHandler;
import spark.Spark;

public class WebServer{


    public static void main(String [] args){
        Spark.port(8080);


        Spark.post("/getMustLeads",RequestHandler::getMustLeadsController);
    }
}