import { useEffect, useState } from "react";
import { useRouter } from "next/router";
import { useAuth } from "../contexts/AuthContext";

const ProtectedRoute = ({ children, allowedUserTypes }) => {
  const router = useRouter();
  const { user, loading, userType } = useAuth();
  const [isAuthorized, setIsAuthorized] = useState(false);

  //O efeito é executado sempre que [user, loading, userType ou allowedUserTypes] mudam.
  useEffect(() => {
    if (!user || (allowedUserTypes && !allowedUserTypes.includes(userType))) {
      router.replace("/login");
    } else {
      setIsAuthorized(true);
    }
  }, [user, loading, router, userType, allowedUserTypes]);

  if (loading) return <div>Carregando...</div>;
  return isAuthorized ? children : null;
};

export default ProtectedRoute;
