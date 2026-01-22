import { Routes, Route } from "react-router-dom";

import Navbar from "./components/Navbar";

// public pages
import Home from "./pages/user/Home";
import Login from "./pages/auth/Login";
import ProductDetails from "./pages/user/ProductDetails";
import Unauthorized from "./pages/Unauthorized";

// protected pages
import MyOrders from "./pages/user/MyOrders";
import AdminDashboard from "./pages/admin/AdminDashboard";

// route guard
import ProtectedRoute from "./routes/ProtectedRoute";

function App() {
  return (
    <>
      <Navbar />

      <Routes>
        {/* ================= PUBLIC ROUTES ================= */}
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/product/:id" element={<ProductDetails />} />

        {/* ================= USER PROTECTED ================= */}
        <Route
          path="/orders"
          element={
            <ProtectedRoute role="USER">
              <MyOrders />
            </ProtectedRoute>
          }
        />

        {/* ================= ADMIN PROTECTED ================= */}
        <Route
          path="/admin/products"
          element={
            <ProtectedRoute role="ADMIN">
              <AdminDashboard />
            </ProtectedRoute>
          }
        />

        <Route path="/unauthorized" element={<Unauthorized />} />
      </Routes>
    </>
  );
}

export default App;
