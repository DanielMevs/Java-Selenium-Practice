package selenium;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import org.junit.Test;
import org.openqa.selenium.By;

public class SeleniumTest {
    @Test
    public void automationTest() {
        open("https://explorecalifornia.org/contact.htm");

        $("#name").should(appear);
        $("#comments").should(appear);

        $("#name").setValue("Daniel Mevs");
        $("#state").selectOptionContainingText("Florida");
        $("#backpack").click();
        $(By.name("newsletter")).selectRadio("yes");
        $("#name").shouldHave(value("Daniel Mevs"));
        String state = $("#state").getSelectedText();
        assert(state).equals("Florida");
        $("#backpack").shouldBe(selected);
        $(By.name("newsletter")).shouldHave(value("yes"));
    }
}
