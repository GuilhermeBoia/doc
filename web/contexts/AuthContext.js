import React, { createContext, useState, useContext, useEffect } from "react";
import { supabase } from "../lib/supabaseConfig";

const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [userType, setUserType] = useState(null);

  const checkUserType = async (user) => {
    try {
      const encodedEmail = encodeURIComponent(user.email);
      const response = await fetch(
        `http://localhost:8080/login/user-type?userEmail=${encodedEmail}`,
        {
          headers: {
            Authorization: `Bearer ${user.access_token}`,
          },
        }
      );
      const data = await response.json();
      setUserType(data.userType);
    } catch (error) {
      console.error("Error checking user type:", error);
      setUserType(null);
    }
  };

  useEffect(() => {
    const checkSession = async () => {
      const {
        data: { session },
      } = await supabase.auth.getSession();

      if (session && new Date(session.expires_at * 1000) > new Date()) {
        setUser(session.user);
        await checkUserType(session.user);
      } else {
        setUser(null);
        setUserType(null);
        await supabase.auth.signOut();
      }
      setLoading(false);
    };

    //Faz a chamada da função acima justamente pra saber qual é a sessão atual
    checkSession();

    const {
      data: { subscription },
    } = supabase.auth.onAuthStateChange(async (_event, session) => {
      if (session && new Date(session.expires_at * 1000) > new Date()) {
        setUser(session.user);
        await checkUserType(session.user);
      } else {
        setUser(null);
        setUserType(null);
        await supabase.auth.signOut();
      }
      setLoading(false);
    });

    return () => subscription.unsubscribe();
  }, []);

  const login = async (email, password) => {
    const { data, error } = await supabase.auth.signInWithPassword({
      email,
      password,
    });
    if (!error && data.user) {
      await checkUserType(data.user);
    }
    return { data, error };
  };

  const logout = async () => {
    setUser(null);
    setUserType(null);
    await supabase.auth.signOut();
  };

  const value = {
    user,
    userType,
    loading,
    login,
    logout,
    setUserType,
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

export const useAuth = () => {
  const context = useContext(AuthContext);
  if (context === undefined) {
    throw new Error("useAuth must be used within an AuthProvider");
  }
  return context;
};
