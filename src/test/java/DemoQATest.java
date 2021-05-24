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
            month = "May",
            year = "1994",
            day = "28",
            subject = "Hindi",
            hobbie1 = "Sports",
            hobbie2 = "Reading",
            picture = "autist-472x312_c.jpg",
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
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--028").click();
        $("#subjectsInput").setValue(subject);
        $("#react-select-2-option-0").click();
        $(byText(hobbie1)).click();
        $(byText(hobbie2)).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/upload/" + picture));
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
                text(hobbie1),
                text(hobbie2),
                text(picture),
                text(address));

    }
}
