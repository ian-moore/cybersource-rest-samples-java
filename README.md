# Java Sample Code for the CyberSource SDK

This repository contains working code samples which demonstrate Java integration with the CyberSource REST APIs through the [CyberSource Java SDK](https://github.com/CyberSource/cybersource-rest-client-java).

The samples are organized into categories and common usage examples.

## Using the Sample Code

The samples are all completely independent and self-contained. You can analyze them to get an understanding of how a particular method works, or you can use the snippets as a starting point for your own project.

### Clone (or download) this repository:
```
    $ git clone https://github.com/CyberSource/cybersource-rest-samples-java
```
### Running the Samples using IntelliJ IDE
* Open the project/folder (rather than import or new).

* Build the project:
	* From the Build menu, select Rebuild Project.

* Run any sample:
	* For example, select ProcessPayment class from the class Explorer
	* Right-click and select Run ProcessPayment.Main()
	
### Running the Samples using Eclipse IDE
* Import the project:
	* From File menu,select Import.
	* Expand Maven menu. 
	* And click Existing Maven Projects
	* Click next and browse the location where you have the Maven project source code. 
	* Click next, Eclipse will recognize the Maven project and it will show you a list of all possible Maven projects located there. 
	* Just select the project and click next. 
	* Eclipse will show you a Maven Build message. Just click finish. 
	* The Maven project is successfully imported into Eclipse IDE.

* Run the project: 
	* Right-click the project folder.
	* Select Run as Maven Build.
	* In the Goals field, enter "clean install"
	* Select the JRE tab and make sure it is pointing at a JRE associated with a JDK.
	* Click Run.
	

## Setting Your API Credentials

To set your API credentials for an API request,Configure the following information in src/main/java/data/Configuration.java file:
  
  * Http Signature

```java
   authenticationType  = http_Signature
   merchantID 	       = your_merchant_id
   merchantKeyId       = your_key_serial_number
   merchantsecretKey   = your_key_shared_secret
```
  * Jwt

```java
   authenticationType  = Jwt
   merchantID 	       = your_merchant_id
   keyAlias	       = your_merchant_id
   keyPassword	       = your_merchant_id
   keyFileName         = your_merchant_id
   keysDirectory       = resources
```

## Switching between the sandbox environment and the production environment
CyberSource maintains a complete sandbox environment for testing and development purposes. This sandbox environment is an exact
duplicate of our production environment with the transaction authorization and settlement process simulated. By default, this SDK is 
configured to communicate with the sandbox environment. To switch to the production environment, set the appropriate environment 
constant in resources/cybersource.properties file.  For example:

```java
// For TESTING use
  runEnvironment      = CyberSource.Environment.SANDBOX
// For PRODUCTION use
// runEnvironment      = CyberSource.Environment.PRODUCTION
```


The [API Reference Guide](https://developer.cybersource.com/api/reference/api-reference.html) provides examples of what information is needed for a particular request and how that information would be formatted. Using those examples, you can easily determine what methods would be necessary to include that information in a request
using this SDK.

  
