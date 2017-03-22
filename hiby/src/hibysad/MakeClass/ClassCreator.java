/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibysad.MakeClass;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import hibysad.PrintOrHearValue.PrintHearValue;
import hibysad.classPack.CreateClass;
import hibysad.jineo.StringReader;

/**
 *
 * @author ajay
 */
public class ClassCreator {
	
    private static final String s = "D:/New folder/";
    String s1;
    PrintHearValue print;

    public ClassCreator(String s1) {
        this.s1 = s1;
        print = new PrintHearValue();
    }

    public void createClass() {
        CreateClass createClass = new CreateClass();
        if (createClass.createClassPackageName()) {
            if (createClass.createClassName()) {
                File file = new File(s + "/" + createClass.getClassName() + ".java");
                Path out = Paths.get(s + "/" + createClass.getClassName() + ".java");
                if (createClass.createInstanceVariables()) {
                    if (createClass.createConstructors()) {
                        if (createClass.createMethods()) {
                            if (createClass.endClass()) {
                                print.print("Class is created and ready to deploy. Shall we engage.");
                                createFile(file, out, createClass);
                            }
                        }
                    }
                }
            }
        }
    }

    public void createFile(File file, Path out, CreateClass createClass) {
        boolean b = new StringReader().readBoolean();
        try {
            if (b) {
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException ex) {
                        Logger.getLogger(ClassCreator.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                Files.write(out, createClass.getListStringFile(), Charset.defaultCharset());
            } else {
                print.print("Shall we engage.");
                createFile(file, out, createClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
