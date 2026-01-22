import { useState } from "react";
import axios from "../../utils/axiosInstance";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

export default function AddProduct() {

  const navigate = useNavigate();

  const [product, setProduct] = useState({
    name: "",
    brand: "",
    price: "",
    stockQuantity: "",
    description: ""
  });

  const handleChange = (e) => {
    setProduct({ ...product, [e.target.name]: e.target.value });
  };

  const saveProduct = async () => {
    try {
      const res = await axios.post("/admin/products", product);
      toast.success("Product created");

      // 👉 redirect to edit page with productId
      navigate(`/admin/products/edit/${res.data.productId}`);

    } catch {
      toast.error("Failed to create product");
    }
  };

  return (
    <div className="container mt-4 col-md-6">
      <h3>Add New Product</h3>

      <input className="form-control mb-2"
        name="name"
        placeholder="Product Name"
        onChange={handleChange}
      />

      <input className="form-control mb-2"
        name="brand"
        placeholder="Brand Name"
        onChange={handleChange}
      />

      <input className="form-control mb-2"
        type="number"
        name="price"
        placeholder="Price"
        onChange={handleChange}
      />

      <input className="form-control mb-2"
        type="number"
        name="stockQuantity"
        placeholder="Stock Quantity"
        onChange={handleChange}
      />

      <textarea className="form-control mb-3"
        name="description"
        placeholder="Description"
        onChange={handleChange}
      />

      <button className="btn btn-success w-100" onClick={saveProduct}>
        Save Product
      </button>
    </div>
  );
}
