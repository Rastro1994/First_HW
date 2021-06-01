import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATest extends TestBase{
    Faker faker = new Faker();
    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            number = faker.phoneNumber().subscriberNumber(10),
            day = "28",
            month = "May",
            year = "1994",
            subject = "Maths",
            hobbie = "Reading",
            picture = "autist-472x312_c.jpg",
            address = faker.address().fullAddress();


    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText(gender)).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--028").click();
        $("#subjectsInput").setValue(subject);
        $("#react-select-2-option-0").click();
        $(byText(hobbie)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));
        $("#currentAddress").setValue(address);
        $("#currentAddress").scrollTo();
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        $(".modal-content").shouldHave(
                text(firstName),
                text(lastName),
                text(email),
                text(number),
                text(address),
                text(month),
                text(year),
                text(day),
                text(subject),
                text(hobbie),
                text(picture),
                text(address));

    }
}