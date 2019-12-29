package CucumberStepDefinition;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class StepDefs {
    private String city;
    private Response response;

    @Given("city is: (.*)")
    public void set_city(String city) {
        this.city = city;

    }
    @When("we are requesting weather")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
         response = requester.requestWeather(city);
    }

    @Then("lon is (.*)")
    public void check_lon(Double lon){
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon!");

    }

    @Then("lat is (.*)")
    public void check_lat(Double lat){
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat");

    }
    @And("id is (.*)")
    public void check_id(long id){
        Assertions.assertEquals(id, response.getWeather().get(0).getId(), "Wrong id");
    }
    @And("main is (.*)")
    public void check_main(String main){
        Assertions.assertEquals(main, response.getWeather().get(0).getMain(), "Not Drizzle");
    }
    @And("description is (.*)")
    public void check_descriptions(String descriptions){
        Assertions.assertEquals(descriptions, response.getWeather().get(0).getDescription(), "Incorrect description");
    }
    @And("icon is (.*)")
    public void check_icon(String icon){
        Assertions.assertEquals(icon, response.getWeather().get(0).getIcon(), "Nope");
    }


    @And("temp is (.*)")
    public void check_temp(Double temp){
        Assertions.assertEquals(temp, response.getMains().getTemp(), "Incorrect");
    }
    @And("temp_min is (.*)")
    public void check_temp_min(Double tempMin){
        Assertions.assertEquals(tempMin, response.getMains().getTempMin(), "Incorrect minimum temp");
    }
    @And("temp_max is (.*)")
    public void check_temp_max(Double tempMax){
        Assertions.assertEquals(tempMax, response.getMains().getTempMax(), "Temp max");
    }
    @And("pressure is (.*)")
    public void check_pressure(Long pressure){
        Assertions.assertEquals(pressure, response.getMains().getPressure(), "Wrong pressure");
    }
    @And("humidity is (.*)")
    public void check_humidity(int humidity){
        Assertions.assertEquals(humidity, response.getMains().getHumidity(), "Wrong humidity");
    }
    @And("visibility is (.*)")
    public void check_visibility(int visibility){
        Assertions.assertEquals(visibility, response.getVisibility().getVisibility(), "mhm");
    }
    @And("speed is (.*)")
    public void check_speed(Double speed){
        Assertions.assertEquals(speed, response.getWind().getSpeed(), "Wrong wind speed for today");
    }
    @And("deg is (.*)")
    public void check_deg(Double deg){
        Assertions.assertEquals(deg, response.getWind().getDeg(), "Wrong deg for today");
    }
    @And("all is (.*)")
    public void check_all(int all){
        Assertions.assertEquals(all, response.getClouds().getAll(), "Not so many clouds");
    }
    @And("dt is (.*)")
    public void check_dt(short dt){
        Assertions.assertEquals(dt, response.getDt().getDt(), "Wrong dt");
    }
    @And("type is (.*)")
    public void check_type(int type){
        Assertions.assertEquals(type, response.getSys().getType(), "Wrong type");
    }
    @And("id is (.*)")
    public void check_id_in_sys(long id){
        Assertions.assertEquals(id, response.getSys().getId(), "Opps");
    }
    @And("message is (.*)")
    public void check_message(Double message){
        Assertions.assertEquals(message, response.getSys().getMessage(), "Is it the correct message?");
    }
    @And("country is (.*)")
    public void check_country(String country){
        Assertions.assertEquals(country, response.getSys().getCountry(), "Some GB");
    }
    @And("sunrise is (.*)")
    public void check_sunrise(short sunrise){
        Assertions.assertEquals(sunrise, response.getSys().getSunrise(), "sunrise");
    }
    @And("sunset is (.*)")
    public void check_sunset(short sunset){
        Assertions.assertEquals(sunset, response.getSys().getSunset(), "sunset");
    }
    @And("id is (.*)")
    public void check_id_dt(short id){
        Assertions.assertEquals(id, response.getDt().getId(), "Some id");
    }
    @And("name is (.*)")
    public void check_name(String name){
        Assertions.assertEquals(name, response.getDt().getName(), "wrong name");
    }

    @And("cod is (.*)")
    public void check_cod(int cod){
        Assertions.assertEquals(cod, response.getDt().getCod(), "is this correct?");
    }

}

/*
-send request
-receive response
-map response

 */


/*
1)(.*) = эквивалент любой строки, показывает что может быть любое выражение
2)HashMap <String, String> or <String, Long>  = таблица из двух колонок, for example | key | value |
3).split ("...");
4)ctr + alt + l
5)ctr+shift+alt+insert = make a scratch file (vremennij)
*/


//list -- > get(0).getId();