import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageObject {

    public static void openPage(String url) {
        open(url);
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
    }

    public static void setFirstName(String firstName) {
        $("#firstName").val(firstName);
    }

    public static void setLastName(String lastName) {
        $("#lastName").val(lastName);
    }

    public static void setEmail(String email) {
        $("#userEmail").val(email);
    }

    public static void setGender(String gender) {
        $(byText(gender)).click();
    }

    public static void setPhoneNumber(String mobile) {
        $("#userNumber").val(mobile);
    }

    public static void setBirthDate(String year, String month, String day) {
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
    }

    public static void setSubjects(String subjects) {
        $("#subjectsInput").val(subjects).pressEnter();
    }

    public static void setHobbies(String hobbies) {
        $("#hobbiesWrapper").$(byText(hobbies)).click();
    }

    public static void uploadFile(String picture) {
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));
    }

    public static void setAddress(String address) {
        $("#currentAddress").val(address);
    }

    public static void chooseState(String state) {
        $("#state").click();
        $(byText(state)).click();
    }

    public static void chooseCity(String city) {
        $("#city").click();
        $(byText(city)).click();
    }

    public static void clickSubmit() {
        $("#submit").click();
    }

    public static void checkData(String firstName, String lastName, String email, String gender, String mobile, String subjects, String hobbies, String picture, String address, String state, String city) {
        $(".modal-content").shouldHave
                (text(firstName),
                        text(lastName),
                        text(email),
                        text(gender),
                        text(mobile),
                        text(subjects),
                        text(hobbies),
                        text(picture),
                        text(address),
                        text(city),
                        text(state));
    }
}