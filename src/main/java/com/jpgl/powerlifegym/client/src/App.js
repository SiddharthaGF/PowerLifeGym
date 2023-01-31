import { BrowserRouter, Routes, Route,  } from "react-router-dom";
import Clientes from "./components/Clientes";
import Especializacion from "./components/Especializacion";
import React, { Component } from "react";
import Instructor from "./components/Instructor";

function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Clientes/>}/>
      <Route path="/specializations" element={<Especializacion/>}/>
      <Route path="/instructors" element={<Instructor/>}/>
    </Routes>
    </BrowserRouter>

  )
}

export default App;
