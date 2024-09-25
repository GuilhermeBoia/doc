import { useEffect } from "react";
import { useRouter } from "next/router";
import { useAuth } from "../contexts/AuthContext";

const ProtectedRoute = ({ children, allowedUserTypes }) => {
  const router = useRouter();
  const { user, loading, userType } = useAuth();

  //O efeito é executado sempre que user, loading, userType ou allowedUserTypes mudam.
  useEffect(() => {
    if (!user || (allowedUserTypes && !allowedUserTypes.includes(userType))) {
      router.replace("/login");
    }
  }, [user, loading, router, userType, allowedUserTypes]);

  return children;
};

export default ProtectedRoute;
