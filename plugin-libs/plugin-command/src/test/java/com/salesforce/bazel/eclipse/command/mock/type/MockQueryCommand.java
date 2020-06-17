package com.salesforce.bazel.eclipse.command.mock.type;

import java.util.List;
import java.util.Map;

import com.salesforce.bazel.eclipse.command.mock.MockCommand;
import com.salesforce.bazel.eclipse.test.TestBazelWorkspaceFactory;

/**
 * Simulates an invocation of 'bazel query xyz'
 */
public class MockQueryCommand extends MockCommand {

    public MockQueryCommand(List<String> commandTokens, Map<String, String> testOptions, TestBazelWorkspaceFactory testWorkspaceFactory) {
        super(commandTokens);
        
        if (commandTokens.size() < 3) {
            // this is just 'bazel build' without a target, which is not valid, blow up here as there is something wrong in the calling code
            throw new IllegalArgumentException("The plugin issued the command 'bazel build' without a third arg. This is not a valid bazel command.");
        }
        
        // TODO create simulated query results in a more dynamic way using the test workspace structure
        if (commandTokens.get(2).contains("javalib0")) {
            addSimulatedOutputToCommandStdOut("java_test rule //projects/libs/javalib0:javalib0Test");
            addSimulatedOutputToCommandStdOut("java_library rule //projects/libs/javalib0:javalib0");
        } else if (commandTokens.get(2).contains("javalib1")) {
            addSimulatedOutputToCommandStdOut("java_test rule //projects/libs/javalib1:javalib1Test");
            addSimulatedOutputToCommandStdOut("java_library rule //projects/libs/javalib1:javalib1");
        }
    }
}