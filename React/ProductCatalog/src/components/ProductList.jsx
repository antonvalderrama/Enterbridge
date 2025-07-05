function ProductList({products, renderFunction}){
    let count = 1
    return <div>
        <table className="products-table">
        <tbody>
        <tr>
            <td className="product-table-hdr"></td>
            <td className="product-table-hdr">Product Name</td>
            <td className="product-table-hdr">Brand</td>
            <td className="product-table-hdr">Price</td>
            <td className="product-table-hdr">Model</td>
        </tr>
        {products.map(product => (
            <tr onClick={(e) => renderFunction(e, product)}>
                <td className="product-table-td">{count++}</td>
                <td className="product-table-td">{product.productName}</td>
                <td className="product-table-td">{product.brand}</td>
                <td className="product-table-td">{product.price}</td>
                <td className="product-table-td">{product.model}</td>
            </tr>
        ))}
        </tbody>
        </table>
    </div>
}

export default ProductList