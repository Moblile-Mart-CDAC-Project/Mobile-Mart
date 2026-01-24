import React from "react";
//import { useAnnouncements } from "./AnnouncementsContext";
import { useAnnouncements } from "../../components/AnnouncementsContext";


const UserAnnouncements = () => {
  const { announcements } = useAnnouncements();

  return (
    <div className="container my-4">
      <h4 className="mb-3">📢 Announcements</h4>

      {announcements.length === 0 && (
        <div className="alert alert-secondary">No announcements available.</div>
      )}

      {announcements.map(({ id, title, message, type, date }) => (
        <div key={id} className={`alert alert-${type} shadow-sm`}>
          <div className="d-flex justify-content-between">
            <strong>{title}</strong>
            <small>{date}</small>
          </div>
          <p className="mb-0">{message}</p>
        </div>
      ))}
    </div>
  );
};

export default UserAnnouncements;
