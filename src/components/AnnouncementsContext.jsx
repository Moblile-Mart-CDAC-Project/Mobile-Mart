import React, { createContext, useState, useEffect, useContext } from "react";

const STORAGE_KEY = "mobilemart_announcements";

const AnnouncementsContext = createContext();

export const AnnouncementsProvider = ({ children }) => {
  const [announcements, setAnnouncements] = useState(() => {
    // Initialize from localStorage or empty array
    try {
      const stored = localStorage.getItem(STORAGE_KEY);
      return stored ? JSON.parse(stored) : [];
    } catch {
      return [];
    }
  });

  // Persist announcements to localStorage on change
  useEffect(() => {
    try {
      localStorage.setItem(STORAGE_KEY, JSON.stringify(announcements));
    } catch {
      // Fail silently or handle storage errors
    }
  }, [announcements]);

  // Add announcement
  const addAnnouncement = (announcement) => {
    setAnnouncements((prev) => [announcement, ...prev]);
  };

  // Optional: Remove announcement by id
  const removeAnnouncement = (id) => {
    setAnnouncements((prev) => prev.filter((a) => a.id !== id));
  };

  return (
    <AnnouncementsContext.Provider
      value={{ announcements, addAnnouncement, removeAnnouncement }}
    >
      {children}
    </AnnouncementsContext.Provider>
  );
};

// Custom hook to use context easily
export const useAnnouncements = () => useContext(AnnouncementsContext);
