# aws-serverless-poc
Api gateway - Lambda (with Java) - DynamoDB


Find the AWS SDK link for eclipse on AWS website, and then download the plugin via eclipse marketplace. https://aws.amazon.com/eclipse/

Create new Lambda project and write the code.

Create a dynamo db table ‘Student’.

See how the Student.java maps to dynamodb table ‘Student’.

Run mvn package to generate the jar file.

On AWS console, make a lambda function and upload the jar as lambda’s code.

Create a role with access to dynamo db, and assign the role to lambda.

Run the lambda test, providing json input matching the Request mapping object as given in the lambda handler class.

You may invoke this lambda via Api gateway, mapping the parameters/post body to the Request object’s mapping.

Increase the lambda duration time in case lambda is taking more than default 15 sec to query dynamodb.


Video explaining the POC:

https://www.youtube.com/watch?v=TbCNVApI4lA