import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomeWorkTest {
            @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.pageLoadStrategy = "eager";
            Configuration.holdBrowserOpen = true;
            Configuration.baseUrl = "https://demoqa.com";
        }

        @Test
        void fillFormTest() {
            open("/automation-practice-form");
            $("#firstName").setValue("Igor");
            $("#lastName").setValue("Vodin");
            $("#userEmail").setValue("Vodin@ya.ry");
            //gender
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("9999999999");
            // birth
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").$(byText("August")).click();
            $(".react-datepicker__year-select").$(byText("1993")).click();
            $(".react-datepicker__day--002:not(.react-datepicker__day--outside-month)").click();

            // subjects
            $("#subjectsInput").setValue("Math").pressEnter();
            // hobbies
            $("#hobbiesWrapper").$(byText("Sports")).click();
            $("#hobbiesWrapper").$(byText("Reading")).click();
            //picture
            $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));

            $("#currentAddress").setValue("Some");
            // select state
            $("#state").click();
            $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
            //select city
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Agra")).click();
            $("#submit").click();

            //проверка
            $(".modal-dialog").should(appear);
            $(".table-responsive").shouldHave(text("Igor"), text("9999999999"), text("Male"));
            $(".table-responsive").shouldHave(text("Math"));


        }
}
