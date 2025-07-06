#### Requirements:  Install Java 21, Git 2.46.0, Maven 3.9, and Docker 28.3.0 (These are what I already have installed).

Download files from Github -- git clone https://github.com/antonvalderrama/Enterbridge.git

#### 1.  Springboot application files are in ./src/main/java.  The application has the following endpoints:
    1.  GET /products  --  retrieves all the products from the db.

        Sample response:
       
            {
                "productKey": 3665295,
                "retailer": "XYZ Retail",
                "brand": "GIANT ART",
                "model": "WAG122733A2",
                "productName": "54-in H x 54-in W Abstract Print on Canvas",
                "productDescription": "Giant artworks creates stunning focal points.",
                "price": null
            },
            {
                "productKey": 12952636,
                "retailer": "XYZ Retail",
                "brand": "Maocao Hoom",
                "model": "BH60071",
                "productName": "63.5-in x 41-in x 98-in Steel Log Rack",
                "productDescription": "ur versatile 2-in-1 garden shed is designed to bring organization to your outdoor space.",
                "price": 382.77
            }
        
    2.  GET /products/{productKey}  --  retrieves the product with the given product key

        Sample response:

            {
                "productKey": 12952635,
                "retailer": "XYZ Retail",
                "brand": "Bosch",
                "model": "WTZSB30UC",
                "productName": "Dryer Wall Mounting Bracket (Silver)",
                "productDescription": "1: Bracket Style | 2: Stainless Steel | 3: Hardware Included",
                "price": null
            }
    3. POST /products  --  adds a new product.

       Sample request (do not include productKey, this field will be auto generated:

            {
              "retailer": "Richmond United",
              "brand": "Adidas",
              "model": "AD12345",
              "productName": "Soccer Ball",
              "productDescription": "Size 4 soccer ball",
              "price": 12.23
            }

    4. GET /products/brand-summary  --  returns a list of of brands and the number of items the brands have

       Sample response:

            [
              {
              "brand": "ThruLOK  by FastenMaster",
              "count": 2
              },
              {
                  "brand": "Adidas",
                  "count": 1
              },
              {
                  "brand": "Savoy House",
                  "count": 1
              },
              {
                  "brand": "Midea",
                  "count": 1
              }
            ]
 
    5. GET /products/{brand}/count  --  returns a specific brand and the number of items it has

       Sample response:
  
           {
              "brand": "Midea",
              "count": 1
           }
   
#### 2.  Database create/insert script and Dockerfile is in ./Postgres
#### 3.  React files are in ./React

### App execution Via Docker Images
1.  In the root directory, run 'mvn clean package' to run unit tests and generate /target/Enterbridge-0.0.1.jar
2.  Dockerfiles have been provided:
    1. Postgres - ./Postgres/Dockerfile
    2. Springboot app - ./Dockerfile
    3. React app - ./React/ProductCatalog/Dockerfile
3.  docker-compose.yml is also in the root directory, run 'docker-compose up --build' to create the docker images and run the containers.
4.  Access the UI via http://localhost:5174

### Manual Installation / Execution

#### Postgres database
1.  Install Postgres -- (Please pick the appropriate installer) https://www.postgresql.org/download/
2.  I already have Postgres 17 installed, so that is what I used.
3.  Create a database named 'postgres'.  I used PGAdmin 4 to create the database, but you may also use the command line.
4.  Run the included create_insert.sql script, which will create the 'product' table and insert the test data
5.  Make sure to run Postgres on port 5432, the Springboot application is dependent on this.

#### Springboot application
1.  To compile and build the jar file, run 'mvn package', this will also run the unit test (TestProductServiceImpl.java).  The jar file will be generated in the ./target directory
3.  To run the app in your machine, you can execute 'java -jar ./target/Enterbridge-0.0.1.jar'
       
#### React application
1.  Install Node 10.9.2 (This is what I have installed)
2.  Navigate to React/ProductCatalog and run 'npm install'.  This will download the dependencies to run the app.
3.  To run the app locally, run 'npm run dev'.  This will start the Vite server.
4.  Access the UI via http://localhost:5173/
