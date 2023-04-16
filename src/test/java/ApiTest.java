import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class ApiTest {

    private final String apiKey = "1bccd100-cc6c-41de-ab64-c2c7ba1f7664.L9vAAjgKVbnP474nXtnZjA3OXnhDudH0";
    private final String apiUrl = "https://api.integration.eurora.com/customs-calculator/v1/shopping-cart";
    private ArrayList<Object> bodyJson;

    @Test
    public void testCalculateDutyAndTaxes() {
        RestAssured.baseURI = apiUrl;
        bodyJson = new ArrayList<Object>();

        JSONObject body = new JSONObject();
        body.put("externalId" , "123e4567-e89b-12d3-a456-426655440000");
        body.put("orderCurrency", "EUR");
        body.put("transportationPrice", 5000.55);
        body.put("insurancePrice", 100);
        body.put("otherAdditionalCosts", 15.55);
        body.put("originCountry", "CN");
        body.put("destinationCountry", "CA");
        body.put("destinationRegion", "CA-MB");
        body.put("additionalValueShare", "MANUAL");

        body.put("date", "2023-04-13");
        body.put("useDeMinimis", true);
        body.put("hsCodeReplaceAllowed", true);
        body.put("declarationType", "H7");
        body.put("transactionModel", "B2B");
        body.put("transactionCategory", "COMMERCIAL");

        JSONObject goods = new JSONObject();
        goods.put("externalId", "123e4567-e89b-12d3-a456-426655440000");
        goods.put("gtin", "00012345600012");
        goods.put("title", "Fidget spinners");
        goods.put("description", "Fidget spinners");
        goods.put("hsCode", "0101000000");
        goods.put("weight", 0.15);
        goods.put("quantity", 250);
        goods.put("additionalValueShareRatio", 1);

        JSONObject price = new JSONObject();
        price.put("currency", "EUR");
        price.put("value", 11.25);
        goods.put("price", price);

        ArrayList<Object> goodsJsonObj = new ArrayList<Object>();
        goodsJsonObj.add(goods);
        body.put("goods", goodsJsonObj);

        bodyJson.add(body);

        Response response = given().header("X-Auth-Token", apiKey)
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .when()
                .post()
                .then()
                .statusCode(200).extract().response();
    }

    @Test
    public void testNoExternalID() {
        RestAssured.baseURI = apiUrl;
        bodyJson = new ArrayList<Object>();

        JSONObject body = new JSONObject();
        body.put("externalId" , "");
        body.put("orderCurrency", "EUR");
        body.put("transportationPrice", 5000.55);
        body.put("insurancePrice", 100);
        body.put("otherAdditionalCosts", 15.55);
        body.put("originCountry", "CN");
        body.put("destinationCountry", "CA");
        body.put("destinationRegion", "CA-MB");
        body.put("additionalValueShare", "MANUAL");

        body.put("date", "2023-04-13");
        body.put("useDeMinimis", true);
        body.put("hsCodeReplaceAllowed", true);
        body.put("declarationType", "H7");
        body.put("transactionModel", "B2B");
        body.put("transactionCategory", "COMMERCIAL");

        JSONObject goods = new JSONObject();
        goods.put("externalId", "123e4567-e89b-12d3-a456-426655440000");
        goods.put("gtin", "00012345600012");
        goods.put("title", "Fidget spinners");
        goods.put("description", "Fidget spinners");
        goods.put("hsCode", "0101000000");
        goods.put("weight", 0.15);
        goods.put("quantity", 250);
        goods.put("additionalValueShareRatio", 1);

        JSONObject price = new JSONObject();
        price.put("currency", "EUR");
        price.put("value", 11.25);
        goods.put("price", price);

        ArrayList<Object> goodsJsonObj = new ArrayList<Object>();
        goodsJsonObj.add(goods);
        body.put("goods", goodsJsonObj);

        bodyJson.add(body);

        Response response = given().header("X-Auth-Token", apiKey)
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .when()
                .post()
                .then()
                .statusCode(400).extract().response();
    }

    @Test
    public void testInvalidToken() {
        RestAssured.baseURI = apiUrl;
        bodyJson = new ArrayList<Object>();

        JSONObject body = new JSONObject();
        body.put("externalId" , "123e4567-e89b-12d3-a456-426655440000");
        body.put("orderCurrency", "EUR");
        body.put("transportationPrice", 5000.55);
        body.put("insurancePrice", 100);
        body.put("otherAdditionalCosts", 15.55);
        body.put("originCountry", "CN");
        body.put("destinationCountry", "CA");
        body.put("destinationRegion", "CA-MB");
        body.put("additionalValueShare", "MANUAL");

        body.put("date", "2023-04-13");
        body.put("useDeMinimis", true);
        body.put("hsCodeReplaceAllowed", true);
        body.put("declarationType", "H7");
        body.put("transactionModel", "B2B");
        body.put("transactionCategory", "COMMERCIAL");

        JSONObject goods = new JSONObject();
        goods.put("externalId", "123e4567-e89b-12d3-a456-426655440000");
        goods.put("gtin", "00012345600012");
        goods.put("title", "Fidget spinners");
        goods.put("description", "Fidget spinners");
        goods.put("hsCode", "0101000000");
        goods.put("weight", 0.15);
        goods.put("quantity", 250);
        goods.put("additionalValueShareRatio", 1);

        JSONObject price = new JSONObject();
        price.put("currency", "EUR");
        price.put("value", 11.25);
        goods.put("price", price);

        ArrayList<Object> goodsJsonObj = new ArrayList<Object>();
        goodsJsonObj.add(goods);
        body.put("goods", goodsJsonObj);

        bodyJson.add(body);

        Response response = given().header("-Token", apiKey)
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .when()
                .post()
                .then()
                .statusCode(401).extract().response();
    }

    @Test
    public void testInvalidUrl() {
        RestAssured.baseURI = apiUrl + "1";
        bodyJson = new ArrayList<Object>();

        JSONObject body = new JSONObject();
        body.put("externalId" , "123e4567-e89b-12d3-a456-426655440000");
        body.put("orderCurrency", "EUR");
        body.put("transportationPrice", 5000.55);
        body.put("insurancePrice", 100);
        body.put("otherAdditionalCosts", 15.55);
        body.put("originCountry", "CN");
        body.put("destinationCountry", "CA");
        body.put("destinationRegion", "CA-MB");
        body.put("additionalValueShare", "MANUAL");

        body.put("date", "2023-04-13");
        body.put("useDeMinimis", true);
        body.put("hsCodeReplaceAllowed", true);
        body.put("declarationType", "H7");
        body.put("transactionModel", "B2B");
        body.put("transactionCategory", "COMMERCIAL");

        JSONObject goods = new JSONObject();
        goods.put("externalId", "123e4567-e89b-12d3-a456-426655440000");
        goods.put("gtin", "00012345600012");
        goods.put("title", "Fidget spinners");
        goods.put("description", "Fidget spinners");
        goods.put("hsCode", "0101000000");
        goods.put("weight", 0.15);
        goods.put("quantity", 250);
        goods.put("additionalValueShareRatio", 1);

        JSONObject price = new JSONObject();
        price.put("currency", "EUR");
        price.put("value", 11.25);
        goods.put("price", price);

        ArrayList<Object> goodsJsonObj = new ArrayList<Object>();
        goodsJsonObj.add(goods);
        body.put("goods", goodsJsonObj);

        bodyJson.add(body);

        Response response = given().header("X-Auth-Token", apiKey)
                .contentType(ContentType.JSON)
                .body(bodyJson)
                .when()
                .post()
                .then()
                .statusCode(404).extract().response();
    }
}