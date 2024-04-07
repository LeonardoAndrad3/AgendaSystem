package ivana.charis.agenda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AgendaApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	@DisplayName("Teste aleatorio")
	void contextLoads() {

		var date = LocalDate.now();

		System.out.println(date.getDayOfWeek());

		assertThat(date.getDayOfWeek()).isBetween(DayOfWeek.MONDAY, DayOfWeek.SATURDAY);
	}

}
