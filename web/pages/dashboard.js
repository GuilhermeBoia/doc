import { useAuth } from "../contexts/AuthContext";
import ProtectedRoute from "../components/ProtectedRoute";
import { useRouter } from "next/router";
import { useCallback } from "react";
import Link from "next/link";

function DashboardContent() {
  const { userType, logout, user } = useAuth();
  const router = useRouter();

  const handleLogout = useCallback(async () => {
    try {
      await logout();
      router.push("/");
    } catch (error) {
      console.error("Erro durante o logout:", error);
      alert("Falha ao fazer logout. Por favor, tente novamente.");
    }
  }, [logout, router]);

  return (
    <div>
      <h1>Bem-vindo, {userType === "terapeuta" ? "Terapeuta" : "Assessor"}!</h1>
      <p>Email: {user?.email}</p>
      <Link href="/profile">
        <button>Perfil</button>
      </Link>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
}

export default function ProtectedDashboard() {
  return (
    <ProtectedRoute allowedUserTypes={["terapeuta", "assessor"]}>
      <DashboardContent />
    </ProtectedRoute>
  );
}
