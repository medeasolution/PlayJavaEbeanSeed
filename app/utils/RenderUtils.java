package utils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import exceptions.AppException;
import play.libs.F;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Results;

/**
 * Created by xavi on 22/03/14.
 */
public class RenderUtils {

    public static String renderError(AppException e) {
        return renderError(e.getApiError(), e.getMessage());
    }

    public static String renderError(String apiError, String apiMessage) {
        ObjectNode result = Json.newObject();
        result.put("success", false);
        result.put("error", apiError);
        result.put("message", apiMessage);
        return result.toString();
    }

    public static F.Promise<Result> renderPromisedError(String errorCode, String apiMessage) {
        return F.Promise.<Result>pure(Results.ok(RenderUtils.renderError(errorCode, apiMessage)));
    }

    public static F.Promise<Result> renderPromisedError(AppException e) {
        return F.Promise.<Result>pure(Results.ok(RenderUtils.renderError(e.getApiError(), e.getMessage())));
    }

    public static String renderOk(String apiMessage) {
        ObjectNode result = Json.newObject();
        result.put("success", true);
        result.put("data", apiMessage);
        return result.toString();
    }
}
