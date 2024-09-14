package StepDefinitions;

import Constants.BookingEndPoints;
import Entities.Booking;
import Entities.BookingDates;
import Utils.Request;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static  org.hamcrest.Matchers.not;

public class BookingSteps {


    Response response;
    Booking booking;


    @And("Perform a GET call to employees end point with id {string}")
    public void getBooking(String id)
    {
        response  = Request.getById(BookingEndPoints.GET_BOOKING, id);
    }


    @Then("Verify status code {int}")
    public void verifyStatusCode(int code)
    {
        response.then().assertThat().statusCode(code);
    }

    @And("Verify that body is not empty")
    public void verifyBodyNotEmpty()
    {
        response.then().assertThat().body("size()", not(0));
    }

    @Then("Verify error message {string}")
    public void checkErrorMessage(String message)
    {
        Assertions.assertEquals(message, response.then().extract().asString());
    }

    @And("Create a new booking with the Info")
    public void createNewBooking(DataTable bookingInfo)
    {
        List<String> data = bookingInfo.transpose().asList(String.class);
        this.booking = new Booking();
        booking.setFirstname(data.get(0));
        booking.setLastname(data.get(1));
        booking.setTotalprice( Integer.parseInt(data.get(2)));
        booking.setDepositpaid(Boolean.parseBoolean(data.get(3)));
        booking.setBookingdates(new BookingDates(data.get(4), data.get(5)));
        booking.setAdditionalneeds(data.get(6));
    }


    private String getBookingPayloadJsonString(Booking booking) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(booking);
        return payload;
    }

    @And("Make a POST request with the booking body")
    public void postNewBooking() throws JsonProcessingException {
        String payload = getBookingPayloadJsonString(this.booking);
        response = Request.post(BookingEndPoints.POST_BOOKING, payload);
    }

    @And("Make a POST request with the empty body")
    public void postNewBookingNoBody()
    {
        response = Request.post(BookingEndPoints.POST_BOOKING, "");
    }

    @And("Booking id is not {int}")
    public void verifyBookingId(int id)
    {
        response.then().assertThat().body("bookingid", Matchers.not(id));
    }

    @And("Verify name equals {string}")
    public void verifyBookingName(String name)
    {
        response.then().assertThat().body("booking.firstname", Matchers.equalTo(name));
    }

    @And("Verify last name equals {string}")
    public void verifyBookingLastName(String lastname)
    {
        response.then().assertThat().body("booking.lastname", Matchers.equalTo(lastname));
    }

    @And("Verify total price equals {string}")
    public void verifyBookingTotalPrice(String price)
    {
        response.then().assertThat().body("booking.totalprice", Matchers.equalTo(Integer.parseInt(price)));
    }


    @And("Verify additionals equals {string}")
    public void verifyBookingAdditionals(String additional)
    {
        response.then().assertThat().body("booking.additionalneeds", Matchers.equalTo(additional));
    }


}
