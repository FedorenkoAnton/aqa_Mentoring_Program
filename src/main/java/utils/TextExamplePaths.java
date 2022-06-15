package utils;

public class TextExamplePaths {
    private static String csharpPath = "src/main/resources/examples/csharp_example_code.txt";
    private static String javaPath = "src/main/resources/examples/java_example_code.txt";
    private static String javaScriptPath = "src/main/resources/examples/javascript_example_code.txt";
    private static String kotlinPath = "src/main/resources/examples/kotlin_example_code.txt";
    private static String pythonPath = "src/main/resources/examples/python_example_code.txt";
    private static String rubyPath = "src/main/resources/examples/ruby_example_code.txt";

    public static String getFilePath(TextExamples examples) {
        String pathToReturn = "";
        switch (examples) {
            case CSHARP_EXAMPLE -> pathToReturn = csharpPath;
            case JAVA_EXAMPLE -> pathToReturn = javaPath;
            case JAVA_SCRIPT_EXAMPLE -> pathToReturn = javaScriptPath;
            case KOTLIN_EXAMPLE -> pathToReturn = kotlinPath;
            case PYTHON_EXAMPLE -> pathToReturn = pythonPath;
            case RUBY_EXAMPLE -> pathToReturn = rubyPath;
        }
        return pathToReturn;
    }

}
