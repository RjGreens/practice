/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibysad.classPack;

import java.util.ArrayList;
import java.util.List;

import hibysad.PrintOrHearValue.PrintHearValue;
import hibysad.askForAccessModifier.AccessModifierClass;
import hibysad.askName.AskNameClass;
import hibysad.askName.AskNameInterface;
import hibysad.jineo.StringReader;
import hibysad.variablesCreation.VariableCreationClass;

/**
 *
 * @author ajay
 */
public class CreateClass implements classInterface {

    private String accessmodifier;
    private String className;
    private List<String> listStringFile;
    private AskNameInterface ask;
    private VariableCreationClass v;
    private PrintHearValue print;
    private int number = 1;

    public CreateClass() {
        listStringFile = new ArrayList<>();
        ask = new AskNameClass();
        v = new VariableCreationClass();
        print = new PrintHearValue();
    }

    @Override
    public boolean createClassPackageName() {
        listStringFile.add("package figured;");
        return true;
    }

    @Override
    public boolean createClassName() {
        AccessModifierClass accessModifierClass = new AccessModifierClass();
        accessmodifier = accessModifierClass.askForAccessModiFier();
        AskNameInterface askName = new AskNameClass();
        className = askName.AskName("Class");
        print.print(accessmodifier + " class " + className + " {");
        listStringFile.add(accessmodifier + " class " + className + " {");
        return true;
    }

    @Override
    public boolean createInstanceVariables() {
        int no = ask.AskNumber("Instance Variables");
        String s = v.createVariables(no);
        listStringFile.add(s);
        return true;
    }

    @Override
    public boolean createConstructors() {
        String var = ask.AskYesOrNo("Should we create a default constructor?");
        if (var != null && var.equalsIgnoreCase("Yes")) {
            listStringFile.add("public " + className + "() { }");
            print.print("public " + className + "() { }");
        }
        createAnotherConstructor();
        return true;
    }

    public boolean createAnotherConstructor() {
        String var2 = ask.AskYesOrNo("Should we create a another constructor?");
        if (var2.equalsIgnoreCase("Yes")) {
            AccessModifierClass accessModifierClass = new AccessModifierClass();
            accessmodifier = accessModifierClass.askForAccessModiFireconstrutor("Constructor");
            int no = ask.AskNumber("Constructor Variables");
            String s = v.createParamsRandom(no);
            listStringFile.add("public " + className + " (" + s + ")" + " { } ");
            print.print("public " + className + " (" + s + ")" + " { } ");
            createAnotherConstructor();
        } else {

        }
        return true;
    }

    @Override
    public boolean createMethods() {
        askForMethod();
        return true;
    }

    public List<String> getListStringFile() {
        return listStringFile;
    }

    public void setListStringFile(List<String> listStringFile) {
        this.listStringFile = listStringFile;
    }

    @Override
    public boolean endClass() {
        listStringFile.add("}");
        return true;
    }

    private void askForMethod() {
        print.print("Creating function " + number);
        String accessModifierMethod = new AccessModifierClass().askForAccessModiFireconstrutor("Function");
        AskNameInterface askname = new AskNameClass();
        String keyword = askname.AskKeywordString("Function");
        String name = askname.AskName("Function");
        listStringFile.add(accessModifierMethod + " " + keyword + " " + name + "(");
        int no = ask.AskNumber("Parameterized Variables");
        String s = v.createParamsRandom(no);
        listStringFile.add(s);
        listStringFile.add(")");
        listStringFile.add("{}");
        print.print("Do you want to make another method?");

        String ans = new StringReader().readString();
        if (ans.equalsIgnoreCase("yes")) {
            askForMethod();
        } else if (ans.equalsIgnoreCase("no")) {

        } else {
            print.print("Didn't get you?");
            askForMethod();
        }
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
