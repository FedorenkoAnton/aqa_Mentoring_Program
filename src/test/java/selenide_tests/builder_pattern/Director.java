package selenide_tests.builder_pattern;

public class Director {
    VariableBuilder builder;

    public void setBuilder(VariableBuilder builder) {
        this.builder = builder;
    }

    public Variables buildVariablesObj() {
        builder.createVariables();
        builder.buildPathToFile();
        builder.buildLanguageTabLocator();
        builder.buildCodeExampleLocator();

        Variables variables = builder.getVariables();

        return variables;
    }
}
