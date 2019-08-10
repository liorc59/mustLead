package controllers;

import bl.GraphBl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.Request;
import spark.Response;

import java.io.IOException;

public class RequestHandler {
    public static ObjectMapper mapper = new ObjectMapper();

    public static String getMustLeadsController(Request req, Response res){
        try {
            JsonNode requestJson = mapper.readTree(req.body());
            return GraphBl.getMustLeads(requestJson.path("graph").asText(), requestJson.path("entry").asText(), requestJson.path("node").asText()).toString();
        } catch (IOException e) {
            res.status(500);
            return "can't parse request to json";
        }
    }
}
