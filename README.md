# Exchange Rates API

This is a simple API that provides exchange rate information for a given currency code and date. The API is built using Spring Boot and retrieves data from an external data source.

## Usage

To use the API, send a GET request to one of the following endpoints:

- `/exchangerates/{currencyCode}/A/{date}` - Returns the average exchange rate for the given currency code on the specified date.
- `/exchangerates/A/{code}/{quotation}` - Returns the maximum and minimum exchange rate for the given currency code and quotation.
- `/exchangerates/C/{code}/{quotation}` - Returns the major exchange rate between buy and ask for the given currency code and quotation.

### Request Parameters

- `currencyCode` - The ISO currency code (e.g. USD, GBP, EUR).
- `date` - The date for which exchange rate data is requested (in the format yyyy-MM-dd).
- `code` - The ISO currency code (e.g. USD, GBP, EUR).
- `quotation` - The quotation to use for the exchange rate (1 for buy rate, 2 for sell rate).

### Example Request

GET exchangerates/GBP/A/2023-01-02 HTTP/1.1
Host: localhost:8080


### Example Response

200 OK
Content-Type: application/json

5.2768 



## Building and Running

To build and run the API, follow these steps:

### 1. Clone the repository:

```bash
git clone https://github.com/yourusername/exchange-rates-api.git

2. Navigate to the project directory:

cd exchange-rates-api

3. Build the project:

mvn clean package

4. Run the project:

mvn spring-boot:run

The API will be accessible at http://localhost:8080.


