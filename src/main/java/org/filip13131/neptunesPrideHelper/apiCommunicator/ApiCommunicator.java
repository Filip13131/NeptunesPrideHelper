package org.filip13131.neptunesPrideHelper.apiCommunicator;


import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;

import java.util.ArrayList;

public interface ApiCommunicator {
    HttpResponse<JsonNode> fetchGameMessages(String game_number, String group, String count, String offset);
    HttpResponse<JsonNode> fetchIntelData(String game_number);
    HttpResponse<JsonNode> fetchPlayerAchievements(String game_number);
    HttpResponse<JsonNode> fetchUnreadCount(String game_number);
    HttpResponse<JsonNode> initPlayer();
    HttpResponse<JsonNode> openGames();
    HttpResponse<JsonNode> postBatchedOrders(String game_number, ArrayList<String> order);
    HttpResponse<JsonNode> postLogin(String alias, String password);
    HttpResponse<JsonNode> postLogout();
    HttpResponse<JsonNode> postOrder(String game_number, String order);
}
