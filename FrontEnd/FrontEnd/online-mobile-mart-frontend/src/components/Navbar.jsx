import { useNavigate } from "react-router-dom";
import { isLoggedIn, isAdmin, logout } from "../utils/auth";

function Navbar() {
  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate("/login");
  };

  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-3">
      <span className="navbar-brand">Online Mobile Mart</span>

      <div className="ms-auto">
        {isLoggedIn() ? (
          <>
            {isAdmin() && (
              <button
                className="btn btn-warning me-2"
                onClick={() => navigate("/admin")}
              >
                Admin Dashboard
              </button>
            )}

            <button className="btn btn-danger" onClick={handleLogout}>
              Logout
            </button>
          </>
        ) : (
          <button
            className="btn btn-success"
            onClick={() => navigate("/login")}
          >
            Login
          </button>
        )}
      </div>
    </nav>
  );
}

export default Navbar;
