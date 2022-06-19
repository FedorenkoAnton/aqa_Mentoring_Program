package selenide_tests.builder_pattern;

public abstract class VariableBuilder {
    protected Variables variables;

    public void createVariables() {
        variables = new Variables();
    }

    abstract void buildPathToFile();

    abstract void buildLanguageTabLocator();

    abstract void buildCodeExampleLocator();

    public Variables getVariables() {
        return this.variables;
    }
}
