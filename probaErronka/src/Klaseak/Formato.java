package Klaseak;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class Formato extends Formatter {
	@Override

	public String format(LogRecord record) {

	// TODO Auto-generated method stub

	return "<Mezua>" + record.getMessage() + "</Mezua>\n" + "<Maila>" + record.getLevel() + "</Maila>\n"

	+ "<Klasea>" + record.getSourceClassName() + "</Klasea>";

	}
}
