package S19.JUNIT.S19_Ejericicio01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import S19.JUNIT.S19_Ejercicio01.views.MainView;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	private static Stream<Arguments> getFormatFixture(){
		return Stream.of(
				Arguments.of(9, 10, "17.0"),
				Arguments.of(16, 17, "3.0"),
				Arguments.of(13, 14, "11.0"));
	}
	
	@ParameterizedTest
	@MethodSource("getFormatFixture")
	public void testSuma(int a, int b, String c) {
		MainView view = new MainView();
		view.btns[a].doClick();
		view.btns[19].doClick();
		view.btns[b].doClick();
		view.btns[23].doClick();
		String resultado = view.num1;
		assertEquals(c, resultado);
	}
	
	
}
