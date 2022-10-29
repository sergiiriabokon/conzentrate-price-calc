# Price Calculator

The code has been written in accordance with Java 7 syntax, i.e. it uses enums, but it doesn't leverage Stream API and Lambdas.

However my local environment is using *openJDK v 16.0.1* and *maven 3.8.6*

## Running the code

```
mvn package
```

and after:

```
java -jar target/conzentrate-price-calc-1.0-SNAPSHOT.jar 12 139.95 book --output-currency=SEK --vat=DK
```

or

```
java -jar target/conzentrate-price-calc-1.0-SNAPSHOT.jar 23 199.95 book
```

## Implementation details

The code distinguishes **Basic costs** and **Secondary costs**. Basic costs are accumulated by a formula

```
Total price = amount x price + freight
```

While **Secondary costs** are calculated by applying a factor to previously calculated basic costs. These are VAT and currency translations.