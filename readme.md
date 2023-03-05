# Shopping Cart

### Setting up the project

- Open the pom.xml file as project in any of the IDEs
- run `mvn clean install` to install all the dependencies

### Testing the project
The project can be tested in two ways:
1. Run the JUnit tests associated with the project
2. Use the `input.json` file to provide custom inputs and run the `main` method

### Input format

Current project expects two object fields in input:
- `fruits`: a list of fruits, currently supports `[APPLE, ORANGE]`, more can be added in `enums\Fruits.java`
- `offers`: it expects a `map` object, signifying if there is any offer applicable on any of the `fruit`. Current
implementation supports two offer type: `[BUY_ONE_GET_ONE, THREE_FOR_PRICE_OF_TWO]`. Either of  these offers can be 
applied to any of the fruits

