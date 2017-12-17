package com.secbro.drools.chapter44;

import com.secbro.drools.BaseTest;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author zzs
 */
public class DecisionTest extends BaseTest{

    @Test
    public void checkDrl() throws FileNotFoundException {
        File file = new File("E:\\GitHub\\respo\\drools-lesson\\src\\main\\resources\\decision.xls");
        InputStream is = new FileInputStream(file);
        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl = compiler.compile(is, InputType.XLS);
        System.out.println(drl);
    }
}
