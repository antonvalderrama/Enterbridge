import React from "react";
import {render, screen} from "@testing-library/react";
import ProductDetails from "./ProductDetails";
import {describe, it, expect} from "vitest";
import "@testing-library/jest-dom/vitest";


describe("ProductDetails", () => {
    
    it("renders 'no product selected' when there is no selected product", () => {
        const selectedProduct = []

        render(<ProductDetails product={selectedProduct}/>)
        const defaultValue = "no product selected";

        //Collect all elements that have the default text
        const elements = screen.getAllByText(defaultValue);
        
        let productNameVerified = false
        let brandVerified = false
        let modelVerified = false
        let retailerVerified = false
        let productDescriptionVerified = false
        let priceVerified = false
        
        //iterate through all the elements and check their ids.  All ids should be accounted for.  Fail if there is an id that does not belong.
        elements.forEach(element => {
            switch(element.id) {
                case "productName" :
                    productNameVerified = true;
                    break;
                case "brand" : 
                    brandVerified = true;
                    break;
                case "model" : 
                    modelVerified = true;
                    break;
                case "retailer" : 
                    retailerVerified = true;
                    break;
                case "productDescription" : 
                    productDescriptionVerified = true;
                    break;
                case "price" : 
                    priceVerified = true;
                    break;
                default :
                    throw new Error(`Extra element (id=${element.id}) with '${defaultValue}' found`)
            }

        });

        //Check if all the expected ids were included in the element array
        expect(productNameVerified).toBe(true);
        expect(brandVerified).toBe(true);
        expect(modelVerified).toBe(true);
        expect(retailerVerified).toBe(true);
        expect(productDescriptionVerified).toBe(true);
        expect(priceVerified).toBe(true);
    })

    it("renders product details of selected product", () => {

        const expectedProductName = "test productName";
        const expectedBrand = "test brand";
        const expectedModel = "test model";
        const expectedRetailer = "test retailer";
        const expectedProductDescription = "test productDescription";
        const expectedPrice = 12.34;

        const selectedProduct = {
            productName : expectedProductName,
            brand : expectedBrand,
            model : expectedModel,
            retailer : expectedRetailer,
            productDescription : expectedProductDescription,
            price : expectedPrice
        };
        
        console.log("unit test : ", selectedProduct)
        render(<ProductDetails product={selectedProduct}/>)
        
        const productName = screen.getByText(expectedProductName);
        const brand = screen.getByText(expectedBrand);
        const model = screen.getByText(expectedModel);
        const retailer = screen.getByText(expectedRetailer);
        const productDescription = screen.getByText(expectedProductDescription);
        const price = screen.getByText(expectedPrice);


        expect(productName.id).toBe("productName");
        expect(brand.id).toBe("brand");
        expect(model.id).toBe("model");
        expect(retailer.id).toBe("retailer");
        expect(productDescription.id).toBe("productDescription");
        expect(price.id).toBe("price");
    })
    
});