import { Inter } from "next/font/google";
import "./globals.css";
import Link from "next/link";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import { Container, Button } from "@mui/material";
import Providers from "@/store/provider";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  title: "Create Next App",
  description: "Generated by create next app",
};

const links = [
  {
    label: "Home",
    route: "/",
  },
  {
    label: "Order",
    route: "/order",
  },
  {
    label: "Customer",
    route: "/customer",
  },
  {
    label: "Prameters",
    route: "/parameter",
  },
  {
    label: "Pizza",
    route: "/pizza",
  },
  {
    label: "Topping",
    route: "/topping",
  },
];

export default function RootLayout({ children }) {
  return (
    <html>
      <Providers>
        <body>
          <AppBar position="static" color="primary">
            <Toolbar>
              <Typography variant="h6" color="inherit" noWrap>
                Hays Tech
              </Typography>
              <nav>
                {links.map(({ label, route }) => (
                  <Button color="inherit" key={route}>
                    <Link href={route}>{label}</Link>
                  </Button>
                ))}
              </nav>
            </Toolbar>
          </AppBar>
          {children}
        </body>
      </Providers>
    </html>
  );
}