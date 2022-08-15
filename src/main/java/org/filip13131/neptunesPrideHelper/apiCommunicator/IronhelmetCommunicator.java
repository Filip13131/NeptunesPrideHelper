package org.filip13131.neptunesPrideHelper.apiCommunicator;


import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class IronhelmetCommunicator implements ApiCommunicator {
    private final String host = "https://np.ironhelmet.com";


    @Override
    public HttpResponse<JsonNode> fetchGameMessages(String game_number, String group, String count, String offset) {
        Map<String, Object> params = new HashMap<>();
        params.put("game_number", game_number);
        params.put("group", group); // game_event or game_diplomacy
        params.put("count", count);
        params.put("offset", offset);
        params.put("type", "fetch_game_messages");
        return Unirest.post(host + "/fetch_game_messages" )
                .queryString(params)
                .asJson();
    }
    @Override
    public HttpResponse<JsonNode> fetchIntelData(String game_number) {
        Map<String, Object> params = new HashMap<>();
        params.put("game_number", game_number);
        params.put("type", "intel_data");
        return Unirest.post(host + "/trequest/intel_data" )
                .queryString(params)
                .asJson();
    }
    @Override
    public HttpResponse<JsonNode> fetchPlayerAchievements(String game_number) {
        Map<String, Object> params = new HashMap<>();
        params.put("game_number", game_number);
        params.put("type", "fetch_player_achievements");
        return Unirest.post(host + "/trequest/fetch_player_achievements" )
                .queryString(params)
                .asJson();
    }
    @Override
    public HttpResponse<JsonNode> fetchUnreadCount(String game_number) {
        Map<String, Object> params = new HashMap<>();
        params.put("game_number", game_number);
        params.put("type", "fetch_unread_count");
        return Unirest.post(host + "/trequest/fetch_unread_count" )
                .queryString(params)
                .asJson();
    }
    @Override
    public HttpResponse<JsonNode> initPlayer() {
        Map<String, Object> params = new HashMap<>();
        params.put("type", "init_player");
        return Unirest.post(host + "/mrequest/init_player" )
                .queryString(params)
                .asJson();
    }
    @Override
    public HttpResponse<JsonNode> openGames() {
        Map<String, Object> params = new HashMap<>();
        params.put("type", "open_games");
        return Unirest.post(host + "/mrequest/open_games" )
                .queryString(params)
                .asJson();
    }
    @Override
    public HttpResponse<JsonNode> postBatchedOrders(String game_number, ArrayList<String> order) {
        Map<String, Object> params = new HashMap<>();
        params.put("game_number", game_number);
        params.put("order", String.join("/", order));
        params.put("type", "order");
        return Unirest.post(host + "/trequest/batched_orders" )
                .queryString(params)
                .asJson();
    }
    @Override
    public HttpResponse<JsonNode> postLogin(String alias, String password) {
        Map<String, Object> params = new HashMap<>();
        params.put("alias", alias);
        params.put("password", password);
        params.put("type", "login");
        return Unirest.post(host + "/arequest/login" )
                .queryString(params)
                .asJson();
    }
    @Override
    public HttpResponse<JsonNode> postLogout(){
        return Unirest.post(host + "/logout" )
                .asJson();
    }
    @Override
    public HttpResponse<JsonNode> postOrder(String game_number, String order) {
        Map<String, Object> params = new HashMap<>();
        params.put("game_number", game_number);
        params.put("order", order);
        params.put("type", "order");
        return Unirest.post(host + "/trequest/order" )
                .queryString(params)
                .asJson();
    }
}
