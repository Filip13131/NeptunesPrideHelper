package org.filip13131.neptunesPrideHelper;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import org.filip13131.neptunesPrideHelper.apiCommunicator.IronhelmetCommunicator;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        IronhelmetCommunicator communicator = new IronhelmetCommunicator();
        communicator.postLogin("","");
        HttpResponse<JsonNode> playerInfo = communicator.initPlayer();
        String firstGameNumber = playerInfo
                .getBody()
                .getArray()
                .getJSONObject(1)
                .getJSONArray("open_games")
                .getJSONObject(0)
                .getString("number");

        HttpResponse<JsonNode> report = communicator.postOrder(firstGameNumber,"full_universe_report");
        System.out.println(report.getBody().toString());
        System.out.println(report.getStatus());
        System.out.println(report.getCookies());
    }}