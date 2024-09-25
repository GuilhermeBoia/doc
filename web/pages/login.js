import { AuthProvider } from "../contexts/AuthContext";
import Login from "../components/Login";

export default function LoginPage() {
  return (
    <AuthProvider>
      <h1>Login</h1>
      <Login />
    </AuthProvider>
  );
}
