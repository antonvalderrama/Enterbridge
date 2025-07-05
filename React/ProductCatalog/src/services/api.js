const BASE_URL = import.meta.env.VITE_API_URL;

console.log("BASE_URL", BASE_URL)

export const getAllProducts = async () => {

    const response = await fetch(`${BASE_URL}/products`, {method : "GET", mode : 'cors'})
    return response.json()
};

export const getProduct = async (productKey) => {
    const response = await fetch(`${BASE_URL}/products/${productKey}`, {method : "GET", mode : 'cors'})
    return response.json()
};

export const addProduct = async (product) => {
    
    const body = JSON.stringify(product);

    console.log("stringify", body)

    const response = await fetch(`${BASE_URL}/products`, {
        method : "POST",
        headers : {
            'content-type' : 'application/json',
            'accept' : '*/*'
        },
        mode : 'cors', 
        body : body
    })
    return response.status
};

export const getBrandCountSummary = async () => {
    const response = await fetch(`${BASE_URL}/products/brand-summary}`, {method : "GET", mode : 'cors'})
    return response.json()
};

export const getBrandCount = async (brand) => {
    const response = await fetch(`${BASE_URL}/products/${brand}/count}`)
    return response.json()
};