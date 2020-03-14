package decision;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;
import org.kie.internal.io.ResourceFactory;

import java.io.*;

/**
 * 获取规则文件内容，并生成对应的规则
 * @author sec
 * @version 1.0
 * @date 2020/3/12 10:27 AM
 **/
public class TestDecision1 {

	@Test
	public void createDrl() throws IOException {

		File file = new File("/Users/zzs/develop/github/drools/drools-lesson4/src/main/resources/com/decision1" +
				"/decision.xls");
		InputStream is = new FileInputStream(file);
		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
		String drl = compiler.compile(is, InputType.XLS);
		System.out.println(drl);
		// 关闭资源
		is.close();
	}

	@Test
	public void checkDrl2() {
		SpreadsheetCompiler compiler = new SpreadsheetCompiler();
		String drl = compiler.compile(ResourceFactory.newClassPathResource("com/decision1/decision.xls"),
				InputType.XLS);
		System.out.println(drl);
	}
}
