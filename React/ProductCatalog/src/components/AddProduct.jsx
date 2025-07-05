import {useState} from "react"
import {addProduct} from '../services/api'

function AddProduct(){

    const [newProduct, updateAddNewProductFields] = useState({});

    //Use spread operator to automaticall update form data
    const handleChange = (e) => {
        const {name, value} = e.target;
        updateAddNewProductFields(prevFormData => ({
        ...prevFormData,
        [name] : value
        }))
    };

    const handleSubmit = (e) => {
        e.preventDefault()

        const status = addNewProduct(newProduct)
        console.log('status', status)
        
        location.reload()
    }

    const addNewProduct = (product) => {
        const status = addProduct(product)
        return status
    }    

    return <form onSubmit={handleSubmit}>
            <div>
            <tr className="required-tr"><input type='text' placeholder='name *' name='productName' value={newProduct.productName} onChange={handleChange} required/></tr>
            <tr className="required-tr"><input type='text' placeholder='brand *' name='brand' value={newProduct.brand} onChange={handleChange} required/></tr>
            <tr><input type='number' placeholder='price' name='price' value={newProduct.price} onChange={handleChange} /></tr>
            <tr><input type='text' placeholder='model' name='model' value={newProduct.model} onChange={handleChange} /></tr>
            <tr><input type='text' placeholder='retailer' name='retailer' value={newProduct.retailer} onChange={handleChange}/></tr>
            <tr className="required-tr"><input type='text' placeholder='description *' name='productDescription' value={newProduct.productDescription} onChange={handleChange} required/></tr>
            <tr className="required-tr">*Required</tr>
            <button type='submit'>Add product</button>
            </div>
          </form>
}export default AddProduct