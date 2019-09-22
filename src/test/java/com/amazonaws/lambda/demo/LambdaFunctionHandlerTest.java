package com.amazonaws.lambda.demo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.amazonaws.services.lambda.runtime.Context;

/**
 * A simple test harness for locally invoking your Lambda function handler.
 */
public class LambdaFunctionHandlerTest {

    private static Request input;

    @BeforeClass
    public static void createInput() throws IOException {
        // TODO: set up your sample input object here.
        input = new Request();
        input.setId(1);
        input.setHttpMethod("GET");
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        // TODO: customize your context here if needed.
        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testLambdaFunctionHandler() {
        LambdaFunctionHandler handler = new LambdaFunctionHandler();
        Context ctx = createContext();
        boolean isDynamoDbException = false;
        try{
        	Object output = handler.handleRequest(input, ctx);
        }catch(Exception ex){
        	isDynamoDbException = true;
        }
        
        // TODO: validate output here if needed.
        Assert.assertEquals(isDynamoDbException, true);
    }
}
