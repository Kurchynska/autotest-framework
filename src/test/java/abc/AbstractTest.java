package abc;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@Data
@NoArgsConstructor
public abstract class AbstractTest {

    protected WebDriver driver;
}
