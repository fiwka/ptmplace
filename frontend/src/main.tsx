import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import {BrowserRouter, Route, Routes} from "react-router";
import {SignIn} from "./SignIn.tsx";
import {ProtectedRoute} from "./ProtectedRoute.tsx";
import {CustomFlowbiteTheme, Flowbite} from "flowbite-react";
import {AnonymousRoute} from "./AnonymousRoute.tsx";

const ptmplaceTheme: CustomFlowbiteTheme = {
    textarea: {
        colors: {
            gray: "dark:bg-gray-900 dark:text-white",
        }
    },
}

createRoot(document.getElementById('root')!).render(
  <StrictMode>
      <Flowbite theme={{ theme: ptmplaceTheme }}>
          <BrowserRouter>
              <Routes>
                  <Route path="/" element={<ProtectedRoute>
                      <App />
                  </ProtectedRoute>} />
                  <Route path="/signin" element={<AnonymousRoute>
                      <SignIn />
                  </AnonymousRoute>} />
              </Routes>
          </BrowserRouter>
      </Flowbite>
  </StrictMode>,
)
