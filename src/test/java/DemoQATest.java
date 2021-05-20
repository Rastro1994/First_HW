import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQATest {
    String firstName = "Ivan",
            lastName = "Ivanov",
            email = "43fsad423eds@mail.ru",
            number = "6464614684",
            address = "45648das";

    @Test
    void fillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").setValue(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--028").click();
        $("#subjectsInput").setValue("Hindi");
        $("#react-select-2-option-0").click();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/upload/" + "autist-472x312_c.jpg"));
        $("#currentAddress").setValue(address);
        $("#currentAddress").scrollTo();
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").click();
        $(".modal-content").shouldHave(text(firstName), text(lastName), text(email), text(number), text(address));

    }
}
