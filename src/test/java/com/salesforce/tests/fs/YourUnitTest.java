package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest {
    @Test
    public void make10Dirs() throws IOException {
        String[] testInput = {
                "dir",
                "mkdir   sub1",
                "mkdir   sub2",
                "mkdir   sub3",
                "mkdir   sub4",
                "mkdir   sub5",
                "mkdir   sub6",
                "mkdir   sub7",
                "mkdir   sub8",
                "mkdir   sub9",
                "mkdir   sub10",
                "dir"
        };

        String[] expectedOutput = {
                "Command: dir     \n",
                "Directory of root:\n",
                "No subdirectories\n",
                "Command: mkdir   sub1    \n",
                "Command: mkdir   sub2    \n",
                "Command: mkdir   sub3    \n",
                "Command: mkdir   sub4    \n",
                "Command: mkdir   sub5    \n",
                "Command: mkdir   sub6    \n",
                "Command: mkdir   sub7    \n",
                "Command: mkdir   sub8    \n",
                "Command: mkdir   sub9    \n",
                "Command: mkdir   sub10   \n",

                "Command: dir     \n",
                "Directory of root:\n",
                "sub1    sub10   sub2    sub3    sub4    sub5    sub6    sub7    sub8    sub9    \n",
        };

        runTest(testInput, expectedOutput, true);
    }

    @Test
    public void make11Dirs() throws IOException {
        String[] testInput = {
                "dir",
                "mkdir   sub1",
                "mkdir   sub2",
                "mkdir   sub3",
                "mkdir   sub4",
                "mkdir   sub5",
                "mkdir   sub6",
                "mkdir   sub7",
                "mkdir   sub8",
                "mkdir   sub9",
                "mkdir   sub10",
                "mkdir   sub11",
                "dir"
        };

        String[] expectedOutput = {
                "Command: dir     \n",
                "Directory of root:\n",
                "No subdirectories\n",
                "Command: mkdir   sub1    \n",
                "Command: mkdir   sub2    \n",
                "Command: mkdir   sub3    \n",
                "Command: mkdir   sub4    \n",
                "Command: mkdir   sub5    \n",
                "Command: mkdir   sub6    \n",
                "Command: mkdir   sub7    \n",
                "Command: mkdir   sub8    \n",
                "Command: mkdir   sub9    \n",
                "Command: mkdir   sub10   \n",
                "Command: mkdir   sub11   \n",

                "Command: dir     \n",
                "Directory of root:\n",
                "sub1    sub10   sub11   sub2    sub3    sub4    sub5    sub6    sub7    sub8    \n",
                "sub9    \n"
        };

        runTest(testInput, expectedOutput, true);
    }
}
