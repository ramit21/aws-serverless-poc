package com.amazonaws.lambda.demo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Request, Object> {

    @Override
    public Object handleRequest(Request request, Context context) {
        context.getLogger().log("Env/Request: " + System.getenv("env") + "," + request);
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(client);
        Student student = null;
        switch(request.getHttpMethod()){
	        case "GET": 
	        	student = mapper.load(Student.class, request.getId());
	        	if(student == null){
	        		throw new RuntimeException("Resource not found : "+ request.getId());
	        	}
	        	return student;
	        case "POST":
	        	student = request.getStudent();
	        	mapper.save(student);
	        	return student;
	        default:
	        	//Throw exception if unsupported method called
	        	break;
	        	
        }
        return null;
    }

}
