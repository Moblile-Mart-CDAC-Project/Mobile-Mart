import React, { useState } from "react";
import { useAnnouncements } from "../../components/AnnouncementsContext";

const AdminAnnouncement = () => {
  const { announcements, addAnnouncement, removeAnnouncement } = useAnnouncements();
  const [form, setForm] = useState({
    title: "",
    message: "",
    type: "info",
  });

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!form.title.trim() || !form.message.trim()) return;

    const newAnnouncement = {
      id: Date.now(),
      title: form.title.trim(),
      message: form.message.trim(),
      type: form.type,
      date: new Date().toISOString().split("T")[0],
    };

    addAnnouncement(newAnnouncement);

    setForm({ title: "", message: "", type: "info" });
  };

  return (
    <div className="container my-4">
      <div className="card shadow">
        <div className="card-header bg-dark text-white">Admin – Manage Announcements</div>
        <div className="card-body">
          <form onSubmit={handleSubmit} noValidate>
            <div className="mb-3">
              <label htmlFor="title" className="form-label">
                Title
              </label>
              <input
                id="title"
                type="text"
                className="form-control"
                name="title"
                value={form.title}
                onChange={handleChange}
                required
                maxLength={100}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="message" className="form-label">
                Message
              </label>
              <textarea
                id="message"
                className="form-control"
                rows="3"
                name="message"
                value={form.message}
                onChange={handleChange}
                required
                maxLength={500}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="type" className="form-label">
                Type
              </label>
              <select
                id="type"
                className="form-select"
                name="type"
                value={form.type}
                onChange={handleChange}
              >
                <option value="info">Info</option>
                <option value="success">Success</option>
                <option value="warning">Warning</option>
                <option value="danger">Danger</option>
              </select>
            </div>

            <button type="submit" className="btn btn-dark w-100">
              Publish
            </button>
          </form>
        </div>
      </div>

      {/* List of announcements with delete option */}
      <div className="mt-4">
        {announcements.length === 0 && (
          <div className="alert alert-secondary">No announcements yet.</div>
        )}

        {announcements.map((a) => (
          <div
            key={a.id}
            className={`alert alert-${a.type} d-flex justify-content-between align-items-center`}
          >
            <div>
              <strong>{a.title}</strong> — {a.message}
              <div className="small text-muted">{a.date}</div>
            </div>
            <button
              className="btn btn-sm btn-outline-danger"
              onClick={() => removeAnnouncement(a.id)}
              aria-label={`Delete announcement: ${a.title}`}
            >
              &times;
            </button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default AdminAnnouncement;
