import { useEffect, useState } from "react";
import axios from "../../utils/axiosInstance";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

function Cart() {

  const [cart, setCart] = useState({
    items: [],
    totalAmount: 0
  });

  const navigate = useNavigate();

  // ======================
  // LOAD CART
  // ======================
  const loadCart = async () => {
    try {
      const res = await axios.get("/cart");
      setCart(res.data);
    } catch (err) {
      toast.error("Failed to load cart");
    }
  };

  useEffect(() => {
    loadCart();
  }, []);

  // ======================
  // UPDATE QUANTITY
  // ======================
  const updateQuantity = async (productId, quantity) => {
    if (quantity <= 0) return;

    try {
      await axios.put("/cart/update", {
        productId,
        quantity
      });
      loadCart(); // refresh cart
    } catch {
      toast.error("Failed to update quantity");
    }
  };

  // ======================
  // REMOVE ITEM
  // ======================
  const removeItem = async (productId) => {
    try {
      await axios.delete(`/cart/remove/${productId}`);
      loadCart(); // refresh cart
      toast.success("Item removed");
    } catch {
      toast.error("Failed to remove item");
    }
  };

  // ======================
  // PLACE ORDER
  // ======================
  const placeOrder = async () => {
    try {
      await axios.post("/orders/place");
      toast.success("Order placed successfully");
      navigate("/orders");
    } catch {
      toast.error("Order failed");
    }
  };

  return (
    <div className="container mt-4">
      <h3>My Cart</h3>

      {cart.items.length === 0 ? (
        <p>Your cart is empty</p>
      ) : (
        <>
          <table className="table">
            <thead>
              <tr>
                <th>Product</th>
                <th>Price</th>
                <th>Qty</th>
                <th>Subtotal</th>
                <th>Action</th>
              </tr>
            </thead>

            <tbody>
              {cart.items.map(item => (
                <tr key={item.cartItemId}>
                  <td>{item.productName}</td>
                  <td>₹{item.price}</td>

                  <td>
                    <button
                      className="btn btn-sm btn-secondary me-1"
                      onClick={() =>
                        updateQuantity(item.productId, item.quantity - 1)
                      }
                    >-</button>

                    {item.quantity}

                    <button
                      className="btn btn-sm btn-secondary ms-1"
                      onClick={() =>
                        updateQuantity(item.productId, item.quantity + 1)
                      }
                    >+</button>
                  </td>

                  <td>₹{item.price * item.quantity}</td>

                  <td>
                    <button
                      className="btn btn-sm btn-danger"
                      onClick={() => removeItem(item.productId)}
                    >
                      Remove
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>

          <h4>Total Amount: ₹{cart.totalAmount}</h4>

          <button
            className="btn btn-success mt-3"
            onClick={placeOrder}
          >
            Place Order
          </button>
        </>
      )}
    </div>
  );
}

export default Cart;
