package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import exceptions.AppException;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.RenderUtils;

import java.net.URI;
import java.net.URISyntaxException;

public class BaseController extends Controller {

	protected static String renderError(AppException e) {
        return RenderUtils.renderError(e);
	}

    public static String renderOk(String message) throws JsonProcessingException {
        return RenderUtils.renderOk(message);
    }

    public static String getHost(){
        try {
            URI uri = new URI(request().getHeader("Origin"));
            return uri.getHost();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Result returnOk(JsonNode json){
        ObjectNode result = Json.newObject();
        result.put("success", true);
        result.set("data", json);
        return ok(result);
    }

}
