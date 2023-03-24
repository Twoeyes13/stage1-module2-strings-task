package com.epam.mjc;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
//        throw new UnsupportedOperationException("You should implement this method.");

        StringBuilder sourceArgument = new StringBuilder(signatureString);
        StringBuilder leftPartOfMethod = new StringBuilder(sourceArgument.substring(0, sourceArgument.indexOf("(")));
        StringBuilder rightPartOfMethod = new StringBuilder(sourceArgument.substring(sourceArgument.indexOf("(") + 1, sourceArgument.indexOf(")")));
        StringTokenizer leftPartStatement = new StringTokenizer(leftPartOfMethod.toString(), " ");

        StringTokenizer argumets = new StringTokenizer(rightPartOfMethod.toString(), ", ");
        List<MethodSignature.Argument> listOfArguments = new ArrayList<>();
        while (argumets.hasMoreTokens()){
            listOfArguments.add(new MethodSignature.Argument(argumets.nextToken(), argumets.nextToken()));
        }
        MethodSignature result = new MethodSignature("", listOfArguments);

        if(leftPartStatement.countTokens() > 2) {
            result.setAccessModifier(leftPartStatement.nextToken());
        }
        result.setReturnType(leftPartStatement.nextToken());
        result.setMethodName(leftPartStatement.nextToken());

        System.out.print(rightPartOfMethod.toString());
        return result;
    }
}
