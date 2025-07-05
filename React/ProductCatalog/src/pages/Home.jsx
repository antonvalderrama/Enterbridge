import '../App.css'
import ProductList from "../components/ProductList"
import ProductDetails from "../components/ProductDetails"
import AddProduct from "../components/AddProduct"
import {useState, useEffect} from "react"
import { getAllProducts } from '../services/api'

function Home(){

  const [products, populateProducts] = useState([]);
  const [productDetails, renderDetails] = useState([]);

  useEffect( () => {
    console.log("useEffect")

    loadProductList()
  }, []);

  const loadProductList = async () => {
    try{
        const data = await getAllProducts()
        console.log(data)
        populateProducts(data)
    } catch (err) {
        console.log(err)
    }
  }


  const handleProductListRowOnClick = (e, product) => {
      console.log("handleProdcutListRowOnClick "+ product.productName)
      e.preventDefault();
      renderDetails(product)
  };

    return (
    <>
      <div><td className='product-details'><ProductDetails product={productDetails}/></td>
        <td width="100px"></td>
        <td> <AddProduct />
        </td>
      </div>
      <div><br></br></div>
      <div>
        <ProductList products={products} renderFunction={handleProductListRowOnClick}></ProductList>
      </div>
    </>
  );
}

export default Home