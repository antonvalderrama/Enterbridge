import React from "react";

function ProductDetails({product}){
    // console.log("component : ", product)
    return <div>
        <table className="details-table"><tbody>
        <tr><td className="details-td-label">Product Name</td> <td className="details-td-value" id="productName">{product.productName || "no product selected"}</td></tr>
        <tr><td className="details-td-label">Brand</td> <td className="details-td-value" id="brand">{product.brand || "no product selected"}</td>  </tr>
        <tr><td className="details-td-label">Model</td> <td className="details-td-value" id="model">{product.model || "no product selected"}</td> </tr>
        <tr><td className="details-td-label">Retailer</td> <td className="details-td-value" id="retailer">{product.retailer || "no product selected"}</td> </tr>
        <tr><td className="details-td-label">Product Description</td> <td className="details-td-value" id="productDescription" >{product.productDescription || "no product selected"}</td> </tr>
        <tr><td className="details-td-label">Price</td> <td className="details-td-value" id="price">{product.price || "no product selected"}</td> </tr>
        </tbody>
        </table>
    </div>
}

export default ProductDetails