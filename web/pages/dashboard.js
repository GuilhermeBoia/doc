import { useAuth } from "../contexts/AuthContext";
import ProtectedRoute from "../components/ProtectedRoute";
import { useRouter } from "next/router";

function DashboardContent() {
  const { userType, logout } = useAuth();
  const router = useRouter();

  const handleLogout = async () => {
    try {
      await logout();
      router.push("/");
    } catch (error) {
      console.error("Erro durante o logout:", error);
      alert("Falha ao fazer logout. Por favor, tente novamente.");
    }
  };

  return (
    <div>
      <h1>Bem-vindo, {userType === "terapeuta" ? "Terapeuta" : "Assessor"}!</h1>
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
