import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "../../utils/axiosInstance";
import { toast } from "react-toastify";

function ProductDetails() {
  const { id } = useParams();
  const navigate = useNavigate();

  const [product, setProduct] = useState(null);
  const [comment, setComment] = useState("");

  const role = localStorage.getItem("role");
  const token = localStorage.getItem("token");

  useEffect(() => {
    axios.get(`/products/${id}`)
      .then(res => setProduct(res.data))
      .catch(() => toast.error("Failed to load product"));
  }, [id]);

  if (!product) {
    return <div className="container mt-4">Loading...</div>;
  }

  const images = product.images || [];

  // ================= ADD TO CART =================
  const addToCart = () => {

    if (!token) {
      toast.warning("Please login first");
      navigate("/login");
      return;
    }

    if (role !== "USER") {
      toast.error("Only users can add to cart");
      return;
    }

    axios.post("/cart/add", {
      productId: product.productId,
      quantity: 1
    })
    .then(() => {
      toast.success("Product added to cart");
    })
    .catch(err => {
      toast.error(err.response?.data?.message || "Failed to add to cart");
    });
  };

  return (
    <div className="container mt-4">

      <h3>{product.name}</h3>

      {/* IMAGES */}
      <div className="d-flex gap-3 mb-3">
        {images.map((img, index) => (
          <img
            key={index}
            src={img.imageUrl}
            width="150"
            alt="product"
          />
        ))}
      </div>

      <p>{product.description}</p>

      <h5 className="text-success">₹ {product.price}</h5>

      {/* ADD TO CART BUTTON */}
      {role !== "ADMIN" && (
        <button
          className="btn btn-warning mt-3"
          onClick={addToCart}
        >
          Add to Cart
        </button>
      )}

      <hr />

      {/* COMMENTS */}
      <h5>Comments</h5>
      <ul>
        {(product.comments || []).map((c, index) => (
          <li key={index}>{c.text}</li>
        ))}
      </ul>

      {/* ADD COMMENT */}
      {role === "USER" && (
        <>
          <textarea
            className="form-control"
            value={comment}
            onChange={e => setComment(e.target.value)}
          />
          <button className="btn btn-primary mt-2">
            Add Comment
          </button>
        </>
      )}
    </div>
  );
}

export default ProductDetails;
